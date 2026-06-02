/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotrivia;

/**
 *
 * @author JERO
 */
public class PreguntasOrdenar extends Preguntas {
    String opcion1;
    String opcion2;
    String opcion3;
    String opcion4;
    String ordenCorrecta;

    public PreguntasOrdenar() {
    }

    public PreguntasOrdenar(String opcion1, String opcion2, String opcion3, String opcion4, String ordenCorrecta, int idPregunta, int idCategoria, String enunciado, int tipoPregunta, int dificultad) {
        super(idPregunta, idCategoria, enunciado, tipoPregunta, dificultad);
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcion4 = opcion4;
        this.ordenCorrecta = ordenCorrecta;
    }
    
    
}
