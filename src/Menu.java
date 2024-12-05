import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public void Menu() {

        Scanner sc = new Scanner(System.in);
        List<Producto> productos = Invetario.leerProdArchivos(Utilities.getNombreArchivo());

        while (true) {
            System.out.println("Menu inicial:");
            System.out.println("Seleccione una opcion en el menu: ");
            System.out.println("1. Buscar productos");
            System.out.println("2. Buscar categoria");
            System.out.println("3. Agregar productos");
            System.out.println("4. Actualizar productos");
            System.out.println("5. Eliminar productos");
            System.out.println("6. Mostrar productos");
            System.out.println("7. Guardar cambios: ");
            System.out.println("8. Cantidad de productos por categoria");
            System.out.println("9. Calcular Precio de Producto");
            System.out.println("10. Salir");
            System.out.print("Elige una opción del menu: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Para buscar el producto ingrese el ID: ");
                    int idProducto = sc.nextInt();
                    Producto buscarProdId = Invetario.buscarProductoPorId(productos, idProducto);
                    if (buscarProdId != null) {
                        System.out.println("El producto se encuentra almacenado: " + buscarProdId);
                    } else {
                        System.out.println("El producto no se encuentra almacenado");
                    }
                    break;
                case 2:
                    System.out.print("Para buscar el producto ingrese la categoria: ");
                    String categoriaProdcuto = sc.nextLine();
                    Producto buscarProductoPorCategoria = Invetario.buscarProductoPorCategoria(productos, categoriaProdcuto);
                    if (buscarProductoPorCategoria != null) {
                        System.out.println("El producto se encuentra almacenado: " + buscarProductoPorCategoria);
                    } else {
                        System.out.println("El producto no se encuentra almacenado");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el Id del producto: ");
                    int idProducto1 = sc.nextInt();
                    sc.nextLine();
                    Producto produEncontrado1 = Invetario.buscarProductoPorId(productos, idProducto1);
                    if (produEncontrado1 == null) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreNuevoProduc = sc.nextLine();
                        System.out.print("Ingrese la categoría del producto: ");
                        String categoriaNuevoProduc = sc.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        double precioNuevoProduc = sc.nextDouble();
                        System.out.print("Ingrese la cantidad del producto: ");
                        int cantidadNuevoProduc = sc.nextInt();
                        Producto nuevoProducto = new Producto(idProducto1, nombreNuevoProduc, categoriaNuevoProduc, precioNuevoProduc, cantidadNuevoProduc);
                        boolean actua1 = Invetario.agregarProducto(productos, idProducto1, nuevoProducto);
                        if (actua1) {
                            System.out.println("Producto Agregado.");
                        }
                    }
                    System.out.println("El id ya se encuentra en el inventario");
                        break;

                case 4:

                    System.out.print("Introduce el ID del producto a actualizar: ");
                    int idActualizarProd = sc.nextInt();
                    sc.nextLine();
                    Producto produEncontrado = Invetario.buscarProductoPorId(productos, idActualizarProd);
                    if (produEncontrado != null) {
                        System.out.println("Producto fue encontrado: " + produEncontrado);
                        System.out.print("Ingrese el nuevo nombre del producto: ");
                        String nuevoNombreProd = sc.nextLine();
                        System.out.print("Ingrese la nueva categoría producto : ");
                        String nuevaCategoriaProd = sc.nextLine();
                        System.out.print("Ingrese el nuevo precio producto : ");
                        double nuevoPrecioProd = sc.nextDouble();
                        System.out.print("Ingrese la nueva cantidad producto : ");
                        int nuevaCantidadProd = sc.nextInt();

                        Producto productoActualizado = new Producto(idActualizarProd, nuevoNombreProd, nuevaCategoriaProd, nuevoPrecioProd, nuevaCantidadProd);
                        boolean actua = Invetario.actualizarProductoId(productos, idActualizarProd, productoActualizado);
                        if (actua) {
                            System.out.println("Producto actualizado.");
                        } else {
                            System.out.println("No se encontró el producto para actualizar.");
                        }
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                 case 5:
                    System.out.print("Ingrese el ID del producto que desea eliminar: ");
                    int idEliminarProd = sc.nextInt();
                    boolean eliminaProd = Invetario.eliminarProductoId(productos, idEliminarProd);
                    if (eliminaProd) {
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("No se encontró el producto para eliminar.");
                    }
                    break;

                case 6:
                    System.out.println("\nLista de productos:");
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                    break;

                case 7:
                    Invetario.almacenarProductoArchivo(Utilities.getNombreArchivo(), productos);
                break;
                case 8:
                    Map<String, Integer> productosPorCategoria = Invetario.cantidadCategoria(Utilities.getNombreArchivo());
                    System.out.println("Cantidad de productos por categoría:");
                    for (Map.Entry<String, Integer> entry : productosPorCategoria.entrySet()) {
                        System.out.println("Categoría: " + entry.getKey() + ", Total: " + entry.getValue());
                    }
                    break;
                case 9:
                        List<Producto> productoList = Invetario.leerProdArchivos(Utilities.getNombreArchivo());
                    System.out.println("El precio total por productos es : ");
                    for (Producto producto : productoList){
                        double precitotal = producto.calcularPrecioTotal();
                        System.out.println("Producto: " + producto.getNombreProducto() + "Precio total: " + producto.getPrecioProducto());
                    }
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");

            }
        }
    }
}



