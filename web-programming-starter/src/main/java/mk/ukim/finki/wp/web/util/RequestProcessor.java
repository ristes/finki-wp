package mk.ukim.finki.wp.web.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import mk.ukim.finki.wp.model.BaseEntity;
import mk.ukim.finki.wp.specifications.BaseSpecification;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

public class RequestProcessor {
	public static Sort sorting(HttpServletRequest request) {
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			if (key.startsWith("sorting")) {
				String field = key.substring(key.indexOf("[") + 1,
						key.indexOf("]"));
				String direction = request.getParameter(key);
				Sort sort = new Sort(Sort.Direction.fromString(direction),
						field);
				return sort;
			}
		}
		return new Sort("id");
	}

	public static <T extends BaseEntity> Specification<T> getSpecifications(
			HttpServletRequest request, BaseSpecification<T> specifications) {
		Enumeration<String> keys = request.getParameterNames();
		Specification<T> result = null;
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			if (key.startsWith("filter")) {
				String field = key.substring(key.indexOf("[") + 1,
						key.indexOf("]"));
				String value = request.getParameter(key);

				result = Specifications.where(result).and(
						specifications.getSpecification(field, value));
			}
		}
		return result;
	}
}
