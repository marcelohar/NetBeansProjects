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
import ouvintes.ListenerSalvar;

public class TelaCadastro extends JDialog {  //trocamos JFrame Por Jdialog para que quando abra 2 janela, elas sejam apenas uma
    //----------------------------------------------
    // ATRIBUTOS
    //----------------------------------------------
        private JPanel panel;

        /// ELEMENTOS DA TELA
        private JLabel      lbl_id, lbl_nome, lbl_valor, lbl_qtd, lbl_descricao;
        private JTextField  txt_id, txt_nome, txt_valor, txt_qtd, txt_descricao;
        private JButton     btn_salvar, btn_cancelar; 

    //----------------------------------------------
    // CONSTRUTOR
    //----------------------------------------------
        public TelaCadastro(){
            this.initialize();
            //this.setExtendedState(NORMAL);    //renderize de maneira normal a janela <-- apneas para JFrame
            this.setModal(true);                //para o S.O ver janela como se fosse  apenas uma se abrir 2. (exenteds JDialog)
            this.setAlwaysOnTop(true);//para o S.O ver janela como se fosse  apenas uma se abrir 2. (exenteds JDialog)
        }   

    //----------------------------------------------
    // MÉTODOS
    //----------------------------------------------
        /// INICIALIZAÇÃO DA JANELA
            public void initialize(){
                panel = new JPanel();                           //cria o novo objeto para o JPanel
                GridLayout g1 = new GridLayout(6, 2,10,10);     //tipo de layout de 5linhas e 2 colunas com espaçamento 10
                panel.setLayout(g1);                            //add ao painel o layout criado

        /// INICIANDO ITENS DA JANELA
            /// IDENTIFICAÇÃO DAS CAIXAS DE TEXTO
            lbl_id          = new JLabel("ID: ");               //criando os objetos para as variáveis declaradas
            lbl_nome        = new JLabel("Nome: ");
            lbl_valor       = new JLabel("Valor: ");
            lbl_qtd         = new JLabel("Quantiddade: ");
            lbl_descricao   = new JLabel("Descrição: ");

            /// CAIXAS DE TEXTO
            txt_id          = new JTextField();
            txt_nome        = new JTextField();
            txt_valor       = new JTextField();
            txt_qtd         = new JTextField();
            txt_descricao   = new JTextField();

            /// BOTOES
            btn_salvar      = new JButton("Salvar");
            btn_cancelar    = new JButton("Cancelar");

        /// ADD ITENS NA JANELA           
            panel.add(lbl_id);
            panel.add(txt_id);

            panel.add(lbl_nome);
            panel.add(txt_nome);

            panel.add(lbl_valor);
            panel.add(txt_valor);

            panel.add(lbl_qtd);
            panel.add(txt_qtd);

            panel.add(lbl_descricao);
            panel.add(txt_descricao);

            panel.add(btn_salvar);                       
            panel.add(btn_cancelar);
            
        ///CONFIGURAR BOTOES
            btn_salvar.addActionListener(new ListenerSalvar(txt_id,txt_nome,txt_valor,txt_qtd,txt_descricao));  //Adiciona uma nova instancia da classe ListenerSalvar, dentro do botão Salver (quando clicar no botão, chamará a classe ListenerSalvar)

            btn_cancelar.addActionListener(new ActionListener() {   //Não precisa criar uma classe, basta sobreescrever o método para fechar a janela
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);                              //deixa a janela oculta
                    dispose();                                      //fecha a janela
                    //System.exit(0);                               //fecha todas as janelas (programa inteiro)
                } 
            });
        
        /// CONFIGURAÇÃO DA JANELA
            this.setBounds(0,0,400,300);                            //configura tamanho e posição janela
            this.add(panel);                                        //add painel no frame (própria classe)
            this.setPreferredSize(new Dimension(400,300));          //define tamanho default da janela
            this.setTitle("Cadastro de Produto");                   //título da janela
            this.pack();                                            //compacta a janela para uso
            this.setVisible(true);                                  //exibe a janela
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha apenas a janela e não  encerrar o programa
        }
}
