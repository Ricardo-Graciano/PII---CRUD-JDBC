/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Danilo
 */
public class Vendas {
    
    private int id, id_pessoa_fk, id_carro_fk;
    
    public Vendas( int id_pessoa_fk,int id_carro_fk){
        
        this.id_carro_fk = id_carro_fk;
        this.id_pessoa_fk = id_pessoa_fk;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_pessoa_fk
     */
    public int getId_pessoa_fk() {
        return id_pessoa_fk;
    }

    /**
     * @param id_pessoa_fk the id_pessoa_fk to set
     */
    public void setId_pessoa_fk(int id_pessoa_fk) {
        this.id_pessoa_fk = id_pessoa_fk;
    }

    /**
     * @return the id_carro_fk
     */
    public int getId_carro_fk() {
        return id_carro_fk;
    }

    /**
     * @param id_carro_fk the id_carro_fk to set
     */
    public void setId_carro_fk(int id_carro_fk) {
        this.id_carro_fk = id_carro_fk;
    }
}
