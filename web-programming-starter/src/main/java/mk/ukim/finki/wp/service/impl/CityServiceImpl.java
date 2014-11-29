package mk.ukim.finki.wp.service.impl;

import java.util.List;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.repository.sd.SpringDataCityRepository;
import mk.ukim.finki.wp.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private SpringDataCityRepository repository;

	@Override
	public City save(City city) {
		if (city.getId() != null) {
			City cityFromDb = getById(city.getId());
			if (cityFromDb != null) {
				cityFromDb.setName(city.getName());
				city = cityFromDb;
			}
		}
		return repository.save(city);

	}

	@Override
	public List<City> findAll() {
		return repository.findAll();
	}

	@Override
	public City getById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		City city = repository.findOne(id);
		if (city != null) {
			repository.delete(city);
		} else {
			System.out.println("Cant find city with id: " + id);
		}
	}

	@Override
	public void delete(City city) {
		repository.delete(city);
	}

	@Override
	public List<City> findByCountryId(Long id) {
		return repository.findByCountryId(id);
	}

}
