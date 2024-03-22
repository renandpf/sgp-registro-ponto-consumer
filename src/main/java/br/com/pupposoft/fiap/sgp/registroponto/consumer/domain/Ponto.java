package br.com.pupposoft.fiap.sgp.registroponto.consumer.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ponto {
	private Long userId;
	private LocalDateTime dataHora;
}
