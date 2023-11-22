package DAO;

import entity.CollectPoint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.ConexaoBanco;

public class PontosColetaDAO {

    public ArrayList<CollectPoint> buscarPontosColetaPorCidade(String cidade) {
        ArrayList<CollectPoint> pontosColeta = new ArrayList<>();
        String query = "SELECT * FROM pontos_coleta WHERE LOWER(cidade) = LOWER(?)";

        try (Connection conexao = ConexaoBanco.conectar(); PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            preparedStatement.setString(1, cidade);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    CollectPoint ponto = new CollectPoint();
                    ponto.setId(resultSet.getInt("id"));
                    ponto.setNome(resultSet.getString("nome"));
                    ponto.setCidade(resultSet.getString("cidade"));
                    ponto.setLatitude(resultSet.getDouble("latitude"));
                    ponto.setLongitude(resultSet.getDouble("longitude"));
                    pontosColeta.add(ponto);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return pontosColeta;
    }

    public static boolean buscarCidadeNome(String nome) {
        String sql = "SELECT * FROM pontos_coleta WHERE LOWER(cidade) = LOWER(?)";
        try (PreparedStatement stm = ConexaoBanco.conectar().prepareStatement(sql)) {
            stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            return rs.next(); // Retorna true se encontrar a cidade, false caso contrário
        } catch (SQLException e) {
            return false; // Retorna false em caso de exceção ou se a cidade não for encontrada
        }
    }

    private boolean existePontoColetaComNome(String nome) {
        String sql = "SELECT COUNT(*) FROM pontos_coleta WHERE nome = ?";
        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

            preparedStatement.setString(1, nome);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Retorna true se existe algum ponto de coleta com o mesmo nome
                }
            }

        } catch (SQLException e) {
            System.out.println(e); // Trate a exceção de maneira apropriada para o seu aplicativo
        }

        return false;
    }
    
    public boolean cadastrarPontoColeta(CollectPoint ponto) {
        if (existePontoColetaComNome(ponto.getNome())) {
            return false;
        }

        String sql = "INSERT INTO pontos_coleta (nome, email, cidade, tipo_residuo, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoBanco.conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            
            ps.setString(1, ponto.getNome());
            ps.setString(2, ponto.getEmail());
            ps.setString(3, ponto.getCidade());
            ps.setString(4, ponto.getTipoResiduo());
            ps.setDouble(5, ponto.getLatitude());
            ps.setDouble(6, ponto.getLongitude());

            int linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas > 0;//deu bom

        } catch (SQLException e) {
            System.out.println(e); 
            return false;
        }
    }
}
