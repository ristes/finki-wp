package mk.ukim.finki.wp.web.resources;

import mk.ukim.finki.wp.model.Category;
import mk.ukim.finki.wp.service.CrudCategoryService;
import mk.ukim.finki.wp.web.CrudResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/categories")
public class CategoryResource extends
		CrudResource<Category, CrudCategoryService> {

	@Autowired
	private CrudCategoryService service;

	@Override
	public CrudCategoryService getService() {
		return service;
	}

}
