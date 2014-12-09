package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Country;
import mk.ukim.finki.wp.repository.CountryRepository;
import mk.ukim.finki.wp.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends
		BaseEntityCrudServiceImpl<Country, CountryRepository> implements
		CountryService {

	@Autowired
	private CountryRepository repository;

	@Override
	protected CountryRepository getRepository() {
		return repository;
	}

}
