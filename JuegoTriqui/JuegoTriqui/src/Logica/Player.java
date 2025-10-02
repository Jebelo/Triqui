
package Logica;

public class Player {
    public char simbolo;// puede ser X u O

    Player (){} //inicializando datos
    
    public Player(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
   
}
