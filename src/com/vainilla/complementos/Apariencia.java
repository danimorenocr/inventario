package com.vainilla.complementos;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Apariencia {

    public static ImageIcon cargarImagen(String nombreArchivo) {
        // Construir la ruta completa
        String ruta = "/com/vainilla/iconos/" + nombreArchivo;
        try {
            InputStream inputStream = Apariencia.class.getResourceAsStream(ruta);
            if (inputStream != null) {
                return new ImageIcon(ImageIO.read(inputStream));
            } else {
                System.err.println("No se pudo cargar la imagen: " + ruta);
                return null;
            }
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen: " + ruta);
            e.printStackTrace();
            return null;
        }
    }
}
