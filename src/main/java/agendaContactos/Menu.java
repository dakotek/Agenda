package agendaContactos;

import java.util.List;
import java.util.Scanner;

public class Menu {

	public String pedirOpcion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Selecciona una opción (1 a 5):\n"
				+ "1. Buscar por código de usuario\n"
				+ "2. Buscar por el comienzo del nombre\n"
				+ "3. Mostrar la agenda completa\n"
				+ "4. Añadir un contacto\n"
				+ "5. Borrar un contacto\n"
				+ "6. Cerrar programa");
		String opcion = sc.nextLine();
		return opcion;
	}
	
	public String pedirNombre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el nombre: ");
		String nombre = sc.nextLine();
		return nombre;
	}
	
	public String pedirTelefono() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce el telefono: ");
		String telefono = sc.nextLine();
		return telefono;
	}
	
	public int pedirEdad() {
        Scanner sc = new Scanner(System.in);
        int edad;
        while (true) {
            try {
                System.out.print("Introduce la edad: ");
                edad = sc.nextInt();
                break; // Salir del bucle si se ingresa un entero válido
            } catch (java.util.InputMismatchException e) {
                System.out.println("Debes ingresar una edad válida:");
                sc.nextLine(); // Limpiar el búfer del scanner
            }
        }
        return edad;
    }
	
	public void mostrarContactos(List<Persona> contactos) {
		for (Persona contacto : contactos) {
            System.out.println(contacto);
            System.out.println("-------------");
        }
	}
}
