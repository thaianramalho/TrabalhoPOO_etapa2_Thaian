package DAO;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import Modelo.FormaPagamento;
import Modelo.Produto;
import Modelo.Venda;

public class VendaDAO {
    private Connection conexao;

    public VendaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirVenda(Venda venda) {
        try {
            String sql = "INSERT INTO venda (cliente_id, data_venda, metodo_pagamento) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setBigDecimal(1, venda.getCliente());
            stmt.setTimestamp(2, new Timestamp(venda.getDataVenda().getTime()));
            stmt.setString(3, venda.getPagamento().toString());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
