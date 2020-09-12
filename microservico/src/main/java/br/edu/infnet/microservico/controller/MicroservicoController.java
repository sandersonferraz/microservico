package br.edu.infnet.microservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.microservico.extra.ConverteStJSON;
import br.edu.infnet.microservico.service.MicroservicoService;

@RestController
@RequestMapping("/")
public class MicroservicoController {

	@Autowired
	private MicroservicoService microservicoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> quotes(@RequestParam(value = "symbols", defaultValue = "TLS.AX,MUS.AX") String symbols) {

		String cotacao = microservicoService.cotacao(symbols);

		System.out.println(ConverteStJSON.converteStringParaJson(cotacao));

		return ResponseEntity.ok().body(ConverteStJSON.converteStringParaJson(cotacao));
	}

}