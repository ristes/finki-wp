package mk.ukim.finki.wp.web.resources;

import java.util.List;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.service.CrudBookService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/books")
public class BookResource extends CrudResource<Book, CrudBookService> {

	@Autowired
	private CrudBookService service;

	@Override
	public CrudBookService getService() {
		return service;
	}

	@RequestMapping(value = "/by_category/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Book> getByCategoryId(@PathVariable Long id) {
		return getService().findByCategoryId(id);
	}

}
