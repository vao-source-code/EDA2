package gerente;

import calendar.MiCalendar;

import persona.ExceptionPersona;
import persona.Persona;
import sector.Sector;

public class Gerente extends Persona{

	private Integer id;
	private Double sueldo;
	private Sector sector;
	
	
	public Gerente(Integer id, Double sueldo, Sector sector) throws ExcepcionesGerente, ExceptionPersona{
		super();
		this.id = id;
		this.sueldo = sueldo;
		
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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}


		
	
}
