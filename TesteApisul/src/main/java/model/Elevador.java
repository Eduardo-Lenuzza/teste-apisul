package model;

/**
 *
 * @author elopes
 */
public class Elevador {

    private int andar;
    private Character elevador;
    private String turno;

    public Elevador(int andar, Character elevador, String turno) {
        this.andar = andar;
        this.elevador = elevador;
        this.turno = turno;
    }

    public int getAndar() {
        return andar;
    }

    public Character getElevador() {
        return elevador;
    }

    public String getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return "Andar-> " + andar + " Elevador-> " + elevador + " Turno-> " + turno;
    }
}
