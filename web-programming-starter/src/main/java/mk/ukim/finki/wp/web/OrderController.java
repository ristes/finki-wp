package mk.ukim.finki.wp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private CityService service;

	public CityService getService() {
		return service;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public City create(@RequestParam(required = false) Long id,
			@RequestParam String name) {
		City city = new City();
		city.setId(id);
		city.setName(name);

		return getService().save(city);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<City> getAll() {
		return getService().findAll();
	}

	@RequestMapping(value = "/by_country/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<City> getByCountryId(@PathVariable Long id) {
		return getService().findByCountryId(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public City get(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) {
		City entity = getService().getById(id);
		if (entity == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return entity;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public void delete(@PathVariable Long id) {
		getService().delete(id);
	}
}
