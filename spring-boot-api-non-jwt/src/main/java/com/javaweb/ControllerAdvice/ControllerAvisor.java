package com.javaweb.ControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.CustomExceptions.InvalidDataException;
import com.javaweb.dto.ErrorDetailDTO;

@ControllerAdvice
public class ControllerAvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmethicException(ArithmeticException ex){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
		errorDetailDTO.setError(ex.getMessage());
		List<String> detail= new ArrayList<String>();
		detail.add("Khong the chia cho 0");
		errorDetailDTO.setDetails(detail);
		return new ResponseEntity<>(errorDetailDTO,HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<Object> handlerInvalidDataException(InvalidDataException ex){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
		errorDetailDTO.setError(ex.getMessage());
		List<String> detail= new ArrayList<String>();
		detail.add("Ten hoac so tang ham dang thieu");
		errorDetailDTO.setDetails(detail);
		return new ResponseEntity<>(errorDetailDTO,HttpStatus.BAD_REQUEST);
	}
}
