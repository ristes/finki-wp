package mk.ukim.finki.wp.repository.impl;

import java.util.List;

import mk.ukim.finki.wp.model.City;
import mk.ukim.finki.wp.repository.CityRepository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImpl implements CityRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public City save(City city) {
		Long id = (Long) sessionFactory.getCurrentSession().save(city);
		return getById(id);
	}

	@Override
	public List<City> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				City.class);
		return criteria.list();
	}

	@Override
	public City getById(Long id) {
		return (City) sessionFactory.getCurrentSession().get(City.class, id);
	}

	@Override
	public void delete(City city) {
		sessionFactory.getCurrentSession().delete(city);
	}

}
