package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
