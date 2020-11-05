package gerente;

import calendar.MiCalendar;

import persona.ExceptionPersona;
import persona.Persona;

public class Gerente extends Persona{

	private Integer id;
	private Double sueldo;
	private String sector;
	
	
	public Gerente(Integer id, Double sueldo, String sector) throws ExcepcionesGerente, ExceptionPersona{
		super();
		this.id = id;
		this.sueldo = sueldo;
		this.sector = sector;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
		
	
}
