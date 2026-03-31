import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // Lista polimórfica: almacena Perro, Gato, Ave como tipo Mascota
    static ArrayList<Mascota> mascotas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        System.out.println("******** SISTEMA DE GESTIÓN DE MASCOTAS********    ");
        

        while (opcion != 5) {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1 -> registrarMascota();
                case 2 -> mostrarMascotas();
                case 3 -> ejecutarSonidoPorId();
                case 4 -> buscarPorNombre();
                case 5 -> System.out.println("\n ¡Cerrando cesión!");
                default -> System.out.println("\n  Opción no válida. \n");
            }
        }
    }

    // FORMA DEL MENU

    static void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Registrar mascota  ");
        System.out.println("2. Mostrar mascotas   ");
        System.out.println("3. Ejecutar sonido por ID");
        System.out.println("4. Buscar mascota por nombre");
        System.out.println("5. Salir ");
        System.out.println("==================================");
    }

    //METODO PARA REGISTRAR MASCOTA CON VALIDACIONES

    static void registrarMascota() {
        System.out.println("\n── Registrar mascota ──");
        System.out.println("Tipo de mascota:");
        System.out.println("  1. Perro");
        System.out.println("  2. Gato");
        System.out.println("  3. Ave");

        int tipo = leerEntero("Elige el tipo: ");
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo no válido. No se registró la mascota.");
            return;
        }

        int id = leerEntero("Ingresa el ID (debe ser > 0): ");
        if (id <= 0) {
            System.out.println(" El ID debe ser mayor que 0. No se registró la mascota.");
            return;
        }

        System.out.print("Ingresa el nombre: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println(" El nombre no puede estar vacío. No se registró la mascota.");
            return;
        }

        int edad = leerEntero("Ingresa la edad (debe ser > 0): ");
        if (edad <= 0) {
            System.out.println("La edad debe ser mayor que 0. No se registró la mascota.");
            return;
        }

        // Polimorfismo: se guardan como tipo Mascota
        Mascota nueva = switch (tipo) {
            case 1 -> new Perro(id, nombre, edad);
            case 2 -> new Gato(id, nombre, edad);
            case 3 -> new Ave(id, nombre, edad);
            default -> null;
        };

        mascotas.add(nueva);
        System.out.println( n/Mascota "registrada correctamente.");
    }

    // MOSTRAR TODAS LAS MASCOTAS 

    static void mostrarMascotas() {
        System.out.println("n/ Lista de mascotas ");

        if (mascotas.isEmpty()) {
            System.out.println("  No hay mascotas registradas.");
            return;
        }

       
        for (Mascota m : mascotas) {
            m.mostrarInfo();
        }
    }

    // METODO PARA EJECUTAR SONIDO POR ID

    static void ejecutarSonidoPorId() {
        System.out.println("\n── Ejecutar sonido por ID ──");

        if (mascotas.isEmpty()) {
            System.out.println("  mascota no registradas.");
            return;
        }

        int id = leerEntero("Ingresa el ID de la mascota: ");
        Mascota encontrada = buscarPorId(id);

        if (encontrada != null) {
            System.out.println("🔊 " + encontrada.getNombre() + " dice: " + encontrada.hacerSonido());
        } else {
            System.out.println("  Mascota no encontrada.");
        }
    }

    // MAETODO PARA BUSCAR MASCOTA POR NOMBRE

    static void buscarPorNombre() {
        System.out.println("\n── Buscar mascota por nombre ──");

        if (mascotas.isEmpty()) {
            System.out.println("  No hay mascotas registradas.");
            return;
        }

        System.out.print("Ingresa el nombre a buscar: ");
        String nombre = scanner.nextLine().trim();

        boolean encontrada = false;
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                m.mostrarInfo();
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println(" Mascota no encontrada.");
        }
    }

    // UTILIDADES

    static Mascota buscarPorId(int id) {
        for (Mascota m : mascotas) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    /**
     * Lee un entero desde consola con manejo de errores (try-catch).
     * Si el usuario ingresa texto no numérico, retorna -1.
     */
    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            String linea = scanner.nextLine().trim();
            return Integer.parseInt(linea);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Se esperaba un número.");
            return -1;
        }
    }
}