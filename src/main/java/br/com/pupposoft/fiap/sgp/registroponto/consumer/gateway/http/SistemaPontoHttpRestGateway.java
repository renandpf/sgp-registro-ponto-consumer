package br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.http;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pupposoft.fiap.sgp.registroponto.consumer.domain.Ponto;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.exception.ErroAoAcessarSistemaPontoException;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.SistemaPontoGateway;
import br.com.pupposoft.fiap.sgp.registroponto.consumer.gateway.http.json.RequestBodyJson;
import lombok.AllArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@AllArgsConstructor
public class SistemaPontoHttpRestGateway implements SistemaPontoGateway {

	private ObjectMapper objectMapper;
	
	@Override
	public void registrar(Ponto ponto) {
		try {
			String messageStr = objectMapper.writeValueAsString(new RequestBodyJson(ponto));
			
			OkHttpClient client = new OkHttpClient().newBuilder()
					.build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(messageStr, mediaType);
			Request request = new Request.Builder()
					.url("http://localhost:8081/pontos")
					.method("POST", body)
					.addHeader("Content-Type", "application/json")
					.build();
			client.newCall(request).execute();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErroAoAcessarSistemaPontoException();
		}
	}
}
