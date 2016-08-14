/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.interfaz_usuario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import principal.Constantes;
import principal.entes.Jugador;
import principal.herramientas.Dibujo;
import principal.herramientas.MedirString;

/**
 *
 * @author Jack_Wolfram
 */
public class MenuInferior {

    private final Rectangle areaInventario;
    private final Rectangle bordeAreaInventario;

    private final int medidaVertical;
    private final int anchoTotal;



    public MenuInferior(final Jugador jugador) {
        int altoMenu = 64;
        areaInventario = new Rectangle(0, Constantes.ALTO_JUEGO - altoMenu, Constantes.ANCHO_JUEGO, altoMenu);
        bordeAreaInventario = new Rectangle(areaInventario.x, areaInventario.y - 1, areaInventario.width, 1);

        medidaVertical = 4;
        anchoTotal = 150;
    }

    public void dibujar(final Graphics g, Jugador jugador) {
        dibujarAreaInventario(g);
        dibujarBarraHP(g);
        dibujarBarraMP(g);
        dibujarBarraStamina(g, jugador.resistencia);
        dibujarBarraXP(g, 69);
        dibujarCantidadOro(g);
        dibujarRanuraArma(g);
        dibujarRanuraArmadura(g);
        dibujarRanuraAmuleto(g);
    }

    private void dibujarAreaInventario(final Graphics g) {
        Dibujo.dibujarRectanguloRelleno(g, areaInventario, Color.gray);
        Dibujo.dibujarRectanguloRelleno(g, bordeAreaInventario, Color.white);
    }

    private void dibujarBarraHP(final Graphics g) {
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical, anchoTotal, medidaVertical, Color.red);
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 2, anchoTotal, medidaVertical, Constantes.ROJO_OSCURO);

        g.setColor(Color.white);
        Dibujo.dibujarString(g, "HP", areaInventario.x + 12, areaInventario.y + medidaVertical * 3);
        Dibujo.dibujarString(g, "750", anchoTotal + 40, areaInventario.y + medidaVertical * 3);
    }

    private void dibujarBarraMP(final Graphics g) {
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 4, anchoTotal, medidaVertical, Color.blue);
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 5, anchoTotal, medidaVertical, Constantes.AZUL_OSCURO);

        g.setColor(Color.white);
        Dibujo.dibujarString(g, "MP", areaInventario.x + 10, areaInventario.y + medidaVertical * 6);
        Dibujo.dibujarString(g, "100", anchoTotal + 40, areaInventario.y + medidaVertical * 6);
    }

    private void dibujarBarraStamina(final Graphics g, final int resistencia) {
        final int ancho = anchoTotal * resistencia / Jugador.RESISTENCIA_TOTAL;

        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 7, ancho, medidaVertical, Color.green);
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 8, ancho, medidaVertical, Constantes.VERDE_OSCURO);

        g.setColor(Color.white);
        Dibujo.dibujarString(g, "STA", areaInventario.x + 4, areaInventario.y + medidaVertical * 9);
        Dibujo.dibujarString(g, "" + resistencia, anchoTotal + 40, areaInventario.y + medidaVertical * 9);
    }

    private void dibujarBarraXP(final Graphics g, final int experiencia) {
        final int ancho = anchoTotal * experiencia / 100;

        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 10, ancho, medidaVertical, Color.yellow);
        Dibujo.dibujarRectanguloRelleno(g, areaInventario.x + 32, areaInventario.y + medidaVertical * 11, ancho, medidaVertical, Constantes.AMARILLO_OSCURO);

        g.setColor(Color.white);
        Dibujo.dibujarString(g, "XP", areaInventario.x + 10, areaInventario.y + medidaVertical * 12);
        Dibujo.dibujarString(g, experiencia + "%", anchoTotal + 40, areaInventario.y + medidaVertical * 12);
    }

    private void dibujarCantidadOro(final Graphics g) {
        Dibujo.dibujarString(g, "Oro ", areaInventario.x + 6, areaInventario.y + medidaVertical * 15, Color.white);
        Dibujo.dibujarString(g, "69 Monedas", areaInventario.x + 48, areaInventario.y + medidaVertical * 15, Constantes.GOLD);
    }

    private void dibujarRanuraArma(final Graphics g) {
        g.setColor(Color.white);

        Dibujo.dibujarRectanguloRelleno(g, Constantes.ANCHO_JUEGO / 2, areaInventario.y + 8, 32, 32);

        Dibujo.dibujarString(g, "Arma", Constantes.ANCHO_JUEGO / 2, areaInventario.y + 52);
    }
    
    private void dibujarRanuraArmadura(final Graphics g) {
        g.setColor(Color.white);

        Dibujo.dibujarRectanguloRelleno(g, Constantes.ANCHO_JUEGO / 2 + 64, areaInventario.y + 8, 32, 32);

        Dibujo.dibujarString(g, "Armadura", Constantes.ANCHO_JUEGO / 2 + MedirString.medirAnchoPixeles(g, "Armadura"), areaInventario.y + 52);
    }
    
    private void dibujarRanuraAmuleto(final Graphics g) {
        g.setColor(Color.white);

        Dibujo.dibujarRectanguloRelleno(g, Constantes.ANCHO_JUEGO / 2 + Constantes.LADO_SPRITE * 4, areaInventario.y + 8, 32, 32);

        Dibujo.dibujarString(g, "Amuleto", Constantes.ANCHO_JUEGO / 2 + MedirString.medirAnchoPixeles(g, "Armadura") + MedirString.medirAnchoPixeles(g, "Amuleto") + 24, areaInventario.y + 52);
    }
    
}
