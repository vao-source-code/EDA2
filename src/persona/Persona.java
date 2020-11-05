package persona;

import calendar.ExceptionCalendar;
import calendar.MiCalendar;


public class Persona {
	private Integer dni;
	private String apellido;
	private String nombre;
	private Character sexo;
	private MiCalendar fechaNac;

	public Persona() {
		this.dni = 0;
		this.apellido = "";
		this.nombre = "";
		this.sexo = 'M';

		try {
			this.fechaNac = new MiCalendar(1, 1, 1900);
		} catch (ExceptionCalendar ex) {
			ex.getMessage();
		}
	}

	public Persona(Integer dni) throws ExceptionPersona {
		this.setDni(dni);
		this.apellido = "";
		this.nombre = "";
		this.sexo = 'M';

		try {
			this.fechaNac = new MiCalendar(1, 1, 1900);
		} catch (ExceptionCalendar ex) {
			ex.getMessage();
		}
	}

	public Persona(Integer dni, String apellido, String nombre, Character sexo, MiCalendar fechaNac)
			throws ExceptionPersona, ExceptionCalendar {
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setSexo(sexo);
		this.setFechaNac(fechaNac);
	}

	public void setLinea(String linea) throws ExceptionCalendar, ExceptionPersona {
		try {
			String[] campos = linea.split("\t");
			setDni(Integer.valueOf(campos[1]));
			setApellido(campos[2]);
			setNombre(campos[3]);
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
			setApellido(campos[2]);
			setNombre(campos[3]);
			setFechaNac(new MiCalendar(campos[4]));
			setSexo(campos[4].charAt(5));
		} catch (ExceptionPersona ex) {
			ex.getMessage();
		}

	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) throws ExceptionPersona {
		if (dni <= 0)
			throw new ExceptionPersona("DNI invalido");

		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws ExceptionPersona {
		if (nombre == null)
			throw new ExceptionPersona("Apellido y Nombres nulo");

		this.nombre = nombre.trim();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) throws ExceptionPersona {
		if (apellido == null)
			throw new ExceptionPersona("Apellido y Nombres nulo");

		this.apellido = apellido.trim();
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) throws ExceptionPersona {
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
		if (fechaNac.getAno() > 1600) {
			switch (fechaNac.getMes()) {
			case 4:
			case 6:
			case 9:
			case 11:
				if (fechaNac.getDia() < 30)
					this.fechaNac = fechaNac;
				break;
			case 2:
				if ((fechaNac.getAno() / 400 == 0) && (fechaNac.getAno() / 100 != 0)) {
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
			throw new ExceptionCalendar("ano invalido");
		}
	}

	@Override
	public String toString() {
		String ape = apellido.length() > 30 ? apellido.substring(0, 30) : apellido;
		String nomb = nombre.length() > 30 ? nombre.substring(0, 30) : nombre;
		return String.format("%08d", dni) + "\t" + String.format("%-10s", ape) + "\t" + String.format("%-10s", nomb)
				+ "\t" + String.format("%02d/%02d/%4d", fechaNac.getDia(), fechaNac.getMes(), fechaNac.getAno()) + "\t"
				+ sexo;
	}

}