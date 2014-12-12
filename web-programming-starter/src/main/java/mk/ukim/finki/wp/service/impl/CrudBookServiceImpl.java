package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.repository.BookRepository;
import mk.ukim.finki.wp.service.CrudBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudBookServiceImpl extends
		SimpleBaseEntityCrudServiceImpl<Book, BookRepository> implements
		CrudBookService {

	@Autowired
	private BookRepository repository;

	@Override
	protected BookRepository getRepository() {
		return repository;
	}

	@Override
	public List<Book> findByCategoryId(Long id) {
		return repository.findByCategoryId(id);
	}

}
