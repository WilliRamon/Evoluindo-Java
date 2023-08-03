package br.com.cod3r.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	//Calculadora/somar/10/20
	//calculadora/subtrair?a=100&b=39
	
	@GetMapping("/somar/{a}/{b}")
	public int getSomar(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}
	
	@GetMapping("/subtrair")
	public int getSubtrair(@RequestParam(name = "a", defaultValue = "0") int a,
			@RequestParam(name = "b", defaultValue = "0") int b){
		return a - b;
	}
}
