/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Mar
 */
public class Listar {
    //-------------------------------------------------
    // TRIBUTOS
    //-------------------------------------------------    
        //LISTA
            private JList<Produto>  lista;
            private JScrollPane     scroll_Lista;
        
        //CONEXAO BD
            private DAOProdutos     daoProd;
            
    //-------------------------------------------------
    // CONSTRUTOR
    //-------------------------------------------------
        public Listar(){
            //chamar o metodo listar
            this.daoProd = DAOProdutos.getInstance();
            this.getListarProduto();   
        }
    
    //-------------------------------------------------
    // MÉTODOS
    //-------------------------------------------------
        public JList getListarProduto(){            
            //LISTA
            lista = new JList<Produto>();
            lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //declaração do tipo da seleção permitido na listagem(uma  ou mais selecões  por vez 
            lista.setLayoutOrientation(JList.VERTICAL);                           //como os elementos ficarão listados 
            lista.setModel(daoProd.List());                                       // recebe a listagem, criando assim a lista
            lista.setVisibleRowCount(-1);      
        return lista;
        }
}
