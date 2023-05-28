package es.ind.ordercriteria.domain.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Criteria Not Found")
public class CriteriaNotFoundException extends RuntimeException{
}
