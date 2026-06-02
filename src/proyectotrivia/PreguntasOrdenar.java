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

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOrdenCorrecta() {
        return ordenCorrecta;
    }

    public void setOrdenCorrecta(String ordenCorrecta) {
        this.ordenCorrecta = ordenCorrecta;
    }
    
    //METODOS FUNCIONALIDADES
     @Override
    public boolean verificarRespuesta(){
    
    
    return true;
    }
    
}
