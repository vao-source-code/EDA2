package calendar;



import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Date;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;


public class MiCalendar extends GregorianCalendar
{
	public MiCalendar(Integer dia, Integer mes, Integer ano) throws ExceptionCalendar
	{
		super(ano, mes - 1, dia);
		setLenient(false);
		
		try
		{
			get(DAY_OF_MONTH);
			get(MONTH);
			get(YEAR);
		}
		catch(Exception ex)
		{
			throw new ExceptionCalendar("La fecha " + dia + "/" + mes + "/" + ano + " es Invalida");
		}
		
	}
	
	
	public MiCalendar(String linea)
	{
		String[] campos = linea.split("/");
		
		setDia(Integer.valueOf(campos[0]));
		setMes(Integer.valueOf(campos[1]));
		setAno(Integer.valueOf(campos[2]));
	}
        
	
	public MiCalendar(Date date)
        {
            this.setTimeInMillis(date.getTime());
        }
	public MiCalendar(Calendar cal)
	{
		setDia(cal.get(DAY_OF_MONTH));
		setMes(cal.get(MONTH) + 1);
		setAno(cal.get(YEAR));
	}
	
	
	public Integer getDia()
	{
		return get(DAY_OF_MONTH);
	}
	
	
	public Integer getMes()
	{
		return get(MONTH) + 1;
	}
	
	
	public Integer getAno()
	{
		return get(YEAR);
	}
	
	
	public void setDia(Integer dia)
	{
		set(DAY_OF_MONTH, dia);
	}
	
	
	public void setMes(Integer mes)
	{
		set(MONTH, mes-1);
	}
	
	
	public void setAno(Integer ano)
	{
		set(YEAR, ano);
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%02d/%02d/%04d", getDia(), getMes(), getAno());
	}

    public Date toDate() {
        return new Date(this.getTimeInMillis());
    }
}