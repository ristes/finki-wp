package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Book;

public interface BookService {

	public Book saveOrUpdate(Book entity);

	public List<Book> findAll();

	public List<Book> findByName(String name);

	public List<Book> findByCategoryId(Long id);

	public Book findById(Long id);

	public void delete(Long id);
}
