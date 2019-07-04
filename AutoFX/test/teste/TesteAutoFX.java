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
import javafx.stage.Stage;
import junit.framework.TestCase;

/**
 *
 * @author willg
 */
public class TesteAutoFX extends TestCase{
    
    private Stage stage;
    private AutoFX autoFX;
    
    public TesteAutoFX() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stage = new Stage();
        autoFX = AutoFX.getInstance(ClasseSimples.class, stage);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testGetInstance(){
        assertEquals(AutoFX.getInstance(ClasseSimples.class, stage), autoFX);
    }
    
    @Test
    public void testApresentarTela(){
        assertEquals(stage, autoFX.getStage());
        autoFX.apresentarTela();
        assertEquals(stage, autoFX.getStage());
    }
    
}
