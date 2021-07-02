package br.edu.ifce.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils {
    public static String FormatForMoney(Double value) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(value);
    }
}
