package main;

import dao.Conexao;
import view.JframeLoginHospede;

public class AtividadeFinalPa {

    public static void main(String[] args) {
        Conexao.inicializarBanco();
        
        JframeLoginHospede login = new JframeLoginHospede();
        
        login.setVisible(true);
        
    }
}
