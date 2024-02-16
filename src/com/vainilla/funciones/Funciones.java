package com.vainilla.funciones;

import java.text.NumberFormat;
import java.util.Locale;

public class Funciones {

    NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());

    public String formatoNumero(int numero) {
        String forma = formatoMoneda.format(numero).replace(",00", "");
        return forma;
    }
}
