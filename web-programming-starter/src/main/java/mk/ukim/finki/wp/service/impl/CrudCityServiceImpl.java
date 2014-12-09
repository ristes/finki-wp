package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.repository.CrudCityRepository;
import mk.ukim.finki.wp.service.CrudCityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudCityServiceImpl extends
		BaseEntityCrudServiceImpl<City, CrudCityRepository> implements
		CrudCityService {

	@Autowired
	private CrudCityRepository repository;

	@Override
	protected CrudCityRepository getRepository() {
		return repository;
	}

	@Override
	public List<City> findByCountryId(Long id) {
		return repository.findByCountryId(id);
	}

}
