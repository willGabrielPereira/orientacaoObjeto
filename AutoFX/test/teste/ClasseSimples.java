/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author willg
 */
public class ClasseSimples {
    private int inte;
    private String palav;

    public Integer getInte() {
        return inte;
    }

    public void setInte(Integer inte) {
        this.inte = inte;
    }

    public String getPalav() {
        return palav;
    }

    public void setPalav(String palav) {
        this.palav = palav;
    }

    @Override
    public String toString() {
        return "ClasseSimples{" + "inte=" + inte + ", palav=" + palav + '}';
    }
    
}
