package mk.ukim.finki.wp.web;

import java.util.List;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.service.CrudCityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/cities")
public class CityResource extends CrudResource<City, CrudCityService> {

	@Autowired
	private CrudCityService service;

	@Override
	public CrudCityService getService() {
		return service;
	}

	@RequestMapping(value = "/by_country/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<City> getByCityId(@PathVariable Long id) {
		return getService().findByCountryId(id);
	}
}
