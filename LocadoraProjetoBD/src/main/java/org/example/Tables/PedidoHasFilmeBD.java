package org.example.Tables;

import org.example.Classes.Cliente;
import org.example.Classes.Filme;

import java.sql.SQLException;
import java.util.Objects;

public class PedidoHasFilmeBD extends ConexaoBD{
    boolean sucesso = false;

    //------------------------INSERIR NOVA RELAÇÂO NA TABELA N:M DE PEDIDOS E FILMES----------------------------
    public boolean insertFilmeOnPedido(int Id_Filme, int Id_Pedido) {

        connect();
        String sql = "INSERT INTO Filme_has_Pedido (Filme_idFilme,Pedido_idPedido) values (?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Filme);
            pst.setInt(2, Id_Pedido);
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

    //------------------------DELETAR RELAÇÂO ESPECIFICA NA TABELA N:M DE PEDIDOS E FILMES----------------------------
    public boolean deleteFilmeFromPedido(int Id_Filme,int Id_Pedido) {

        connect();
        boolean verifica;
        String sql = "DELETE FROM Filme_has_Pedido WHERE Filme_idFilme = ? AND Pedido_idPedido = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, Id_Filme);
            pst.setInt(2, Id_Pedido);
            pst.execute();
            verifica = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            verifica = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return verifica;
    }

    //------------------------BUSCAR FILMES RELACIONADOS A UM PEDIDO ESPECIFICO NO DATABASE----------------------------
    public int[] selectFilmesPedido(int id_Pedido) {

        int[] idFilmes = new int[30];
        int i = 0;

        connect();

        String sql = "SELECT Filme_ifFilme FROM Filme_has_Pedido WHERE Pedido_idPedido = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_Pedido);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Filme filmeTemp = new Filme(resultSet.getInt("Filme_idFilme"));
                idFilmes[i] =  filmeTemp.getIdFilme();
                i += 1;
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
        return idFilmes;
    }

    //------------------------DELETAR TODAS AS RELAÇÕES DE UM PEDIDO ESPECIFICO----------------------------
    public boolean deleteFromFilmeHasPedido(int idPedido) {

        connect();

        String sql = "DELETE FROM Filme_has_Pedido WHERE Pedido_idPedido = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPedido);
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

}
