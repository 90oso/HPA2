

public class DVD extends Product {
    // Campos de instancia adicionales para DVD
    private int duracionMinutos;
    private String clasificacionEdad;
    private String estudioCinematografico;

    // Constructor para la clase DVD
    public DVD(int numero, String nombre, int cantidad, double precio, int duracionMinutos, String clasificacionEdad, String estudioCinematografico) {
        super(numero, nombre, cantidad, precio);
        this.duracionMinutos = duracionMinutos;
        this.clasificacionEdad = clasificacionEdad;
        this.estudioCinematografico = estudioCinematografico;
    }

    public double valorInventario() {
        double precio = getPrecio();
        int cantidad = getCantidad();
        double valorInventario = precio * cantidad;

        // Agregar la tasa de devolución del 5% al valor del inventario
        valorInventario += valorInventario * 0.05;

        return valorInventario;
    }

    public String toString() {
        return "Número de elemento: " + getNumero() +
               "\nNombre: " + getNombre() +
               "\nDuración de la película: " + duracionMinutos + " minutos" +
               "\nClasificación de edad: " + clasificacionEdad +
               "\nEstudio cinematográfico: " + estudioCinematografico +
               "\nCantidad en stock: " + getCantidad() +
               "\nPrecio: " + getPrecio() +
               "\nValor en inventario: " + valorInventario() +
               "\nEstado del producto: " + (Activo() ? "Activo" : "Descatalogado");
    }
    
    // Getters y setters para los campos de instancia adicionales de DVD
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getEstudioCinematografico() {
        return estudioCinematografico;
    }

    public void setEstudioCinematografico(String estudioCinematografico) {
        this.estudioCinematografico = estudioCinematografico;
    }
}
