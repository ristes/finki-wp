package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.City;

public interface CrudCityRepository extends JpaSpecificationRepository<City> {

	List<City> findByCountryId(Long id);

}
