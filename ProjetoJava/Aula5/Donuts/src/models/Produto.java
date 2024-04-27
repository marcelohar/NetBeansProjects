/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Mar
 */
public class Produto {
    //----------------------------------------------
    // ATRIBUTOS
    //----------------------------------------------    
        private int     id;
        private String  nome, valor, qtd, descricao;
    
    //----------------------------------------------
    // CONSTRUTOR
    //----------------------------------------------
        //CONTRUTOR 1    
        public  Produto(String nome, String valor, String qtd, String descricao){
            this.nome       = nome;
            this.valor      = valor;
            this.qtd        = qtd;
            this.descricao  = descricao;    
        }
            
        //CONSTRUTOR 2
        public Produto(int id, String nome, String valor, String qtd, String descricao){
            this.id         = id;
            this.nome       = nome;
            this.valor      = valor;
            this.qtd        = qtd;
            this.descricao  = descricao;            
        }
                
    //----------------------------------------------
    // MÉTODOS
    //---------------------------------------------- 
        @Override
        public String toString(){
            return this.nome;
        }
}
