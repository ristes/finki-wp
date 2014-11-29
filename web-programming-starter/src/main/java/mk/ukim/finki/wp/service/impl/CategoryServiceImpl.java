package mk.ukim.finki.wp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.repository.CategoryRepository;
import mk.ukim.finki.wp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository repository;

	@Override
	public Category saveOrUpdate(Category entity) {
		return repository.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return repository.findAll();
	}

	@Override
	public Category findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

}
