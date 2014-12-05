package mk.ukim.finki.wp.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.BookService;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/books")
public class BookController {

	private static final String BOOKS2 = "books";

	private static final String CATEGORY = "category";

	private static final String SHOPPING_CART = "shoppingCart";

	private static final String TOTAL_PRICE = "totalPrice";

	@Autowired
	private BookService service;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	OrderService orderService;

	public BookService getService() {
		return service;
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(HttpSession session, HttpServletRequest request) {

		List<Book> shoppingCart = (List<Book>) session
				.getAttribute(SHOPPING_CART);

		if (shoppingCart == null) {
			shoppingCart = new ArrayList<Book>();
			session.setAttribute(SHOPPING_CART, shoppingCart);
		}

		Order order = orderService.createOrder(shoppingCart);

		return "redirect:/orders/" + order.getId();
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public String order(@PathVariable Long id, HttpSession session,
			HttpServletRequest request) {
		Book orderedBook = service.findById(id);

		List<Book> shoppingCart = (List<Book>) session
				.getAttribute(SHOPPING_CART);

		Double totalPrice = (Double) session.getAttribute(TOTAL_PRICE);
		if (shoppingCart == null) {
			shoppingCart = new ArrayList<Book>();
			session.setAttribute(SHOPPING_CART, shoppingCart);
			totalPrice = 0d;
		}
		shoppingCart.add(orderedBook);

		totalPrice += orderedBook.getPrice();
		session.setAttribute(TOTAL_PRICE, totalPrice);

		List<Book> books = service.findByCategoryId(orderedBook.getCategory()
				.getId());
		request.setAttribute(CATEGORY, orderedBook.getCategory());
		request.setAttribute(BOOKS2, books);
		request.setAttribute(SHOPPING_CART, shoppingCart);

		return "redirect:/categories/index/"
				+ orderedBook.getCategory().getId();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Book create(@RequestParam String name, @RequestParam Long categoryId) {
		Book book = new Book();
		book.setName(name);
		Category category = categoryService.findById(categoryId);
		book.setCategory(category);

		return getService().saveOrUpdate(book);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Book> getAll() {
		return getService().findAll();
	}

	@RequestMapping(value = "/by_category/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Book> getByCountryId(@PathVariable Long id) {
		return getService().findByCategoryId(id);
	}

	@RequestMapping(value = "/by_name", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Book> getByName(@RequestParam String name) {
		return getService().findByName(name);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Book get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		Book entity = getService().findById(id);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		getService().delete(id);
	}
}
