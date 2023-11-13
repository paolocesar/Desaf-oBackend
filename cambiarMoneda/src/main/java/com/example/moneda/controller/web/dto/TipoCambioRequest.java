package com.example.moneda.controller.web.dto;

public class TipoCambioRequest {

    private Integer monedaOrigen;

    private Integer monedaDestino;

    private String descripcion;

    private Double tipo;

    public Integer getmonedaOrigen() {
        return monedaOrigen;
    }

    public void setmonedaOrigen(Integer monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public Integer getmonedaDestino() {
        return monedaDestino;
    }

    public void setmonedaDestino(Integer monedaDestino) {
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
