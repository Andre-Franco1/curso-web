package com.curso.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.curso.modelo.enums.Status;

@Entity
public class Inscricao {
	private Long codigo;
	private int isAlergico;
	private String alergia;
	private int isCondicaoFisica;
	private int comprovante;
	private int arquivo;
	private Date datainscricao;
	private String contato;
	private String telefoneContato;
	private Status status;
	private Categoria categoria;
	private Evento evento;
	private Atleta atleta;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public int getIsAlergico() {
		return isAlergico;
	}

	public void setIsAlergico(int isAlergico) {
		this.isAlergico = isAlergico;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public int getIsCondicaoFisica() {
		return isCondicaoFisica;
	}

	public void setIsCondicaoFisica(int isCondicaoFisica) {
		this.isCondicaoFisica = isCondicaoFisica;
	}

	public int getComprovante() {
		return comprovante;
	}

	public void setComprovante(int comprovante) {
		this.comprovante = comprovante;
	}

	public int getArquivo() {
		return arquivo;
	}

	public void setArquivo(int arquivo) {
		this.arquivo = arquivo;
	}

	public Date getDatainscricao() {
		return datainscricao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDatainscricao(Date datainscricao) {
		this.datainscricao = datainscricao;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_categoria")
	public Categoria getCategoria() {
		return categoria;
	}

	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_evento")
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codigo_atleta")
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


}
