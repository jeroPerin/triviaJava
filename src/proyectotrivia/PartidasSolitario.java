/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class PartidasSolitario extends Partidas {
          
    int idUsuario;
    int puntajeFinal;

    public PartidasSolitario() {
    }

    public PartidasSolitario(int idUsuario, int puntajeFinal) {
        this.idUsuario = idUsuario;
        this.puntajeFinal = puntajeFinal;
    }

    public PartidasSolitario(int idUsuario, int puntajeFinal, int idPartida, boolean finalizada) {
        super(idPartida, finalizada);
        this.idUsuario = idUsuario;
        this.puntajeFinal = puntajeFinal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(int puntajeFinal) {
        this.puntajeFinal = puntajeFinal;
    }

    @Override
    public void iniciarPartida(){
   
        //OBTENER PREGUNTAS
        
    
    
    };
    public void finalizarPartida(){};
    public void calcularPuntaje(){};
    public void siguientePregunta(){};
    
    
}
