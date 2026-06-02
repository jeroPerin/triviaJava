package proyectotrivia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JERO
 */
public class Respuestas {
    
    int idRespuesta;
    int idPartida;
    int idPregunta;
    String respuestaSeleccionada;
    boolean respuestaCorrecta;

    public Respuestas() {
    }

    public Respuestas(int idRespuesta, int idPartida, int idPregunta, String respuestaSeleccionada, boolean respuestaCorrecta) {
        this.idRespuesta = idRespuesta;
        this.idPartida = idPartida;
        this.idPregunta = idPregunta;
        this.respuestaSeleccionada = respuestaSeleccionada;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    
}
