package org.uma.mbd.mdBancoV1L.banco;
import java.util.*;

public class Banco {
    private static final int PRIMIER_NUM_CTA = 1001;
    private final String nombre;
    private int snc;
    private List <Cuenta> ctas;

    public Banco(String nombre_banco){
        nombre = nombre_banco;
        snc = PRIMIER_NUM_CTA;
        ctas = new LinkedList<>();
    }

    public int abrirCuenta(String nombre_titular,double saldo){
        Cuenta cta = new Cuenta(nombre_titular,snc,saldo);
        int nc = snc;
        snc+=1;
        ctas.add(cta);
        return nc;
    }
    public int abrirCuenta(String nombre_titular){

        return abrirCuenta(nombre_titular,0);

    }

    public void cerrarCuenta(int num_cuenta){
        int pos = posicionCuenta(num_cuenta);
        ctas.remove(pos);
    }
    private int posicionCuenta(int nc){
        int pos = 0;
        while(pos< ctas.size() && ctas.get(pos).getNumCuenta() != nc){
            pos++;
        }
        if (pos == ctas.size()){
            throw new RuntimeException("Cuenta no existe "+ nc);
        }
        return pos;
    }

    public void ingreso(int numCuenta,double saldo){
        int cuenta = posicionCuenta(numCuenta);
        ctas.get(cuenta).ingreso(saldo);
    }

    public double debito(int numCuenta,double retirar){

        int cuenta = posicionCuenta(numCuenta);
        Cuenta cta = ctas.get(cuenta);
        double real = Math.min(retirar,cta.getSaldo());
        cta.debito(real);
        return real;
    }

    public double Saldo(int numCuenta){
        int cuenta  = posicionCuenta(numCuenta);
        return ctas.get(cuenta).getSaldo();
    }

    public double transferencia(int cta1,int cta2, double ingreso){
        int pos = posicionCuenta(cta2);//se hace para que si la cuenta 2 no existe lance una excepcion
        double restante = debito(cta1,ingreso);
        ingreso(cta2,restante);
        return restante;
    }
    @Override
    public String toString() {
        String salida = nombre + " :";
        for (int i = 0; i < ctas.size(); i++) {
            salida += ctas.get(i);
            if (i < ctas.size() - 1) {
                salida += " ";
            }
        }
        salida += "]";
        return salida;
    }

}
