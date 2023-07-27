//Proyecto seccion #4
// Producto.java

public class Product{
    //Instance field declarations
    private int numero; 
    private String nombre; 
    private int cantidad;
    private double precio;
    private boolean Activo; 

    // Constructor predeterminado sin parámetros
    public Product() {
    }

    // Constructor con parámetros para inicializar los campos de instancia
    public Product(int numero, String nombre, int cantidad, double precio) {
        this.numero = numero;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.Activo = true; 
    }

    // Métodos getters/accessors para obtener los valores de los campos de instancia
    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean Activo(){
        return Activo;
    }

    // Métodos setters/mutators para modificar los valores de los campos de instancia
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setActivo(boolean activo){
        Activo = activo; 
    }

    public double valorInventario(){
        return precio*cantidad;
    }

     // Método para sumar al número de unidades en existencias (addToInventory)
     public void addToInventory(int cantidad) {
        if (!Activo()) {
            System.out.println("No se pueden agregar existencias a un producto descatalogado.");
        } else {
            cantidad += cantidad;
            System.out.println(cantidad + " unidades agregadas al producto " + nombre + ".");
        }
    }
    
    // Método para restar del número de unidades en existencias (deductFromInventory)
    public void deductFromInventory(int cantidad) {
        if (this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("No se puede restar. No hay suficientes productos");
        }
    }   
    
    // Método toString() para mostrar una descripción del objeto Producto
    public String toString() {
        String Estado = Activo ? "Activo" : "Descatalogado";
        return "Número de elemento: " + numero +
               "\nNombre: " + nombre +
               "\nCantidad en stock: " + cantidad +
               "\nPrecio: " + precio +
               "\nValor en inventario: " + valorInventario()+
               "\nEstado de producto: " + Estado;
    }
}

