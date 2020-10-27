package org.uma.mbd.mdMastermindL.masterMind;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MasterMindMemoria extends MasterMind {
    private List<Movimiento> movimientos = new LinkedList<>();

    public MasterMindMemoria(int tamano) {
        super(tamano);

    }

    public MasterMindMemoria() {
        super();
    }

    public MasterMindMemoria(String secreto) {
        super(secreto);
    }

    @Override
    public Movimiento intento(String cifra) {
        Movimiento mov = super.intento(cifra);
        if(movimientos.contains(mov)){
            throw new MasterMindException("Cifra ya introducida");

        }
        movimientos.add(mov);
        return mov;
    }

    public List<Movimiento> movimientos() {

        return movimientos;
    }


}

