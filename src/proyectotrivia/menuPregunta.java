/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotrivia;
import javax.swing.Timer;
/**
 *
 * @author JERO
 */
public class menuPregunta extends javax.swing.JFrame {
    
       private Partidas p;
       private int jugador;
       private Preguntas pregActual;
       private boolean eraMiTurno = false;
       private boolean respuestaCorrecta;
       private Timer timer;
       
    public menuPregunta(Partidas partida, int idJugador,int numJugador) {
        initComponents();
        
        p=partida;
        if(p instanceof PartidasMultijugador){
        timer = new Timer(200, e -> {
            actualizarPantalla();
        });
         timer.start();
         
         lblJugador.setText("J" + numJugador);
         
         
        }

        
        
        panelVerdaderoFalso.setBounds(471, 50, 100, 500);
            panelMultipleChoice.setBounds(471, 50, 100, 500);
            panelCompletar5.setBounds(471, 50, 100, 500);
        
        jugador=idJugador;
         
        pregActual=p.siguientePregunta();
        System.out.println(pregActual);
          
        mostrarPregunta();

    
    }
    
    private void procesarRespuesta(String respuesta){
    
        
        System.out.println(respuesta);
        
        p.guardarRespuesta(respuesta.toUpperCase());

        pregActual= p.siguientePregunta();
        
        if(pregActual == null){
        p.finalizarPartida();
        menuFinalPartida m = new menuFinalPartida(p);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        dispose();
        return;
            }
        System.out.println(pregActual);
      
        
        if(p instanceof PartidasSolitario)
        mostrarPregunta();
        
    }
    
    private void mostrarPregunta(){
        
        
            ocultarPaneles();
            
        
        switch(pregActual.tipoPregunta){
        
           case 1 : panelVerdaderoFalso.setVisible(true);break;
           
           case 2 : 
            PreguntasMultipleChoice preguntaMC = (PreguntasMultipleChoice) pregActual;

            opcion1MultipleChoice.setText(preguntaMC.getOpcion1());
            opcion2MultipleChoice.setText(preguntaMC.getOpcion2());
            opcion3MultipleChoice.setText(preguntaMC.getOpcion3());
            opcion4MultipleChoice.setText(preguntaMC.getOpcion4());

             
              
            panelMultipleChoice.setVisible(true);break;
           
           case 3 : panelCompletar5.setVisible(true);break ;
           
        
        }
        
        System.out.println("Mostrando: " + pregActual.enunciado);
        lblPregunta.setText(pregActual.enunciado);
    }

    private void actualizarPantalla(){
    
        boolean esMiTurno = ((PartidasMultijugador)p).getTurno() == jugador;
        
          if( esMiTurno && !eraMiTurno  ){

                 
                mostrarPregunta();
                eraMiTurno=true;
            }
            
                
              if(!eraMiTurno)
              
              { 
                  ocultarPaneles();
                lblPregunta.setText("Esperando al otro jugador...");
            }
    
               eraMiTurno = esMiTurno;
    }
    
    private void ocultarPaneles(){
        
        txtCompletar5.setText("");
        panelVerdaderoFalso.setVisible(false);
        panelMultipleChoice.setVisible(false);
        panelCompletar5.setVisible(false);
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPregunta = new javax.swing.JLabel();
        panelVerdaderoFalso = new javax.swing.JPanel();
        btnVerdadero = new javax.swing.JButton();
        btnFalso = new javax.swing.JButton();
        lblJugador = new javax.swing.JLabel();
        panelCompletar5 = new javax.swing.JPanel();
        txtCompletar5 = new javax.swing.JTextField();
        lblCompletar5 = new javax.swing.JLabel();
        btnCompletar5 = new javax.swing.JButton();
        panelMultipleChoice = new javax.swing.JPanel();
        opcion3MultipleChoice = new javax.swing.JButton();
        opcion1MultipleChoice = new javax.swing.JButton();
        opcion2MultipleChoice = new javax.swing.JButton();
        opcion4MultipleChoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(650, 300));

        lblPregunta.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnVerdadero.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnVerdadero.setText("VERDADERO");
        btnVerdadero.addActionListener(this::btnVerdaderoActionPerformed);

        btnFalso.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        btnFalso.setText("FALSO");
        btnFalso.addActionListener(this::btnFalsoActionPerformed);

        javax.swing.GroupLayout panelVerdaderoFalsoLayout = new javax.swing.GroupLayout(panelVerdaderoFalso);
        panelVerdaderoFalso.setLayout(panelVerdaderoFalsoLayout);
        panelVerdaderoFalsoLayout.setHorizontalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerdaderoFalsoLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnFalso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(btnVerdadero)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelVerdaderoFalsoLayout.setVerticalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerdaderoFalsoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFalso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerdadero, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        lblJugador.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N

        txtCompletar5.addActionListener(this::txtCompletarActionPerformed);

        lblCompletar5.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        lblCompletar5.setText("Completa:");

        btnCompletar5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCompletar5.setText("RESPONDER");
        btnCompletar5.addActionListener(this::btnCompletarActionPerformed);

        javax.swing.GroupLayout panelCompletar5Layout = new javax.swing.GroupLayout(panelCompletar5);
        panelCompletar5.setLayout(panelCompletar5Layout);
        panelCompletar5Layout.setHorizontalGroup(
            panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletar5Layout.createSequentialGroup()
                .addGroup(panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompletar5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblCompletar5)
                        .addGap(18, 18, 18)
                        .addComponent(txtCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCompletar5Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelCompletar5Layout.setVerticalGroup(
            panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletar5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompletar5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompletar5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        opcion3MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        opcion3MultipleChoice.addActionListener(this::opcion3MultipleChoiceActionPerformed);

        opcion1MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        opcion1MultipleChoice.addActionListener(this::opcion1MultipleChoiceActionPerformed);

        opcion2MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        opcion2MultipleChoice.addActionListener(this::opcion2MultipleChoiceActionPerformed);

        opcion4MultipleChoice.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        opcion4MultipleChoice.addActionListener(this::opcion4MultipleChoiceActionPerformed);

        javax.swing.GroupLayout panelMultipleChoiceLayout = new javax.swing.GroupLayout(panelMultipleChoice);
        panelMultipleChoice.setLayout(panelMultipleChoiceLayout);
        panelMultipleChoiceLayout.setHorizontalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultipleChoiceLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );
        panelMultipleChoiceLayout.setVerticalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultipleChoiceLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(panelMultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(379, 379, 379)
                        .addComponent(panelCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74)
                .addComponent(panelMultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(panelCompletar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion4MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion4MultipleChoice.getText());
    }//GEN-LAST:event_opcion4MultipleChoiceActionPerformed

    private void opcion2MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion2MultipleChoice.getText());
    }//GEN-LAST:event_opcion2MultipleChoiceActionPerformed

    private void opcion1MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion1MultipleChoice.getText());
    }//GEN-LAST:event_opcion1MultipleChoiceActionPerformed

    private void opcion3MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion3MultipleChoice.getText());
    }//GEN-LAST:event_opcion3MultipleChoiceActionPerformed

    private void btnFalsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalsoActionPerformed
        procesarRespuesta("FALSE");
    }//GEN-LAST:event_btnFalsoActionPerformed

    private void btnVerdaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdaderoActionPerformed
        procesarRespuesta("TRUE");
    }//GEN-LAST:event_btnVerdaderoActionPerformed

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(txtCompletar5.getText());
    }//GEN-LAST:event_btnCompletarActionPerformed

    private void txtCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompletarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompletar5;
    private javax.swing.JButton btnFalso;
    private javax.swing.JButton btnVerdadero;
    private javax.swing.JLabel lblCompletar5;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JButton opcion1MultipleChoice;
    private javax.swing.JButton opcion2MultipleChoice;
    private javax.swing.JButton opcion3MultipleChoice;
    private javax.swing.JButton opcion4MultipleChoice;
    private javax.swing.JPanel panelCompletar5;
    private javax.swing.JPanel panelMultipleChoice;
    private javax.swing.JPanel panelVerdaderoFalso;
    private javax.swing.JTextField txtCompletar5;
    // End of variables declaration//GEN-END:variables
}
