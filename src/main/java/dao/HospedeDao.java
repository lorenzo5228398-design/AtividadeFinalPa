package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Hospede;

public class HospedeDao {

    public void cadastrar(Hospede hospede) {

        String sql = "INSERT INTO hospedes(nome, idade, cpf, sexo) VALUES (?,?,?,?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, hospede.getNome());
            comando.setInt(2, hospede.getIdade());
            comando.setString(3, hospede.getCpf());
            comando.setString(4, hospede.getSexo());
            comando.executeUpdate();

            System.out.println("Cadastro de hóspede realizada com sucesso.");

        } catch (Exception e) {
            System.out.println("Falha ao cadastrar hóspede." + e);
        }

    }

}
