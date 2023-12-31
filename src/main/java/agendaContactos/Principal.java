package agendaContactos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Principal {

	private List<Persona> agenda = new ArrayList<>();
	private Menu menu = new Menu();

	public static void main(String[] args) {
		Principal programa = new Principal();
		programa.iniciarPrograma();
	}

	public void iniciarPrograma() {
		boolean salir = false;
		while (!salir) {
			String opcion = menu.pedirOpcion();
			switch (opcion) {
			case "1":
				buscarPorCodigo();
				break;
			case "2":
				buscarPorNombre();
				break;
			case "3":
				mostrarAgenda();
				break;
			case "4":
				agregarContacto();
				break;
			case "5":
				borrarContacto();
				break;
			case "6":
				salir = true;
				System.out.println("AGENDA DE CONTACTOS CERRADA");
				break;
			default:
				System.err.println("Opción no válida. Por favor, elija una opción válida.");
			}
		}
	}

	private void buscarPorCodigo() {
		if (agenda.isEmpty()) {
		    System.err.println("No hay contactos en la agenda");
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese el código de usuario:");
			String codigoString = sc.nextLine();
			try {
				UUID codigo = UUID.fromString(codigoString);
				List<Persona> resultados = new ArrayList<>();
				for (Persona contacto : agenda) {
					if (contacto.getUsuario().equals(codigo)) {
						resultados.add(contacto);
					}
				}
				if (resultados.isEmpty()) {
		        	System.err.println("No hay contactos con ese codigo de usuario");
		        } else {
		        	menu.mostrarContactos(resultados);
		        }
			} catch (IllegalArgumentException e) {
				System.err.println("El formato del codigo ingresado no es válido");
			}
		}
	}

	private void buscarPorNombre() {
		if (agenda.isEmpty()) {
		    System.err.println("No hay contactos en la agenda");
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese un comienzo de nombre:");
			String inicioNombre = sc.nextLine();
	        List<Persona> resultados = new ArrayList<>();
	        for (Persona contacto : agenda) {
	            if (contacto.getNombre().startsWith(inicioNombre)) {
	                resultados.add(contacto);
	            }
	        }
	        if (resultados.isEmpty()) {
	        	System.err.println("No hay contactos con ese comienzo de nombre");
	        } else {
	        	menu.mostrarContactos(resultados);
	        }
		}		
	}

	private void mostrarAgenda() {
		if (agenda.isEmpty()) {
		    System.err.println("No hay contactos en la agenda");
		} else {
			menu.mostrarContactos(agenda);
		}
	}

	private void agregarContacto() {
		System.out.println("Ingresa los datos del contacto:");
		String nombre = menu.pedirNombre();
		String telefono = menu.pedirTelefono();
		int edad = menu.pedirEdad();
		UUID codigo = UUID.randomUUID();
		Persona nuevoContacto = new Persona(codigo, nombre, telefono, edad);
		agenda.add(nuevoContacto);
		System.out.println("Contacto agregado exitosamente\n");
	}

	private void borrarContacto() {
		if (agenda.isEmpty()) {
		    System.err.println("No hay contactos en la agenda");
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese el nombre del contacto a borrar:");
			String nombre = sc.nextLine();
			for (Persona contacto : agenda) {
				if (contacto.getNombre().equals(nombre)) {
					agenda.remove(contacto);
					System.out.println("Contacto borrado exitosamente\n");
					return;
				}
			}
			System.err.println("No se encontró ningún contacto con ese nombre");
		}
	}

}
