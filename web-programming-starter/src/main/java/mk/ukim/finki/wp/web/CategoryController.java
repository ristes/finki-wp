package mk.ukim.finki.wp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.service.BookService;
import mk.ukim.finki.wp.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@Autowired
	private BookService booksService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		List<Category> categories = service.findAll();
		ModelAndView res = new ModelAndView();
		res.setViewName("categories");
		res.addObject("categories", categories);
		return res;
	}

	@RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
	public ModelAndView categoryBooks(@PathVariable Long id) {
		List<Book> books = booksService.findByCategoryId(id);
		Category category = service.findById(id);
		ModelAndView res = new ModelAndView();
		res.setViewName("categoryBooks");
		res.addObject("category", category);
		res.addObject("books", books);
		return res;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Category create(@RequestParam String name) {
		Category category = new Category();
		category.setName(name);

		return service.saveOrUpdate(category);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Category> getAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Category get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		Category entity = service.findById(id);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
