/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.herramientas;

import java.awt.Point;
import java.awt.Rectangle;
import principal.Constantes;

/**
 *
 * @author Jack_Wolfram
 */
public class EscaladorElementos {
    
    public static Rectangle escalarRectanguloArriba(final Rectangle r) {
        
        final Rectangle rr = new Rectangle((int)(r.x * Constantes.FACTOR_ESCALADO_X), (int)(r.y * Constantes.FACTOR_ESCALADO_Y), (int)(r.width * Constantes.FACTOR_ESCALADO_X), (int)(r.height * Constantes.FACTOR_ESCALADO_X));
        
        return rr;
    }
    
    public static Point escalarPuntoArriba(final Point p) {
        
        final Point pr = new Point ((int)(p.x * Constantes.FACTOR_ESCALADO_X), (int)(p.y * Constantes.FACTOR_ESCALADO_Y));
        
        return pr;
    }
    
    public static Point escalarPuntoAbajo(final Point p) {
                
        final Point pr = new Point ((int)(p.x / Constantes.FACTOR_ESCALADO_X), (int)(p.y / Constantes.FACTOR_ESCALADO_Y));
        
        return pr;
    }
    
}
