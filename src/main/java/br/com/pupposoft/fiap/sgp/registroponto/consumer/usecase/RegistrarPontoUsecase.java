package br.com.pupposoft.fiap.sgp.registroponto.consumer.usecase;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.domain.Ponto;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.SistemaPontoGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrarPontoUsecase {
	
	private SistemaPontoGateway sistemaPontoGateway;
	
	public void processar(Ponto ponto) {
		sistemaPontoGateway.registrar(ponto);
	}

}
