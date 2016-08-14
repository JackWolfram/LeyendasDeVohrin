/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.inventario;

import java.awt.Point;

/**
 *
 * @author Jack_Wolfram
 */
public class ContenedorItems {
    
    private Point posicion;
    private Item[] items;
    
    public ContenedorItems(final Point posicion, final int[] items, final int[] cantidades) {
        
        this.posicion = posicion;
        this.items = new Item[items.length];
        
        for(int i = 0; i < items.length; i++) {
            this.items[i] = RegistroItems.items[items[i]];
            this.items[i].incrementarCantidad(cantidades[i]);
        }
        
    }
    
}
