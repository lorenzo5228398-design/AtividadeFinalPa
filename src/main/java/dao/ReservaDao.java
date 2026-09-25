package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Reserva;

public class ReservaDao {

    public void cadastrar(Reserva reserva) {

        String sql = """
                     INSERT INTO reservas (id_hospede, id_id_quarto, checkin) VALUES(?,?,?);
                     """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, reserva.getIdHospede());
            comando.setInt(2, reserva.getIdQuarto());
            comando.setBoolean(3, false);
            comando.executeUpdate();

        } catch (Exception e) {
            System.out.println("Falha ao criar reserva." + e);
        }

    }
    
    
    public void reservar(String cpf, int numeroQuarto) {

        String sql = """
                 INSERT INTO reservas (id_hospede, id_quarto, checkin)
                 VALUES (
                 (SELECT id FROM hospedes WHERE cpf = ?),
                 (SELECT id FROM quartos WHERE numeroQuarto = ?),
                 0);
                 """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, cpf);
            comando.setInt(2, numeroQuarto);
            
            comando.executeUpdate();
            
            
            System.out.println("Reserva realizada com sucesso.");

        } catch (Exception e) {
            System.out.println("Falha ao inserir na tabela de reservas." + e.getMessage());
        }

    }

}
