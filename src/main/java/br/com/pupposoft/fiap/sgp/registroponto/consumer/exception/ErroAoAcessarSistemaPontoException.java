package br.com.pupposoft.fiap.sgp.registroponto.consumer.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class ErroAoAcessarSistemaPontoException extends SystemBaseException {
	private static final long serialVersionUID = -4308164376145793198L;
	
	private final String code = "sgp.erroAoAcessarSistemaPonto";//NOSONAR
	private final String message = "Erro ao acessar sistema de ponto";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR

	
}
