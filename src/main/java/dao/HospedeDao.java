package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Hospede;
import dao.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.JframeLoginHospede;

public class HospedeDao {

    public void cadastrar(Hospede hospede) {

        String sql = "INSERT INTO hospedes(nome, idade, cpf, sexo, senha) VALUES (?,?,?,?,?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, hospede.getNome());
            comando.setInt(2, hospede.getIdade());
            comando.setString(3, hospede.getCpf());
            comando.setString(4, hospede.getSexo());
            comando.setString(5, hospede.getSenha());
            comando.executeUpdate();

            System.out.println("Cadastro de hóspede realizada com sucesso.");

        } catch (Exception e) {
            System.out.println("Falha ao cadastrar hóspede." + e);
        }

    }

    public String verificarSenha(String cpf) {
        JframeLoginHospede hospede = new JframeLoginHospede();
        String sql = """
                     SELECT * FROM hospedes WHERE cpf =?;
                     """;

        try (Connection conexao = Conexao.conectar(); PreparedStatement comando = conexao.prepareStatement(sql)) {
            comando.setString(1, cpf);

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Hospede hosp = new Hospede(
                        resultado.getString("senha"));
                return hosp.getSenha();
            } else {
                JOptionPane.showMessageDialog(hospede, "Login ou senha inválidos.");
                System.out.println("CPF inexistente.");
            }

        } catch (Exception e) {
            System.out.println("Erro no banco de dados." + e);
        }
        return null;
    }
    
    
    
}
