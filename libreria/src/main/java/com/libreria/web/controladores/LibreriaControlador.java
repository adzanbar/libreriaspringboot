package com.libreria.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LibreriaControlador {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
}
