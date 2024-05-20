package View;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class ProdutoView extends JFrame implements ActionListener{

	public JButton cadastrar, editar, remover, buscaCodigo, buscaNome, buscaCategoria;
	private JLabel id, nome, descricao, precoCusto, precoVenda, quantidade, categoria;
	public JTextField campoCodigo, campoNome, campoDescricao, campoQuantidade, campoCusto, campoVenda;
	public JRadioButton cat1, cat2, cat3;
	
	public ProdutoView() {
		super("Produtos");
		
		id = new JLabel("ID:");
		id.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		id.setBounds(10, 11, 80, 25);
		getContentPane().add(id);
		
		nome = new JLabel("Nome:");
		nome.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		nome.setBounds(10, 75, 80, 25);
		getContentPane().add(nome);
		
		descricao = new JLabel("Descrição:");
		descricao.setFont(new Font("Roboto Black", Font.PLAIN, 11));
		descricao.setBounds(10, 136, 80, 25);
        getContentPane().add(descricao);

        precoCusto = new JLabel("Preço Custo:");
        precoCusto.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        precoCusto.setBounds(10, 195, 80, 25);
        getContentPane().add(precoCusto);
        
        precoVenda = new JLabel("Preço Venda:");
        precoVenda.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        precoVenda.setBounds(10, 255, 80, 25);
        getContentPane().add(precoVenda);
        
        quantidade = new JLabel("Quantidade:");
        quantidade.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        quantidade.setBounds(10, 312, 80, 25);
        getContentPane().add(quantidade);
        
        categoria = new JLabel("Categoria:");
        categoria.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        categoria.setBounds(480, 39, 80, 25);
        getContentPane().add(categoria);
        
        campoCodigo = new JTextField();
        campoCodigo.setBounds(10, 39, 280, 25);
        getContentPane().add(campoCodigo);
        
        campoNome = new JTextField();
        campoNome.setBounds(10, 100, 280, 25);
        getContentPane().add(campoNome);

        campoDescricao = new JTextField();
        campoDescricao.setBounds(10, 159, 280, 25);
        getContentPane().add(campoDescricao);
        
        campoCusto = new JTextField();
        campoCusto.setBounds(10, 219, 280, 25);
        getContentPane().add(campoCusto);
        
        campoVenda = new JTextField();
        campoVenda.setBounds(10, 280, 280, 25);
        getContentPane().add(campoVenda);
        
        campoQuantidade = new JTextField();
        campoQuantidade.setBounds(10, 339, 280, 25);
        getContentPane().add(campoQuantidade);
             
        cat1 = new JRadioButton("Alimentício");
        cat2 = new JRadioButton("Eletrônico");
        cat3 = new JRadioButton("Limpeza");
        ButtonGroup grupoTipo = new ButtonGroup();
        grupoTipo.add(cat1);
        grupoTipo.add(cat2);
        grupoTipo.add(cat3);
        
        cat1.setBounds(480, 71, 100, 25);
        cat2.setBounds(480, 129, 100, 25);
        cat3.setBounds(480, 100, 100, 25);
        getContentPane().add(cat1);
        getContentPane().add(cat2);
        getContentPane().add(cat3);
        
        buscaCodigo = new JButton("Buscar");
        buscaCodigo.setBounds(300, 39, 100, 25);
        buscaCodigo.addActionListener(this);
        getContentPane().add(buscaCodigo);
        
        buscaNome = new JButton("Buscar");
        buscaNome.setBounds(300, 100, 100, 25);
        buscaNome.addActionListener(this);
        getContentPane().add(buscaNome);
        
        buscaCategoria = new JButton("Buscar");
        buscaCategoria.setBounds(468, 159, 100, 25);
        buscaCategoria.addActionListener(this);
        getContentPane().add(buscaCategoria);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(10, 393, 150, 50);
		cadastrar.addActionListener(this);
        getContentPane().add(cadastrar);
        
        editar = new JButton("Editar");
        editar.setBounds(250, 393, 150, 50);
        editar.addActionListener(this);
        getContentPane().add(editar);
        
        remover = new JButton("Remover");
        remover.setBounds(461, 393, 150, 50);
        remover.addActionListener(this);
        getContentPane().add(remover);	
        
        getContentPane().setLayout(null);
        setSize(637, 515);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
