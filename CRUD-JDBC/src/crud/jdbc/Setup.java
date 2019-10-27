/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.jdbc;

import Beans.Carro;
import Beans.Pessoa;
import DAOs.CarroDAO;
import DAOs.Conexao;
import DAOs.PessoaDAO;
import View.Cliente;

/**
 *
 * @author Danilo
 */
public class Setup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
           Carro c = new Carro("GOL QUADRADO", "Branco", 1992,14,5600.99);
           CarroDAO cDao = new CarroDAO();
           cDao.addCarro(c);
           int tam = cDao.mostraCarros().size();
           for(int i=0;i<tam;i++){
               System.out.println("Nome: "+cDao.mostraCarros().get(i).getNome());
               System.out.println("Ano: "+cDao.mostraCarros().get(i).getAno());
               System.out.println("Cor: "+cDao.mostraCarros().get(i).getCor());
               System.out.println("Potencia: "+cDao.mostraCarros().get(i).getPotencia());
               System.out.println("Valor: "+cDao.mostraCarros().get(i).getValor());
               System.out.println("-----------------------------------------------------------------");
           }
          */
        
//        Pessoa p = new Pessoa();
//        p.setCpf("999999999");
//        p.setNome("Danilo Lindo!");
//        p.setIdade("29");
//        p.setRg("098908909");
//        PessoaDAO pDAO = new PessoaDAO();
//        pDAO.addPessoa(p);
//        
//        int tam = pDAO.mostrar_pessoas().size();
//        
//        for(int i =0 ;i<tam;i++){
//            System.out.println("ID: "+
//                    pDAO.mostrar_pessoas().get(i).getId());
//            System.out.println("Nome: "+
//                    pDAO.mostrar_pessoas().get(i).getNome());
//            System.out.println("Idade: "+
//                    pDAO.mostrar_pessoas().get(i).getIdade());
//            System.out.println("CPF: "+
//                    pDAO.mostrar_pessoas().get(i).getCpf());
//            System.out.println("RG: "+
//                    pDAO.mostrar_pessoas().get(i).getRg());
//            
//            System.out.println("--------------------------------------------------");
//        }
        
        
        Cliente c = new Cliente();
        c.setVisible(true);
        
        
    }
    
}
