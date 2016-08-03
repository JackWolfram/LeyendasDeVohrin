/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.control;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import principal.herramientas.CargadorRecursos;

/**
 *
 * @author Jack_Wolfram
 */
public class Raton {
    
    private final Cursor cursor;
    
    public Raton() {
        Toolkit configuracion = Toolkit.getDefaultToolkit();
        
        BufferedImage icono = CargadorRecursos.cargarImagenCompatibleTranslucida("/imagenes/cursores/Normal.png");
        
        Point punta = new Point(0, 0);
        
        this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor por defecto");
    }
    
    public Cursor obtenerCursor() {
        return this.cursor;
    }
}
