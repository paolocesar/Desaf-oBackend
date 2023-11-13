package com.example.moneda.repository;


import com.example.moneda.controller.web.dto.TipoCambio;

public interface TipoCambioRepository  {
    Double obtenerTipoCambio(String monedaOrigen, String monedaDestino);
    Integer actualizarTipoCambio(TipoCambio tipoCambio);
}
