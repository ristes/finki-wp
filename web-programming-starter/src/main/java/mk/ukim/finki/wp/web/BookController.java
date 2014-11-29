package mk.ukim.finki.wp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.service.BookService;
import mk.ukim.finki.wp.service.CategoryService;
import mk.ukim.finki.wp.service.CityService;

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

	@Autowired
	private BookService service;

	@Autowired
	private CategoryService categoryService;

	public BookService getService() {
		return service;
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
