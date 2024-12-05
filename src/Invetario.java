import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Invetario {
    List<Producto> productos = Invetario.leerProdArchivos(Utilities.getNombreArchivo());

    public static List<Producto> leerProdArchivos(String nombreArchivo) {
        List<Producto> productoList = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = rd.readLine()) != null) {
                String[] Dato = line.split(",");
                if (Dato.length == 5) {
                    int idProducto = Integer.parseInt(Dato[0]);
                    String nombreProducto = Dato[1];
                    String categoriaProducto = Dato[2];
                    double precioProducto = Double.parseDouble(Dato[3]);
                    int cantidadProducto = Integer.parseInt(Dato[4]);
                    productoList.add(new Producto(idProducto, nombreProducto, categoriaProducto, precioProducto, cantidadProducto));

                }
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
        }

        return productoList;

    }

    public static void almacenarProductoArchivo(String nombreArchivo, List<Producto> productoList) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Producto producto : productoList) {
                wr.write(producto.toString());
                wr.newLine();
            }

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo:" + e.getMessage());
        }

    }

    public static boolean agregarProducto(List<Producto> productos, int idProducto, Producto nuevoProducto) {
        Iterator<Producto> iter = productos.iterator();
        while (iter.hasNext()) {
            Producto producto = iter.next();
            if (producto.getIdProducto() != idProducto) {
                productos.add(nuevoProducto);
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarProductoId(List<Producto> productos, int idProducto) {
        Iterator<Producto> iter = productos.iterator();
        while (iter.hasNext()) {
            Producto producto = iter.next();
            if (producto.getIdProducto() == idProducto) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public static boolean actualizarProductoId(List<Producto> productos, int idProducto, Producto productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto() == idProducto) {
                productos.set(i, productoActualizado);
                return true;
            }
        }
        return false;

    }

    public static Producto buscarProductoPorId(List<Producto> productos, int idProducto) {
        for (Producto producto : productos) {
            if (producto.getIdProducto() == idProducto) {
                return producto;
            }
        }
        return null;
    }

    public static Producto buscarProductoPorCategoria(List<Producto> productos, String categoriaProdcuto) {
        for (Producto producto : productos) {
            if (producto.getCategoriaProducto().equals(categoriaProdcuto)) {
                return producto;
            }
        }
        return null;
    }

    public static Map<String, Integer> cantidadCategoria (String nombreArchivo){
        Map<String, Integer> productosPorCategoria = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String line;
            while ((line = br.readLine()) != null) {
                String campo[] = line.split(",");
                String categoriaProdcutos = campo[2].trim();
                int cantidadProductos = Integer.parseInt(campo[4].trim());
                productosPorCategoria.put(categoriaProdcutos, productosPorCategoria.getOrDefault(categoriaProdcutos, 0) + cantidadProductos);

            }

        }catch (Exception e){
            System.out.println("Error");
        }

        return productosPorCategoria;
    }



}