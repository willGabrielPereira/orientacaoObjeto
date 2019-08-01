/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import autoFX.AutoFX;
import autoFX.grafica.CriadorInterface;
import autoFX.reflection.Reflection;
import java.io.File;
import javafx.stage.Stage;
import junit.framework.TestCase;

/**
 *
 * @author willg
 */
public class TesteAutoFX extends TestCase{
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testPersistencia(){
        Reflection r = Reflection.getInstance(ClasseSimples.class);
        CriadorInterface c = CriadorInterface.getInstance(r);
        ClasseSimples simples = new ClasseSimples();
        simples.setInte(1);
        simples.setPalav("teste");
        c.getLista().add(simples);
        simples = new ClasseSimples();
        simples.setInte(2);
        simples.setPalav("teste2");
        c.getLista().add(simples);
        assertTrue(c.salvarJson(new File("teste.json")));
    }
    
}
