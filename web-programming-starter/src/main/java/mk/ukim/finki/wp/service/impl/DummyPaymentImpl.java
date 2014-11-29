package mk.ukim.finki.wp.service.impl;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.PaymentGateway;

@Service
public class DummyPaymentImpl implements PaymentGateway {

	@Override
	public boolean pay(Order order) {
		System.out.println("Paying procedure..");
		return true;
	}

}
