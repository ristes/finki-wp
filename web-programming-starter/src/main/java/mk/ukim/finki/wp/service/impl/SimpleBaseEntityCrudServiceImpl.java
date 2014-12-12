package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.service.BaseEntityCrudService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class SimpleBaseEntityCrudServiceImpl<T extends BaseEntity, R extends JpaRepository<T, Long>>
		implements BaseEntityCrudService<T> {

	protected abstract R getRepository();

	@Override
	public T save(T entity) {
		return getRepository().save(entity);
	}

	@Override
	public List<T> save(Iterable<T> entities) {
		return getRepository().save(entities);
	}

	@Override
	public T saveAndFlush(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	@Override
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return getRepository().findAll(sort);
	}

	@Override
	public List<T> findAll(Iterable<Long> ids) {
		return getRepository().findAll(ids);
	}

	@Override
	public List<T> findAll(Specification<T> spec) {
		return findAll();
	}

	@Override
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		return null;
	}

	@Override
	public List<T> findAll(Specification<T> spec, Sort sort) {
		return findAll();
	}

	@Override
	public long count() {
		return getRepository().count();
	}

	@Override
	public long count(Specification<T> spec) {
		return 0;
	}

	@Override
	public T findOne(Long id) {
		return getRepository().findOne(id);
	}

	@Override
	public T findOne(Specification<T> spec) {
		return null;
	}

	@Override
	public boolean exists(Long id) {
		return getRepository().exists(id);
	}

	@Override
	public void delete(Long id) {
		getRepository().delete(id);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void delete(Iterable<T> entities) {
		getRepository().delete(entities);
	}

	@Override
	public void deleteAll() {
		getRepository().deleteAll();
	}

}
