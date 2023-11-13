package com.example.moneda.controller.web;

import com.example.moneda.controller.web.dto.CambioMonedaResponse;
import com.example.moneda.controller.web.dto.TipoCambio;
import com.example.moneda.service.TipoCambioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rx.Observable;
import rx.functions.Action1;


@RestController
@RequestMapping("/api")
public class TipoCambioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioController.class);
    TipoCambioService tipoCambioService;

    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }
    @PostMapping(value = "/cambiarMonedaYml")
    public CambioMonedaResponse cambiarMonedaYml(@RequestParam("monto") Double monto, @RequestParam("monedaOrigen") String monedaOrigen, @RequestParam("monedaDestino") String monedaDestino) {

        final CambioMonedaResponse[] cambioMonedaResponse = {new CambioMonedaResponse()};

        Observable<Double> tipoCambioObservado = Observable.just(monto);
        tipoCambioObservado.subscribe(new Action1<Double>() {
            @Override
            public void call(Double monto) {
                cambioMonedaResponse[0] = tipoCambioService.aplicarCambioYml(monto, monedaOrigen, monedaDestino);
            }
        });

        LOGGER.info("se aplico tipo de cambio: {} ", cambioMonedaResponse[0].toString());
        return cambioMonedaResponse[0];
    }

    @PostMapping(value = "/cambiarMoneda")
    public CambioMonedaResponse cambiarMoneda(@RequestParam("monto") Double monto, @RequestParam("monedaOrigen") String monedaOrigen, @RequestParam("monedaDestino") String monedaDestino) {

        final CambioMonedaResponse[] cambioMonedaResponse = {new CambioMonedaResponse()};

        Observable<Double> tipoCambioObservado = Observable.just(monto);
        tipoCambioObservado.subscribe(new Action1<Double>() {
            @Override
            public void call(Double monto) {
                cambioMonedaResponse[0] = tipoCambioService.aplicarCambio(monto, monedaOrigen, monedaDestino);
            }
        });
        return cambioMonedaResponse[0];
    }

    @PostMapping(value = "/agregarTipoCambio")
    public TipoCambio agregarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        final TipoCambio[] tipoCambioNuevo = {new TipoCambio()};

        Observable<TipoCambio> tipoCambioObservado = Observable.just(tipoCambio);
        tipoCambioObservado.subscribe(new Action1<TipoCambio>() {
            @Override
            public void call(TipoCambio tipoCambio) {
                tipoCambioNuevo[0] = tipoCambioService.agregarTipoCambio(tipoCambio);
            }
        });

        return tipoCambioNuevo[0];

    }

    @PutMapping(value = "/actualizarTipoCambio")
    public HttpEntity<Integer> actualizarTipoCambio(@RequestBody TipoCambio tipoCambio) {
        final TipoCambio[] tipoCambioNuevo = {new TipoCambio()};
        final Integer[] status = {0};
        Observable<TipoCambio> tipoCambioObservado = Observable.just(tipoCambio);
        tipoCambioObservado
                .doOnNext(valor -> {
                    status[0] = tipoCambioService.actualizarTipoCambio(tipoCambio);
                })
                .doOnError(error -> {
                    LOGGER.error("Ocurrio un error al actualizar el tipo de cambio: {}", error.getMessage());
                })
                .doOnCompleted(() ->
                        LOGGER.info("se completo el proceso de actualizar el tipo de cambio"))
                .subscribe(valor -> LOGGER.info("valor: {}", valor));

        if(status[0] ==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping(value = "/obtenerTipoCambio")
    public Double obtenerTipoCambio(@RequestParam("monedaOrigen") String monedaOrigen, @RequestParam("monedaDestino") String monedaDestino) {

        final Double[] tipoCambio = {0.00};
        Observable<String> tipoCambioObservado = Observable.just(monedaOrigen, monedaDestino);
        tipoCambioObservado
                .doOnNext(valor -> {
                    tipoCambio[0] = tipoCambioService.obtenerTipoCambio(monedaOrigen, monedaDestino);
                })
                .doOnError(error -> {
                    LOGGER.error("Ocurrio un error al obtener el tipo de cambio: {}", error.getMessage());
                })
                .doOnCompleted(() ->
                        LOGGER.info("se completo el proceso de obtener el tipo de cambio"))
                .subscribe(valor -> LOGGER.info("valor: {}", valor));


        return tipoCambio[0];

    }


}
