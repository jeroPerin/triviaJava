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
    
    String respuestaSeleccionada;
    boolean respuestaCorrecta;

    public Respuestas() {
    }

    public Respuestas(String respuestaSeleccionada, boolean respuestaCorrecta) {
        
       
        this.respuestaSeleccionada = respuestaSeleccionada;
        this.respuestaCorrecta = respuestaCorrecta;
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
