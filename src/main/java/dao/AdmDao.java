package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.Reserva;

public class AdmDao {

    public void deletarReserva(Reserva reserva) {

        String sql = """
                 DELETE FROM reservas WHERE id = ?;
                 """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql);
              ) {

            comando.setInt(1, reserva.getId());
            
            comando.executeUpdate();
            
            System.out.println("Reserva deletada com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao tentar deletar uma linha do banco." + e);
        }

    }

    public List<Reserva> listarReservas() {

        List<Reserva> reservas = new ArrayList();

        String sql = "SELECT * FROM reservas;";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Reserva reserva = new Reserva(
                        resultado.getInt("id"),
                        resultado.getInt("id_hospede"),
                        resultado.getInt("id_quarto"),
                        resultado.getInt("checkin") == 1
                );

                reservas.add(reserva);

            }
        } catch (Exception e) {
            System.out.println("Não foi possível conectar-se ao banco de dados.");
        }

        return reservas;

    }

    public void atualizarReservas(Reserva reserva) {

        String sql = """
                     UPDATE reservas SET id_hospede = ?,  id_quarto = ?, checkin = ? WHERE id = ?;
                     """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, reserva.getIdHospede());
            comando.setInt(2, reserva.getIdQuarto());
            comando.setInt(3, reserva.isCheckin() ? 1 : 0);
            comando.setInt(4, reserva.getId());

            comando.executeUpdate();

            System.out.println("Reservas atualizadas com sucesso.");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar banco." + e.getMessage());
        }

    }

    public List<Object[]> listarReservasDetalhadas() {
        List<Object[]> lista = new ArrayList<>();

       
        String sql = """
                 SELECT r.id, h.nome, q.numeroQuarto, r.checkin 
                 FROM reservas r
                 INNER JOIN hospedes h ON r.id_hospede = h.id
                 INNER JOIN quartos q ON r.id_quarto = q.id;
                 """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql); ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
             
                String statusCheckin = resultado.getInt("checkin") == 1 ? "Realizado" : "Pendente";

             
                Object[] linha = new Object[]{
                    resultado.getInt("id"),
                    resultado.getString("nome"), 
                    resultado.getInt("numeroQuarto"),
                    statusCheckin
                };

                lista.add(linha);
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar reservas detalhadas: " + e.getMessage());
        }

        return lista;
    }

}
