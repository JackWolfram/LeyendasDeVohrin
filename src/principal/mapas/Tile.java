/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.mapas;

import java.awt.Rectangle;
import principal.sprites.Sprite;

/**
 *
 * @author Jack_Wolfram
 */
public class Tile {
    
    private final Sprite sprite;
    private final int id;
    private boolean solido;
    
    public Tile(final Sprite sprite, final int id) {
        this.sprite = sprite;
        this.id = id;
        solido = false;
    }
    
    public Tile(final Sprite sprite, final int id, final boolean solido) {
        this.sprite = sprite;
        this.id = id;
        this.solido = solido;
    }
    
    public Sprite obtenerSprite() {
        return sprite;
    }
    
    public int obtenerId() {
        return id;
    }
    
    public void establecerSolido(final boolean solido) {
        this.solido = solido;
    }
    
    public Rectangle obtenerLimites(final int x, final int y) {
        return new Rectangle(x, y, sprite.obtenerAncho(), sprite.obtenerAlto());
    }
    
    
}
