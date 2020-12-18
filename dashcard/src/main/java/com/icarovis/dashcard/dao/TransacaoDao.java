package com.icarovis.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.icarovis.dashcard.dto.Consolidado;
import com.icarovis.dashcard.model.AgenteFinanceiro;
import com.icarovis.dashcard.model.Transacao;

public interface TransacaoDao extends CrudRepository<Transacao, Integer>{
	
	public ArrayList<Transacao> findAllByAgente(AgenteFinanceiro agente);
	@Query("SELECT new com.icarovis.dashcard.dto.Consolidado(t.agente.nomeAgente, t.agente.volume, t.status, count(t.status))"
			+ "FROM Transacao t WHERE t.agente.id=:id GROUP BY t.status")
	public ArrayList<Consolidado> recuperarStatus(@Param("id") int id);
	

}
