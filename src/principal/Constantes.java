/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.Font;
import principal.herramientas.CargadorRecursos;

/**
 *
 * @author Jack_Wolfram
 */
public class Constantes {

    public static final int LADO_SPRITE = 32;
    public static int LADO_CURSOR = 0;

    public static final int ANCHO_JUEGO = 480;
    public static final int ALTO_JUEGO = 320;

//    public static final int ANCHO_PANTALLA_COMPLETA = 1920;
//    public static final int ALTO_PANTALLA_COMPLETA = 1080;
    
    public static final int ANCHO_PANTALLA_COMPLETA = 960;
    public static final int ALTO_PANTALLA_COMPLETA = 640;

    public static double FACTOR_ESCALADO_X = (double) ANCHO_PANTALLA_COMPLETA / (double) ANCHO_JUEGO;
    public static double FACTOR_ESCALADO_Y = (double) ALTO_PANTALLA_COMPLETA / (double) ALTO_JUEGO;

    public static int CENTRO_VENTANA_X = ANCHO_JUEGO / 2;
    public static int CENTRO_VENTANA_Y = ALTO_JUEGO / 2;

    public static String RUTA_MAPA_1 = "/mapas/01.ldv";
    public static String RUTA_MAPA_2 = "/mapas/02.ldv";
    public static String RUTA_ICONO_RATON = "/imagenes/cursores/Normal.png";
    public static String RUTA_PERSONAJE = "/imagenes/hojasPersonajes/Warrior1.png";
    public static String RUTA_ICONO_VENTANA = "/imagenes/iconos/iconoVentana.png";
    public static String RUTA_LOGOTIPO = "/imagenes/iconos/Logo.png";
    public static String RUTA_ITEMS = "/imagenes/hojasItems/Items01.png";

    public static Font MAIN_FONT = CargadorRecursos.cargarFuente("/fuentes/MAIN.ttf");
    
    public static final Color ROJO_OSCURO = new Color(200, 0, 0);
    public static final Color VERDE_OSCURO = new Color(0, 200, 0);
    public static final Color AZUL_OSCURO = new Color(0, 0, 200);
    public static final Color AMARILLO_OSCURO = new Color(200, 200, 0);
    public static final Color GOLD = new Color(255, 215, 0);
}
