package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    private static final String URL = "jdbc:sqlite: hotel.db";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void inicializarBanco() {

        String sql = """
                     CREATE TABLE IF NOT EXISTS hospedes(
                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                      nome TEXT NOT NULL,
                      idade INTEGER NOT NULL,
                      cpf TEXT NOT NULL UNIQUE,
                      sexo CHAR(1),
                      senha TEXT NOT NULL
                                     
                                     );
                     
                     CREATE TABLE IF NOT EXISTS quartos(
                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                     numeroQuarto INTEGER NOT NULL,
                     reservado INTEGER NOT NULL CHECK (reservado = 1 OR reservado = 0)
                     
                     
                     );
                     
                     CREATE TABLE IF NOT EXISTS reservas(
                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                     id_quarto INTEGER,
                     id_hospede INTEGER,
                     checkin INTEGER NOT NULL CHECK (checkin = 0 OR checkin = 1) DEFAULT reservado 0,
                     
                     FOREIGN KEY (id_hospede) REFERENCES hospedes(id),
                     FOREIGN KEY (id_quarto) REFERENCES quartos(id)
                     )
                     """;
        
        

        try (Connection conexao = conectar(); Statement comando = conexao.createStatement()) {
            
            comando.execute(sql);
            
            System.out.println("Conexão realizada com sucesso.");
            
            

        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dado." + e);
        };

    }

}
