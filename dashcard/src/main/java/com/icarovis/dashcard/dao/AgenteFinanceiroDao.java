package com.icarovis.dashcard.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.icarovis.dashcard.model.AgenteFinanceiro;

public interface AgenteFinanceiroDao extends CrudRepository<AgenteFinanceiro, Integer>{

	public ArrayList<AgenteFinanceiro> findAllByOrderByVolumeAsc();
	
	
}
