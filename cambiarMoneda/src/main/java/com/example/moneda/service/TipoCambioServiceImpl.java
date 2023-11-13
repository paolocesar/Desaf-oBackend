package com.example.moneda.service;

import com.example.moneda.config.TipoCambioProperties;
import com.example.moneda.controller.web.dto.CambioMonedaResponse;
import com.example.moneda.controller.web.dto.TipoCambio;
import com.example.moneda.repository.TipoCambioCrudRepository;
import com.example.moneda.repository.TipoCambioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioServiceImpl.class);
    private TipoCambioCrudRepository tipoCambioCrudRepository;
    private TipoCambioRepository tipoCambioRepository;

    private final TipoCambioProperties tipoCambioProperties;

    public TipoCambioServiceImpl(TipoCambioProperties tipoCambioProperties, TipoCambioCrudRepository tipoCambioCrudRepository,TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioProperties = tipoCambioProperties;
        this.tipoCambioCrudRepository = tipoCambioCrudRepository;
        this.tipoCambioRepository = tipoCambioRepository;
    }

    @Override
    public CambioMonedaResponse aplicarCambioYml(Double monto, String monedaOrigen, String monedaDestino) {

        CambioMonedaResponse CambioMonedaResponse = new CambioMonedaResponse();
        Double tipoCambio=0.00;

        // 1: PEN  2:USD  3:MXN
        if(monedaOrigen.equalsIgnoreCase("PEN") && monedaDestino.equalsIgnoreCase("USD")){
            tipoCambio=tipoCambioProperties.getSol().getSolADolarUsa();
        }else if(monedaOrigen.equalsIgnoreCase("PEN") && monedaDestino.equalsIgnoreCase("MXN")){
            tipoCambio=tipoCambioProperties.getSol().getSolAPesoMexicano();

        }else if(monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("PEN")){
            tipoCambio=tipoCambioProperties.getDolarUsa().getDolarUsaASol();
        }else if(monedaOrigen.equalsIgnoreCase("USD") && monedaDestino.equalsIgnoreCase("MXN")){
            tipoCambio=tipoCambioProperties.getSol().getSolAPesoMexicano();

        }else if(monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("PEN")){
            tipoCambio=tipoCambioProperties.getPesoMexicano().getPesosMexicanoASol();
        }else if(monedaOrigen.equalsIgnoreCase("MXN") && monedaDestino.equalsIgnoreCase("USD")){
            tipoCambio=tipoCambioProperties.getPesoMexicano().getPesosMexicanoADolarUsa();
        }

        CambioMonedaResponse.setMonto(monto);
        CambioMonedaResponse.setMontoTipoCambio(monto*tipoCambio);
        CambioMonedaResponse.setMonedaOrigen(monedaOrigen);
        CambioMonedaResponse.setMonedaDestino(monedaDestino);
        CambioMonedaResponse.setTipoCambio(tipoCambio);

        return CambioMonedaResponse;
    }

    @Override
    public CambioMonedaResponse aplicarCambio(Double monto, String monedaOrigen, String monedaDestino) {
        try {
            CambioMonedaResponse CambioMonedaResponse = new CambioMonedaResponse();
            Double tipoCambio = tipoCambioRepository.obtenerTipoCambio(monedaOrigen, monedaDestino);
            CambioMonedaResponse.setMonto(monto);
            CambioMonedaResponse.setMontoTipoCambio(monto * tipoCambio);
            CambioMonedaResponse.setMonedaOrigen(monedaOrigen);
            CambioMonedaResponse.setMonedaDestino(monedaDestino);
            CambioMonedaResponse.setTipoCambio(tipoCambio);

            return CambioMonedaResponse;
        }catch (Exception e){
            LOGGER.error("Ocurrio un error al cambiar la moneda: {}",e);
            return null;
        }
    }


    @Override
    public TipoCambio agregarTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioCrudRepository.save(tipoCambio);
    }

    @Override
    public Integer actualizarTipoCambio(TipoCambio tipoCambio) {
        return tipoCambioRepository.actualizarTipoCambio(tipoCambio);
    }

    @Override
    public Double obtenerTipoCambio(String monedaOrigen, String monedaDestino) {
        Double tipocambio= null;
        try {
            tipocambio = tipoCambioRepository.obtenerTipoCambio(monedaOrigen,monedaDestino);
            return tipocambio;
        } catch (Exception e) {
            LOGGER.error("Ocurrio un eror al obtener el tipo de cambio: {}",e);
            return null;
        }
    }

}
