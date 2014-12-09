package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Order;
import mk.ukim.finki.wp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	public OrderService getService() {
		return service;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable Long id) {
		Order order = service.findById(id);
		ModelAndView res = new ModelAndView();
		res.setViewName("order");
		res.addObject("order", order);
		return res;
	}

}
