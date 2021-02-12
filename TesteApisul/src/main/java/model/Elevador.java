package model;

/**
 *
 * @author elopes
 */
public class Elevador {

    private int andar;
    private Character elevador;
    private Character turno;

    public Elevador(int andar, Character elevador, Character turno) {
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

    public Character getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return "Andar-> " + andar + " Elevador-> " + elevador + " Turno-> " + turno;
    }
}
