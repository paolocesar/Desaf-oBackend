package com.example.moneda.controller.web.dto;

public class CambioMonedaResponse {

    Double monto;
    Double montoTipoCambio;
    String monedaOrigen;
    String monedaDestino;
    Double tipoCambio;

    public CambioMonedaResponse() {
    }

    public CambioMonedaResponse(Double monto, Double montoTipoCambio, String monedaOrigen, String monedaDestino, Double tipoCambio) {
        this.monto = monto;
        this.montoTipoCambio = montoTipoCambio;
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoCambio = tipoCambio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMontoTipoCambio() {
        return montoTipoCambio;
    }

    public void setMontoTipoCambio(Double montoTipoCambio) {
        this.montoTipoCambio = montoTipoCambio;
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

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

}
