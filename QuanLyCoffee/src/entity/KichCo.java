/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Lam Chuot
 */
public class KichCo {

    private int makichco;
    private String KichCo;

    public KichCo() {
    }

    public KichCo(int makichco, String KichCo) {
        this.makichco = makichco;
        this.KichCo = KichCo;
    }

    public int getMakichco() {
        return makichco;
    }

    public void setMakichco(int makichco) {
        this.makichco = makichco;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.KichCo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KichCo other = (KichCo) obj;
        if (!Objects.equals(this.KichCo, other.KichCo)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return KichCo;
    }

}
