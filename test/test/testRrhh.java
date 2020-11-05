package test;

import static org.junit.Assert.*;

import org.junit.Test;

import gerente.ExcepcionesGerente;
import gerente.Gerente;
import persona.ExceptionPersona;
import sector.Sector;

public class testRrhh {

	@Test
	public void queNoSePuedaAgregarDosGerentesEnElMismoSector() throws ExcepcionesGerente, ExceptionPersona {
		
		Gerente g=new Gerente(12, 30000.0, Sector.administracion);
		Gerente g1=new Gerente(13, 31000.0, Sector.administracion);
		
	}

}
