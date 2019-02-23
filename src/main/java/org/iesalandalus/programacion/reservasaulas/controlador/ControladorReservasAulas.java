package org.iesalandalus.programacion.reservasaulas.controlador;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.IModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.*;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.*;
import org.iesalandalus.programacion.reservasaulas.vista.IVistaReservasAulas;

public class ControladorReservasAulas implements IControladorReservasAulas {
	private IVistaReservasAulas vista;
	private IModeloReservasAulas modelo;
	
	public ControladorReservasAulas(IVistaReservasAulas vista, IModeloReservasAulas modelo) {
		this.vista = vista;
		this.modelo = modelo;
		vista.setControlador(this);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#comenzar()
	 */
	@Override
	public void comenzar() {
		vista.comenzar();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#salir()
	 */
	@Override
	public void salir() {
		vista.salir();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#insertarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void insertarAula(Aula aula) throws OperationNotSupportedException {
		modelo.insertarAula(aula);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#borrarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public void borrarAula(Aula aula) throws OperationNotSupportedException {
		modelo.borrarAula(aula);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#buscarAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public Aula buscarAula(Aula aula) {
		return new Aula(modelo.buscarAula(aula));
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#representarAulas()
	 */
	@Override
	public List<String> representarAulas() {
		return modelo.representarAulas();
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#insertarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException {
		System.out.println(profesor);
		modelo.insertarProfesor(profesor);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#borrarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException {
		modelo.borrarProfesor(profesor);
	}

	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#buscarProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public Profesor buscarProfesor(Profesor profesor) {
		return new Profesor(modelo.buscarProfesor(profesor));

	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#representarProfesores()
	 */
	@Override
	public List<String> representarProfesores(){
		return modelo.representarProfesores();
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#realizarReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void realizarReserva(Reserva reserva) throws OperationNotSupportedException {
		modelo.realizarReserva(reserva);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#anularReserva(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva)
	 */
	@Override
	public void anularReserva(Reserva reserva) throws OperationNotSupportedException{
		modelo.anularReserva(reserva);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#representarReservas()
	 */
	@Override
	public List<String> representarReservas(){
		return modelo.representarReservas();
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#getReservasAula(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula)
	 */
	@Override
	public List<Reserva> getReservasAula(Aula aula){
		return modelo.getReservasAula(aula);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#getReservasProfesor(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor)
	 */
	@Override
	public List<Reserva> getReservasProfesor(Profesor profesor){
		return modelo.getReservasProfesor(profesor);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#getReservasPermanencia(org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public List<Reserva> getReservasPermanencia(Permanencia permanencia){
		return modelo.getReservasPermanencia(permanencia);
	}
	/* (non-Javadoc)
	 * @see org.iesalandalus.programacion.reservasaulas.controlador.IControladorReservasAulas#consultarDisponibilidad(org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula, org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.Permanencia)
	 */
	@Override
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		return modelo.consultarDisponibilidad(aula, permanencia);
	}
}

	