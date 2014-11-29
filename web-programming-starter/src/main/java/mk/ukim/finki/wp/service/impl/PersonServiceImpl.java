package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.Person;
import mk.ukim.finki.wp.repository.PersonRepository;
import mk.ukim.finki.wp.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends
		BaseEntityCrudServiceImpl<Person, PersonRepository> implements
		PersonService {

//	@Autowired
	private PersonRepository repository;

	@Override
	protected PersonRepository getRepository() {
		return repository;
	}

	@Override
	public List<Person> findByCityId(Long id) {
		return repository.findByCityId(id);
	}

}
