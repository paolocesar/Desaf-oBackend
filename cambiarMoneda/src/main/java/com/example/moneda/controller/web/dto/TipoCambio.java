package com.example.moneda.controller.web.dto;

import javax.persistence.*;

@Entity
@Table(name = "TIPOCAMBIO")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_MONEDA_ORIGEN")
    private String monedaOrigen;

    @Column(name = "ID_MONEDA_DESTINO")
    private String monedaDestino;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "TIPO")
    private Double tipo;

    public TipoCambio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getTipo() {
        return tipo;
    }

    public void setTipo(Double tipo) {
        this.tipo = tipo;
    }
}
