/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.herramientas;

import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author Jack_Wolfram
 */
public class MedirString {
    
    public static int medirAnchoPixeles(final Graphics g, final String s) {
        
        FontMetrics fm = g.getFontMetrics();
        
        return fm.stringWidth(s);
    }
    
    public static int medirAltoPixeles(final Graphics g, final String s) {
        
        FontMetrics fm = g.getFontMetrics();
        
        return (int)fm.getLineMetrics(s, g).getHeight();
    }
    
}
