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
    
   boolean opcionBooleana;
   boolean opcionCorrecta;

    public PreguntasVerdaderoFalso() {
    }

    public PreguntasVerdaderoFalso(boolean opcionBooleana, boolean opcionCorrecta, int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad) {
        super(idPregunta, idCategoria, enunciado, tipoPregunta, dificultad);
        this.opcionBooleana = opcionBooleana;
        this.opcionCorrecta = opcionCorrecta;
    }
    
   
    
}
