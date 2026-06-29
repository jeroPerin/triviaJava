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
       
    public menuPregunta(Partidas partida, int idJugador) {
        initComponents();
        
        p=partida;
        if(p instanceof PartidasMultijugador){
        timer = new Timer(200, e -> {
            actualizarPantalla();
        });
         timer.start();
        }

        
        
        panelVerdaderoFalso.setBounds(0, 0, 600, 200);
        panelMultipleChoice.setBounds(0, 0, 600, 200);
        panelCompletar.setBounds(0, 0, 600, 200);
        jugador=idJugador;
         
        pregActual=p.siguientePregunta();
        System.out.println(pregActual);
          
        mostrarPregunta();

    
    }
    
    private void procesarRespuesta(String respuesta){
    
        respuestaCorrecta = pregActual.verificarRespuesta(respuesta);
        
        p.guardarRespuesta(respuesta);
        if(respuestaCorrecta)
            System.out.println("RESPONDISTE BIEN");
        
        
        pregActual= p.siguientePregunta();
        if(pregActual == null){
        p.finalizarPartida();
        menuFinalPartida m = new menuFinalPartida(p);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        dispose();
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
           
           case 3 : panelCompletar.setVisible(true);break ;
           
        
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
        
        txtCompletar.setText("");
        panelVerdaderoFalso.setVisible(false);
        panelMultipleChoice.setVisible(false);
        panelCompletar.setVisible(false);
    
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPregunta = new javax.swing.JLabel();
        panelVerdaderoFalso = new javax.swing.JPanel();
        btnVerdadero = new javax.swing.JButton();
        btnFalso = new javax.swing.JButton();
        panelMultipleChoice = new javax.swing.JPanel();
        opcion3MultipleChoice = new javax.swing.JButton();
        opcion1MultipleChoice = new javax.swing.JButton();
        opcion2MultipleChoice = new javax.swing.JButton();
        opcion4MultipleChoice = new javax.swing.JButton();
        panelCompletar = new javax.swing.JPanel();
        txtCompletar = new javax.swing.JTextField();
        lblCompletar = new javax.swing.JLabel();
        btnCompletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(650, 300));

        btnVerdadero.setText("VERDADERO");
        btnVerdadero.addActionListener(this::btnVerdaderoActionPerformed);

        btnFalso.setText("FALSO");
        btnFalso.addActionListener(this::btnFalsoActionPerformed);

        javax.swing.GroupLayout panelVerdaderoFalsoLayout = new javax.swing.GroupLayout(panelVerdaderoFalso);
        panelVerdaderoFalso.setLayout(panelVerdaderoFalsoLayout);
        panelVerdaderoFalsoLayout.setHorizontalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVerdaderoFalsoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnFalso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVerdadero)
                .addGap(38, 38, 38))
        );
        panelVerdaderoFalsoLayout.setVerticalGroup(
            panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVerdaderoFalsoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelVerdaderoFalsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFalso)
                    .addComponent(btnVerdadero))
                .addGap(31, 31, 31))
        );

        opcion3MultipleChoice.addActionListener(this::opcion3MultipleChoiceActionPerformed);

        opcion1MultipleChoice.addActionListener(this::opcion1MultipleChoiceActionPerformed);

        opcion2MultipleChoice.addActionListener(this::opcion2MultipleChoiceActionPerformed);

        opcion4MultipleChoice.addActionListener(this::opcion4MultipleChoiceActionPerformed);

        javax.swing.GroupLayout panelMultipleChoiceLayout = new javax.swing.GroupLayout(panelMultipleChoice);
        panelMultipleChoice.setLayout(panelMultipleChoiceLayout);
        panelMultipleChoiceLayout.setHorizontalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultipleChoiceLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMultipleChoiceLayout.createSequentialGroup()
                        .addComponent(opcion2MultipleChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                        .addComponent(opcion4MultipleChoice))
                    .addGroup(panelMultipleChoiceLayout.createSequentialGroup()
                        .addComponent(opcion1MultipleChoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opcion3MultipleChoice)))
                .addGap(52, 52, 52))
        );
        panelMultipleChoiceLayout.setVerticalGroup(
            panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMultipleChoiceLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultipleChoiceLayout.createSequentialGroup()
                        .addComponent(opcion3MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMultipleChoiceLayout.createSequentialGroup()
                        .addComponent(opcion1MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelMultipleChoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opcion2MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcion4MultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtCompletar.addActionListener(this::txtCompletarActionPerformed);

        lblCompletar.setText("Completa:");

        btnCompletar.setText("RESPONDER");
        btnCompletar.addActionListener(this::btnCompletarActionPerformed);

        javax.swing.GroupLayout panelCompletarLayout = new javax.swing.GroupLayout(panelCompletar);
        panelCompletar.setLayout(panelCompletarLayout);
        panelCompletarLayout.setHorizontalGroup(
            panelCompletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompletarLayout.createSequentialGroup()
                .addGroup(panelCompletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCompletarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompletar))
                    .addGroup(panelCompletarLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblCompletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(txtCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        panelCompletarLayout.setVerticalGroup(
            panelCompletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompletarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCompletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMultipleChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMultipleChoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCompletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelVerdaderoFalso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerdaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerdaderoActionPerformed
        procesarRespuesta("TRUE");
    }//GEN-LAST:event_btnVerdaderoActionPerformed

    private void btnFalsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFalsoActionPerformed
       procesarRespuesta("FALSE");
    }//GEN-LAST:event_btnFalsoActionPerformed

    private void opcion1MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion1MultipleChoice.getText());
    }//GEN-LAST:event_opcion1MultipleChoiceActionPerformed

    private void opcion2MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion2MultipleChoice.getText());
    }//GEN-LAST:event_opcion2MultipleChoiceActionPerformed

    private void opcion3MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion3MultipleChoice.getText());
    }//GEN-LAST:event_opcion3MultipleChoiceActionPerformed

    private void opcion4MultipleChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4MultipleChoiceActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(opcion4MultipleChoice.getText());
    }//GEN-LAST:event_opcion4MultipleChoiceActionPerformed

    private void btnCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompletarActionPerformed
        // TODO add your handling code here:
        procesarRespuesta(txtCompletar.getText());
    }//GEN-LAST:event_btnCompletarActionPerformed

    private void txtCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCompletarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompletar;
    private javax.swing.JButton btnFalso;
    private javax.swing.JButton btnVerdadero;
    private javax.swing.JLabel lblCompletar;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JButton opcion1MultipleChoice;
    private javax.swing.JButton opcion2MultipleChoice;
    private javax.swing.JButton opcion3MultipleChoice;
    private javax.swing.JButton opcion4MultipleChoice;
    private javax.swing.JPanel panelCompletar;
    private javax.swing.JPanel panelMultipleChoice;
    private javax.swing.JPanel panelVerdaderoFalso;
    private javax.swing.JTextField txtCompletar;
    // End of variables declaration//GEN-END:variables
}
