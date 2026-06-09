/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author JERO
 */
abstract public class Partidas {
    
    int idPartida;
   // DateTime fecha;
    boolean finalizada;
   
   

    public Partidas() {
    }

    public Partidas(int idPartida, boolean finalizada) {
        this.idPartida = idPartida;
        this.finalizada = finalizada;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    
    /*iniciarPartida()
    finalizarPartida()
    calcularPuntaje()
    verificarRespuesta()
    siguientePregunta()*/

    abstract void iniciarPartida();
    abstract void finalizarPartida();
    abstract void calcularPuntaje();
     
    abstract Preguntas siguientePregunta();
}
