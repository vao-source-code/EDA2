package persona;

import calendar.ExceptionCalendar;
import calendar.MiCalendar;

/**
 *
 * @author victor
 */
public class Persona {
	int dni;
	private String ap;
	private String nom;
	private char sexo;
	private MiCalendar fechaNac;

	public Persona() {
		this.dni = 0;
		this.ap = "";
		this.nom = "";
		this.sexo = 'M';

		try {
			this.fechaNac = new MiCalendar(1, 1, 1900);
		} catch (ExceptionCalendar ex) {
			ex.getMessage();
		}
	}

	public Persona(int dni) throws ExceptionPersona {
		this.setDni(dni);
		this.ap = "";
		this.nom = "";
		this.sexo = 'M';

		try {
			this.fechaNac = new MiCalendar(1, 1, 1900);
		} catch (ExceptionCalendar ex) {
			ex.getMessage();
		}
	}

	public Persona(int dni, String ape, String nomb, char sexo, MiCalendar fechaNac)
			throws ExceptionPersona, ExceptionCalendar {
		this.setDni(dni);
		this.setAp(ape);
		this.setNom(nomb);
		this.setSexo(sexo);
		this.setFechaNac(fechaNac);
	}

	public void setLinea(String linea) throws ExceptionCalendar, ExceptionPersona {
		try {
			String[] campos = linea.split("\t");
			setDni(Integer.valueOf(campos[1]));
			setAp(campos[2]);
			setNom(campos[3]);
			setFechaNac(new MiCalendar(campos[4]));
			setSexo(campos[4].charAt(5));
		} catch (ExceptionPersona ex) {
			ex.getMessage();
		}
	}

	public Persona(String linea) throws ExceptionPersona, ExceptionCalendar {
		try {
			String[] campos = linea.split("\t");
			setDni(Integer.valueOf(campos[1]));
			setAp(campos[2]);
			setNom(campos[3]);
			setFechaNac(new MiCalendar(campos[4]));
			setSexo(campos[4].charAt(5));
		} catch (ExceptionPersona ex) {
			ex.getMessage();
		}

	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) throws ExceptionPersona {
		if (dni <= 0)
			throw new ExceptionPersona("DNI inválido");

		this.dni = dni;
	}

	public String getnom() {
		return nom;
	}

	public void setNom(String nom) throws ExceptionPersona {
		if (nom == null)
			throw new ExceptionPersona("Apellido y Nombres nulo");

		this.nom = nom.trim();
	}

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) throws ExceptionPersona {
		if (ap == null)
			throw new ExceptionPersona("Apellido y Nombres nulo");

		this.ap = ap.trim();
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) throws ExceptionPersona {
		if (Character.isUpperCase(sexo)) {
			sexo = Character.toUpperCase(sexo);
		}
		if (sexo == 'M' || sexo == 'F')
			this.sexo = sexo;
		else
			throw new ExceptionPersona("Sexo invalido");

	}

	public MiCalendar getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(MiCalendar fechaNac) throws ExceptionCalendar {
		if (fechaNac.getAño() > 1600) {
			switch (fechaNac.getMes()) {
			case 4:
			case 6:
			case 9:
			case 11:
				if (fechaNac.getDia() < 30)
					this.fechaNac = fechaNac;
				break;
			case 2:
				if ((fechaNac.getAño() / 400 == 0) && (fechaNac.getAño() / 100 != 0)) {
					if (fechaNac.getDia() < 29)
						this.fechaNac = fechaNac;
					else
						throw new ExceptionCalendar("dia invalido");
				} else if (fechaNac.getDia() < 28) {
					this.fechaNac = fechaNac;
				}

				if (fechaNac.getDia() > 29)
					throw new ExceptionCalendar("dia invalido");

				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (fechaNac.getDia() < 31)
					this.fechaNac = fechaNac;
				else
					throw new ExceptionCalendar("dia invalido");
				break;
			default:
				throw new ExceptionCalendar("mes invalido");
			}
		} else {
			throw new ExceptionCalendar("año invalido");
		}
	}

	@Override
	public String toString() {
		String ape = ap.length() > 30 ? ap.substring(0, 30) : ap;
		String nomb = nom.length() > 30 ? nom.substring(0, 30) : nom;
		return String.format("%08d", dni) + "\t" + String.format("%-10s", ape) + "\t" + String.format("%-10s", nomb)
				+ "\t" + String.format("%02d/%02d/%4d", fechaNac.getDia(), fechaNac.getMes(), fechaNac.getAño()) + "\t"
				+ sexo;
	}

}