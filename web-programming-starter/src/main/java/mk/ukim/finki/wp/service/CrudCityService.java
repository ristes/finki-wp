package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CrudCityService extends BaseEntityCrudService<City> {

	List<City> findByCountryId(Long id);

}
