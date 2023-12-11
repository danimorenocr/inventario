package com.vainilla.apariencia;

import javax.swing.*;
import java.awt.*;

public class PanelRedondeado extends JPanel {

    private int radioEsquinas = 15; // Puedes ajustar este valor según tus preferencias

    public PanelRedondeado() {
        super();
        setOpaque(false); // Establece el JPanel como transparente para que se vean las esquinas redondeadas
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setColor(getBackground());
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, radioEsquinas, radioEsquinas);
        graphics.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    /**
     * Cambia el radio de las esquinas del panel.
     * @param radioEsquinas el nuevo valor para el radio de las esquinas
     */
    public void cambiarRadioEsquinas(int radioEsquinas) {
        this.radioEsquinas = radioEsquinas;
        repaint(); // Vuelve a pintar el panel cuando se actualiza el radio de las esquinas
    }
}
