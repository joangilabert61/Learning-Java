package com.trifulcas.pla6alumnos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
	
	@RequestMapping("/")
	public String verPagina() {return "inicio";}

}
