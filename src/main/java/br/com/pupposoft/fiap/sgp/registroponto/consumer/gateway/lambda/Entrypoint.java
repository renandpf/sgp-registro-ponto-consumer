package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.lambda;

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
	
	private ObjectMapper objectMapper;
	
	public Entrypoint() {
		objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		if(System.getenv("IS_UNIT_TEST") == null) {
			SistemaPontoGateway sistemaPontoGateway = new SistemaPontoHttpRestGateway(System.getenv("SISTEMA_PONTO_BASEURL"), new ObjectMapper());
			registrarPontoUsecase = new RegistrarPontoUsecase(sistemaPontoGateway);
		}
	}
	
	@Override
	public ResponseJson handleRequest(Object input, Context context) {
		System.out.println("input=" + input);
		System.out.println("context=" + context);

		try {
			
			String[] split = input.toString().split("body=");
			split = split[1].split("},");
			
			String mensagem = split[0]+"}";
			
			Ponto ponto = objectMapper.readValue(mensagem, Ponto.class);
			
			registrarPontoUsecase.processar(ponto);
			return new ResponseJson(false, 200, new HashMap<>(), "OK");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);//NOSONAR
		}
	}
}
