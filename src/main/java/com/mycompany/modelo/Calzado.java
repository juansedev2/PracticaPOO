/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author Juan Sebastian
 */
public class Calzado extends Producto{
    
    // Atributos de la clase
    private int talla;
    
    // Constructor de la clase
    public Calzado(){
        super();
    }   
    
    // Get y set de los atributos

    public int getTalla() {
        return talla;
    }
    
    public void setTalla(int talla) {
        this.talla = talla;
    }
    
    // toString mejorado
    @Override
    public String toString() {
        return super.toString() + "Calzado{" + "talla=" + talla + '}';
    }
    
    /*
    
    // toString
    @Override  // Sobreescritua de toString, método que me permite devolver toda la información del objeto, esta etiqueta indica sobreescritura PERO manteniendo firma del padre(TIPO DE FUNCIÓN) y únicamente se modifica el funcionamiento, sin esto, no funcionaría y solo modifica el hijo, no el padre
    public String toString() {
        return "Producto{" + "codigo :" + codigo + ", descripcion :" + descripcion + ", precio_compra : " 
                + precio_compra + ", precio_venta=" + precio_venta + ", cantidad_bodega : " + cantidad_bodega 
                + ", cantidad_min_requerida : " + cantidad_min_requerida + ", cantidad_max_inventario : " 
                + cantidad_max_inventario + ", porcentaje_descuento : " + porcentaje_descuento 
                + ", talla: " + talla +'}';
    }
    // NOTA: Se puede llamar al super.toString() para llamar a toString del padre e incluso sucesivamente*/

}
