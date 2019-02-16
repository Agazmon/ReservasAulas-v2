package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.permanencia.*;

public class Reserva {
	private Profesor profesor;
	private Aula aula;
	private Permanencia permanencia;

	public Reserva(Profesor profesor, Aula aula, Permanencia permanencia) {
		setProfesor(profesor);
		setAula(aula);
		setPermanencia(permanencia);
	}

	public Reserva(Reserva reserva) {
		if (reserva == null) {
			throw new IllegalArgumentException("No se puede copiar una reserva nula.");
		}
		setProfesor(reserva.profesor);
		setAula(reserva.aula);
		setPermanencia(reserva.permanencia);
	}

	private void setProfesor(Profesor profesor) {
		if (profesor == null) {
			throw new IllegalArgumentException("La reserva debe estar a nombre de un profesor.");
		} else {
			this.profesor = new Profesor(profesor);
		}
	}

	public Profesor getProfesor() {
		return new Profesor(this.profesor);
	}

	private void setAula(Aula aula) {
		if (aula == null) {
			throw new IllegalArgumentException("La reserva debe ser para un aula concreta.");
		} else {
			this.aula = new Aula(aula);
		}
	}

	public Aula getAula() {
		return new Aula(this.aula);
	}

	private void setPermanencia(Permanencia permanencia) {
		if (permanencia == null) {
			throw new IllegalArgumentException("La reserva se debe hacer para una permanencia concreta.");
		} else {
			if(permanencia instanceof PermanenciaPorTramo) {
				this.permanencia = new PermanenciaPorTramo((PermanenciaPorTramo)permanencia);
			} else if (permanencia instanceof PermanenciaPorHora) {
				this.permanencia = new PermanenciaPorHora((PermanenciaPorHora)permanencia);
			}
		}
	}

	public Permanencia getPermanencia() {
		if (this.permanencia instanceof PermanenciaPorTramo) {
			return new PermanenciaPorTramo((PermanenciaPorTramo)permanencia);
		} else {
			return new PermanenciaPorHora((PermanenciaPorHora)permanencia);
		}
	}
	
	public float getPuntos() {
		return permanencia.getPuntos()+aula.getPuntos();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aula == null) ? 0 : aula.hashCode());
		result = prime * result + ((permanencia == null) ? 0 : permanencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (aula == null) {
			if (other.aula != null)
				return false;
		} else if (!aula.equals(other.aula))
			return false;
		if (permanencia == null) {
			if (other.permanencia != null)
				return false;
		} else if (!permanencia.equals(other.permanencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[profesor=%s, aula=%s, permanencia=%s, puntos=%s]", profesor, aula, permanencia, getPuntos());
	}

}
