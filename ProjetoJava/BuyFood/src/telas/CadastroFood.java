/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Mar
 */
public class CadastroFood extends JDialog{
     //----------------------------------------
    // ATRIBUTOS
    //---------------------------------------- 
    private JPanel painelCadfood;
    
    //labels
    private JLabel lblId, lblNome, lblQtd, lblValor;
    
    //Text Filds
    private JTextField txtId, txtNome, txtQtd, txtValor;
    
    //buttons
    private JButton btnSalvar, btnCancelar;
    
    //----------------------------------------
    // CONSTRUTOR
    //---------------------------------------- 
    public CadastroFood(){
        initialize();    
    
    }
    
    //----------------------------------------
    // MÉTODOS
    //---------------------------------------- 
    public void initialize(){
        //iniciar variáveis
        //painel
        painelCadfood   = new JPanel();
        
        //label
        lblId           = new JLabel("ID");
        lblNome         = new JLabel("Nome");
        lblQtd          = new JLabel("Quantidade");
        lblValor        = new JLabel("Valor");
        
        //text filds
        txtId           = new JTextField();
        txtNome         = new JTextField();
        txtQtd          = new JTextField();
        txtValor        = new JTextField();
        
        //buttons
        btnCancelar     = new JButton("Cancelar");
        btnSalvar       = new JButton("Salvar");
        
        //configurar painel
        GridLayout g1 = new GridLayout(5, 2, 15, 15);
        painelCadfood.setLayout(g1);
        
        painelCadfood.add(lblId);
        painelCadfood.add(txtId);
        
        painelCadfood.add(lblNome);
        painelCadfood.add(txtNome);
        
        painelCadfood.add(lblQtd);
        painelCadfood.add(txtQtd);
        
        painelCadfood.add(lblValor);
        painelCadfood.add(txtValor);
        
        painelCadfood.add(btnSalvar);
        painelCadfood.add(btnCancelar);
        
        this.add(painelCadfood);
        this.setBounds(0, 0, 400, 200);
        this.setPreferredSize(new Dimension(400, 200));
        this.setTitle("Cadastro Food");
        
        this.pack();
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    
    
    
    
}
