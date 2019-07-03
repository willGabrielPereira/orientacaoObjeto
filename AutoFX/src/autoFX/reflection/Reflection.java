package autoFX.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reflection {

    private static Reflection reflection;

    /**
     * Valor inteiro que equivale à qualquer função "<code>set</code>"
     */
    public final static int SET = 0;
    /**
     * Valor inteiro que equivale à qualquer função "<code>get</code>"
     */
    public final static int GET = 1;

    private Class<?> classe;
    private Object objeto;
    private String nomeClasse;
    private Field[] atributos;

    /**
     * Singleton para Reflection, evitando o uso de mais de uma classe ao mesmo tempo
     * @param classe Class que será trabalhada
     * @return Reflection
     */
    public static Reflection getInstance(Class<?> classe) {
        if (reflection == null) {
            reflection = new Reflection(classe);
            return reflection;
        } else {
            return reflection;
        }
    }

    private Reflection(Class<?> classe) {
        this.classe = classe;
        String nome[] = classe.getName().replace('.', ' ').split(" ");
        this.nomeClasse = nome[nome.length - 1];
        try {
            objeto = classe.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        this.setAtributos();
    }

    /**
     * Instancia um novo objeto limpo da <code>classe</code>
     */
    public void novoObjeto() {
        try {
            this.objeto = classe.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Class<?> getClasse() {
        return classe;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public Field[] getAtributos() {
        return atributos;
    }

    /**
     * Busca pelo atributo com o mesmo nome
     * @param nome nome do atributo desejado
     * @return atributo encontrado, ou null caso não seja encontrado
     */
    public Field procuraAtributo(String nome) {
        for (Field f : atributos) {
            if (f.getName().startsWith(nome)) {
                return f;
            }
        }
        return null;
    }

    public Object getObjeto() {
        return objeto;
    }

    private void setAtributos() {
        atributos = classe.getDeclaredFields();
    }
    
    /**
     * Invoca/chama método para tal atributo, enviando junto o objeto que deverá receber/resgatar o valor
     * @param <tipoParametro> tipo do parametro da função
     * @param atributo atributo que recebe/envia valor
     * @param setGet define se função é setter ou getter
     * @param parametro valor do parametro
     * @param objeto objeto que recebe o valor do atributo
     * @return objeto retornado caso seja um <code>get</code>, ou null caso seja <code>set</code>
     */
    public <tipoParametro> Object invokeParaAtributo(Field atributo,
            int setGet, tipoParametro parametro, Object objeto){
        this.objeto = objeto;
        return invokeParaAtributo(atributo, setGet, parametro);
    }
    /**
     * Invoca/chama método para tal atributo, atribuindo/resgatando valor no objeto já instanciado previamente, pesquisa automaticamente pelo nome do atributo
     * @param <tipoParametro> tipo do parametro da função
     * @param atributo nome do atributo que recebe/envia valor
     * @param setGet define se função é setter ou getter
     * @param parametro valor do parametro
     * @return objeto retornado caso seja um <code>get</code>, ou null caso seja <code>set</code>
     */
    public <tipoParametro> Object invokeParaAtributo(String atributo,
            int setGet, tipoParametro parametro) {
        Field f = procuraAtributo(atributo);
        return invokeParaAtributo(f, setGet, parametro);
    }

    /**
     * Invoca/chama método para tal atributo, atribuindo/resgatando valor no objeto já instanciado previamente
     * @param <tipoParametro> tipo do parametro da função
     * @param atributo atributo que recebe/envia valor
     * @param setGet define se função é setter ou getter
     * @param parametro valor do parametro
     * @return objeto retornado caso seja um <code>get</code>, ou null caso seja <code>set</code>
     */    
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
        palavra = pre + palavra.substring(0, 1).
                toUpperCase().concat(palavra.substring(1));

        if (setGet == 0) {
            switch (atributo.getType().getName()) {
                case "int":
                    //parametro = Integer.parseInt((String) parametro);
                    break;
            }
        }

        try {
            Method metodo;
            if (parametro == null) {
                metodo = classe.getMethod(palavra, null);
                return metodo.invoke(objeto, null);
            }else{
                metodo = classe.getMethod(palavra, parametro.getClass());
                return metodo.invoke(objeto, parametro);
            }
            
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Reflection{" + "classe=" + classe + '}';
    }

}
