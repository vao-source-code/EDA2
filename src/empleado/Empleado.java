package empleado;

import calendar.ExceptionCalendar;
import calendar.MiCalendar;
import clasesAdicionales.Caracter;
import persona.ExceptionPersona;
import persona.Persona;

public class Empleado extends Persona {

	private Integer id;
	private MiCalendar fechaIngreso;
	private Double sueldo;
	private Caracter estado;

	
	public Empleado(Integer id) throws ExceptionEmpleado, ExceptionPersona {
		super();

		this.setID(id);
	}  
	public void setID(Integer id) throws ExceptionEmpleado {

		if (id <= 0) {

			throw new ExceptionEmpleado("ID invalido");

		} else {
			this.id = id;

		}

	}

	public void setFechaIngreso(MiCalendar fechaIngreso) throws ExceptionCalendar {
		MiCalendar f = this.getFechaNac();

		int difa = fechaIngreso.getAno() - f.getAno();
		int difm = fechaIngreso.getMes() - f.getMes();
		int difd = fechaIngreso.getDia() - f.getDia();

		if (difa > 18) {
			this.fechaIngreso = fechaIngreso;
			return;
		}

		if (difa > 18 && difm > 0) {
			this.fechaIngreso = fechaIngreso;
			return;
		}
		if (difa == 18 && difm == 0 && difd >= 0) {
			this.fechaIngreso = fechaIngreso;
			return;
		}

		throw new ExceptionCalendar("Fecha Ingreso Invalida");

	}

	@Override
	public String toString() {

		return String.format("%04d", id) + "\t" + super.toString() + "\t"
				+ String.format("%02d/%02d/%4d", fechaIngreso.getDia(), fechaIngreso.getMes(), fechaIngreso.getAno())
				+ "\t" + String.format("%05.2f", sueldo).replace(',', '.') + "\t" + estado + "\t";
	}

}
