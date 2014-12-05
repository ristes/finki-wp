package mk.ukim.finki.wp.service;

import java.util.List;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Order;

public interface OrderService {

	public Order saveOrUpdate(Order entity);

	public List<Order> findAll();

	public Order findById(Long id);

	public void delete(Long id);

	public void addBookToOrder(Order order, Book book);

	public void removeBookFromOrder(Order order, Book book);

	public void closeOrder(Order order);

	public boolean payOrder(Order order);

	public Order createOrder(List<Book> shoppingCart);
}
