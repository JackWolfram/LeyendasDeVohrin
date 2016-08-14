/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import principal.Constantes;
import principal.GestorPrincipal;
import principal.control.GestorControles;
import principal.control.Raton;
import principal.herramientas.DatosDebug;
import principal.herramientas.Dibujo;
import principal.maquinaestado.GestorEstados;

/**
 *
 * @author Jack_Wolfram
 */
public class SuperficieDibujo extends Canvas {

    private static final long serialVersionUID = -6227038142688953660L;

    private final int ancho;
    private final int alto;

    private final Raton raton;

    public SuperficieDibujo(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;

        this.raton = new Raton(this);

        setIgnoreRepaint(true);
        setCursor(raton.obtenerCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(GestorControles.teclado);
        addMouseListener(raton);
        setFocusable(true);
        requestFocus();
    }

    public void actualizar() {
        raton.actualizar(this);
    }

    public void dibujar(final GestorEstados ge) {
        final BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(4);
            return;
        }

        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();

        Dibujo.reiniciarContadorObjetos();

        g.setFont(Constantes.MAIN_FONT);
        Dibujo.dibujarRectanguloRelleno(g, 0, 0, Constantes.ANCHO_PANTALLA_COMPLETA, Constantes.ALTO_PANTALLA_COMPLETA, Color.black);

        if (Constantes.FACTOR_ESCALADO_X != 1.0 || Constantes.FACTOR_ESCALADO_Y != 1.0) {
            g.scale(Constantes.FACTOR_ESCALADO_X, Constantes.FACTOR_ESCALADO_Y);
        }

        ge.dibujar(g);

        g.setColor(Color.white);

        Dibujo.dibujarString(g, "FPS: " + GestorPrincipal.obtenerFPS(), 6, 14);
        Dibujo.dibujarString(g, "APS: " + GestorPrincipal.obtenerAPS(), 6, 26);

        DatosDebug.enviarDato("ESCALA X: " + Constantes.FACTOR_ESCALADO_X);
        DatosDebug.enviarDato("ESCALA Y: " + Constantes.FACTOR_ESCALADO_Y);
        DatosDebug.enviarDato("OPF: " + Dibujo.obtenerContadorObjetos());

        if (GestorControles.teclado.debug) {
            DatosDebug.dibujarDatos(g);
        } else {
            DatosDebug.vaciarDatos();
        }

        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show();
    }

    public int obtenerAncho() {
        return ancho;
    }

    public int obtenerAlto() {
        return alto;
    }

    public Raton obtenerRaton() {
        return raton;
    }

}
