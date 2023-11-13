package com.example.moneda.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


import javax.validation.constraints.NotNull;


@ConfigurationProperties("moneda.tipocambio")
@Validated
public class TipoCambioProperties {

    private Sol sol;
    private DolarUsa dolarUsa;
    private PesoMexicano pesoMexicano;

    public Sol getSol() {
        return sol;
    }

    public void setSol(Sol sol) {
        this.sol = sol;
    }

    public DolarUsa getDolarUsa() {
        return dolarUsa;
    }

    public void setDolarUsa(DolarUsa dolarUsa) {
        this.dolarUsa = dolarUsa;
    }

    public PesoMexicano getPesoMexicano() {
        return pesoMexicano;
    }

    public void setPesoMexicano(PesoMexicano pesoMexicano) {
        this.pesoMexicano = pesoMexicano;
    }

    public static class Sol{
        @NotNull(message = "El campo solADolarUsa no puede ser nulo")
        private Double solADolarUsa;

        @NotNull(message = "El campo solAPesoMexicano no puede ser nulo")
        private Double solAPesoMexicano;

        public Double getSolADolarUsa() {
            return solADolarUsa;
        }

        public void setSolADolarUsa(Double solADolarUsa) {
            this.solADolarUsa = solADolarUsa;
        }

        public Double getSolAPesoMexicano() {
            return solAPesoMexicano;
        }

        public void setSolAPesoMexicano(Double solAPesoMexicano) {
            this.solAPesoMexicano = solAPesoMexicano;
        }
    }

    public static class DolarUsa{
        @NotNull(message = "El campo dolarUsaASol no puede ser nulo")
        private Double dolarUsaASol;

        @NotNull(message = "El campo dolarUsaAPesoMexicano no puede ser nulo")
        private Double dolarUsaAPesoMexicano;

        public Double getDolarUsaASol() {
            return dolarUsaASol;
        }

        public void setDolarUsaASol(Double dolarUsaASol) {
            this.dolarUsaASol = dolarUsaASol;
        }

        public Double getDolarUsaAPesoMexicano() {
            return dolarUsaAPesoMexicano;
        }

        public void setDolarUsaAPesoMexicano(Double dolarUsaAPesoMexicano) {
            this.dolarUsaAPesoMexicano = dolarUsaAPesoMexicano;
        }
    }

    public static class PesoMexicano{
        @NotNull(message = "El campo pesosMexicanoASol no puede ser nulo")
        private Double pesosMexicanoASol;

        @NotNull(message = "El campo pesosMexicanoADolarUsa no puede ser nulo")
        private Double pesosMexicanoADolarUsa;

        public Double getPesosMexicanoASol() {
            return pesosMexicanoASol;
        }

        public void setPesosMexicanoASol(Double pesosMexicanoASol) {
            this.pesosMexicanoASol = pesosMexicanoASol;
        }

        public Double getPesosMexicanoADolarUsa() {
            return pesosMexicanoADolarUsa;
        }

        public void setPesosMexicanoADolarUsa(Double pesosMexicanoADolarUsa) {
            this.pesosMexicanoADolarUsa = pesosMexicanoADolarUsa;
        }
    }
}
