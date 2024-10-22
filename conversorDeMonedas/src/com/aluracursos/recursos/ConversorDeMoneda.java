package com.aluracursos.recursos;

import com.aluracursos.moneda.TasaDeCambio;

public class ConversorDeMoneda {
    private String codigoMonedaOrigen;
    private String codigoMonedaDestino;
    private double valorMonedaOrigen;
    private double valorMonedaDestino;
    private TasaDeCambio tasaDeCambio;

    public ConversorDeMoneda(String codigoMonedaOrigen, String codigoMonedaDestino, TasaDeCambio tasaDeCambio) {
        this.codigoMonedaOrigen = codigoMonedaOrigen;
        this.codigoMonedaDestino = codigoMonedaDestino;
        this.tasaDeCambio = tasaDeCambio;

        this.valorMonedaOrigen = tasaDeCambio.conversion_rates().get(codigoMonedaOrigen);
        this.valorMonedaDestino = tasaDeCambio.conversion_rates().get(codigoMonedaDestino);

    }

    public void convierteMonedas (double monto){
        System.out.printf("El valor %.2f [%s] corresponde el valor final de =>>> %.2f [%s]\n",monto, codigoMonedaOrigen,
                ((valorMonedaDestino * monto)/valorMonedaOrigen),codigoMonedaDestino);

    }

    public void convierteMonedasInversa (double monto){
        System.out.printf("El valor %.2f [%s] corresponde el valor final de =>>> %.2f [%s]\n",monto, codigoMonedaDestino,
                ((valorMonedaOrigen * monto)/valorMonedaDestino),codigoMonedaOrigen);
    }


}
