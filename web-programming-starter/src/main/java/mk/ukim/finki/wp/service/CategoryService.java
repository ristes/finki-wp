package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Category;

public interface CategoryService {

	public Category saveOrUpdate(Category entity);

	public List<Category> findAll();

	public Category findById(Long id);

	public void delete(Long id);
}
