import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Utilities {

    public static final String ruta = "D:/workspaceintellij2024/TallerFinal/ListaProducto.txt";

   public static final String nombreArchivo = "ListaProducto.txt";

    public static String getRuta() {
        return ruta;
    }

    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    public void leerArchivo() {

        try (FileReader fr = new FileReader(ruta+nombreArchivo)) {

            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean validarArchivo() {

        try {
            File file = new File(ruta+nombreArchivo);

            if (file.exists() && file.isFile()) {
                System.out.println("El archivo existe en la ruta: " + file.getAbsolutePath());
                return true;
            } else {
                System.out.println("El archivo no existe en la ruta especificada.");
                return false;
            }

        } catch (Exception e) {

            System.out.println("Error al intentar validar el archivo: " + e.getMessage());
            return false;
        }
    }


}
