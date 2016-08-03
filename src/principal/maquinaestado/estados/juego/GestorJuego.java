/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

/**
 *
 * @author Jack_Wolfram
 */
public class GestorJuego implements EstadoJuego{

    private GestorMapa gestorMapa;
    Mapa mapa = new Mapa("/recursos/texto/mapa.ldv");
    
    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g);
    }
    
}
