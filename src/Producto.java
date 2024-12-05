public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String categoriaProducto;
    private double precioProducto;
    private int cantidadDisponible;

    public Producto(int idProducto, String nombreProducto, String categoriaProducto, double precioProducto, int cantidadDisponible) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.categoriaProducto = categoriaProducto;
        this.precioProducto = precioProducto;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String toString() {
        return idProducto + "," + nombreProducto + "," + categoriaProducto + "," + precioProducto + "," + cantidadDisponible;
    }

    public double calcularPrecioTotal() {
        return precioProducto * cantidadDisponible;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


}

