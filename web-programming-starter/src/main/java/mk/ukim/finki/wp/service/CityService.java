package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CityService {

	public City save(City city);

	public List<City> findAll();

	public City getById(Long id);

	public void delete(Long id);

	public void delete(City city);

	public List<City> findByCountryId(Long id);
}
