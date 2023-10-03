package agendaContactos;

import java.util.List;
import java.util.Scanner;

public class Menu {

	public String pedirOpcion() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Selecciona una opción (1 a 6):\n"
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
		String nombre;
		do {
			System.out.print("Introduce el nombre (Obligatorio): ");
			nombre = sc.nextLine();
		} while (nombre.isEmpty()); //Mientras que el nombre este en blanco, seguir pidiendo (Obligatorio)
		
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
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    edad = 0; // Si la entrada está en blanco = 0
                } else {
                    edad = Integer.parseInt(input); // Intentar convertir la edad en un entero, si no excepcion y vuelve a pedir edad
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar una edad válida o dejarlo en blanco:");
            }
        }
        return edad;
    }
	
	public void mostrarContactos(List<Persona> contactos) {
		for (Persona contacto : contactos) {
            System.out.println(contacto);
        }
		System.out.println();
	}
}
