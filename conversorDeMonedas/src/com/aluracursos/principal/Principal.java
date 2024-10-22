package com.aluracursos.principal;

import com.aluracursos.moneda.TasaDeCambio;
import com.aluracursos.recursos.ConsultaApi;
import com.aluracursos.recursos.ConversorDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaApi consultaApi = new ConsultaApi();
        Scanner lectura = new Scanner(System.in);

        TasaDeCambio cambio = consultaApi.obtieneTasaDeCambio();

        ConversorDeMoneda dolarAMonedaArgentina = new ConversorDeMoneda("USD",
                "ARS", cambio);

        ConversorDeMoneda dolarAMonedaBolivia = new ConversorDeMoneda("USD",
                "BOB", cambio);

        ConversorDeMoneda dolarAMonedaBrasil = new ConversorDeMoneda("USD",
                "BRL", cambio);

        ConversorDeMoneda dolarAMonedaChile = new ConversorDeMoneda("USD",
                "CLP", cambio);

        ConversorDeMoneda dolarAMonedaColombia = new ConversorDeMoneda("USD",
                "COP", cambio);


        String menu = """
                *************************************
                Sea bienvenido/a al conversor de moneda =)
                           
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Boliviano
                4) Boliviano =>> Dolar
                5) Dolar =>> Real Brasileño
                6) Real Brasileño =>> Dolar
                7) Dolar =>> Peso Chileno
                8) Peso Chileno =>> Dolar
                9) Dolar =>> Peso Colombiano
                10) Peso Colombiano =>> Dolar
                
                O escriba "Salir" para finalizar la aplicación 
                """;
        try {
            while (true) {
                System.out.println(menu);
                System.out.println("Elija una opción");
                var numeroDeOpcion = lectura.nextLine();

                if (numeroDeOpcion.equalsIgnoreCase("salir")) {
                    break;
                }
                System.out.println("Ingrese el valor que desea convertir");
                var monto = Double.parseDouble(lectura.nextLine());

                switch (numeroDeOpcion){
                    case "1":
                        dolarAMonedaArgentina.convierteMonedas(monto);
                        break;
                    case "2":
                        dolarAMonedaArgentina.convierteMonedasInversa(monto);
                        break;
                    case "3":
                        dolarAMonedaBolivia.convierteMonedas(monto);
                        break;
                    case "4":
                        dolarAMonedaBolivia.convierteMonedasInversa(monto);
                        break;
                    case "5":
                        dolarAMonedaBrasil.convierteMonedas(monto);
                        break;
                    case "6":
                        dolarAMonedaBrasil.convierteMonedasInversa(monto);
                        break;
                    case "7":
                        dolarAMonedaChile.convierteMonedas(monto);
                        break;
                    case "8":
                        dolarAMonedaChile.convierteMonedasInversa(monto);
                        break;
                    case "9":
                        dolarAMonedaColombia.convierteMonedas(monto);
                        break;
                    case "10":
                        dolarAMonedaColombia.convierteMonedasInversa(monto);
                        break;
                    default:
                        System.out.println("Ingrese un valor correcto");
                }


            }
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion");
            }

        System.out.println("\nFinalizando la aplicacion");
    }
}
