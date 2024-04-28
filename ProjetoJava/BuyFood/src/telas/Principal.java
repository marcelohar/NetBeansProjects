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

/**
 *
 * @author Mar
 */
public class Principal extends JFrame {
    
    //----------------------------------------
    // ATRIBUTOS
    //----------------------------------------    
        //PAINEl
        private JPanel painelP, painelB;

        //LABELS
        private JLabel lblTitudo;

        //BUTTONS 
        private JButton btnCadastrar, btnDeletar, btnSair;

        //MENU
        private JMenuBar bMenu;
        private JMenu mIniciar;
        private JMenuItem iCadastrar, iSair;
    
    //----------------------------------------
    // CONSTRUTOR
    //----------------------------------------
        public Principal(){
            this.initialize(); 
            this.setExtendedState(NORMAL);

        }
    
    //----------------------------------------
    // FUNÇÕES DA CLASSE
    //----------------------------------------
    public void initialize(){
        //iniciar variáveis
        
        //iniciar paineis
        painelP         = new JPanel();
        painelB         = new JPanel();
        
        //iniciar textos
        lblTitudo       = new JLabel("BUY FOOD");
        
        //iniciar botões do painel de botoes
        btnCadastrar    = new JButton("Cadastrar");
        btnDeletar      = new JButton("Deletar");
        btnSair         = new JButton("Sair");
        
        //iniciar menu
        bMenu           = new JMenuBar();
        mIniciar        = new JMenu("Iniciar");
        iCadastrar      = new JMenuItem("Cadastrar");
        iSair           = new JMenuItem("Sair");
        
        //add itens na tela           
        
        //MENU
            //add itens no menu INICIAR 
            mIniciar.add(iCadastrar);
            mIniciar.addSeparator();
            mIniciar.add(iSair);

            //add menu na barra
            bMenu.add(mIniciar);
            
            //add barra na tela 
            this.setJMenuBar(bMenu);
            
        
        //painel de botões
         painelB.setLayout(new GridLayout(6,1,10,10));
         painelB.add(btnCadastrar);
         painelB.add(btnDeletar);
         painelB.add(btnSair);
                 
        //painel principal
        painelP.setLayout(new BorderLayout(5,5));          //BorderLayout, Gridlayout...
        painelP.add(lblTitudo, BorderLayout.PAGE_START);
        painelP.add(painelB, BorderLayout.LINE_END);   
        
        //add painel principal na tela
        this.add(painelP);
        
       
        //configurar botoes
            //menu 
            
            iSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);                
            }       
            });
            
            //painel botões
            btnSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                dispose();
                System.exit(0);
            }
            });
            
            btnCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CadastroFood c = new CadastroFood();
            }            
            });
            /*************************************************************************
             * proxima etapa, criar a tela de cadastro.
             * 
             */
        
        
        //configurar tela
        this.setBounds(0, 0, 600, 300);
        this.setPreferredSize(new Dimension(600,300));
        this.pack();
        this.setTitle("BUY FOOD");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
      
}
