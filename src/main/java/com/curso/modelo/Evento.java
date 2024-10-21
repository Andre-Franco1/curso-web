package com.curso.modelo;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import com.curso.modelo.enums.Etapa;

@Entity
public class Evento {
    private Long codigo;
    private String local;
    private Date data;
    private String organizador;

    private Competicao competicao;
    private Etapa etapa;

    public Evento() {
    }

    public Evento(Long codigo, String local, Date data, String organizador) {
        this.codigo = codigo;
        this.local = local;
        this.data = data;
        this.organizador = organizador;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    @ManyToOne()
    @JoinColumn(name = "codigo_competicao")
    public Competicao getCompeticao() {
        return competicao;
    }

    public void setCompeticao(Competicao competicao) {
        this.competicao = competicao;
    }

    @Enumerated(EnumType.STRING)
    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

}