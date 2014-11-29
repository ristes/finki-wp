package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Order;

public interface PaymentGateway {

	public boolean pay(Order order);
}
