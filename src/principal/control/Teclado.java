/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jack_Wolfram
 */
public class Teclado implements KeyListener {

    public Tecla arriba = new Tecla();
    public Tecla abajo = new Tecla();
    public Tecla izquierda = new Tecla();
    public Tecla derecha = new Tecla();

    public boolean corriendo = false;
    public boolean inventarioActivo = false;
    public boolean menuActivo = false;
    public boolean debug = false;

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W:
                arriba.teclaPulsada();
                break;
            case KeyEvent.VK_S:
                abajo.teclaPulsada();
                break;
            case KeyEvent.VK_A:
                izquierda.teclaPulsada();
                break;
            case KeyEvent.VK_D:
                derecha.teclaPulsada();
                break;
            case KeyEvent.VK_SHIFT:
                corriendo = true;
                break;
            case KeyEvent.VK_I:
                inventarioActivo = !inventarioActivo;
                break;
            case KeyEvent.VK_F1:
                debug = !debug;
                break;
            case KeyEvent.VK_END:
                int teclaEsc = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?", "¡WARNING!", JOptionPane.YES_NO_OPTION);
                if (teclaEsc == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_W:
                arriba.teclaLiberada();
                break;
            case KeyEvent.VK_S:
                abajo.teclaLiberada();
                break;
            case KeyEvent.VK_A:
                izquierda.teclaLiberada();
                break;
            case KeyEvent.VK_D:
                derecha.teclaLiberada();
                break;
            case KeyEvent.VK_SHIFT:
                corriendo = false;
                break;
        }
    }
}
