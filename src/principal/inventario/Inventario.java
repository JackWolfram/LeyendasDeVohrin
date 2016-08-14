/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.inventario;

import java.util.ArrayList;

/**
 *
 * @author Jack_Wolfram
 */
public class Inventario {
    
    public final ArrayList<Item> items;
    
    public Inventario() {
        items = new ArrayList<>();
        
        items.add(RegistroItems.items[0]);
        items.add(RegistroItems.items[1]);
        items.add(RegistroItems.items[2]);
        items.add(RegistroItems.items[3]);
        
        incrementarItem(RegistroItems.items[0], 5);
        incrementarItem(RegistroItems.items[1], 5);
        incrementarItem(RegistroItems.items[2], 5);
        incrementarItem(RegistroItems.items[3], 1);
        
    }
    
    public boolean incrementarItem(final Item item, final int cantidad) {
        boolean incrementado = false;
        for(Item itemActual: items) {
            if(itemActual.obtenerId() == item.obtenerId()) {
                itemActual.incrementarCantidad(cantidad);
                incrementado = true;
                break;
            }
        }
        return incrementado;
    }
}
