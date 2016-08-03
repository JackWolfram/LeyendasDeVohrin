/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.maquinaestado.estados.juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import principal.GestorPrincipal;
import principal.herramientas.CargadorRecursos;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

/**
 *
 * @author Jack_Wolfram
 */
public class GestorJuego implements EstadoJuego{

    Mapa mapa = new Mapa("/texto/mapa.ldv");
    BufferedImage logo = CargadorRecursos.cargarImagenCompatibleTranslucida("/imagenes/iconos/Logo.png");
    
    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g);
        g.drawImage(logo, 640 - logo.getWidth() - 5, 360 - logo.getHeight() - 5, null);
    }
    
}
