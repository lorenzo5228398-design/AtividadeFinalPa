
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
    void testeVerificarSenhaCpfExistente() {
        HospedeDao dao = new HospedeDao();
        
     
        String senhaRetornada = dao.verificarSenha("11122233344");


        assertEquals("minhaSenha123", senhaRetornada);
    }

    @Test
    void testeVerificarSenhaCpfInexistente() {
        HospedeDao dao = new HospedeDao();
        
      
        String senhaRetornada = dao.verificarSenha("00000000000");


        assertNull(senhaRetornada);
    }

    @Test
    void testeCadastrarComDadosNulos() {
        HospedeDao dao = new HospedeDao();
        

        Hospede hospede = new Hospede(); 


        assertDoesNotThrow(() -> dao.cadastrar(hospede));
    }

    @Test
    void testeVerificarSenhaCpfNulo() {
        HospedeDao dao = new HospedeDao();
        
     
        String senhaRetornada = dao.verificarSenha(null);

        
        assertNull(senhaRetornada);
    }
    
    
    
    
    
}
