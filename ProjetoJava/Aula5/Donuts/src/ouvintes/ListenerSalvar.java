package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import models.DAOProdutos;

public class ListenerSalvar implements ActionListener {
    //-------------------------------------------------
    // PEGAR DADOS DA TELA
    //-------------------------------------------------    
        private JTextField id, nome, valor, qtd, descricao;

    //-------------------------------------------------
    // CONSTRUTOR
    //-------------------------------------------------
        public ListenerSalvar(JTextField id, JTextField nome, JTextField valor, JTextField qtd, JTextField descricao){
            this.id         = id;           //variáveis locais recebendo os dados passandos por parâmetros pelo botão salvar ao chamar a classe atual
            this.nome       = nome;
            this.valor      = valor;
            this.qtd        = qtd;
            this.descricao  = descricao;
        }
  
    //-------------------------------------------------
    //MÉTODOS SOBREESCRITOS DA CLASSE
    //-------------------------------------------------
        @Override
        public void actionPerformed(ActionEvent e){                     //tô passando o atributo "e" que é do tipo ActionEvent

            DAOProdutos dao = DAOProdutos.getInstance();

            dao.save(id.getText(), nome.getText(), valor.getText(), qtd.getText(), descricao.getText());

            String msg = "Salvo!";

            System.out.println(msg);
            /*
            String msg ="\nID: "            + id.getText()       +      //pegando os textos das variáveis 
                        "\nNome: "          + nome.getText()     + 
                        "\nValor: "         + valor.getText()    +
                        "\nQuantidade: "    + qtd.getText()      + 
                        "\nDescrição: "     + descricao.getText();   
            */

            //JOptionPane.showMessageDialog(null, e); 
            
            /*após apresentar a mensagem e clicar no ok para voltar para a tela 
            de cadastro, se eu clicar em cancelar, a janela trava e tenho que reinicar o
            netbeans ou matar o processo. Parce que tem relação com o dispose() da classe
            TelaCadastro
            */
    }
}
