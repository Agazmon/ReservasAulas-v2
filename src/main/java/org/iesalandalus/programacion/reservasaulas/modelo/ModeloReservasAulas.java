package org.iesalandalus.programacion.reservasaulas.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.*;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class ModeloReservasAulas {
	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;

	public ModeloReservasAulas() {
		profesores = new Profesores();
		aulas = new Aulas();
		reservas = new Reservas();
	}

	public List<Aula> getAulas() {
		return aulas.getAulas();
	}

	public int getNumAulas() {
		return aulas.getNumAulas();
	}

	public List<String> representarAulas() {
		return aulas.representar();
	}

	public Aula buscarAula(Aula aulaBuscar) {
		return aulas.buscar(aulaBuscar);
	}

	public void insertarAula(Aula aulaInsertar) throws OperationNotSupportedException {
		aulas.insertar(aulaInsertar);
	}

	public void borrarAula(Aula aulaBorrar) throws OperationNotSupportedException {
		aulas.borrar(aulaBorrar);
	}

	public List<Profesor> getProfesores() {
		return profesores.getProfesores();
	}

	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}

	public List<String> representarProfesores() {
		return profesores.representar();
	}

	public Profesor buscarProfesor(Profesor profesorBuscar) {
		return profesores.buscar(profesorBuscar);
	}

	public void insertarProfesor(Profesor profesorInsertar) throws OperationNotSupportedException {
		profesores.insertar(profesorInsertar);
	}

	public void borrarProfesor(Profesor profesorBorrar) throws OperationNotSupportedException {
		profesores.borrar(profesorBorrar);
	}

	public List<Reserva> getReservas() {
		return reservas.getReservas();
	}

	public int getNumReservas() {
		return reservas.getNumReservas();
	}

	public List<String> representarReservas() {
		return reservas.representar();
	}

	public Reserva buscarReserva(Reserva reservaBuscar) {
		return reservas.buscar(reservaBuscar);
	}

	public void realizarReserva(Reserva reservaRealizar) throws OperationNotSupportedException {
		reservas.insertar(reservaRealizar);
	}

	public void anularReserva(Reserva reservaAnular) throws OperationNotSupportedException {
		reservas.borrar(reservaAnular);
	}

	public List<Reserva> getReservasAula(Aula aulaReservas) {
		return reservas.getReservasAula(aulaReservas);
	}

	public List<Reserva> getReservasProfesor(Profesor profesorReservas) {
		return reservas.getReservasProfesor(profesorReservas);
	}

	public List<Reserva> getReservasPermanencia(Permanencia permanenciaReservas) {
		return reservas.getReservasPermanencia(permanenciaReservas);
	}

	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}
}