package br.edu.infnet.microservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroservicoService {

	@Autowired
	private RestTemplate restTemplate;
	
	public String cotacao(String symbols) {
		return restTemplate.getForObject("https://query1.finance.yahoo.com/v7/finance/quote?symbols={symbols}", String.class, symbols);
	}
	
}
