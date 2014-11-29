package mk.ukim.finki.wp.specifications;

import mk.ukim.finki.wp.model.BaseEntity;

import org.springframework.data.jpa.domain.Specification;

public interface BaseSpecification<T extends BaseEntity> {

	public Specification<T> getSpecification(String field, String value);
}
