package model;

public class Quarto {

    private int id;
    private int numeroQuarto;
    private boolean reservado;

    public Quarto() {
    }

    public Quarto(int numeroQuarto, boolean reservado) {
        this.numeroQuarto = numeroQuarto;
        this.reservado = reservado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

}
