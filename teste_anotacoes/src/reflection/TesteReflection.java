package reflection;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
public class TesteReflection {
	
	final static int SET = 0;
	final static int GET = 1;
	
	private Class<?> classe;
	private Object objeto;
	private String nomeClasse;
	private Field[] atributos;
	
	public Class<?> getClasse() {
		return classe;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}
	
	public TesteReflection(Class<?> classe) {
		this.classe = classe;
		this.nomeClasse = classe.getName();
		try {
			objeto = classe.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		this.setAtributos();
	}
	
	private void setAtributos() {
		atributos = classe.getDeclaredFields();
	}
	
	public <tipoParametro> Object invokeParaAtributo(String atributo, 
			int setGet,	tipoParametro parametro) {
		Field f = procuraAtributo(atributo);
		return invokeParaAtributo(f, setGet, parametro);
	}
	
	public <tipoParametro> Object invokeParaAtributo(Field atributo, 
			int setGet, tipoParametro parametro) {
		String pre = "";
		switch (setGet) {
		case 0:
			pre = "set";
			break;
		case 1:
			pre = "get";
			break;
		default:
			break;
		}
		
		String palavra = atributo.getName();
		palavra = pre+palavra.substring(0,1).
				toUpperCase().concat(palavra.substring(1));
		
		try {
			Method metodo = classe.getMethod(palavra, parametro.getClass());
			return metodo.invoke(objeto, parametro);
		} catch (IllegalAccessException | IllegalArgumentException | 
				InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Field[] getAtributos(){
		return atributos;
	}
	
	public Field procuraAtributo(String nome) {
		for(Field f : atributos) {
			if(f.getName().startsWith(nome)) {
				return f;
			}
		}
		return null;
	}
	
	public Object getObjeto() {
		return objeto;
	}
	
	
	/*public static void main(String args[])
	{
		String className = JOptionPane.showInputDialog(null, 
								"Digite o nome da classe: ");
		try
		{
			Class clazz = Class.forName(className);
			// cria o objeto solicitado
			Object object = clazz.newInstance();
			// obtém e executa o método getDesc
			Method method = clazz.getMethod("getDesc", null);
			Method method2 = clazz.getMethod("setNome", String.class);
			method2.invoke(object, "nome Teste");
			List desc  = (List) method.invoke(object, null);
			System.out.println(object);
			for (Object o: desc)
				System.out.println(o);
		}
		catch (Exception e)
		{
			e.printStackTrace(System.err);
		}
	}*/
}

