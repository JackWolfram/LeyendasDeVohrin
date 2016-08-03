/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import principal.control.Raton;
import principal.control.Teclado;
import principal.maquinaestado.GestorEstados;

/**
 *
 * @author Jack_Wolfram
 */
public class SuperficieDibujo extends Canvas{
    private static final long serialVersionUID = -6227038142688953660L;
    
    private final int ancho;
    private final int alto;
    
    private final Teclado teclado;
    private final Raton raton;
    
    public SuperficieDibujo(final int ancho, final int alto) {
        this.ancho = ancho;
        this.alto = alto;
        
        this.teclado = new Teclado();
        this.raton = new Raton();
        
        setIgnoreRepaint(true);
        setCursor(raton.obtenerCursor());
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(teclado);
        setFocusable(true);
        requestFocus();
    }
    
    public void dibujar(final GestorEstados ge) {
        BufferStrategy buffer = getBufferStrategy();
        
        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = buffer.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, ancho, alto);
        
        ge.dibujar(g);
        
        Toolkit.getDefaultToolkit().sync();
        
        g.dispose();
        
        buffer.show();
    }
    
    public Teclado obtenerTeclado() {
        return teclado;
    }
    
    public int obtenerAncho() {
        return ancho;
    }
    
    public int obtenerAlto() {
        return alto;
    }
    
}
