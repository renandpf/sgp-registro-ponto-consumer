package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.domain.Ponto;

public interface SistemaPontoGateway {
	public void registrar(Ponto ponto);
	
}
