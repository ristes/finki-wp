package mk.ukim.finki.wp.repository;

import java.util.List;

import mk.ukim.finki.wp.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByCategoryId(Long id);

	List<Book> findByNameLikeOrderByIdDesc(String name);

}
