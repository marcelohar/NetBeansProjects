/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexoes;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Mar
 */
public class DAOproduto {
    
    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------
    private Connection cxBdBuyFoodProd;
    private static DAOproduto instanciaDaoProd;
    
    //----------------------------------------------
    // CONSTRUTOR
    //----------------------------------------------
    /* Padrão Singleton  */
    
    private DAOproduto(){
        
        try {
            
            String driver = "com.mysql.jdbc.Driver";    // endereço do driver
            Class.forName(driver);                      //usada para carregar dinamicamente a classe de um driver JDBC 
            
            //atributos da conexao
            String host = "localhost";
            String db   = "buyfood";
            String url  = "jdbc:myslq://" + host + "/" + db;
            String user = "root";
            String pwd  = "1007";
            
            this.cxBdBuyFoodProd = DriverManager.getConnection(url, user, pwd);
            
            if (this.cxBdBuyFoodProd != null) {
                System.out.println("Conexão BD buy food ok");                
            }else{
                System.err.println("##ERRO Conexao com o BD " + db);
                
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("##ERRO O Driver não foi encontrado!");
        }catch (SQLException e){
        /***************CAIU AQUI VERIFICAR SE É PQ O BANCO ESTA EM "OUTROS BD"************************/
            System.err.println("##ERRO NÃO CONECTOU AO BD");
            
        }
    }
    
    //----------------------------------------------
    // METODOS
    //----------------------------------------------
    public static DAOproduto getInstanceDaoProd(){
        if (instanciaDaoProd == null) {
            instanciaDaoProd = new DAOproduto();           
        }
    return instanciaDaoProd;
    }
    
    
    
}
