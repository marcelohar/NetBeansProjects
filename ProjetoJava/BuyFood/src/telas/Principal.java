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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
        
        private static Principal instance;                  // Variável para pegar uma única instância da clase
    
    //----------------------------------------
    // CONSTRUTOR
    //----------------------------------------
        private Principal(){                                // tive que deixar o construtor privado para que possa ser chamado somente por aqui e com isso poder criar uma única instância
            this.initialize(); 
            this.setExtendedState(NORMAL);

        }
    
    //----------------------------------------
    // FUNÇÕES DA CLASSE
    //----------------------------------------
        
           
    public static Principal getInstance(){              // Método estático para obter a instância única da classe 
        if (instance == null) {
            instance = new Principal();
        }
    return instance;
    }

        
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
            
            iCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CadastroFood c = new CadastroFood();
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
                    setEnabled(false);                                  //desabilita a tela principal quando abrir a de cadastro

                    c.addWindowListener(new WindowAdapter(){

                    @Override
                    public void windowClosed(WindowEvent e){            // tem que  import java.awt.event.WindowEvent;
                        setEnabled(true);                               //habilita a tela principal quando fechar a tela de cadastro
                    }   

                    });  
                }            
            });
           
                   
        
        
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
