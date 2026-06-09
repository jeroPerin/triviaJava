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
    int indicePregunta1;
     Preguntas preguntasPartida1;
    Respuestas respuestasPartida1;
    
    int idUsuario2;
    int puntajeFinal2;
    int indicePregunta2;
     Preguntas preguntasPartida2;
    Respuestas respuestasPartida2;

    public PartidasMultijugador() {
    }

    public PartidasMultijugador(int idUsuario1, int puntajeFinal1, int idUsuario2, int puntajeFinal2, int idPartida, boolean finalizada) {
        super(idPartida, finalizada);
        this.idUsuario1 = idUsuario1;
        this.puntajeFinal1 = puntajeFinal1;
        this.idUsuario2 = idUsuario2;
        this.puntajeFinal2 = puntajeFinal2;
    }

    public int getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(int idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public int getPuntajeFinal1() {
        return puntajeFinal1;
    }

    public void setPuntajeFinal1(int puntajeFinal1) {
        this.puntajeFinal1 = puntajeFinal1;
    }

    public int getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(int idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public int getPuntajeFinal2() {
        return puntajeFinal2;
    }

    public void setPuntajeFinal2(int puntajeFinal2) {
        this.puntajeFinal2 = puntajeFinal2;
    }
    
    @Override
    public void iniciarPartida(){};
    public void finalizarPartida(){};
    public void calcularPuntaje(){};
    public Preguntas siguientePregunta(){    
        
        Preguntas p = new PreguntasVerdaderoFalso();
    return p;
    };
    
}
