package org.fao.plataformaECA.exceptionhandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcaExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource source;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String mensagemUsuario=source.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvidor=ex.getCause().toString();
		List<Erro> erros= Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvidor));
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros=criarListErrors(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	private List<Erro> criarListErrors(BindingResult bindingResult){
		List<Erro> erros= new ArrayList<>();
		for(FieldError fieldError: bindingResult.getFieldErrors()) {
		String mensagemUsuario=source.getMessage(fieldError, LocaleContextHolder.getLocale());
		String mensagemDesenvolvidor=fieldError.toString();
		erros.add(new Erro(mensagemUsuario, mensagemDesenvolvidor));
		}
		return erros;
	}
	public static class Erro{
		private String mensagemUsuario;
		private String mensagemDesenvolvidor;
		
		
		public Erro(String mensagemUsuario, String mensagemDesenvolvidor) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvidor = mensagemDesenvolvidor;
		}
		public String getMensagemUsuario() {
			return mensagemUsuario;
		}
		public String getMensagemDesenvolvidor() {
			return mensagemDesenvolvidor;
		}
		
		
	}
}
