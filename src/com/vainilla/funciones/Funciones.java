package com.vainilla.funciones;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Funciones {

    private static NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());

    //FORMATO PUNTO DE MIL A LAS CAJAS
    public static void formatoMondeaCajas(JTextField textField) {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                formatText(textField);
            }

            private void formatText(JTextField textField) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    try {
                        NumberFormat format = new DecimalFormat("#,###");
                        String formattedText = format.format(format.parse(text));
                        textField.setText(formattedText);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                         JOptionPane.showMessageDialog(textField, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    //FORMATO NUMERO NATURAL A LBL
    public static String formatoNatural(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }

    //FORMATO MONEDA A LBL
    public static String formatoNumero(int numero) {
        String forma = formatoMoneda.format(numero).replace(",00", "");
        return forma;
    }
}
