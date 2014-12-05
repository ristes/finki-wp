package mk.ukim.finki.wp.service.impl;

import java.util.ArrayList;
import java.util.List;

import mk.ukim.finki.wp.model.Book;
import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.repository.OrderRepository;
import mk.ukim.finki.wp.service.OrderService;
import mk.ukim.finki.wp.service.PaymentGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;

	@Autowired
	private PaymentGateway paymentGateway;

	@Override
	public Order saveOrUpdate(Order entity) {
		return repository.save(entity);
	}

	@Override
	public List<Order> findAll() {
		return repository.findAll();
	}

	@Override
	public Order findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public void addBookToOrder(Order order, Book book) {

		if (order.getBooks() == null) {
			order.setBooks(new ArrayList<Book>());
		}
		order.getBooks().add(book);

		repository.save(order);

	}

	@Override
	public void removeBookFromOrder(Order order, Book book) {
		if (order.getBooks() != null && order.getBooks().contains(book)) {
			order.getBooks().remove(book);
			repository.save(order);
		}
	}

	@Override
	public void closeOrder(Order order) {
		order.setClosed(true);
		repository.save(order);

	}

	@Override
	public boolean payOrder(Order order) {
		return paymentGateway.pay(order);
	}

	@Override
	public Order createOrder(List<Book> shoppingCart) {
		Order order = new Order();
		order.setBooks(shoppingCart);
		double totalPrice = 0d;
		for (Book b : shoppingCart) {
			totalPrice += b.getPrice();
		}
		order.setTotalPrice(totalPrice);
		repository.save(order);
		return order;
	}

}
