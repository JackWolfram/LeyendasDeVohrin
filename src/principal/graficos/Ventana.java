/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.graficos;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import principal.Constantes;
import principal.herramientas.CargadorRecursos;

/**
 *
 * @author Jack_Wolfram
 */
public class Ventana extends JFrame {

    private static final long serialVersionUID = 5979421777239930009L;

    private final String titulo;
    private final ImageIcon icono;

    public Ventana(final String titulo, final SuperficieDibujo sd) {
        this.titulo = titulo;

        BufferedImage imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(Constantes.RUTA_ICONO_VENTANA);
        this.icono = new ImageIcon(imagen);

        configurarVentana(sd);
    }

    private void configurarVentana(final SuperficieDibujo sd) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(icono.getImage());
        setLayout(new BorderLayout());
        add(sd, BorderLayout.CENTER);
        //setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
