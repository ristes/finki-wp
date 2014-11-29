package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.Person;

public interface PersonRepository extends JpaSpecificationRepository<Person> {

	List<Person> findByCityId(Long id);

}
