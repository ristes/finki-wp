package mk.ukim.finki.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.repository.BookRepository;
import mk.ukim.finki.wp.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;

	@Override
	public Book saveOrUpdate(Book entity) {
		return repository.save(entity);
	}

	@Override
	public List<Book> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Book> findByCategoryId(Long id) {
		return repository.findByCategoryId(id);
	}

	@Override
	public Book findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public List<Book> findByName(String name) {
		return repository.findByNameLikeOrderByIdDesc(name);
	}

}
