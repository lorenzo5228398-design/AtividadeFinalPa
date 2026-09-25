package main;

import dao.Conexao;
import dao.QuartoDao;
import view.JframeLoginHospede;

public class AtividadeFinalPa {
    
    public static void main(String[] args) {
        Conexao.inicializarBanco();
        
        JframeLoginHospede login = new JframeLoginHospede();
        QuartoDao dao = new QuartoDao();
        dao.cadastrar();
        login.setVisible(true);
        
    }
}
