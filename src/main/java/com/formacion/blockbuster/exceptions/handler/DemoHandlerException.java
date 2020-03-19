package com.formacion.blockbuster.exceptions.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.formacion.blockbuster.exceptions.ResponseError;
import com.formacion.blockbuster.exceptions.generic.BadRequestException;
import com.formacion.blockbuster.exceptions.generic.NoContentException;
import com.formacion.blockbuster.exceptions.generic.NotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class DemoHandlerException extends ResponseEntityExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({
		NotFoundException.class,
	})
	@ResponseBody
	private ResponseError notFoundException(HttpServletRequest request, Exception ex) {
		return new ResponseError(ex, ex.getLocalizedMessage(), request.getRequestURI());
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler({
		NoContentException.class
	})
	@ResponseBody
	private ResponseError noContentException(HttpServletRequest request, Exception ex) {
		return new ResponseError(ex, ex.getLocalizedMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
		org.springframework.dao.DuplicateKeyException.class,
		javax.validation.ConstraintViolationException.class,
		BadRequestException.class
	})
	@ResponseBody
	private ResponseError badRequestException(HttpServletRequest request, Exception ex) {
		return new ResponseError(ex, ex.getLocalizedMessage(), request.getRequestURI());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({
		Exception.class
	})
	@ResponseBody
	private ResponseError internalServerErrorException(HttpServletRequest request, Exception ex) {
		return new ResponseError(ex, ex.getLocalizedMessage(), request.getRequestURI());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
		log.error("Ocurrió un error de validación");
		return new ResponseEntity<Object>(new ResponseError(ex, errorMessages.toString(), request.getContextPath()), HttpStatus.BAD_REQUEST);
	}

}
