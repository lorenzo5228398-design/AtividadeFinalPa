
package Testes;
import dao.ReservaDao;
import model.Reserva;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ReservaDaoTests {
    
    
    @Test
    void testeCadastrarReservaValidaSemTravar() {
        ReservaDao dao = new ReservaDao();
        

        Reserva reserva = new Reserva();
        reserva.setIdHospede(1);
        reserva.setIdQuarto(101);

   
        assertDoesNotThrow(() -> dao.cadastrar(reserva));
    }

    @Test
    void testeCadastrarSeguraExcecaoAoReceberNulo() {
        ReservaDao dao = new ReservaDao();
        

        assertDoesNotThrow(() -> dao.cadastrar(null));
    }

    @Test
    void testeReservarComDadosValidosSemTravar() {
        ReservaDao dao = new ReservaDao();
        
        String cpfHospede = "11122233344";
        int numeroQuarto = 5;


        assertDoesNotThrow(() -> dao.reservar(cpfHospede, numeroQuarto));
    }

    @Test
    void testeReservarComCpfNulo() {
        ReservaDao dao = new ReservaDao();
        

        assertDoesNotThrow(() -> dao.reservar(null, 2));
    }

    @Test
    void testeReservarComNumeroQuartoInvalido() {
        ReservaDao dao = new ReservaDao();
        
        String cpfHospede = "11122233344";
        int numeroQuartoInvalido = -999;


        assertDoesNotThrow(() -> dao.reservar(cpfHospede, numeroQuartoInvalido));
    }
    
    
    
}
