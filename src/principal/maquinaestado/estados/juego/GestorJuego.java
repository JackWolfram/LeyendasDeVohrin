/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.maquinaestado.estados.juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import principal.Constantes;
import principal.entes.Jugador;
import principal.herramientas.CargadorRecursos;
import principal.herramientas.DatosDebug;
import principal.herramientas.Dibujo;
import principal.interfaz_usuario.MenuInferior;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

/**
 *
 * @author Jack_Wolfram
 */
public class GestorJuego implements EstadoJuego {

    Mapa mapa;
    Jugador jugador;
    BufferedImage logo;
    MenuInferior menuInferior;

    public GestorJuego() {
        iniciarMapa(Constantes.RUTA_MAPA_1);
        iniciarJugador();
        menuInferior = new MenuInferior(jugador);
        logo = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_LOGOTIPO);
    }

    private void recargarJuego() {
        final String ruta = "/mapas/" + mapa.obtenerSiguienteMapa();

        iniciarMapa(ruta);
        iniciarJugador();
    }

    private void iniciarMapa(final String ruta) {
        mapa = new Mapa(ruta);
    }

    private void iniciarJugador() {
        jugador = new Jugador(mapa);
    }

    @Override
    public void actualizar() {
        if (jugador.obtener_LIMITE_ARRIBA().intersects(mapa.obtenerZonaSalida())) {
            recargarJuego();
        }

        jugador.actualizar();
        mapa.actualizar((int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
    }

    @Override
    public void dibujar(Graphics g) {
        mapa.dibujar(g, (int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
        jugador.dibujar(g);
        menuInferior.dibujar(g, jugador);

        //Dibujo.dibujarImagen(g, logo, Constantes.ANCHO_JUEGO - logo.getWidth() - 5, 0 + 2);

        Dibujo.dibujarRectanguloRelleno(g, mapa.obtenerZonaSalida().x, mapa.obtenerZonaSalida().y, mapa.obtenerZonaSalida().width, mapa.obtenerZonaSalida().height);

        DatosDebug.enviarDato("X = " + jugador.obtenerPosicionX());
        DatosDebug.enviarDato("Y = " + jugador.obtenerPosicionY());
        DatosDebug.enviarDato("Siguiente mapa: " + mapa.obtenerSiguienteMapa());
        DatosDebug.enviarDato("Coordenadas salida X: " + mapa.obtenerPuntoSalida().x);
        DatosDebug.enviarDato("Coordenadas salida Y: " + mapa.obtenerPuntoSalida().y);
    }
}
