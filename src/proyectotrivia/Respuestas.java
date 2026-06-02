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

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getRespuestaSeleccionada() {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(String respuestaSeleccionada) {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public boolean isRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    
}
