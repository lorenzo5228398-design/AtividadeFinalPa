package model;

import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Reserva {

    private int id;
    private int idHospede;
    private int idQuarto;
    private boolean checkin;

    public Reserva() {
    }

    public Reserva(int idHospede, int idQuarto, boolean checkin) {
        this.idHospede = idHospede;
        this.idQuarto = idQuarto;
        this.checkin = checkin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    

}
