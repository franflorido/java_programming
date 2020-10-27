package org.uma.mbd.mdMastermindL.masterMind;

public class MasterMindException extends RuntimeException {
    public MasterMindException() {
        super();
    }

    public MasterMindException(String msg) {
        super(msg);
    }
   /* public MasterMindException(int i){
        super(Integer.toString(i));
    }


    */
}