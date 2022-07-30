/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author Juan Sebastian
 */
public class Prenda_vestir extends Producto {  // Hereda de la clase abstracta: Producto
    
    // Atributos de la clase
    private boolean planchado;
    private String talla;  // S, M, L

    public Prenda_vestir() {
        super();  // Llama al constructor de la clase padre (incluso es implícito pero mejor lo dejo escrito)
        /* Llamar al constructor de la super clase es realizar lo que este tenga programado
        (NOTA: Permite llamar todos los atributos y métodos de la clase padre) */
    }

    
    // Get y set de los atributos 
    
    public boolean isPlanchado() {
        return planchado;
    }

    public void setPlanchado(boolean planchado) {
        this.planchado = planchado;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    // toString
    @Override  // Sobreescritua de override, método que me permite devolver toda la información del objeto (etiqueta importante para el compilador)
    public String toString() {
        return super.toString() + ", permite planchado : " + planchado + ", talla: " + talla +'}';
    }
    
    
}
