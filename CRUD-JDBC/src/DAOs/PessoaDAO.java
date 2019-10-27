/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Beans.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
/**
 * id int(11) AI PK 
nome varchar(250) 
idade int(11) 
rg varchar(12) 
cpf varchar(11)
 * @author Danilo
 */
public class PessoaDAO {
    
   private static final String INSERT = "INSERT INTO pessoa (nome,idade,rg,cpf)"
            + "VALUES (?,?,?,?)";
     String READ = "SELECT * FROM pessoa";
   private static String DELETE = "DELETE FROM pessoa WHERE id = ?";
   private static String UPDATE = "UPDATE pessoa SET nome = ?,"
           + "idade = ?, rg = ? , cpf = ? ";
   
   private Connection conn;
   
   public PessoaDAO(){
      this.conn = Conexao.getConnection();
   }
   public void addPessoa(Pessoa pessoa){
       
       try{
           PreparedStatement stmt = this.conn.prepareStatement(INSERT);
           stmt.setString(1, pessoa.getNome());
           stmt.setInt(2, pessoa.getIdade());
           stmt.setString(3,pessoa.getRg());
           stmt.setString(4, pessoa.getCpf());
           stmt.execute();
           System.out.println("Registro inserido com sucesso");
       }
       catch(SQLException e ){
           System.out.println("Erro ao inserir registro: "+e.getMessage());
       }
       
       
   }
   
   public ArrayList<Pessoa> mostrar_pessoas(){
           ArrayList<Pessoa> retorno = new ArrayList<>();
           try{
               PreparedStatement stmt =this.conn.prepareStatement(READ);
               ResultSet  rs = stmt.executeQuery();
               
               while(rs.next()){
                   Pessoa pessoa = new Pessoa();
                   pessoa.setCpf(rs.getString(("cpf")));
                   pessoa.setIdade(rs.getString("idade"));
                   pessoa.setRg(rs.getString("rg"));
                   pessoa.setNome(rs.getString("nome"));
                   pessoa.setId(rs.getInt("id"));
                   retorno.add(pessoa);
               }
               rs.close();
               return retorno;
           }
           catch(SQLException e){
               System.out.println("Erro ao retornar pessoa."+e.getMessage());
               return null;
           }
       }
   
   public ResultSet populaGrid(){
       try{
            PreparedStatement stmt = this.conn.prepareStatement(READ);
            ResultSet  rs = stmt.executeQuery();
               
            //rs.close();
            return rs;
           }
        catch(SQLException e){
           System.out.println("Erro ao retornar pessoa."+e.getMessage());
           return null;
        }
   }
   
}
