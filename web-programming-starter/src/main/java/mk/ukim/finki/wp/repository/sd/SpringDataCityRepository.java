package mk.ukim.finki.wp.repository.sd;

import java.util.List;

import mk.ukim.finki.wp.model.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCityRepository extends JpaRepository<City, Long> {
	public List<City> findByCountryId(Long id);
}
