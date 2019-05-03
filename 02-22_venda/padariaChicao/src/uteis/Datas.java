package uteis;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Datas {
	
	/**
	 * criaData
	 * @author William Gabriel Pereira
	 * @param dia int
	 * @param mes int
	 * @param ano int
	 * @param segundo int
	 * @param minuto int
	 * @param hora int
	 * @return data no tipo Date
	 */
	public static Date criaData(int dia, int mes, int ano, int segundo, int minuto, int hora) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		calendario.set(Calendar.MONTH, mes); // 0=jan, 1=fev....
		calendario.set(Calendar.YEAR, ano);
		calendario.set(Calendar.HOUR_OF_DAY, hora);
		calendario.set(Calendar.MINUTE, minuto);
		calendario.set(Calendar.SECOND, segundo);
		Date dt = calendario.getTime();
		return dt;
	}
	
	/**
	 * 
	 * @param data
	 * @param separador
	 * @return
	 */
	public static Date stringToDate(String data, String separador) {
		int dia = Integer.parseInt(data.split(separador)[0]);
		int mes = Integer.parseInt(data.split(separador)[1]);
		int ano = Integer.parseInt(data.split(separador)[2]);
		
		return criaData(dia, mes-1, ano, 0, 0, 0);
	}
	
	/**
	 * dateToCalendar
	 * usado para obter o tipo Calendar de um tipo Date
	 * @author William Gabriel Pereira
	 * @param data em Date
	 * @return tipo Calendar
	 */
	public static Calendar dateToCalendar(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		return cal;
	}
	

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static int pegaMes(Date data) {
		Calendar m = dateToCalendar(data);
		return m.get(Calendar.MONTH);
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static int pegaDia(Date data) {
		Calendar m = dateToCalendar(data);
		return m.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 
	 * @param data
	 * @return
	 */
	public static int pegaAno(Date data) {
		Calendar m = dateToCalendar(data);
		return m.get(Calendar.YEAR);
	}
	
	
	/**
	 * diasDoMes
	 * @author William Gabriel Pereira
	 * @param mes int
	 * @param ano int
	 * @return lista de Date ///
	 * Serve para verificar quais são os dias possíveis
	 */
	public static List<Date> diasDoMes(int mes, int ano) {
		Calendar calendario = Calendar.getInstance();
		
		calendario.set(Calendar.YEAR, ano);
		calendario.set(Calendar.MONTH, mes);
		
		List<Date> lista = new ArrayList<Date>();
		for(int i=1; i<=calendario.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
			calendario.set(Calendar.DAY_OF_MONTH, i);
			Date dt = calendario.getTime();
			lista.add(dt);
		}
		return lista;
		
	}
	
	/**
	 * diasEntreDatas
	 * busca os dias que estão entre duas datas
	 * @author William Gabriel Pereira
	 * @param inicio Date
	 * @param fim Date
	 * @return List de tipo Date
	 */
	public static List<Date> diasEntreDatas(Date inicio, Date fim) {
		Calendar calInicio = dateToCalendar(inicio);
		Calendar calFim = dateToCalendar(fim);
		
		List<Date> lista = new ArrayList<Date>();
		for(int i = calInicio.get(Calendar.DAY_OF_MONTH); i < calFim.get(Calendar.DAY_OF_MONTH); i++) {
			calInicio.set(Calendar.DAY_OF_MONTH, i);
			Date dt = calInicio.getTime();
			lista.add(dt);
		}
		return lista;
	}
	
	
	/**
	 * diferencaEmSegundos
	 * Calcula a diferença em segundos entre duas datas
	 * @author William Gabriel Pereira
	 * @param inicial em Date
	 * @param ultimo em Date
	 * @return segundos em Long
	 */
	public static Long diferencaEmSegundos(Date inicial, Date ultimo) {
		Long inicio = inicial.getTime();
		Long ultima = ultimo.getTime();
		return (ultima-inicio)/1000;
	}
	
	/** diferencaEmDias
	 * @author William Gabriel Pereira
	 * @param inicial
	 * @param ultimo
	 * @return quantidade de dias entre duas datas em Long
	 */
	public static Long diferencaEmDias(Date inicial, Date ultimo) {
		return diferencaEmSegundos(inicial, ultimo)/86400;
	}
	
	/**
	 * diaUtil verifica se a data pertence à um dia util
	 * @author William Gabriel Pereira
	 * @param data
	 * @return boolean
	 */
	public static boolean diaUtil(Date data) {
		boolean diaUtil=false;
		Calendar cal = Datas.dateToCalendar(data);
		if(cal.get(Calendar.DAY_OF_WEEK) > 1 && cal.get(Calendar.DAY_OF_WEEK) < 7) {
			System.out.println(cal.get(Calendar.DAY_OF_WEEK));
			diaUtil=true;
		}
		return diaUtil;
	}
	
	/**
	 * dataToString
	 * cria uma string que representa a data
	 * @param data Date
	 * @return String
	 * "segunda, 8 de maio de 2005"
	 */
	public static String dataToString(Date data) {
		Calendar dia = dateToCalendar(data);
		
		StringBuilder dataString = new StringBuilder();
		
		dataString.append(dia.get(Calendar.DAY_OF_MONTH)+" ");
		
		switch(dia.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			dataString.append("Domingo");
			break;
		case 2:
			dataString.append("Segunda-feira");
			break;
		case 3:
			dataString.append("Terça-feira");
			break;
		case 4:
			dataString.append("Quarta-feira");
			break;
		case 5:
			dataString.append("Quinta-feira");
			break;
		case 6:
			dataString.append("Sexta-feira");
			break;
		case 7:
			dataString.append("Sábado");
			break;
		}
		
		dataString.append(" de ");
		
		switch(dia.get(Calendar.MONTH)) {
		case 0:
			dataString.append("janeiro");
			break;
		case 1:
			dataString.append("Fevereiro");
			break;
		case 2:
			dataString.append("Março");
			break;
		case 3:
			dataString.append("Abril");
			break;
		case 4:
			dataString.append("Maio");
			break;
		case 5:
			dataString.append("Junho");
			break;
		case 6:
			dataString.append("Julho");
			break;
		case 7:
			dataString.append("Agosto");
			break;
		case 8:
			dataString.append("Setembro");
			break;
		case 9:
			dataString.append("Outubro");
			break;
		case 10:
			dataString.append("Novembro");
			break;
		case 11:
			dataString.append("Dezembro");
			break;
		}
		
		dataString.append(" de ");
		dataString.append(dia.get(Calendar.YEAR));
		
		return dataString.toString();
	}

    public static String dataCompletaToString(Date data) {
        String d = dataToString(data);
        Calendar c = dateToCalendar(data);
        d += " "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE);
        return d;
    }
}
