/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

    #################################################################################################################
    OBS: Para conseguir conectar o banco, precisei baixar a mesma versão do pacote
    JDBC "mysql-connector-java-5.1.48" da aula 7-programação desktop - 5ºsemestre
    eng. de software, pois a atual não tem o arquivo bin.jar. 
    #################################################################################################################
 */
package models;

import java.sql.*;  //as classes do JDBC são iguais as do java.sql. Para não haver erros, importamos tudo de java.sql
import java.util.logging.Level;
import javax.swing.DefaultListModel;
/**
 *
 * @author Mar
 */
public class DAOProdutos {
      
    //----------------------------------------------
    // ATRIBUTOS
    //----------------------------------------------
        private Connection conexao;                 //conexao com o BD
        private static DAOProdutos instancia;       //unica instância do DAO (DATA ACCESS OBJECT)
    
    //----------------------------------------------
    // CONSTRUTOR
    //----------------------------------------------
    /* Padrão Singleton  */
    
        private DAOProdutos(){
            try{                                                // se o caminho(driverName, não for encontrado, cai na excessão catch "ClassNotFoundException e"
                String driverName = "com.mysql.jdbc.Driver";    //tenta carregar o driver
                Class.forName(driverName);                      //se não carregar, cairá na linha do ClassNotFound

                //parametros de conexão ao banco
                String host = "localhost";
                String db   = "Cadastro_de_Produto";
                String url  = "jdbc:mysql://" + host + "/" + db;
                String user = "root";
                String pwd  = "1007";   
                
                //testar
                this.conexao = DriverManager.getConnection(url, user, pwd);
                    if (this.conexao != null) {
                        System.out.println("CONEXAO COM O BD " + db + " OK!");                
                    }else{
                        System.err.println("##ERRO NA CONEXAO COM O BD " + db +"!");
                    }        
            }catch (ClassNotFoundException e){
                System.err.println("##O driver não foi encontrado!");        
            }catch (SQLException e){
                System.err.println("##Não foi possível conectar ao BD");       
            }        
        }
    
    //----------------------------------------------
    // METODOS
    //----------------------------------------------
        ///CONEXAO BD
            public static DAOProdutos getInstance(){
                if (instancia == null) {
                    instancia = new DAOProdutos();          //se uma nova instancia == nulo, cria uma nova instancia da classe conexao com o BD-produtos.
                }       
                return  instancia;        
            }
        
        ///PEGAR LISTA
            public DefaultListModel<Produto> List(){

                DefaultListModel<Produto> model = new DefaultListModel<>();

                try {
                    PreparedStatement ps = conexao.prepareStatement("SELECT * FROM PRODUTOS");
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                        model.addElement(new Produto( 
                            rs.getInt("id_prod"),
                            rs.getString("nome_prod"),
                            rs.getString("valor_prod"),
                            rs.getString("qtd_prod"),
                            rs.getString("descricao_prod")                        
                        ));               
                    }
                return model;
                } catch (SQLException ex) {           
                    java.util.logging.Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
            return null;
            }
        
        ///SALVAR
        public void save(String id, String nome, String valor, String qtd, String descricao){ // no banco cadastrei como double
            try {
                PreparedStatement ps = conexao.prepareStatement("INSERT INTO PRODUTOS(id_prod, nome_prod, valor_prod, qtd_prod, descricao_prod)" + "VALUES (?, ?, ?, ?, ?)");
                    ps.setString(1, id);
                    ps.setString(2, nome);
                    ps.setString(3, valor);
                    ps.setString(4, qtd);
                    ps.setString(5, descricao);
                    
                    ps.execute();      

            } catch (SQLException ex) {            
                //Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE,null,ex);
                  /*
                OBSERVAÇÃO: 
                VERSÃO APOSTILA: //Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE,null,ex);
                CAUSA ERRO!

                COM AJUDA DO GTP, COLOQUEI O QUE FOI SUGERIDO:

                "O uso de System.Logger é uma nova funcionalidade introduzida no 
                Java 9 para fazer log. Se você está usando uma versão anterior do 
                Java, você pode usar a classe java.util.logging.Logger, que é a
                classe de log padrão do Java."

                "No entanto, se você está usando Java 9 ou posterior e deseja 
                utilizar System.Logger, então a correção que mencionei acima será 
                apropriada. Certifique-se apenas de importar corretamente as classes
                necessárias no início do arquivo, como você já fez para java.sql.*.
                */
                java.util.logging.Logger.getLogger(DAOProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }  
    
        }
       
}
