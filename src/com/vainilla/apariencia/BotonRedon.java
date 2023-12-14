package com.vainilla.apariencia;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class BotonRedon extends JButton {

    private int radioEsquinas = 15; // Puedes ajustar este valor según tus preferencias

    public BotonRedon() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 15, 5, 15)); // Ajusta los márgenes como desees
        setBackground(Color.WHITE); // Color de fondo del botón
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addActionListener(e -> {
            // Código a ejecutar cuando se presiona el botón (puedes añadir tu lógica aquí)
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, radioEsquinas, radioEsquinas);
        graphics.dispose();
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 40); // Ajusta el tamaño predeterminado del botón según tus necesidades
    }

    /**
     * Cambia el radio de las esquinas del botón.
     *
     * @param radioEsquinas el nuevo valor para el radio de las esquinas
     */
    public void cambiarRadioEsquinas(int radioEsquinas) {
        this.radioEsquinas = radioEsquinas;
        repaint(); // Vuelve a pintar el botón cuando se actualiza el radio de las esquinas
    }
}
