package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public interface CriterioSeleccion {
    public Map<Partido,Integer> ejecuta(List<Partido> partidos,int numEscaños);
}
