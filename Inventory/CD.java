public class CD extends Product {
    // Campos de instancia adicionales para CD
    private String artista;
    private int numeroCanciones;
    private String discografica;

    // Constructor para la clase CD
    public CD(int numero, String nombre, int cantidad, double precio, String artista, int numeroCanciones, String discografica) {
        super(numero, nombre, cantidad, precio);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
        this.discografica = discografica;
    }

    public String toString() {
        return "Número de elemento: " + getNumero() +
               "\nNombre: " + getNombre() +
               "\nArtista: " + artista +
               "\nNúmero de canciones en el álbum: " + numeroCanciones +
               "\nDiscográfica: " + discografica +
               "\nCantidad en stock: " + getCantidad() +
               "\nPrecio: " + getPrecio() +
               "\nValor en inventario: " + valorInventario() +
               "\nEstado del producto: " + (Activo() ? "Activo" : "Descatalogado");
    }
    
    // Getters y setters para los campos de instancia adicionales de CD
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }
}

