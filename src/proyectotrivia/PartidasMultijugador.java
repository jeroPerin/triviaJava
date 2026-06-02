/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class PartidasMultijugador extends Partidas{
    
    int idUsuario1;
    int puntajeFinal1;
    
    int idUsuario2;
    int puntajeFinal2;

    public PartidasMultijugador() {
    }

    public PartidasMultijugador(int idUsuario1, int puntajeFinal1, int idUsuario2, int puntajeFinal2, int idPartida, boolean finalizada) {
        super(idPartida, finalizada);
        this.idUsuario1 = idUsuario1;
        this.puntajeFinal1 = puntajeFinal1;
        this.idUsuario2 = idUsuario2;
        this.puntajeFinal2 = puntajeFinal2;
    }
    
    
}
