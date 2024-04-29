package telas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.initialize(); 
        
        /*
        modal - especifica se a caixa de diálogo bloqueia
        a entrada para outras janelas quando mostrada; 
        chamar para setModal(true) é equivalente a 
        setModalityType(Dialog.DEFAULT_MODALITY_TYPE) e 
        chamar para setModal(false) é equivalente a 
        setModalityType(Dialog.ModalityType.MODELESS)
        */
        
        this.setAlwaysOnTop(true); 
        this.setModal(true);
    
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
        
        //configurar buttons
        btnCancelar.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Principal.getInstance().toFront();          // Restaura o foco para a janela principal
            // Principal.getInstance().requestFocus();   // Não deu! Restaura o foco para a janela principal
            setVisible(false);
            dispose(); 
            
        }
        });
        
        /****************************************************************************************
         * nao pegou o foco na janela principal depois de fechar a janela de cadastrpo        
         */
        
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
