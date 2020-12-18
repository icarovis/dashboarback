package com.icarovis.dashcard.dao;

import org.springframework.data.repository.CrudRepository;

import com.icarovis.dashcard.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{
	
	
	public Usuario findByEmailAndSenha(String email, String senha);

	public Usuario findEmailByNomeUsuario(String user);

	public Usuario findByEmailOrRacf(String email, String racf);
}
