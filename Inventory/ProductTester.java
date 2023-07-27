import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;

        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            System.out.println("No se requieren productos");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);
            do {
                menuChoice = getMenuOption(in,products);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }
    }

    // Método para obtener el número de productos ingresado por el usuario
    public static int getNumProducts(Scanner in) {
        int maxSize;
        do {
            try {
                System.out.print("Ingresa el número de productos que deseas agregar: (Ingresa 0 (cero) si no deseas agregar productos): ");
                maxSize = in.nextInt();
                if (maxSize < 0) {
                    System.out.println("Valor incorrecto ingresado. Por favor ingresa de nuevo");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato incorrecto ingresado. Por favor ingrese un valor entero");
                in.nextLine(); // Limpiar el buffer de entrada
                maxSize = -1; // Establecer maxSize en -1 para repetir el ciclo nuevamente
            }
        } while (maxSize < 0);
        return maxSize;
    }

    // Método para agregar productos al inventario
    public static void addToInventory(Product[] products, Scanner in) {
        int tempNumber;
        String tempName;
        int tempQty;
        double tempPrice;

        for (int i = 0; i < products.length; i++) {
            in.nextLine(); // Limpiar el buffer de entrada

            System.out.println("\nProducto #" + (i + 1));
            int stockChoice = -1;
            while (stockChoice < 1 || stockChoice > 2) {
                try {
                    System.out.println("1: CD");
                    System.out.println("2: DVD");
                    System.out.print("Por favor ingrese el tipo de producto: ");
                    stockChoice = in.nextInt();
                    if (stockChoice < 1 || stockChoice > 2) {
                        System.out.println("Solo se permiten números 1 o 2. Vuelve a intentarlo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de dato incorrecto ingresado. Vuelve a intentarlo.");
                    in.nextLine(); // Limpiar el buffer de entrada
                    stockChoice = -1;
                }
            }

            in.nextLine(); // Limpiar el buffer de entrada

            System.out.print("Por favor ingrese el nombre del producto: ");
            tempName = in.nextLine();

            System.out.print("Por favor ingrese el número de unidades en existencias: ");
            tempQty = in.nextInt();

            System.out.print("Por favor ingrese el precio del producto: ");
            tempPrice = in.nextDouble();

            if (stockChoice == 1) {
                in.nextLine(); // Limpiar el buffer de entrada
                System.out.print("Por favor ingrese el nombre del artista: ");
                String artist = in.nextLine();

                System.out.print("Por favor ingrese el número de canciones en el álbum: ");
                int numSongs = in.nextInt();

                in.nextLine(); // Limpiar el buffer de entrada
                System.out.print("Por favor ingrese el nombre de la discográfica: ");
                String recordLabel = in.nextLine();

                products[i] = new CD(1, tempName, tempQty, tempPrice, artist, numSongs, recordLabel);
            } else if (stockChoice == 2) {
                in.nextLine(); // Limpiar el buffer de entrada
                System.out.print("Por favor ingrese el nombre del estudio cinematográfico: ");
                String filmStudio = in.nextLine();

                System.out.print("Por favor ingrese la clasificación de edad: ");
                String ageRating = in.nextLine();

                System.out.print("Por favor ingrese la duración en minutos: ");
                int durationMinutes = in.nextInt();

                products[i] = new DVD(0, tempName, tempQty, tempPrice, durationMinutes, ageRating, filmStudio);
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }


    // Método para mostrar el inventario
    public static void displayInventory(Product[] products) {
        System.out.println("\nInformación de cada producto: ");
        for (Product product : products) {
            if (product != null) {
                System.out.println();
                System.out.println("Número del producto: " + product.getNumero());
                System.out.println("Nombre del producto: " + product.getNombre());
                System.out.println("Cantidad disponible: " + product.getCantidad());
                System.out.println("Precio del producto: " + product.getPrecio());
            }
        }
    }

    // Método para obtener la opción del menú elegida por el usuario
    public static int getMenuOption(Scanner in, Product[] products) {
        int option;
        do {
            try {
                System.out.println("\nMenú:");
                System.out.println("1. Ver inventario");
                System.out.println("2. Agregar existencias");
                System.out.println("3. Restar existencias");
                System.out.println("4. Descatalogar producto");
                System.out.println("5. Agregar más productos");
                System.out.println("0. Salir");
                System.out.print("Por favor ingrese una opción: ");
                option = in.nextInt();
                if (option < 0 || option > 5) {
                    System.out.println("Opción inválida. Por favor ingrese una opción válida (0-5).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato incorrecto ingresado. Por favor ingrese un número.");
                in.nextLine(); // Limpiar el buffer de entrada
                option = -1; // Establecer option en -1 para repetir el ciclo nuevamente
            }
        } while (option < 0 || option > 5);
        return option;
    }

    // Método para seleccionar un producto del inventario
    public static int getProductNumber(Product[] products, Scanner in) {
        int productChoice = -1;
        do {
            System.out.println("\nLista de productos:");
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null) {
                    System.out.println(i + ". " + products[i].getNombre());
                }
            }
            System.out.print("Por favor ingrese el número del producto que desea actualizar: ");
            productChoice = in.nextInt();
            if (productChoice < 0 || productChoice >= products.length || products[productChoice] == null) {
                System.out.println("Número de producto inválido. Por favor ingrese un número válido.");
            }
        } while (productChoice < 0 || productChoice >= products.length || products[productChoice] == null);
        return productChoice;
    }

    // Método para agregar existencias a un producto
    public static void addInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        if (productChoice >= 0 && productChoice < products.length) {
            System.out.print("¿Cuántos productos quieres agregar?: ");
            int updateValue = in.nextInt();
            if (updateValue >= 0) {
                products[productChoice].addToInventory(updateValue);
                System.out.println("Se agregaron " + updateValue + " unidades a " + products[productChoice].getNombre());
            } else {
                System.out.println("Valor inválido. La cantidad debe ser un número positivo.");
            }
        }
    }

    public static void addMoreProducts(Product[] products, Scanner in) {
        int additionalProducts = getNumProducts(in);
        if (additionalProducts > 0) {
            int oldSize = products.length;
            Product[] updatedProducts = new Product[oldSize + additionalProducts];
            System.arraycopy(products, 0, updatedProducts, 0, oldSize);
            addToInventory(updatedProducts, in);
            System.out.println("Productos adicionales agregados con éxito.");
        } else {
            System.out.println("No se agregaron productos adicionales.");
        }
    }

    // Método para restar existencias a un producto
    public static void deductInventory(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        if (productChoice >= 0 && productChoice < products.length) {
            System.out.print("¿Cuántos productos quieres restar?: ");
            int updateValue = in.nextInt();
            if (updateValue >= 0 && updateValue <= products[productChoice].getCantidad()) {
                products[productChoice].deductFromInventory(updateValue);
                System.out.println("Se restaron " + updateValue +
                        " unidades de " + products[productChoice].getNombre());
            } else {
                System.out.println("Valor inválido. La cantidad debe ser un número positivo y no puede exceder la cantidad disponible.");
            }
        }
    }

    // Método para descatalogar un producto
    public static void removeProduct(Product[] products, Scanner in) {
        int productChoice = getProductNumber(products, in);
        if (productChoice >= 0 && productChoice < products.length) {
            products[productChoice] = null;
            System.out.println("El producto ha sido descatalogado.");
        }
    }

    // Método para ejecutar la opción del menú seleccionada por el usuario
    public static void executeMenuChoice(int option, Product[] products, Scanner in) {
        switch (option) {
            case 1:
                displayInventory(products);
                break;
            case 2:
                addInventory(products, in);
                break;
            case 3:
                deductInventory(products, in);
                break;
            case 4:
                removeProduct(products, in);
                break;
            case 5:
                addMoreProducts(products, in);
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no reconocida.");
                break;
        }
    }
}
