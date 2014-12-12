package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Book;

public interface CrudBookService extends BaseEntityCrudService<Book> {

	public List<Book> findByCategoryId(Long id);

}
