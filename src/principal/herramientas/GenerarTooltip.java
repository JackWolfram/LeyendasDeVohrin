/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.herramientas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;
import principal.graficos.SuperficieDibujo;

/**
 *
 * @author Jack_Wolfram
 */
public class GenerarTooltip {
    
    private static Point generarTooltip(final Point pi) {
        
        final int x = pi.x;
        final int y = pi.y;
        
        final Point centroCanvas = new Point(Constantes.CENTRO_VENTANA_X, Constantes.CENTRO_VENTANA_Y);
        
        final Point centroCanvasEscalado = new Point(EscaladorElementos.escalarPuntoArriba(centroCanvas).x, EscaladorElementos.escalarPuntoArriba(centroCanvas).y);
        
        final int margenCursor = 2;
        
        final Point pf = new Point();
        
        if(x <= centroCanvasEscalado.x) {
            if(y <= centroCanvasEscalado.y) {
                pf.x = x + Constantes.LADO_CURSOR + margenCursor;
                pf.y = y + Constantes.LADO_CURSOR + margenCursor;
            } else {
                pf.x = x + Constantes.LADO_CURSOR + margenCursor;
                pf.y = y - Constantes.LADO_CURSOR - margenCursor;
            }
        } else {
            if(y <= centroCanvasEscalado.y) {
                pf.x = x - Constantes.LADO_CURSOR - margenCursor;
                pf.y = y + Constantes.LADO_CURSOR + margenCursor;
            } else {
                pf.x = x - Constantes.LADO_CURSOR - margenCursor;
                pf.y = y - Constantes.LADO_CURSOR - margenCursor;
            }
        }
        return pf;
    }
    
    private static String obtenerPosicionTooltip(final Point pi) {
        final int x = pi.x;
        final int y = pi.y;
        
        final Point centroCanvas = new Point(Constantes.CENTRO_VENTANA_X, Constantes.CENTRO_VENTANA_Y);
        final Point centroCanvasEscalado = new Point(EscaladorElementos.escalarPuntoArriba(centroCanvas).x, EscaladorElementos.escalarPuntoArriba(centroCanvas).y);
        
        String posicion = "";
        
        if(x <= centroCanvasEscalado.x) {
            if(y <= centroCanvasEscalado.y) {
                posicion = "no";
            } else {
                posicion = "so";
            }
        } else {
            if(y <= centroCanvasEscalado.y) {
                posicion = "ne";
            } else {
                posicion = "se";
            }
        }
        return posicion;
    }
    
    public static void dibujarTooltip(final Graphics g, final SuperficieDibujo sd, final String texto) {
        
        final Point posicionRaton = sd.obtenerRaton().obtenerPuntoPosicion();
        final Point posicionTooltip = GenerarTooltip.generarTooltip(posicionRaton);
        final String pistaPosicion = GenerarTooltip.obtenerPosicionTooltip(posicionRaton);
        final Point posicionTooltipEscalada = EscaladorElementos.escalarPuntoAbajo(posicionTooltip);
        
        final int ancho = MedirString.medirAnchoPixeles(g, texto);
        final int alto = MedirString.medirAltoPixeles(g, texto);
        final int margenFuente = 2;
        
        Rectangle tooltip = null;
        
        switch(pistaPosicion){
            case "no":
                tooltip = new Rectangle(posicionTooltipEscalada.x, posicionTooltipEscalada.y, ancho + margenFuente * 2, alto + margenFuente * 2);
                break;
            case "ne":
                tooltip = new Rectangle(posicionTooltipEscalada.x - ancho, posicionTooltipEscalada.y, ancho + margenFuente * 2, alto + margenFuente * 2);
                break;
            case "so":
                tooltip = new Rectangle(posicionTooltipEscalada.x, posicionTooltipEscalada.y - alto, ancho + margenFuente * 2, alto + margenFuente * 2);
                break;
            case "se":
                tooltip = new Rectangle(posicionTooltipEscalada.x - ancho, posicionTooltipEscalada.y - alto, ancho + margenFuente * 2, alto + margenFuente);
                break;
        }
        
        Dibujo.dibujarRectanguloRelleno(g, tooltip, Color.black);
        Dibujo.dibujarString(g, texto, new Point(tooltip.x + margenFuente, tooltip.y + tooltip.height - margenFuente - 1), Color.white);
        
    }
    
}
