package org.iesalandalus.programacion.reservasaulas.modelo.permanencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Permanencia {
	protected LocalDate dia;
	protected static final DateTimeFormatter FORMATO_DIA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	protected Permanencia() {

	}

	protected Permanencia(LocalDate fechaPasada) {
		setDia(fechaPasada);
	}

	protected Permanencia(String cadenaPermanencia) {
		if (cadenaPermanencia == null) {
			throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
		}
		setDia(cadenaPermanencia);
	}

	public LocalDate getDia() {
		return dia;
	}

	protected void setDia(LocalDate diaPasado) {
		if (diaPasado == null) {
			throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
		} else {
			dia = diaPasado;
		}
	}

	protected void setDia(String cadenaPermanencia) {
		if (cadenaPermanencia == null | cadenaPermanencia.trim().equals("")) {
			throw new IllegalArgumentException("Fecha pasada no válida");
		} else {
			this.dia = LocalDate.parse(cadenaPermanencia, FORMATO_DIA);
		}
	}

	public abstract int getPuntos();

	public abstract String toString();

	public abstract int hashCode();

	public abstract boolean equals();

}
