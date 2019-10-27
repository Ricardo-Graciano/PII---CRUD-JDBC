/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Beans.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class VendasDAO {
    private Connection conn = null;
    private final String INSERT = "INSERT INTO vendas "
            + "(id_carros,id_pessoas) "
            + "VALUES (?,?)";
    private final String DELETE = "DELETE FROM vendas "
            + "WHERE id = ?";
    private final String READ = "SELECT * FROM vendas";
    private final String UPDATE = "UPDATE vendas SET "
            + "id_carros = ? , id_pessoas = ?  WHERE id = ?";
    
    public VendasDAO(){
        this.conn = Conexao.getConnection();
    }
    
    public void addVenda(Vendas v){
        try {
            PreparedStatement stmt = this.conn.prepareStatement(INSERT);
            stmt.setInt(1, v.getId_carro_fk());
            stmt.setInt(2, v.getId_pessoa_fk());
            
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Houve um erro ao adicionar venda "+e.getMessage());
        }
    }
    
    public ArrayList<Vendas> mostrarVendas(){
        try {
            ArrayList<Vendas> lista_vendas = new ArrayList<Vendas>();
            PreparedStatement stmt = this.conn.prepareStatement(READ);
            ResultSet rs =   stmt.executeQuery();
            
            while(rs.next()){
                Vendas v = new Vendas(rs.getInt("id_pessoa_fk"), rs.getInt("id_carro_fk"));
                lista_vendas.add(v);
            }
            
            return lista_vendas;
            
        } catch (SQLException e) {
            System.out.println("Erro ao pegar vendas "+ e.getMessage());
            return null;
        }
    }
}
