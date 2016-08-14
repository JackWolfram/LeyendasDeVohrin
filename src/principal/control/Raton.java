/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.control;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;
import principal.Constantes;
import principal.graficos.SuperficieDibujo;
import principal.herramientas.CargadorRecursos;
import principal.herramientas.DatosDebug;

/**
 *
 * @author Jack_Wolfram
 */
public class Raton extends MouseAdapter {

    private final Cursor cursor;
    private final Point posicion;
    private boolean click;

    public Raton(final SuperficieDibujo sd) {
        Toolkit configuracion = Toolkit.getDefaultToolkit();

        BufferedImage icono = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_ICONO_RATON);

        Constantes.LADO_CURSOR = icono.getWidth();
        
        Point punta = new Point(0, 0);

        this.cursor = configuracion.createCustomCursor(icono, punta, "Cursor por defecto");

        posicion = new Point();
        actualizarPosicion(sd);
        
        click = false;
    }

    public void actualizar(final SuperficieDibujo sd) {
        actualizarPosicion(sd);
    }

    public void dibujar(final Graphics g) {
        DatosDebug.enviarDato("RX: " + posicion.x);
        DatosDebug.enviarDato("RY: " + posicion.y);
    }

    private void actualizarPosicion(final SuperficieDibujo sd) {
        final Point posicionInicial = MouseInfo.getPointerInfo().getLocation();

        SwingUtilities.convertPointFromScreen(posicionInicial, sd);

        posicion.setLocation(posicionInicial.x, posicionInicial.y);
    }
    
    public Point obtenerPuntoPosicion() {
        return posicion;
    }
    
    public Cursor obtenerCursor() {
        return this.cursor;
    }

    public Rectangle obtenerRectanguloPosicion() {
        final Rectangle area = new Rectangle(posicion.x, posicion.y, 1, 1);
        return area;
    }
    
    @Override
    public void mouseClicked(MouseEvent c) {
        if(!click) {
            click = true;
        }
    }
    
    public boolean obtenerClick() {
        return click;
    }
    
    public void reiniciarClick() {
        if (click) {
            click = false;
        }
    }
    
}
