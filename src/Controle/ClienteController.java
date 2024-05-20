package Controle;

import Modelo.Cliente;
import View.ClienteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Conexao.Conexao;
import DAO.ClienteDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteController implements ActionListener {
    private ClienteView view;
    private ClienteDAO dao;

    public ClienteController(ClienteView view, ClienteDAO dao) {
        this.view = view;
        this.dao = dao;
        this.view.cadastrar.addActionListener(this);
        this.view.editar.addActionListener(this);
        this.view.remover.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cadastrar) {
            cadastrarCliente();
        } else if (e.getSource() == view.editar) {
            editarCliente();
        } else if (e.getSource() == view.remover) {
            removerCliente();
        }
    }

    private void cadastrarCliente() {
    	BigInteger cpf = new BigInteger(view.campoCpf.getText());
        String nome = view.campoNome.getText();
        String email = view.campoEmail.getText();
        String dataTexto = view.campodata_nascimento.getText();
        
        Date data_nascimento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data_nascimento = sdf.parse(dataTexto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data inválido!");
            return;
        }

        Cliente cliente = new Cliente(cpf, nome, email, data_nascimento);

        try {
            dao.adicionarCliente(cliente);
            JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar cliente: " + ex.getMessage());
        }
    }

    private void editarCliente() {
    	BigInteger cpf = new BigInteger(view.campoCpf.getText());
        String nome = view.campoNome.getText();
        String email = view.campoEmail.getText();
        String dataTexto = view.campodata_nascimento.getText();

        Date data_nascimento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            data_nascimento = sdf.parse(dataTexto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data inválido!");
            return;
        }

        Cliente cliente = new Cliente(cpf, nome, email, data_nascimento);

        try {
            dao.atualizarCliente(cliente);
            JOptionPane.showMessageDialog(view, "Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cliente: " + ex.getMessage());
        }
    }


    private void removerCliente() {
    	BigInteger cpf = new BigInteger(view.campoCpf.getText());

    	try {
            dao.removerCliente(cpf);
            JOptionPane.showMessageDialog(view, "Cliente removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar cliente: " + ex.getMessage());
        }
    }
}
