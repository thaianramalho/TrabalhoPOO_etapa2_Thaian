package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Modelo.Produto;
import Modelo.ProdutoAlimenticio;
import Modelo.ProdutoEletronico;
import Modelo.ProdutoLimpeza;

public class ProdutoDAO {
	private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void adicionarProduto(Produto produto) throws SQLException{
    	String query = "INSERT INTO produto (nome, descricao, preco_custo, preco_venda, quantidade_estoque, categoria_id) VALUES (?, ? , ? , ? , ? , ?)";
    	try(PreparedStatement stmt = conexao.prepareStatement(query)){
    		stmt.setString(1, produto.getNome());
    		stmt.setString(2, produto.getDescricao());
    		stmt.setDouble(3, produto.getPrecoCusto());
    		stmt.setDouble(4, produto.getPrecoVenda());
    		stmt.setInt(5, produto.getQuantidade());
    		stmt.setInt(6, produto.getCategoria());
    		stmt.executeUpdate();
    	}
    }
    
    public void consultarProdutoid(Integer id) throws SQLException{
        String query = "SELECT nome, quantidade_estoque FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultado = stmt.executeQuery()){
                while(resultado.next()) {
                    String nome = resultado.getString("nome");
                    Integer quantidade = resultado.getInt("quantidade_estoque");
                    
                    consultaid(id, nome, quantidade);
                }
            }
        }
    }
    
    private void consultaid(Integer id, String nome, Integer quantidade) {
        JOptionPane.showMessageDialog(null, "ID: " + id +"\n- - - - - - - - - -" +"\nNome: " + nome +"\n- - - - - - - - - -" + "\nQuantidade: " + quantidade);
    }
 
    
    public void consultarProdutoNome(String nome) throws SQLException{
    	String query = "SELECT id, quantidade_estoque FROM produto WHERE nome = ?";
    	try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, nome);
            try (ResultSet resultado = stmt.executeQuery()){
                while(resultado.next()) {
                    Integer id = resultado.getInt("id");
                    Integer quantidade = resultado.getInt("quantidade_estoque");
                    
                    consultaid(id, nome, quantidade);
                }
            }
    	}
    }
    
    public void consultarProdutoCategoria(String categoria) throws SQLException{
    	String query = "SELECT id, nome, quantidade_estoque FROM produto WHERE categoria_id = ?";
    	try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, categoria);
            try (ResultSet resultado = stmt.executeQuery()){
                while(resultado.next()) {
                    Integer id = resultado.getInt("ID");
                    String nome = resultado.getString("nome");
                    Integer quantidade = resultado.getInt("quantidade_estoque");
                    
                    consultaid(id, nome, quantidade);
                }
            }
    	}
    }
    
    public void atualizarProduto(Produto produto, Integer id) throws SQLException{
    	String query = "UPDATE produto SET nome=?, descricao=?, preco_custo=?, preco_venda=?, quantidade_estoque=?, categoria_id=? WHERE id=?";
    	try(PreparedStatement stmt = conexao.prepareStatement(query)){
    		stmt.setString(1, produto.getNome());
    		stmt.setString(2, produto.getDescricao());
    		stmt.setDouble(3, produto.getPrecoCusto());
    		stmt.setDouble(4, produto.getPrecoVenda());
    		stmt.setInt(5, produto.getQuantidade());
    		stmt.setInt(6, produto.getCategoria());
    		stmt.setInt(7, id);
    		stmt.executeUpdate();
    	}
    }
    
    public void removerProduto(Integer id) throws SQLException {
        String query = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
