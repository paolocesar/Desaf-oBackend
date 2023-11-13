package com.example.moneda.service;

import com.example.moneda.controller.web.dto.CambioMonedaResponse;
import com.example.moneda.controller.web.dto.TipoCambio;

public interface TipoCambioService {
    CambioMonedaResponse aplicarCambioYml(Double monto, String monedaOrigen, String monedaDestino);

    CambioMonedaResponse aplicarCambio(Double monto, String monedaOrigen, String monedaDestino);

    TipoCambio agregarTipoCambio(TipoCambio tipoCambio);

    Integer actualizarTipoCambio(TipoCambio tipoCambio);

    Double obtenerTipoCambio(String monedaOrigen, String monedaDestino);
}
