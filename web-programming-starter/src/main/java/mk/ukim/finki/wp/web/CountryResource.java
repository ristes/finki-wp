package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Country;
import mk.ukim.finki.wp.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/countries")
public class CountryResource extends CrudResource<Country, CountryService> {

	@Autowired
	private CountryService service;

	@Override
	public CountryService getService() {
		return service;
	}
}
