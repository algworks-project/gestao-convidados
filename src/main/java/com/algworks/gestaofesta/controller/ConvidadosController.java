package com.algworks.gestaofesta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algworks.gestaofesta.model.Convidado;
import com.algworks.gestaofesta.repository.Convidados;

@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	/*@GetMapping("/convidados")
	public String listar() {
	return "ListaConvidados";
	}*/
	@Autowired
	private Convidados convidados;
	/*Enviando um objeto do Controller para a View*/
	//@GetMapping("/convidados")
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());

		return modelAndView;
		}

	//@PostMapping("/convidados")
	@PostMapping
	public String salvar(Convidado convidado) {
	this.convidados.save(convidado);
	
	/*Depois de salvar o convidado, seria interessante recarregar a página para que a
	pesquisa fosse executada novamente, e consequentemente a tabela com a lista de
	convidados atualizada.*/

	return "redirect:/convidados";
	}

}