package com.icarovis.dashcard.dto;

public class Consolidado {
	private String nomeAgente;
	private float volume;
	private int status;
	private long numeroOp;
	
	public Consolidado(String nomeAgente, float volume, int status, long numeroOp) {
		super();
		this.nomeAgente = nomeAgente;
		this.volume = volume;
		this.status = status;
		this.numeroOp = numeroOp;
	}
	public String getNomeAgente() {
		return nomeAgente;
	}
	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getNumeroOp() {
		return numeroOp;
	}
	public void setNumeroOp(long numeroOp) {
		this.numeroOp = numeroOp;
	}
	
	
}
