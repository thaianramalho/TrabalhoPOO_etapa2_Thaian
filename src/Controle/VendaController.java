package Controle;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import Modelo.FormaPagamento;
import Modelo.Produto;
import Modelo.Venda;
import DAO.VendaDAO;
import View.VendaView;

public class VendaController {
    private VendaView view;
    private VendaDAO dao;

    public VendaController(VendaView view, VendaDAO dao) {
        this.view = view;
        this.dao = dao;
        this.view.setVisible(true);
    }

    public void realizarVenda(BigDecimal cliente, ArrayList<Produto> produtos, FormaPagamento pagamento, Date dataVenda) {
        Venda venda = new Venda(cliente, produtos, pagamento, dataVenda);
        dao.inserirVenda(venda);
    }
}
