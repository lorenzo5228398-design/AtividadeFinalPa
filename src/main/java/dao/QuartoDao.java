package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Quarto;

public class QuartoDao {

    public void cadastrar() {
        String sqlVerificar = "SELECT COUNT(*) FROM quartos";

        String sqlInserir = "INSERT INTO quartos (numeroQuarto, reservado) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sqlVerificar); ResultSet resultado = comando.executeQuery()) {

            if (resultado.next() && resultado.getInt(1) == 0) {

                try (PreparedStatement comandoInserir = conexao.prepareStatement(sqlInserir)) {
                    for (int i = 1; i <= 5; i++) {
                        comandoInserir.setInt(1, i);
                        comandoInserir.setBoolean(2, false);
                        comandoInserir.executeUpdate();
                    }
                    System.out.println("Cadastro de quarto realizada com sucesso.");
                }

            } else {
                System.out.println("Os quartos já estavam cadastrados. Nenhuma duplicata foi criada.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar quartos." + e);
        }

    }

    public List<Quarto> listar() {

        List<Quarto> quartos = new ArrayList();

        String sql = "SELECT * FROM quartos;";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Quarto quarto = new Quarto(
                        resultado.getInt("id"),
                        resultado.getInt("numeroQuarto"),
                        resultado.getBoolean("reservado")
                );

                quartos.add(quarto);

            }
        } catch (Exception e) {
            System.out.println("Não foi possível conectar-se ao banco de dados.");
        }

        return quartos;

    }

    public void atualizar(Quarto quarto) {

        String sql = """
                     UPDATE quartos SET numeroQuarto = ?, reservado = ? WHERE id = ?;
                     """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, quarto.getNumeroQuarto());
            comando.setBoolean(2, quarto.isReservado());
            comando.setInt(3, quarto.getId());

            comando.executeUpdate();

            System.out.println("Quarto registrado com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar banco." + e.getMessage());
        }

    }
}
