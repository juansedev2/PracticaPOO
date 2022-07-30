/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author Juan Sebastian
 */
public abstract class Producto {
    
    // Atributos de la clase
    protected int codigo;
    protected String descripcion;
    protected float precio_compra;
    protected float precio_venta;
    protected int cantidad_bodega;
    protected int cantidad_min_requerida;
    protected int cantidad_max_inventario;
    protected float porcentaje_descuento;
    
    // Constructor de la clase

    public Producto() {
        this.porcentaje_descuento = 1;  // El descuento es el mismo para todo producto (requerimiento)
    }
    
    // Get y set de cada atributo

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCantidad_bodega() {
        return cantidad_bodega;
    }

    public void setCantidad_bodega(int cantidad_bodega) {
         if(cantidad_bodega < 0){  // La cantidad en bodega no debe ser menor a cero
            this.cantidad_bodega = 0;
        }else{
            this.cantidad_bodega = cantidad_bodega;
        }
    }

    public int getCantidad_min_requerida() {
        return cantidad_min_requerida;
    }

    public void setCantidad_min_requerida(int cantidad_min_requerida) {
        if(cantidad_min_requerida < 0){  // La cantidad mínima requerida en bodega no debe ser menor a cero
            this.cantidad_min_requerida = 0;
        }else{
            this.cantidad_min_requerida = cantidad_min_requerida;
        }
    }

    public int getCantidad_max_inventario() {
        return cantidad_max_inventario;
    }

    public void setCantidad_max_inventario(int cantidad_max_inventario) {
        this.cantidad_max_inventario = cantidad_max_inventario;
    }

    public float getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(float porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
    
    // Se debe arrojar una alerta en caso de que la cantidad en bodega sea menor a la cantidad mínima requerida
    public boolean solicitarPedido() {
        return this.cantidad_bodega < this.cantidad_min_requerida;
    }

    // Calcular el total a pagar con descuento
    public float calcularTotalPagoDescuento(int cantidad_productos) {
        // Calcular el total de pago de la sumatoria de los productos
        float el_descuento = (this.precio_venta * this.porcentaje_descuento) / 100;  // Obtengo el valor del descuento del producto
        // Sumo al precio el descuento y solo debo multiplicarlo por la cantidad de productos que haya
        return (this.precio_venta - el_descuento) * cantidad_productos;  // NOTA: ES MENOS EL DESCUENTO, NO MÁS (sería el IVA en ese caso)
    }
    
    // Calcular el total a pagar sin descuento
    public float calcularTotalPago(int cantidad_productos) {
        // NOTA: En este ejercicio no se solicita que sean de diversos productos, por lo tanto se trabaja con un mismo producto
        return this.precio_venta * cantidad_productos;  
    }
    
    public String mostrarAlerta(){  // Acompañará al método de alertar escasez en caso de que deba imprimir el producto
        return "Producto : " + this.descripcion + " con código: " + this.codigo + " necesita solicitar más productos al proveedor";
    }

    @Override  // Sobreescritua de override, método que me permite devolver toda la información del objeto
    public String toString() {
        return "Producto{" + "codigo : " + codigo + ", descripcion : " + descripcion + ", precio_compra : " + precio_compra + ", precio_venta : " + precio_venta + ", cantidad_bodega : " + cantidad_bodega + ", cantidad_min_requerida : " + cantidad_min_requerida + ", cantidad_max_inventario: " + cantidad_max_inventario + ", porcentaje_descuento : " + porcentaje_descuento + '}';
    }
    
}
