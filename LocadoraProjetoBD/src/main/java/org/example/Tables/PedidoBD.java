package org.example.Tables;

import java.sql.SQLException;
import org.example.Classes.Pedido;
import org.example.Classes.Data;

public class PedidoBD extends ConexaoBD{
    boolean sucesso = false;

    //------------------------INSERIR NOVO PEDIDO NO DATABASE----------------------------
    public boolean insertPedido(Pedido pedido) {

        connect();
        String sql = "INSERT INTO Pedido (idPedido, dataPedido, diasDevolucao, Cliente_CPF) values (?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, pedido.getIdPedido());
            pst.setString(2, pedido.getDataPedido());
            pst.setInt(3, pedido.getDiasDevolucao());
            pst.setString(4, pedido.getFk_Cliente_CPF());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro de conexao " + e.getMessage());
            }
        }
        return sucesso;
    }

    //------------------------BUSCAR PEDIDO ESPECIFICO NO DATABASE----------------------------
    public boolean selectPedidoId(int Id_Pedido,String CPF) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM Pedido";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("dataPedido"),resultSet.getInt("diasDevolucao"), resultSet.getString("Cliente_CPF"));
                if (pedidoTemp.getIdPedido() == Id_Pedido && pedidoTemp.getFk_Cliente_CPF().equals(CPF)) {
                    verificado = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());

        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }

    //------------------------BUSCAR PEDIDOS RELACIONADOS A UM CLIENTE NO DATABASE----------------------------
    public boolean selectPedidosIDs(String Cliente_CPF) {

        connect();

        boolean verificado = false;
        String sql = "SELECT * FROM Pedido WHERE Cliente_CPF = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Cliente_CPF);
            resultSet = pst.executeQuery();

            System.out.println("Lista de Id's de pedidos desta conta: ");
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("dataPedido"),resultSet.getInt("diasDevolucao"), resultSet.getString("Cliente_CPF"));
                System.out.println("Id: " + pedidoTemp.getIdPedido());
            }
            verificado = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            verificado = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verificado;
    }

    //------------------------BUSCAR INFOS ESPECIFICAS DE UM PEDIDO NO DATABASE----------------------------
    public void selectInfosPedidos(int idPedido, String cpf) {

        connect();

        boolean verificado;

        String sql = "SELECT * FROM Pedido WHERE idPedido = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Pedido pedidoTemp = new Pedido(resultSet.getInt("idPedido"), resultSet.getString("dataPedido"),resultSet.getInt("diasDevolucao"), resultSet.getString("Cliente_CPF"));
                if (pedidoTemp.getFk_Cliente_CPF().equals(cpf)) {
                    System.out.println("Data do pedido: " + pedidoTemp.getDataPedido());
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
    }

    //------------------------DELETAR UM PEDIDO ESPECIFICO NO DATABASE----------------------------
    public boolean deletePedido(int idPedido,String cpf) {

        connect();

        String sql = "DELETE FROM pedido WHERE idPedido = ? AND Cliente_CPF = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
            pst.setString(2,cpf);
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }

    //------------------------ATUALIZAR STATUS DE UM PEDIDO ESPECIFICO NO DATABASE----------------------------
    public boolean updateStatusPedido(int Id_pedido,String cpf) {

        connect();
        boolean validado;
        String sql = "UPDATE pedido SET statusPedido='Pagamento realizado' WHERE idPedido=? AND Cliente_CPF=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_pedido);
            pst.setString(2,cpf);
            pst.execute();
            validado = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            validado = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return validado;
    }


}
