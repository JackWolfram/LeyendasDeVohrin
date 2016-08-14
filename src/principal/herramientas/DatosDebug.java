/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.herramientas;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Jack_Wolfram
 */
public class DatosDebug {

    private static ArrayList<String> datos = new ArrayList<>();

    public static void enviarDato(final String dato) {
        datos.add(dato);
    }

    public static void vaciarDatos() {
        datos.clear();
    }

    public static void dibujarDatos(final Graphics g) {
        g.setColor(Color.white);

        for (int i = 0; i < datos.size(); i++) {
            Dibujo.dibujarString(g, datos.get(i), 6, 38 + i * 12);
        }
        datos.clear();
    }
}
