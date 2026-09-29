
package Testes;
import dao.HospedeDao;
import model.Hospede;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class HospedeDaoTests {
    
    @Test
    void testeCadastrarHospedeComSucesso() {
        HospedeDao dao = new HospedeDao();

        Hospede hospede = new Hospede();
        hospede.setNome("Ana Oliveira");
        hospede.setIdade(25);
        hospede.setCpf("11122233344");
        hospede.setSexo("F");
        hospede.setSenha("minhaSenha123");

        assertDoesNotThrow(() -> dao.cadastrar(hospede));
    }

    @Test
    void testeAutenticarSucesso() {
        HospedeDao dao = new HospedeDao();

        // Verifica se o login retorna TRUE quando CPF e senha estão corretos
        boolean loginValido = dao.verificarSenha("11122233344", "minhaSenha123");

        assertTrue(loginValido, "Deveria autenticar com sucesso para CPF e senha corretos.");
    }

    @Test
    void testeAutenticarCpfInexistente() {
        HospedeDao dao = new HospedeDao();

        // Verifica se o login retorna FALSE para um CPF que não existe no banco
        boolean loginValido = dao.verificarSenha("00000000000", "minhaSenha123");

        assertFalse(loginValido, "Não deveria autenticar um CPF inexistente.");
    }

    @Test
    void testeAutenticarSenhaIncorreta() {
        HospedeDao dao = new HospedeDao();

        // Verifica se o login retorna FALSE para um CPF existente com a senha errada
        boolean loginValido = dao.verificarSenha("11122233344", "senhaErrada123");

        assertFalse(loginValido, "Não deveria autenticar com a senha incorreta.");
    }

    @Test
    void testeCadastrarComDadosNulos() {
        HospedeDao dao = new HospedeDao();

        Hospede hospede = new Hospede(); 

        assertDoesNotThrow(() -> dao.cadastrar(hospede));
    }

    @Test
    void testeAutenticarComDadosNulos() {
        HospedeDao dao = new HospedeDao();

        // Verifica se o método lida com valores nulos com segurança devolvendo FALSE em vez de lançar exceções
        boolean loginValido = dao.verificarSenha(null, null);

        assertFalse(loginValido, "Autenticação com parâmetros nulos deve retornar false.");
    }
    
    
    
    
    
}
