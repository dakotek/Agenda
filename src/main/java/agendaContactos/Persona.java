package agendaContactos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	private UUID usuario;
	private String nombre;
	private String telefono;
	private int edad;

}
