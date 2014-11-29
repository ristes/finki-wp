package mk.ukim.finki.wp.web;

import java.util.List;

import mk.ukim.finki.wp.model.Person;
import mk.ukim.finki.wp.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data/rest/persons")
public class PersonResource extends CrudResource<Person, PersonService> {

	@Autowired
	private PersonService service;

	@Override
	public PersonService getService() {
		return service;
	}

	@RequestMapping(value="/by_city/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Person> getByCityId(@PathVariable Long id) {
		return getService().findByCityId(id);
	}
}
