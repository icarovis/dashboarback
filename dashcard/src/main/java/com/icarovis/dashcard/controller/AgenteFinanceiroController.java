package com.icarovis.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icarovis.dashcard.dao.AgenteFinanceiroDao;
import com.icarovis.dashcard.model.AgenteFinanceiro;

@RestController
@CrossOrigin("*")
public class AgenteFinanceiroController {
	
	@Autowired
	AgenteFinanceiroDao agDao;
	
	@GetMapping("/agentes")
	public ArrayList<AgenteFinanceiro> recuperatudo(){
		ArrayList<AgenteFinanceiro> lista;
		lista = agDao.findAllByOrderByVolumeAsc();
		return lista;
	}
	
	@PostMapping("/novoagente")
	public ResponseEntity<AgenteFinanceiro> adcionaNovoAgente(@RequestBody AgenteFinanceiro novo){
		try {
			agDao.save(novo);
			return ResponseEntity.status(201).body(novo);
		}
		catch(Exception ex) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	

}
