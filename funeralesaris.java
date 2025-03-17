import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que representa un servicio funerario
class ServicioFunerario {
    private String nombreDifunto;
    private int edad;
    private String fechaDefuncion;
    private String tipoCeremonia;
    private String ubicacion;
    private String fechaCeremonia;
    private String horaCeremonia;

    // Constructor
    public ServicioFunerario(String nombreDifunto, int edad, String fechaDefuncion, 
                              String tipoCeremonia, String ubicacion, 
                              String fechaCeremonia, String horaCeremonia) {
        this.nombreDifunto = nombreDifunto;
        this.edad = edad;
        this.fechaDefuncion = fechaDefuncion;
        this.tipoCeremonia = tipoCeremonia;
        this.ubicacion = ubicacion;
        this.fechaCeremonia = fechaCeremonia;
        this.horaCeremonia = horaCeremonia;
    }

    // Método para mostrar los detalles del servicio
    public void mostrarDetalles() {
        System.out.println("Nombre del Difunto: " + nombreDifunto);
        System.out.println("Edad: " + edad);
        System.out.println("Fecha de Defunción: " + fechaDefuncion);
        System.out.println("Tipo de Ceremonia: " + tipoCeremonia);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Fecha de la Ceremonia: " + fechaCeremonia);
        System.out.println("Hora de la Ceremonia: " + horaCeremonia);
        System.out.println("--------------------------------");
    }
}

// Clase para gestionar los registros de servicios funerarios
class RegistroServicioFunerario {
    private List<ServicioFunerario> servicios;

    public RegistroServicioFunerario() {
        servicios = new ArrayList<>();
    }

    // Método para registrar un servicio funerario
    public void registrarServicio() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del difunto:");
        String nombreDifunto = scanner.nextLine();

        System.out.println("Ingrese la edad del difunto:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la fecha de defunción (YYYY-MM-DD):");
        String fechaDefuncion = scanner.nextLine();

        System.out.println("Ingrese el tipo de ceremonia (religiosa, laica, etc.):");
        String tipoCeremonia = scanner.nextLine();

        System.out.println("Ingrese la ubicación de la ceremonia:");
        String ubicacion = scanner.nextLine();

        System.out.println("Ingrese la fecha de la ceremonia (YYYY-MM-DD):");
        String fechaCeremonia = scanner.nextLine();

        System.out.println("Ingrese la hora de la ceremonia (HH:MM):");
        String horaCeremonia = scanner.nextLine();

        ServicioFunerario servicio = new ServicioFunerario(
            nombreDifunto, edad, fechaDefuncion, tipoCeremonia, ubicacion, fechaCeremonia, horaCeremonia
        );

        servicios.add(servicio);
        System.out.println("Servicio funerario registrado exitosamente.");
    }

    // Método para mostrar todos los servicios registrados
    public void mostrarServicios() {
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios funerarios registrados.");
            return;
        }
        System.out.println("\nServicios Funerarios Registrados:");
        for (ServicioFunerario servicio : servicios) {
            servicio.mostrarDetalles();
        }
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        RegistroServicioFunerario registro = new RegistroServicioFunerario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar Servicio Funerario");
            System.out.println("2. Mostrar Servicios Registrados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registro.registrarServicio();
                    break;
                case 2:
                    registro.mostrarServicios();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}
