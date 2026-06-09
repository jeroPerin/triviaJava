/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class PreguntasVerdaderoFalso extends Preguntas {
    
   boolean opcionCorrecta;

    public PreguntasVerdaderoFalso() {
    }

    public PreguntasVerdaderoFalso( boolean opcionCorrecta, int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad) {
        super(idPregunta, idCategoria, enunciado, tipoPregunta, dificultad);
        this.opcionCorrecta = opcionCorrecta;
    }


    public boolean isOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(boolean opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }
    
   //METODOS FUNCIONALIDADES
    
    @Override
    public boolean verificarRespuesta(String respuestaUsuario){
    
        
    if(respuestaUsuario.equals(opcionCorrecta))
        return true;
    else
        return false;
    
    }
    
    
}
