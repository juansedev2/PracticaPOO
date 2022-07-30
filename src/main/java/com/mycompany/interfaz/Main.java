/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.interfaz;

import com.mycompany.modelo.Calzado;
import com.mycompany.modelo.Prenda_vestir;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Sebastian
 */
public class Main {

    public static void main(String[] args) {

        // Variables de control
        Scanner scn = new Scanner(System.in);
        ArrayList<Prenda_vestir> lista_prendas = new ArrayList();  // Arreglo para almacenar las prendas de vestir
        ArrayList<Calzado> lista_calzado = new ArrayList();  // Arreglo para almacenar el calzado
        int cant_insertar, opcion;
        boolean salida = false;

        while (!salida) {
            mostrarMenu();
            opcion = scn.nextInt();
            switch (opcion) {
                case 1 -> {
                    // Caso 1: Consultar información de productos
                    opcion = consultarNumProduco();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de consultar prendas
                            if (validarArreglo(lista_prendas)) {
                                System.out.println("No hay prendas registradas hasta el momento");
                            } else {
                                mostrarPrendas(lista_prendas);
                            }
                        }
                        case 2 -> {
                            // En caso de consultar calzado
                            if (validarArreglo(lista_calzado)) {
                                System.out.println("No hay calzado registrado hasta el momento");
                            } else {
                                mostrarCalzado(lista_calzado);
                            }
                        }
                        default ->
                            System.out.println("Fuera de rango");
                    }
                }
                case 2 -> // Verficar estado de productos en bodega
                    alertarProductos(lista_prendas, lista_calzado);
                case 3 -> {
                    // Caso 3: Insertar algún producto
                    opcion = consultarNumProduco();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de insertar prendas
                            System.out.println("Digite la cantidad de prendas a insertar");
                            cant_insertar = scn.nextInt();
                            agregarPrenda(cant_insertar, lista_prendas);
                        }
                        case 2 -> {
                            // En caso de insertar calzado
                            System.out.println("Digite la cantidad de calzado a insertar");
                            cant_insertar = scn.nextInt();
                            agregarCalzado(cant_insertar, lista_calzado);
                        }
                        default ->
                            System.out.println("Fuera de rango");
                    }
                }
                case 4 -> {
                    // Caso 4: Consultar calzado con mayor cantidad de unidades
                    if (validarArreglo(lista_calzado)) {
                        System.out.println("No hay calzado registrado hasta el momento");
                    } else {
                        mostrarCalzadoMayor(lista_calzado);
                    }
                }
                case 5 -> {
                    // Caso 5: Consultar calzado con mayor cantidad
                    if (validarArreglo(lista_prendas)) {
                        System.out.println("No hay prendas de vestir registradas hasta el momento");
                    } else {
                        mostrarPrendaMayor(lista_prendas);
                    }
                }
                case 6 -> {
                    // Caso 6: Modificar la cantidad mínima requerida de un producto
                    opcion = consultarNumProduco();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de modificar en prendas
                            if (validarArreglo(lista_prendas)) {
                                System.out.println("No hay prendas de vestir registradas hasta el momento");
                            } else {
                                modificarCantMinPrendas(lista_prendas);
                            }
                        }
                        case 2 -> {
                            // En caso de modificar en calzado
                            if (validarArreglo(lista_calzado)) {
                                System.out.println("No hay calzado registrado hasta el momento");
                            } else {
                                modificarCantMinCalzado(lista_calzado);
                            }
                        }
                        default ->
                            System.out.println("Fuera de rango");
                    }
                }
                case 7 -> {
                    // Caso 7: Vender un producto
                    opcion = consultarNumProduco();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de modificar en prendas
                            if (validarArreglo(lista_prendas)) {
                                System.out.println("No hay prendas de vestir registradas hasta el momento");
                            } else {
                                venderPrenda(lista_prendas);
                            }
                        }
                        case 2 -> {
                            // En caso de modificar en calzado
                            if (validarArreglo(lista_calzado)) {
                                System.out.println("No hay calzado registrado hasta el momento");
                            } else {
                                venderCalzado(lista_calzado);
                            }
                        }
                        default ->
                            System.out.println("Fuera de rango");
                    }
                }
                case 8 -> // Caso 8: Salidar del programa
                    salida = rectificarSalida();
                default ->
                    System.out.println("OPCION FUERA DE RANGO, DIGITE NUEVAMENTE");
            }
        }
        System.out.println("Gracias, vuelvan pronto");
    }

    // Función para mostrar el menú
    public static void mostrarMenu() {  // Recordar que en Java, en el main, los miembros de la clase (funciones) deben eser estáticos si se requiere acceder a ellos desde la misma clase
        System.out.println("=============================");
        System.out.println("MENU");
        System.out.println("1. Consultar producto"
                + "\n2. Verificar estado de productos en bodega"
                + "\n3. Insertar productos"
                + "\n4. Consultar calzado con mayor cantidad de unidades"
                + "\n5. Consultar prenda de vestir con  mayor cantidad de unidades"
                + "\n6. Modificar cantidad mínima requerida en bodega de un producto"
                + "\n7. Vender producto"
                + "\n8. SALIR DEL PROGRAMA");
    }

    // Función para rectificar salida
    public static boolean rectificarSalida() {
        Scanner scn = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println("¿Está seguro?");
        System.out.println("1. SI"
                + "\n2. NO");
        int opcion = scn.nextInt();
        return opcion == 1;
    }

    // Función para validar si hay elementos en el arreglo
    public static boolean validarArreglo(ArrayList arreglo) {
        return arreglo.isEmpty();  // Devuelve true si el arreglo no tiene elementos
    }

    // Fucntión para validar el tipo de producto a consultar
    public static int consultarNumProduco() {
        Scanner scn = new Scanner(System.in);
        System.out.println("¿Que producto va a tratar?"
                + "\n1. Prendas de vestir"
                + "\n2. Calzado");
        int opcion = scn.nextInt();
        return opcion;
    }

    // Función para solicitar datos de un producto de prenda de vestir
    public static void agregarPrenda(int cantidad_insertar, ArrayList lista_prendas) {

        Scanner scn = new Scanner(System.in);
        Prenda_vestir prenda;

        for (int i = 0; i < cantidad_insertar; i++) {

            prenda = new Prenda_vestir();
            System.out.println("PRODUCTO NÚMERO: " + (i + 1));
            System.out.println("================================");
            System.out.println("Digite el código del producto");
            int codigo = scn.nextInt();
            prenda.setCodigo(codigo);
            System.out.println("Digite la descripcion del producto");
            scn.reset();
            String descripcion = scn.nextLine();
            if (descripcion.equals("") || descripcion.equals(" ")) {
                descripcion = scn.nextLine();
            }
            prenda.setDescripcion(descripcion);
            System.out.println("Digite precio de compra");
            float precio = scn.nextFloat();
            prenda.setPrecio_compra(precio);
            System.out.println("Digite precio de venta");
            precio = scn.nextFloat();
            prenda.setPrecio_venta(precio);
            System.out.println("Digite la cantidad que hay en bodega");
            int cantidad_bodega = scn.nextInt();
            prenda.setCantidad_bodega(cantidad_bodega);
            System.out.println("Digite la cantidad mínima requerida");
            int cantidad = scn.nextInt();
            prenda.setCantidad_min_requerida(cantidad);
            System.out.println("Digite la cantidad máxima en inventario");
            cantidad = scn.nextInt();
            prenda.setCantidad_max_inventario(cantidad);
            System.out.println("¿Es posible plancharla?"
                    + "\n1.SI"
                    + "\n2.NO");
            int opcion = scn.nextInt();
            switch (opcion) {  // Nueva forma de implementar switch (misma lógica original)
                case 1 ->
                    prenda.setPlanchado(true);
                case 2 ->
                    prenda.setPlanchado(false);
                default ->
                    prenda.setPlanchado(false);
            }
            System.out.println("Digite la tallad del producto:"
                    + "\n S, M, L ...");
            String talla = scn.next();
            prenda.setTalla(talla);
            lista_prendas.add(prenda);
        }
        System.out.println("Producto/s de prenda de vestir registrado/s");

    }

    // Función para solicitar datos de un producto de prenda de vestir
    public static void agregarCalzado(int cantidad_insertar, ArrayList lista_calzado) {

        Scanner scn = new Scanner(System.in);
        Calzado calzado;

        for (int i = 0; i < cantidad_insertar; i++) {

            calzado = new Calzado();
            System.out.println("PRODUCTO NÚMERO: " + (i + 1));
            System.out.println("================================");
            System.out.println("Digite el código del producto");
            int codigo = scn.nextInt();
            calzado.setCodigo(codigo);
            System.out.println("Digite la descripcion del producto");
            scn.reset();
            String descripcion = scn.nextLine();
            if (descripcion.equals("") || descripcion.equals(" ")) {
                descripcion = scn.nextLine();
            }
            calzado.setDescripcion(descripcion);
            System.out.println("Digite precio de compra");
            float precio = scn.nextFloat();
            calzado.setPrecio_compra(precio);
            System.out.println("Digite precio de venta");
            precio = scn.nextFloat();
            calzado.setPrecio_venta(precio);
            System.out.println("Digite la cantidad que hay en bodega");
            int cantidad_bodega = scn.nextInt();
            calzado.setCantidad_bodega(cantidad_bodega);
            System.out.println("Digite la cantidad mínima requerida");
            int cantidad = scn.nextInt();
            calzado.setCantidad_min_requerida(cantidad);
            System.out.println("Digite la cantidad máxima en inventario");
            cantidad = scn.nextInt();
            calzado.setCantidad_max_inventario(cantidad);
            System.out.println("Digite la talla del producto (número):");
            int talla = scn.nextInt();
            calzado.setTalla(talla);
            lista_calzado.add(calzado);
        }
        System.out.println("Producto/s de calzado registrado/s");
    }

    // Función para mostrar los productos de prendas de vestir
    public static void mostrarPrendas(ArrayList<Prenda_vestir> lista_productos) {  // Se puede especificar el tipo de objeto de ArrayList que se debe recibir

        Scanner scn = new Scanner(System.in);

        System.out.println("¿Desea ver todos los productos o buscar un o en específicos?"
                + "\n1. Ver todos"
                + "\n2. Ver uno específico");
        int opcion = scn.nextInt();
        switch (opcion) {

            case 1 -> {

                for (Prenda_vestir prenda : lista_productos) {
                    System.out.println(prenda.toString());
                }

            }
            case 2 -> {

                System.out.println("Digite el código del producto a buscar (si no existe no mostrará nada)");
                int codigo = scn.nextInt();

                for (Prenda_vestir prenda : lista_productos) {
                    if (codigo == prenda.getCodigo()) {
                        System.out.println(prenda.toString());
                        break;
                    }
                }

            }
            default ->
                System.out.println("Opcion fuera de rango");
        }

    }

    // Función para mostrar los productos de calzado
    public static void mostrarCalzado(ArrayList<Calzado> lista_productos) {  // Se puede especificar el tipo de objeto de ArrayList que se debe recibir

        Scanner scn = new Scanner(System.in);
        System.out.println("¿Desea ver todos los productos o buscar un o en específicos?"
                + "\n1. Ver todos"
                + "\n2. Ver uno específico");
        int opcion = scn.nextInt();
        switch (opcion) {  // Una nueva e interesante forma de utilizar switch
            case 1 -> {

                for (Calzado calzado : lista_productos) {
                    System.out.println(calzado.toString());
                }
            }
            case 2 -> {

                System.out.println("Digite el código del producto a buscar (si no existe no mostrará nada)");
                int codigo = scn.nextInt();

                for (Calzado calzado : lista_productos) {
                    if (codigo == calzado.getCodigo()) {
                        System.out.println(calzado.toString());
                        break;
                    }
                }
            }
            default ->
                System.out.println("Opcion fuera de rango");
        }
    }

    // Función para alertar sobre productos que necesitan ser abastecidos (revisar clase padre Producto)
    public static void alertarProductos(ArrayList<Prenda_vestir> lista_prendas, ArrayList<Calzado> lista_calzado) {

        System.out.println("CONSULTA DE VERIFICACIÓN DE ESTADO DE PRODUCTOS EN BODEGA");
        System.out.println("NOTA: DE NO MOSTRARSE NADA, SIGNIFICA QUE TODO ESTÁ EN ORDEN");
        System.out.println("PRENDAS DE VESTIR: ");

        for (Prenda_vestir prenda : lista_prendas) {

            if (prenda.solicitarPedido()) {
                System.out.println(prenda.mostrarAlerta());
            }
        }

        System.out.println("CALZADO: ");
        for (Calzado calzado : lista_calzado) {
            if (calzado.solicitarPedido()) {
                System.out.println(calzado.mostrarAlerta());
            }
        }
        System.out.println("=====================================================");
    }

    // Función para mostrar la prenda de vestir con mayor cantidad en bodega
    public static void mostrarPrendaMayor(ArrayList<Prenda_vestir> lista_prendas) {
        String producto = null;
        int mayor = 0;
        for (Prenda_vestir prenda : lista_prendas) {
            if (prenda.getCantidad_bodega() > mayor) {
                mayor = prenda.getCantidad_bodega();
                producto = prenda.getDescripcion() + " con código: " + prenda.getCodigo();
            }
        }
        if (producto == null) {
            System.out.println("No hay elementos mayores a cero");  // Caso muy raro de suceder pero si pasa, corregir el algoritmo o revisar datos
        } else {
            System.out.println(producto + " es el producto de prenda de vestir con mayor cantidad en bodega");
        }
    }

    // Función para mostrar el calzado con mayor cantidad en bodega
    public static void mostrarCalzadoMayor(ArrayList<Calzado> lista_calzado) {
        String producto = null;
        int mayor = 0;
        for (Calzado calzado : lista_calzado) {
            if (calzado.getCantidad_bodega() > mayor) {
                mayor = calzado.getCantidad_bodega();
                producto = calzado.getDescripcion() + " con código: " + calzado.getCodigo();
            }
        }
        if (producto == null) {
            System.out.println("No hay elementos mayores a cero");  // Caso muy raro de suceder pero si pasa, corregir el algoritmo o revisar datos
        } else {
            System.out.println(producto + " es el producto de calzado con mayor cantidad en bodega");
        }

    }

    // Función para modificar la cantidad mínima de prendas en bodega
    public static void modificarCantMinPrendas(ArrayList<Prenda_vestir> lista_prendas) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite el código de la prenda de vestir (si no se encuentra, no se mostrará nada)");
        int codigo = scn.nextInt();

        for (Prenda_vestir prenda : lista_prendas) {
            if (prenda.getCodigo() == codigo) {
                System.out.println("La cantidad mínima requerida actual del producto en bodega es: " + prenda.getCantidad_min_requerida());
                System.out.println("Digite la nueva cantidad mínima requerida (NO PUEDE SER CERO NI MENOR A CERO)");
                codigo = scn.nextInt();
                prenda.setCantidad_min_requerida(codigo);
                System.out.println("Realizado, la nueva cantidad mínima requerida en bodega del producto ahora es:  " + prenda.getCantidad_min_requerida());
                break;
            }
        }
    }

    // Función para modificar la cantidad mínima de calzado en bodega
    public static void modificarCantMinCalzado(ArrayList<Calzado> lista_calzado) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite el código del calzado (si no se encuentra, no se mostrará nada)");
        int codigo = scn.nextInt();

        for (Calzado calzado : lista_calzado) {
            if (calzado.getCodigo() == codigo) {
                System.out.println("La cantidad mínima requerida actual del producto en bodega es: " + calzado.getCantidad_min_requerida());
                System.out.println("Digite la nueva cantidad mínima requerida (NO PUEDE SER CERO NI MENOR A CERO)");
                codigo = scn.nextInt();
                calzado.setCantidad_min_requerida(codigo);
                System.out.println("Realizado, la nueva cantidad mínima requerida en bodega del producto ahora es:  " + calzado.getCantidad_min_requerida());
                break;
            }
        }
    }

    // Función para realiza la venta de un producto de prenda de vestir
    public static void venderPrenda(ArrayList<Prenda_vestir> lista_prendas) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Digite el código de la prenda de vestir (Si no existe se cancela la compra)");
        int codigo = scn.nextInt();

        for (Prenda_vestir prenda : lista_prendas) {
            if (prenda.getCodigo() == codigo) {
                System.out.println("Producto: " + prenda.getDescripcion() + " con talla " + prenda.getTalla());
                System.out.println("Digite la cantidad que el cliente va a comprar");
                int cantidad = scn.nextInt();
                if (cantidad > prenda.getCantidad_bodega()) {
                    System.out.println("VENTA CANCELADA: No hay cantidad suficiente en bodega de este producto respecto a la cantidad que pide el cliente");
                    break;
                } else {
                    System.out.println("Preparando compra....");
                    System.out.println("Precio CON descuento: " + prenda.calcularTotalPagoDescuento(cantidad));
                    System.out.println("Precio SIN descuento: " + prenda.calcularTotalPago(cantidad));
                    System.out.println("¿Desea confirmar la compra?"
                            + "\n1.Si"
                            + "\n2.No");
                    int opcion = scn.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de confirmar la compra
                            System.out.println("ANUNCIE EL PRECIO MOSTRADO ANTERIORMENTE");
                            System.out.println("COMPRA REALIZADA");
                            prenda.setCantidad_bodega(prenda.getCantidad_bodega() - cantidad);  // Resto la cantidad de bodega actual con los comprados por el cliente
                            break;
                        }
                        case 2 -> {
                            System.out.println("COMPRA CANCELADA");
                            break;
                        }
                        default -> {
                            System.out.println("FUERA DE RANGO, compra cancelada");
                            break;
                        }
                    }
                }
            }
        }
    }

    // Función para realiza la venta de un producto de calzado
    public static void venderCalzado(ArrayList<Calzado> lista_calzado) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Digite el código del calzado (Si no existe se cancela la compra)");
        int codigo = scn.nextInt();

        for (Calzado calzado : lista_calzado) {
            if (calzado.getCodigo() == codigo) {
                System.out.println("Producto: " + calzado.getDescripcion() + " con talla " + calzado.getTalla());
                System.out.println("Digite la cantidad que el cliente va a comprar");
                int cantidad = scn.nextInt();
                if (cantidad > calzado.getCantidad_bodega()) {
                    System.out.println("VENTA CANCELADA: No hay cantidad suficiente en bodega de este producto respecto a la cantidad que pide el cliente");
                    break;
                } else {
                    System.out.println("Preparando compra....");
                    System.out.println("Precio CON descuento: " + calzado.calcularTotalPagoDescuento(cantidad));
                    System.out.println("Precio SIN descuento: " + calzado.calcularTotalPago(cantidad));
                    System.out.println("¿Desea confirmar la compra?"
                            + "\n1.Si"
                            + "\n2.No");
                    int opcion = scn.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            // En caso de confirmar la compra
                            System.out.println("ANUNCIE EL PRECIO MOSTRADO ANTERIORMENTE");
                            System.out.println("COMPRA REALIZADA");
                            calzado.setCantidad_bodega(calzado.getCantidad_bodega() - cantidad);  // Resto la cantidad de bodega actual con los comprados por el cliente
                            break;
                        }
                        case 2 -> {
                            System.out.println("COMPRA CANCELADA");
                            break;
                        }
                        default -> {
                            System.out.println("FUERA DE RANGO, compra cancelada");
                            break;
                        }
                    }
                }
            }
        }
    }
}
