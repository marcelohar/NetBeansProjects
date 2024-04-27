 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.Listar;

/**
 *
 * @author Mar
 */
public class Principal extends JFrame {
        
    //----------------------------------------------
    // ATRIBUTOS
    //----------------------------------------------
    
        //PAINEL
        private JPanel panel_principal, panel_botoes;
        private JButton btn_cadastrar, btn_deletar, btn_sair;
        private JLabel lbl_titulo;
        
        //MENU
        private JMenuBar    b_menu;
        private JMenu       mB_iniciar;
        private JMenuItem   iM_cadastrar, iM_sair;   
    
    //----------------------------------------------
    // CONSTRUTOR
    //----------------------------------------------
    public Principal(){
        //this.dao = DAOProdutos.getInstance();        
        this.initialize();
        this.setExtendedState(NORMAL);        
    }
    
    //----------------------------------------------
    // MÉTODOS
    //----------------------------------------------
    public void initialize(){
        
        ///INICIALIZAÇÃO DOS OBJETOS 
            //LABEL
            lbl_titulo      = new JLabel("Cadastro de Prooduto");

            //BOTÕES
            btn_cadastrar   = new JButton("Cadastrar");
            btn_deletar     = new JButton("Deletar");
            btn_sair        = new JButton("Sair");

            //PAINEIS
            panel_principal = new JPanel();
            panel_botoes    = new JPanel();
            
            //MENU
            b_menu          = new JMenuBar();
            mB_iniciar      = new JMenu("INICIAR");
            iM_cadastrar    = new JMenuItem("Cadastrar");
            iM_sair         = new JMenuItem("Sair");
                                
                //*********TEM QUE IR PARA OUTRO LUGAR***********************
                
                //************************************************************
        
        //CONFIGURAR JANELA    
            ///BARRA DE MENU
                ////ADD ITENS, NO MENU DA BARRA-mB
                    mB_iniciar.add(iM_cadastrar);
                    mB_iniciar.addSeparator();      //add um separador ao menu
                    mB_iniciar.add(iM_sair);

                ////ADD MENU, NA BARRA DE MENU-b
                    b_menu.add(mB_iniciar);

                ////BOTOES ITEM_MENU-iM                
                    /////CADASTRAR
                    iM_cadastrar.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            TelaCadastro c = new TelaCadastro();
                        }  
                    });  

                    /////SAIR
                    iM_sair.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            setVisible(false);
                            dispose();
                            System.exit(0);
                        }
                    });

                ////ADD BARRA DE MENU, NA TELA PRINCIPAL
                this.setJMenuBar(b_menu); 
                        
            ///PAINEL_BOTÕES       
                ////ESTILO PAINEL_BOTÕES
                panel_botoes.setLayout(new GridLayout(6,1,10,10));          //formato tipo tabela (grid) com 6 linhas e 1 coluna
                
                ////BOTÕES - PAINEL_BOTÕES
                    /////ADD BOTÕES - PAINEL_BOTÕES
                    panel_botoes.add(btn_cadastrar);
                    panel_botoes.add(btn_deletar);
                    panel_botoes.add(btn_sair);
                    
                    /////CONFIGURAR BOTÕES - PAINEL_BOTÕES
                        //////BTN_SAIR - PAINEL_BOTÕES
                        btn_sair.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                setVisible(false);
                                dispose();
                                System.exit(0);     
                            }            
                        });
                        //////BTN_CADASTRAR - PAINEL_BOTÕES                  
                        btn_cadastrar.addActionListener(new ActionListener(){   //ao clicar em cadastrar criar uma nova instância da tela de cadastro
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                TelaCadastro c = new TelaCadastro();
                            }
                        });
            ///CONFIGURAR O TAMANHO DA JANELA
            this.setBounds(0,0,600,300);                                //esta janela tem: posição x,y e largura, altura
            this.setPreferredSize(new Dimension(600,300));
            
            ///PAINEL PRINCIPAL 
                ////LAYOUT DO PAINEL PRINCIPAL
                    panel_principal.setLayout(new BorderLayout(5,5));
                    panel_principal.add(lbl_titulo, BorderLayout.PAGE_START);   //ADD ELEMENTOS NO PAINEL PRINCIPAL 
                    panel_principal.add(panel_botoes, BorderLayout.LINE_END);   //ADD PAINEL_BOTÕES NO PAINEL PRINCIPAL 
                    
                ////ADD LISTA AO PAINEL PRINCIPAL
                    Listar lista = new Listar();            
                    JScrollPane scroll_lista = new JScrollPane(lista.getListarProduto()); //scroll_lista é um novo objeto que recebe uma lista que vem de lista.getListaProduto()
                    panel_principal.add(scroll_lista, BorderLayout.CENTER);     //ADD PAINEL DE ROLAGEM NO PAINEL PRINCIPAL
                    
            ///CONCUINDO JANELA        
                this.add(panel_principal);              ///ADD PAINEL PRINCIPAL NA JANELA(FRAME)
                this.pack();                            //junta tudo em um
                this.setTitle("Cadastro de Produto");   //Título da tela
                this.setVisible(true);                  //deixa a tela visível
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
    } 
}

