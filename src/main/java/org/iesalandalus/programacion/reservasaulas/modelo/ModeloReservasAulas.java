package org.iesalandalus.programacion.reservasaulas.modelo;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dao.*;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia;

public class ModeloReservasAulas implements IModeloReservasAulas {
	private Profesores profesores;
	private Aulas aulas;
	private Reservas reservas;

	public ModeloReservasAulas() {
		profesores = new Profesores();
		aulas = new Aulas();
		reservas = new Reservas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getAulas()
	 */
	@Override
	public List<Aula> getAulas() {
		return aulas.getAulas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumAulas()
	 */
	@Override
	public int getNumAulas() {
		return aulas.getNumAulas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarAulas()
	 */
	@Override
	public List<String> representarAulas() {
		return aulas.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public Aula buscarAula(Aula aulaBuscar) {
		return aulas.buscar(aulaBuscar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#insertarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void insertarAula(Aula aulaInsertar) throws OperationNotSupportedException {
		aulas.insertar(aulaInsertar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#borrarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void borrarAula(Aula aulaBorrar) throws OperationNotSupportedException {
		aulas.borrar(aulaBorrar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getProfesores()
	 */
	@Override
	public List<Profesor> getProfesores() {
		return profesores.getProfesores();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumProfesores()
	 */
	@Override
	public int getNumProfesores() {
		return profesores.getNumProfesores();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarProfesores()
	 */
	@Override
	public List<String> representarProfesores() {
		return profesores.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public Profesor buscarProfesor(Profesor profesorBuscar) {
		return profesores.buscar(profesorBuscar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#insertarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void insertarProfesor(Profesor profesorInsertar) throws OperationNotSupportedException {
		profesores.insertar(profesorInsertar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#borrarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void borrarProfesor(Profesor profesorBorrar) throws OperationNotSupportedException {
		profesores.borrar(profesorBorrar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservas()
	 */
	@Override
	public List<Reserva> getReservas() {
		return reservas.getReservas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getNumReservas()
	 */
	@Override
	public int getNumReservas() {
		return reservas.getNumReservas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#representarReservas()
	 */
	@Override
	public List<String> representarReservas() {
		return reservas.representar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#buscarReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public Reserva buscarReserva(Reserva reservaBuscar) {
		return reservas.buscar(reservaBuscar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#realizarReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void realizarReserva(Reserva reservaRealizar) throws OperationNotSupportedException {
		reservas.insertar(reservaRealizar);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#anularReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void anularReserva(Reserva reservaAnular) throws OperationNotSupportedException {
		reservas.borrar(reservaAnular);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservasAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public List<Reserva> getReservasAula(Aula aulaReservas) {
		return reservas.getReservasAula(aulaReservas);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservasProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public List<Reserva> getReservasProfesor(Profesor profesorReservas) {
		return reservas.getReservasProfesor(profesorReservas);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#getReservasPermanencia(org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public List<Reserva> getReservasPermanencia(Permanencia permanenciaReservas) {
		return reservas.getReservasPermanencia(permanenciaReservas);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas#consultarDisponibilidad(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula, org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return reservas.consultarDisponibilidad(aula, permanencia);
	}
}