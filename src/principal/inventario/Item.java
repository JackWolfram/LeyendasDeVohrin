/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.inventario;

import principal.Constantes;
import principal.sprites.HojaSprites;
import principal.sprites.Sprite;

/**
 *
 * @author Jack_Wolfram
 */
public class Item {
    
    public static HojaSprites hojaItems = new HojaSprites(Constantes.RUTA_ITEMS, 32, true);
    
    private final int id;
    private final String nombre;
    private final String descripcion;
    private final Sprite sprite;
    
    private int cantidad;
    private int cantidadMaxima;
    
    public Item (final int id, final String nombre, final String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sprite = hojaItems.obtenerSprite(id);
        
        cantidad = 0;
        cantidadMaxima = 10;
    }
    
    public Item (final int id, final String nombre, final String descripcion, final int cantidad) {
        this(id, nombre, descripcion);
        if(cantidad <= cantidadMaxima) {
            this.cantidad = cantidad;
        }
    }
    
    public Sprite obtenerSprite() {
        return sprite;
    }
    
    public boolean incrementarCantidad(final int incremento) {
        boolean incrementado = false;
        
        if(cantidad + incremento <= cantidadMaxima) {
            cantidad += incremento;
            incrementado = true;
        }
        
        return incrementado;
    }
    
    public boolean reducirCantidad(final int reduccion) {
        boolean reducido = false;
        
        if(cantidad - reduccion >= 0) {
            cantidad -= reduccion;
            reducido = true;
        }
        
        return reducido;
    }
    
    public int obtenerCantidad() {
        return cantidad;
    }
    
    public int obtenerId() {
        return id;
    }
    
}
