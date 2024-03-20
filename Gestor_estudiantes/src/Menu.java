import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    private Scanner scanner;
    private GestorEstudiantes gestor;

    public Menu() {
        gestor = new GestorEstudiantes();
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Buscar estudiante ");
            System.out.println("3. mostrar los estudiantes");
            System.out.println("4. estudiantes ordenados por promedio");
            System.out.println("5. Calcular promedio general del cuatrimestre ");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
            case 1:
                agregarEstudiante();
                break;
            case 2:
                buscarPorDni();
                break;
            case 3:
                MostrarEstudiantes();
                break;
            case 4:
                EstudiantesOrdenados();
                break;
            case 5:
                PromedioCuatri();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
            }
            System.out.println();
        } while (opcion != 0);
    }

    private void agregarEstudiante() {
        boolean dniValido = false;
        boolean nombreValido = false;
        boolean apellidoValido = false;
        String nombre = "";
        String apellido = "";
        int dni = 0;

        while (!nombreValido) {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = scanner.nextLine();
            if (Pattern.matches("[a-zA-Z]+", nombre)) {
                nombreValido = true;
            } else {
                System.out.println("Error: El nombre solo puede contener letras.");
            }
        }

        while (!apellidoValido) {
            System.out.print("Ingrese el apellido del estudiante: ");
            apellido = scanner.nextLine();
            if (Pattern.matches("[a-zA-Z]+", apellido)) {
                apellidoValido = true;
            } else {
                System.out.println("Error: El apellido solo puede contener letras.");
            }
        }

        Estudiante estudiante1 = new Estudiante(nombre, apellido, 0, 0, 0); 

        while (!dniValido) {
            try {
                System.out.print("Ingrese el DNI del estudiante: ");
                dni = Integer.parseInt(scanner.nextLine());
                estudiante1.setDni(dni); 
                dniValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: El DNI solo puede contener números.");
            } catch (DniInvalido e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        System.out.print("Ingrese la nota final del estudiante: ");
        int notafinal = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el prom final: ");
        double promFinal = scanner.nextDouble();
        scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellido, dni, notafinal, promFinal);
        gestor.AgregarEstudiante(estudiante);
    }

    private void buscarPorDni() {
        System.out.println("----- BUSCAR ESTUDIANTE POR DNI -----");
        System.out.print("Ingrese el DNI del estudiante: ");
        int dni = scanner.nextInt();
        scanner.nextLine();
        gestor.BuscarEstudiante(dni);
        if (dni != 0) {
            gestor.toString();

        } else {
            System.out.println("No se encontró el estudiante.");
        }
    }

    public void MostrarEstudiantes() {
        gestor.MostrarEstudiantes();
    }

    public void EstudiantesOrdenados() {
        System.out.println("----- LISTA DE ESTUDIANTES ORDENADA POR PROMEDIO -----");

        gestor.OrdenarLista();
        gestor.MostrarEstudiantes();
    }

    public void PromedioCuatri() {
        double promedio = gestor.CalcularPromedio();
        System.out.println("El promedio general del cuatrimestre es: " + promedio);
    }

}
