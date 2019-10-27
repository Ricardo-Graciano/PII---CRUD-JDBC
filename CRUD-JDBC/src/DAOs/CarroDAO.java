/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Beans.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class CarroDAO {
    private Connection conn = null;
    private String INSERT = "INSERT INTO carro "
            + "(nome,cor,ano,potencia,valor) "
            + "VALUES (?,?,?,?,?)";
    private String DELETE = "DELETE FROM carro "
            + "WHERE id = ?";
    private String READ = "SELECT * FROM carro";
    private String UPDATE = "UPDATE carro SET "
            + "nome = ? , cor = ? , ano = ? , potencia = ?"
            + "valor = ? WHERE id = ?";
    public CarroDAO (){
        this.conn = Conexao.getConnection();
    }
    public void addCarro(Carro carro){
        try{
            PreparedStatement stmt = this.conn.prepareStatement(INSERT);
            stmt.setString(1, carro.getNome());
            stmt.setString(2, carro.getCor());
            stmt.setInt(3, carro.getAno());
            stmt.setInt(4, carro.getPotencia());
            stmt.setDouble(5, carro.getValor());
            stmt.execute();
            System.out.println("Carro adicionado com sucesso");
            
        }
        catch(SQLException e){
            System.out.println("Erro ao inserir carro:"+ e.getMessage());
        }
        
      
    }
    
    public ArrayList<Carro> mostraCarros(){
        ArrayList<Carro> retorno = new ArrayList<>();
        try{
            PreparedStatement stmt = this.conn.prepareStatement(READ);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Carro c = new Carro(rs.getString("nome"),rs.getString("cor"),rs.getInt("ano"),rs.getInt("potencia"),rs.getDouble("valor"));
                 retorno.add(c);
            }
            rs.close();
            return retorno;

        }
        catch(SQLException e){
            System.out.println("Erro ao retornar "+e.getMessage());
            return null;
        }
    }
    
    
}
