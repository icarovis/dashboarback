package com.icarovis.dashcard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icarovis.dashcard.dao.TransacaoDao;
import com.icarovis.dashcard.dto.Consolidado;
import com.icarovis.dashcard.model.AgenteFinanceiro;
import com.icarovis.dashcard.model.Transacao;

@RestController
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	TransacaoDao dao;
	
	@GetMapping("/transacao")
	public ArrayList<Transacao> recuperatudo(){
		ArrayList<Transacao> lista;
		lista = (ArrayList<Transacao>)dao.findAll();
		return lista;
		}


	@GetMapping("/totaisporagente")
	public ArrayList<Consolidado> recuperarTotaisPorAgente(@RequestParam(name="id") int id){
		int idAgente = id;
		long contStatus0 = 0;
		long contStatus1 = 0;
		long contStatus2 = 0;
		AgenteFinanceiro ag = new AgenteFinanceiro();
		ag.setId(idAgente);
		ArrayList<Transacao> listaTmp = dao.findAllByAgente(ag);
		for (Transacao t: listaTmp) {
			if (t.getStatus() == 0) {
				contStatus0++;
			}
			else if (t.getStatus() == 1) {
				contStatus1++;
			}
			else {
				contStatus2++;
			}
		}
		
		System.out.println("DEBUG = STATUS 0 = "+contStatus0);
		System.out.println("DEBUG = STATUS 1 = "+contStatus1);
		System.out.println("DEBUG = STATUS 2 = "+contStatus2);
		String nomeAgente = listaTmp.get(0).getAgente().getNomeAgente();
		float  volume = listaTmp.get(0).getAgente().getvolume();
		
		ArrayList<Consolidado> listaConsolidados = new ArrayList<Consolidado>();
		
		listaConsolidados.add(new Consolidado(nomeAgente, volume, 0, contStatus0));
		listaConsolidados.add(new Consolidado(nomeAgente, volume, 1, contStatus1));
		listaConsolidados.add(new Consolidado(nomeAgente, volume, 2, contStatus2));
		
		return listaConsolidados;
	}
	
	@GetMapping("/totaisconsolidado")
	public ArrayList<Consolidado> recuperarConsolidado(@RequestParam(name="id")int id){
	/*
		ArrayList<ConsolidadoStatus> lista=null;
		lista=dao.recuperarStatus(id);
		return lista;
		*/
		return dao.recuperarStatus(id);
	}
}
