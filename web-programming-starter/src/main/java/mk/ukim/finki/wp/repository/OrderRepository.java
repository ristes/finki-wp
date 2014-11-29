package mk.ukim.finki.wp.repository;

import mk.ukim.finki.wp.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
