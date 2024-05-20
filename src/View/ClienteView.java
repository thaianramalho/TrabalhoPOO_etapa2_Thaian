package View;

import java.awt.EventQueue;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.Font;

public class ClienteView extends JFrame implements ActionListener{

	public JButton cadastrar, editar, remover;
	private JLabel cpf, nome, email, data_nascimento;
	public JTextField campoCpf, campoNome, campoEmail, campodata_nascimento;
	
	public ClienteView() {
		super("Setor de Clientes");
		setTitle("Clientes");

        cpf = new JLabel("CPF:");
        cpf.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        cpf.setBounds(10, 11, 111, 25);
        getContentPane().add(cpf);

        nome = new JLabel("Nome:");
        nome.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        nome.setBounds(10, 67, 80, 25);
        getContentPane().add(nome);

        email = new JLabel("Email:");
        email.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        email.setBounds(10, 129, 80, 25);
        getContentPane().add(email);
        
        data_nascimento = new JLabel("Data de Nascimento:");
        data_nascimento.setFont(new Font("Roboto Black", Font.PLAIN, 11));
        data_nascimento.setBounds(187, 11, 111, 25);
        getContentPane().add(data_nascimento);

        try {
            MaskFormatter formatter = new MaskFormatter("###.###.###-##");
            formatter.setPlaceholderCharacter('0');
            campoCpf = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoCpf.setBounds(10, 32, 156, 25);
        getContentPane().add(campoCpf);

        campoNome = new JTextField();
        campoNome.setBounds(10, 90, 319, 25);
        getContentPane().add(campoNome);

        campoEmail = new JTextField();
        campoEmail.setBounds(10, 150, 319, 25);
        getContentPane().add(campoEmail);
        
        try {
            MaskFormatter formatterData = new MaskFormatter("##/##/####");
            formatterData.setPlaceholderCharacter('0');
            campodata_nascimento = new JFormattedTextField(formatterData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campodata_nascimento.setBounds(187, 32, 139, 25);
        getContentPane().add(campodata_nascimento);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(9, 186, 100, 34);
		cadastrar.addActionListener(this);
        getContentPane().add(cadastrar);
        
        editar = new JButton("Editar");
        editar.setBounds(119, 186, 100, 34);
        editar.addActionListener(this);
        getContentPane().add(editar);
        
        remover = new JButton("Remover");
        remover.setBounds(229, 186, 100, 34);
        remover.addActionListener(this);
        getContentPane().add(remover);	
        
        getContentPane().setLayout(null);
        setSize(355, 267);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
