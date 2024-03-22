package br.com.pupposoft.fiap.sgp.registroponto.consumer.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ponto {
	private Long userId;
	private LocalDateTime dataHora;
}
