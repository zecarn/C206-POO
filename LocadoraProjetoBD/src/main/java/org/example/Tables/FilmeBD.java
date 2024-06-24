package org.example.Tables;

import java.sql.SQLException;
import java.util.ArrayList;

import org.example.Classes.Cliente;
import org.example.Classes.Filme;
import org.example.Classes.Pedido;


public class FilmeBD extends ConexaoBD{

    boolean sucesso = false;

    //------------------------INSERIR NOVO FILME NO DATABASE----------------------------
    public boolean insertFilme(Filme filme) {

        connect();
        String sql = "INSERT INTO Filme (idFilme, nome, categoria, classificacaoIdade, anoLancamento, preco, Produtora_CNPJ) values (?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, filme.getIdFilme());
            pst.setString(2, filme.getNome());
            pst.setString(3, filme.getCategoria());
            pst.setInt(4, filme.getClassificacaoIdade());
            pst.setInt(5, filme.getAnoLancamento());
            pst.setFloat(6, filme.getPreco());
            pst.setString(7, filme.getFk_Produtora_CNPJ());
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

    //------------------------BUSCAR FILMES NO DATABASE----------------------------
    public void selectFilme() {
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        connect();

        String sql = "SELECT * FROM Filme";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql); //ref. a tabela resultante da busca
            while (resultSet.next()) {

                Filme filmeTemp = new Filme(resultSet.getInt("idFilme"),resultSet.getString("nome"), resultSet.getString("categoria"),resultSet.getInt("classificacaoIdade"),resultSet.getInt("anoLancamento"), resultSet.getFloat("preco"), resultSet.getString("Produtora_CNPJ"));
                System.out.println("ID do Filme = " + filmeTemp.getIdFilme());
                System.out.println("Nome = " + filmeTemp.getNome());
                System.out.println("Categoria = " + filmeTemp.getCategoria());
                System.out.println("Idade mínima permitida = " + filmeTemp.getClassificacaoIdade());
                System.out.println("Ano de lançamento = " + filmeTemp.getAnoLancamento());
                System.out.println("Preco = " + filmeTemp.getPreco());
                System.out.println("CNPJ da produtora = " + filmeTemp.getFk_Produtora_CNPJ());
                System.out.println("---------------------------------");
                listaDeFilmes.add(filmeTemp);
            }
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
    }

    //------------------------BUSCAR FILME ESPECIFICO NO DATABASE----------------------------
    public boolean selectFilmeId(int id_Filme) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM Filme WHERE idFilme = ?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_Filme);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Filme filmeTemp = new Filme(resultSet.getInt("idFilme"),resultSet.getString("nome"), resultSet.getString("categoria"),resultSet.getInt("classificacaoIdade"),resultSet.getInt("anoLancamento"), resultSet.getFloat("preco"), resultSet.getString("Produtora_CNPJ"));
                if(filmeTemp.getIdFilme() == id_Filme){
                    verificado = true;
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
        return verificado;
    }

    //------------------------BUSCAR FILME ESPECÍFICO NO DATABASE----------------------------
    public boolean selectFilmeFromId(int id_Filme) {

        boolean verificado = false;
        connect();

        String sql = "SELECT * FROM Filme WHERE idFilme = ?";
        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_Filme);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Filme filmeTemp = new Filme(resultSet.getInt("idFilme"),resultSet.getString("nome"), resultSet.getString("categoria"),resultSet.getInt("classificacaoIdade"),resultSet.getInt("anoLancamento"), resultSet.getFloat("preco"), resultSet.getString("Produtora_CNPJ"));
                if(filmeTemp.getIdFilme() == id_Filme){
                    System.out.println("idFilme = " + filmeTemp.getIdFilme());
                    System.out.println("nome = " + filmeTemp.getNome());
                    System.out.println("categoria = " + filmeTemp.getCategoria());
                    System.out.println("classificacaoIdade = " + filmeTemp.getClassificacaoIdade());
                    System.out.println("anoLancamento = " + filmeTemp.getAnoLancamento());
                    System.out.println("preco = " + filmeTemp.getPreco());
                    System.out.println("Produtora_CNPJ = " + filmeTemp.getFk_Produtora_CNPJ());
                    System.out.println("---------------------------------");
                    verificado = true;
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
        return verificado;
    }

    //------------------------BUSCAR PREÇO DE FILME ESPECIFICO NO DATABASE----------------------------
    public double selectFilmePreco(int id_Filme) {

        connect();

        double preco = 0;
        String sql = "SELECT * FROM Filme where idFilme = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_Filme);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Filme filmeTemp = new Filme(resultSet.getInt("idFilme"),resultSet.getString("nome"), resultSet.getString("categoria"),resultSet.getInt("classificacaoIdade"),resultSet.getInt("anoLancamento"), resultSet.getFloat("preco"), resultSet.getString("Produtora_CNPJ"));
                preco = filmeTemp.getPreco();
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
        return preco;
    }

    //------------------------BUSCAR IDADE DE FILMES NO DATABASE----------------------------
    public int selectFilmeIdadeMinima(int id_Filme){
        connect();

        int idade = 0;
        String sql = "SELECT * FROM filme WHERE idFilme = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id_Filme);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Filme filmeTemp = new Filme(resultSet.getInt("idFilme"),resultSet.getString("nome"), resultSet.getString("categoria"),resultSet.getInt("classificacaoIdade"),resultSet.getInt("anoLancamento"), resultSet.getFloat("preco"), resultSet.getString("Produtora_CNPJ"));
                idade = filmeTemp.getClassificacaoIdade();
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
        return idade;
    }
}
