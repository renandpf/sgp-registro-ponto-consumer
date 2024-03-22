package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.lambda;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.domain.Ponto;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.SistemaPontoGateway;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.http.SistemaPontoHttpRestGateway;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.lambda.json.ResponseJson;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.usecase.RegistrarPontoUsecase;


public class Entrypoint implements RequestHandler<Object, ResponseJson> {

	private RegistrarPontoUsecase registrarPontoUsecase;
	
	public Entrypoint() {
		if(System.getenv("IS_UNIT_TEST") == null) {
			SistemaPontoGateway sistemaPontoGateway = new SistemaPontoHttpRestGateway(new ObjectMapper());
			registrarPontoUsecase = new RegistrarPontoUsecase(sistemaPontoGateway);
		}
	}
	
	@Override
	public ResponseJson handleRequest(Object input, Context context) {
		System.out.println("input=" + input);
		System.out.println("context=" + context);

		try {
			
			//FIXME: transformar "input" em "Ponto"
			
			registrarPontoUsecase.processar(new Ponto(15L, LocalDateTime.now()));//NOSONAR //FIXME
			return new ResponseJson(false, 200, new HashMap<>(), "OK");
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJson(false, 500, new HashMap<>(), e.getMessage());
		}
	}
}
