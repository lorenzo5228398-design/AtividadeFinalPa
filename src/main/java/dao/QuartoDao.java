package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Quarto;

public class QuartoDao {

    public void cadastrar(Quarto quarto) {

        String sql = """
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (01, 0);
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (02, 0);
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (03, 0);
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (04, 0);
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (05, 0);
                 INSERT INTO quartos (numeroQuarto, reservado) VALUES (05, 0);
                 """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            
            comando.executeUpdate();

            System.out.println("Cadastro de quarto realizada com sucesso.");
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar quarto." + e);
        }

    }

}
