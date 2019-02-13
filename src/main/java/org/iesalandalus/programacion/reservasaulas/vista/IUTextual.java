package org.iesalandalus.programacion.reservasaulas.vista;

import java.util.List;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class IUTextual {
	private ModeloReservasAulas modelo;
	private static final String ERROR = "ERROR: ";
	private static final String NOMBRE_VALIDO = "Alex Gazquez";
	private static final String CORREO_VALIDO = "alexgazquezmonedero@gmail.com";

	public IUTextual() {
		modelo = new ModeloReservasAulas();
		Opcion.setVista(this);
	}

	public void comenzar() {
		int opcionEscogida;
		do {
			Consola.mostrarMenu();
			opcionEscogida = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(opcionEscogida);
			opcion.ejecutar();
		} while (opcionEscogida != Opcion.SALIR.ordinal());
	}

	public void salir() {
		System.out.print("Has salido del programa Reservas Aulas.");
	}

	public void insertarAula() {
		Consola.mostrarCabecera("Insertar Aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.insertarAula(aula);
			System.out.println("El Aula proporcionada ha sido añadida al sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarAula() {
		Consola.mostrarCabecera("Borrar Aula");
		try {
			Aula aula = Consola.leerAula();
			modelo.borrarAula(aula);
			System.out.println("El Aula ha sido borrada del sistema");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarAula() {
		Consola.mostrarCabecera("Buscar Aula");
		try {
			Aula aula = modelo.buscarAula(Consola.leerAula());
			if (aula != null) {
				System.out.println("El aula encontrada es: " + aula);
			} else {
				System.out.println("Aula no encontrada en el sistema.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarAulas() {
		Consola.mostrarCabecera("Listar Aulas");
		try {
			List<String> aulas = modelo.representarAulas();
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} catch (IllegalArgumentException | UnsupportedOperationException e) {
			System.out.println(ERROR + e.getMessage());

		}
	}

	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar Profesor/a");
		try {
			Profesor profesor = Consola.leerProfesor();
			modelo.insertarProfesor(profesor);
			System.out.println("Profesor/a proporcionado/a ha sido añadido/a al sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar Profesor/a");
		try {
			Profesor profesorBorrar = modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO));
			modelo.borrarProfesor(profesorBorrar);
			System.out.println("Profesor/a proporcionado/a ha sido borrado/a del sistema");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar Profesor/a");
		Profesor profesorEncontrado = modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO));
		if (profesorEncontrado != null) {
			System.out.println(profesorEncontrado);
		} else {
			System.out.println("Profesor/a proporcionado/a no ha sido encontrado/a del sistema");
		}

	}

	public void listarProfesores() {
		Consola.mostrarCabecera("Listar Profesores");
		List<String> profesores = modelo.representarProfesores();
		if (modelo.getNumProfesores() > 0) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No existen profesores para listar actualmente.");
		}

	}

	public void realizarReserva() {
		Consola.mostrarCabecera("Realizar Reserva");
		try {
			Reserva reserva;
			Profesor profesor = new Profesor(
					modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			reserva = leerReserva(profesor);
			if (reserva != null) {
				modelo.realizarReserva(reserva);
				System.out.println("La reserva ha sido realizada y añadida al sistema.");
				System.out.println("Los datos de la reserva son" + reserva.toString());
			} else {
				System.out.println("Ya hay una reserva realizada en este tramo");
			}
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());

		}
	}

	private Reserva leerReserva(Profesor profesorReserva) {
		Reserva reservaLeida;
		Permanencia permanencia;
		Aula aula = modelo.buscarAula(new Aula(Consola.leerNombreAula()));
		permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if (modelo.consultarDisponibilidad(aula, permanencia)) {
			reservaLeida = new Reserva(profesorReserva, aula, permanencia);
		} else {
			return null;
		}
		return reservaLeida;
	}

	public void anularReserva() {
		Consola.mostrarCabecera("Anula Reserva");
		try {
			Profesor profesor = new Profesor(
					modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			Aula aula = modelo.buscarAula(new Aula(Consola.leerNombreAula()));
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
			Reserva reservaAnular = new Reserva(profesor, aula, permanencia);
			modelo.anularReserva(reservaAnular);
			System.out.println("La reserva ha sido borrada del sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarReservas() {
		Consola.mostrarCabecera("Listar Reservas");
		try {
			List<String> reservas = modelo.representarReservas();
			if (modelo.getNumReservas() > 0) {
				for (String reserva : reservas) {
					System.out.println(reserva);
				}
			} else {
				System.out.println("No existen reservas para listar actualmente");
			}
		} catch (Exception e) {
			System.out.println(ERROR + e.getMessage());
		}

	}

	public void listarReservasAula() {
		Consola.mostrarCabecera("Listar Reservas por Aula");
		try {
			Aula reservasAula = new Aula(Consola.leerAula());
			List<Reserva> reservaAula = modelo.getReservasAula(reservasAula);
			if (reservaAula.size() > 0) {
				for (Reserva reserva : reservaAula) {
					System.out.println(reserva.toString());
				}
			} else {
				System.out.println("No existen reservas para el Aula.");
			}
		} catch (Exception e) {
			System.out.println(ERROR + e.getMessage());
		}

	}

	public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar Reservas por Profesor");
		try {
			Profesor profesor = new Profesor(
					modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			if (profesor != null) {
				List<Reserva> reservaProfesor = modelo.getReservasProfesor(profesor);
				if (reservaProfesor.size() > 0) {
					for (Reserva reserva : reservaProfesor) {
						System.out.println(reserva.toString());
					}
				} else {
					System.out.println("No existen reservas para el profesor.");
				}
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar Reservas por Permanencia");
		try {
			Permanencia permanencia = new Permanencia(Consola.leerDia(), Consola.leerTramo());
			List<Reserva> reservaPermanencia = modelo.getReservasPermanencia(permanencia);
			if (reservaPermanencia.size() > 0) {
				for (Reserva reserva : reservaPermanencia) {

					System.out.println(reserva.toString());
				}
			} else {
				System.out.println("No existen reservas para la permanencia.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	public void consultarDisponibilidad() {
		if (modelo.consultarDisponibilidad(Consola.leerAula(),
				new Permanencia(Consola.leerDia(), Consola.leerTramo()))) {
			System.out.println("El Aula esta disponible en el tramo solicitado.");
		} else {
			System.out.println("El Aula no esta disponible en el tramo solicitado.");
		}
	}
}
