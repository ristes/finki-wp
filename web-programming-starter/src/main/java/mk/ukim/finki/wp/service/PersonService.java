package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Person;

public interface PersonService extends BaseEntityCrudService<Person> {

	List<Person> findByCityId(Long id);

}
