package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.http.json;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.domain.Ponto;
import lombok.Getter;

@Getter
public class RequestBodyJson {
	private Long userId;
	private String dataHora;
	
	public RequestBodyJson(Ponto ponto) {
		userId = ponto.getUserId();
		dataHora = ponto.getDataHora().toString();
	}
}
