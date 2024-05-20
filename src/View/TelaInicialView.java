package View;

import java.awt.event.*;
import javax.swing.*;
import Controle.ClienteController;
import Controle.ProdutoController;
import DAO.*;
import Conexao.Conexao;
import java.awt.Font;
import java.awt.BorderLayout;

public class TelaInicialView extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuOpcoes;
    private JMenuItem menuItemCliente, menuItemProduto, menuItemVenda;
    private JLabel lblNewLabel;

    public TelaInicialView() {
        super("Menu Principal");

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuOpcoes = new JMenu("Opções");
        menuBar.add(menuOpcoes);

        menuItemCliente = new JMenuItem("Cliente");
        menuItemCliente.addActionListener(this);
        menuOpcoes.add(menuItemCliente);

        menuItemProduto = new JMenuItem("Produto");
        menuItemProduto.addActionListener(this);
        menuOpcoes.add(menuItemProduto);

        menuItemVenda = new JMenuItem("Venda");
        menuItemVenda.addActionListener(this);
        menuOpcoes.add(menuItemVenda);

        setSize(524, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\repositorios\\TrabalhoPOO_etapa2_Thaian\\src\\img\\selling.png"));
        getContentPane().add(lblNewLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemCliente) {
            ClienteView view = new ClienteView();
            ClienteDAO dao = new ClienteDAO(Conexao.obterConexao());
            ClienteController controller = new ClienteController(view, dao);
        } else if (e.getSource() == menuItemProduto) {
            ProdutoView view = new ProdutoView();
            ProdutoDAO dao = new ProdutoDAO(Conexao.obterConexao());
            ProdutoController controller = new ProdutoController(view, dao);
        } else if (e.getSource() == menuItemVenda) {
            VendaView view = new VendaView();
            view.setVisible(true);
        }
    }

    public static void main(String[] args) {
        TelaInicialView tela = new TelaInicialView();
    }
}
