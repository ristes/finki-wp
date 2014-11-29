package mk.ukim.finki.wp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.service.BaseEntityCrudService;
import mk.ukim.finki.wp.web.util.RequestProcessor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class CrudResource<T extends BaseEntity, S extends BaseEntityCrudService<T>> {

	public abstract S getService();

	public void beforeSave(T entity) {

	}

	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = "application/json")
	public void importEntities(@RequestBody @Valid List<T> entities,
			HttpServletRequest request, HttpServletResponse response) {
		for (T entity : entities) {
			getService().save(entity);
		}
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public T create(@RequestBody @Valid T entity, HttpServletRequest request,
			HttpServletResponse response) {
		beforeSave(entity);
		getService().save(entity);
		return entity;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<T> getAll() {
		return getService().findAll();
	}

	@RequestMapping(value = "/paged", method = RequestMethod.GET, produces = "application/json")
	public Page<T> getAll(@RequestParam int page, @RequestParam int count,
			HttpServletRequest request) {
		Sort sort = RequestProcessor.sorting(request);
		Pageable pageable = new PageRequest(page - 1, count, sort);
		return getService().findAll(pageable);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public T get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		T entity = getService().findOne(id);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void delete(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		getService().delete(id);
	}

}
