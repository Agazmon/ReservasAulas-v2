package org.iesalandalus.programacion.reservasaulas.vista;

import java.util.List;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class VistaReservasAulas implements IVistaReservasAulas {
	private IControladorReservasAulas Controlador;
	private static final String ERROR = "ERROR: ";
	private static final String NOMBRE_VALIDO = "Alex Gazquez";
	private static final String CORREO_VALIDO = "alexgazquezmonedero@gmail.com";

	public VistaReservasAulas() {
		Opcion.setVista(this);
		this.Controlador= new ControladorReservasAulas(this, new ModeloReservasAulas());
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#setControlador(org.iesalandalus.programacion.reservasaulas.controlador.ControladorReservasAulas)
	 */
	@Override
	public void setControlador(IControladorReservasAulas controlador){
		this.Controlador = controlador;
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#comenzar()
	 */
	@Override
	public void comenzar() {
		int opcionEscogida;
		do {
			Consola.mostrarMenu();
			opcionEscogida = Consola.elegirOpcion();
			Opcion opcion = Opcion.getOpcionSegunOrdinal(opcionEscogida);
			opcion.ejecutar();
		} while (opcionEscogida != Opcion.SALIR.ordinal());
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#salir()
	 */
	@Override
	public void salir() {
		System.out.print("Has salido del programa Reservas Aulas.");
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#insertarAula()
	 */
	@Override
	public void insertarAula() {
		Consola.mostrarCabecera("Insertar Aula");
		try {
			Aula aula = Consola.leerAula();
			Controlador.insertarAula(aula);
			System.out.println("El Aula proporcionada ha sido añadida al sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#borrarAula()
	 */
	@Override
	public void borrarAula() {
		Consola.mostrarCabecera("Borrar Aula");
		try {
			Aula aula = Consola.leerAula();
			Controlador.borrarAula(aula);
			System.out.println("El Aula ha sido borrada del sistema");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#buscarAula()
	 */
	@Override
	public void buscarAula() {
		Consola.mostrarCabecera("Buscar Aula");
		try {
			Aula aula = Controlador.buscarAula(Consola.leerAula());
			if (aula != null) {
				System.out.println("El aula encontrada es: " + aula);
			} else {
				System.out.println("Aula no encontrada en el sistema.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarAulas()
	 */
	@Override
	public void listarAulas() {
		Consola.mostrarCabecera("Listar Aulas");
		try {
			List<String> aulas = Controlador.representarAulas();
			for (String aula : aulas) {
				System.out.println(aula);
			}
		} catch (IllegalArgumentException | UnsupportedOperationException e) {
			System.out.println(ERROR + e.getMessage());

		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#insertarProfesor()
	 */
	@Override
	public void insertarProfesor() {
		Consola.mostrarCabecera("Insertar Profesor/a");
		try {
			Profesor profesor = Consola.leerProfesor();
			System.out.println(profesor);
			Controlador.insertarProfesor(profesor);
			System.out.println("Profesor/a proporcionado/a ha sido añadido/a al sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#borrarProfesor()
	 */
	@Override
	public void borrarProfesor() {
		Consola.mostrarCabecera("Borrar Profesor/a");
		try {
			Profesor profesorBorrar = Controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO));
			Controlador.borrarProfesor(profesorBorrar);
			System.out.println("Profesor/a proporcionado/a ha sido borrado/a del sistema");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#buscarProfesor()
	 */
	@Override
	public void buscarProfesor() {
		Consola.mostrarCabecera("Buscar Profesor/a");
		Profesor profesorEncontrado = Controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO));
		if (profesorEncontrado != null) {
			System.out.println(profesorEncontrado);
		} else {
			System.out.println("Profesor/a proporcionado/a no ha sido encontrado/a del sistema");
		}

	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarProfesores()
	 */
	@Override
	public void listarProfesores() {
		Consola.mostrarCabecera("Listar Profesores");
		List<String> profesores = Controlador.representarProfesores();
		if (!profesores.isEmpty()) {
			for (String profesor : profesores) {
				System.out.println(profesor);
			}
		} else {
			System.out.println("No existen profesores para listar actualmente.");
		}

	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#realizarReserva()
	 */
	@Override
	public void realizarReserva() {
		Consola.mostrarCabecera("Realizar Reserva");
		try {
			Reserva reserva;
			Profesor profesor = new Profesor(
					Controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			reserva = leerReserva(profesor);
			if (reserva != null) {
				Controlador.realizarReserva(reserva);
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
		Aula aula = Controlador.buscarAula(new Aula(Consola.leerNombreAula(),10));
		permanencia = Consola.leerPermanencia();
		if (Controlador.consultarDisponibilidad(aula, permanencia)) {
			reservaLeida = new Reserva(profesorReserva, aula, permanencia);
		} else {
			return null;
		}
		return reservaLeida;
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#anularReserva()
	 */
	@Override
	public void anularReserva() {
		Consola.mostrarCabecera("Anula Reserva");
		try {
			Profesor profesor = new Profesor(
					Controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			Aula aula = Controlador.buscarAula(new Aula(Consola.leerNombreAula(),10));
			Permanencia permanencia = Consola.leerPermanencia();
			Reserva reservaAnular = new Reserva(profesor, aula, permanencia);
			Controlador.anularReserva(reservaAnular);
			System.out.println("La reserva ha sido borrada del sistema.");
		} catch (OperationNotSupportedException | IllegalArgumentException e) {
			System.out.println(ERROR + e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarReservas()
	 */
	@Override
	public void listarReservas() {
		Consola.mostrarCabecera("Listar Reservas");
		try {
			List<String> reservas = Controlador.representarReservas();
			if (!reservas.isEmpty()) {
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

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarReservasAula()
	 */
	@Override
	public void listarReservasAula() {
		Consola.mostrarCabecera("Listar Reservas por Aula");
		try {
			Aula reservasAula = new Aula(Consola.leerAula());
			List<Reserva> reservaAula = Controlador.getReservasAula(reservasAula);
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

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarReservasProfesor()
	 */
	@Override
	public void listarReservasProfesor() {
		Consola.mostrarCabecera("Listar Reservas por Profesor");
		try {
			Profesor profesor = new Profesor(
					Controlador.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), CORREO_VALIDO)));
			if (profesor != null) {
				List<Reserva> reservaProfesor = Controlador.getReservasProfesor(profesor);
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

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#listarReservasPermanencia()
	 */
	@Override
	public void listarReservasPermanencia() {
		Consola.mostrarCabecera("Listar Reservas por Permanencia");
		try {
			Permanencia permanencia = Consola.leerPermanencia();
			List<Reserva> reservaPermanencia = Controlador.getReservasPermanencia(permanencia);
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

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas#consultarDisponibilidad()
	 */
	@Override
	public void consultarDisponibilidad() {
		if (Controlador.consultarDisponibilidad(Consola.leerAula(),
				Consola.leerPermanencia())) {
			System.out.println("El Aula esta disponible en el tramo solicitado.");
		} else {
			System.out.println("El Aula no esta disponible en el tramo solicitado.");
		}
	}
	
}
