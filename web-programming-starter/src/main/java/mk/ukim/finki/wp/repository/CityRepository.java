package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CityRepository {

	public City save(City city);

	public List<City> findAll();

	public City getById(Long id);

	public void delete(City city);
}
