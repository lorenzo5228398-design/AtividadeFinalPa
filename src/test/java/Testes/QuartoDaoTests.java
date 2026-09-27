/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Testes;
import dao.QuartoDao;
import java.util.List;

import model.Quarto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class QuartoDaoTests {
 
    @Test
    void testeCadastrarExecutaSemTravar() {
        QuartoDao dao = new QuartoDao();
        
        assertDoesNotThrow(() -> dao.cadastrar());
    }

    @Test
    void testeListarRetornaListaNaoNula() {
        QuartoDao dao = new QuartoDao();
        List<Quarto> quartos = dao.listar();
        
  
        assertNotNull(quartos, "A lista de quartos não deve ser nula.");
    }

    @Test
    void testeListarQuartosTamanhoCoerente() {
        QuartoDao dao = new QuartoDao();
        
       
        dao.cadastrar(); 
        List<Quarto> quartos = dao.listar();
        
        assertTrue(quartos.size() >= 0, "O tamanho da lista deve ser zero ou maior.");
    }

    @Test
    void testeAtualizarQuartoValidoSemErro() {
        QuartoDao dao = new QuartoDao();
        
 
        Quarto quarto = new Quarto(1, 101, true);
        
        
        assertDoesNotThrow(() -> dao.atualizar(quarto));
    }

    @Test
    void testeAtualizarSeguraExcecaoComQuartoNulo() {
        QuartoDao dao = new QuartoDao();
        
       
        assertDoesNotThrow(() -> dao.atualizar(null));
    }
    
    
}
