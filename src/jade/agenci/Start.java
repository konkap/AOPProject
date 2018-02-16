
package jade.agenci;
import jade.Boot;

public class Start extends javax.swing.JFrame {
    Boot AgentPlatform;
    public Start() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButStartPlatform = new javax.swing.JButton();
        jButStartAgents = new javax.swing.JButton();
        jCheckAInt = new javax.swing.JCheckBox();
        jCheckADat = new javax.swing.JCheckBox();
        jCheckADB = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButStartPlatform.setText("Uruchom JADE");
        jButStartPlatform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButStartPlatformActionPerformed(evt);
            }
        });

        jButStartAgents.setText("Dodaj agentow");
        jButStartAgents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButStartAgentsActionPerformed(evt);
            }
        });

        jCheckAInt.setSelected(true);
        jCheckAInt.setText("Interfejs");

        jCheckADat.setSelected(true);
        jCheckADat.setText("Wykop");

        jCheckADB.setSelected(true);
        jCheckADB.setText("Baza");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButStartAgents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButStartPlatform, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckADat)
                    .addComponent(jCheckAInt)
                    .addComponent(jCheckADB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButStartPlatform)
                    .addComponent(jCheckAInt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButStartAgents)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckADat)
                        .addGap(6, 6, 6)
                        .addComponent(jCheckADB)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButStartPlatformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButStartPlatformActionPerformed
        String[] param = new String[1];
        param[0] = "-gui";
        //param[1] = "agentInstance:path.to.agent.class.AgentClass()";
        Boot.main(param);
    }//GEN-LAST:event_jButStartPlatformActionPerformed

    private void jButStartAgentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButStartAgentsActionPerformed
        String host = "localhost";
        String port = "2000";
        String aInterface[] = { "-host", host,
            "-port",port,
            "-container-name","Interfejs",
            "-container","AgentInterfejsu"+
            ":"+"jade.agenci.InterfaceAgent"};
        String aWykop[] = { "-host", host,
            "-port",port,
            "-container-name","Wykop",
            "-container","AgentWykopu"+
            ":"+"jade.agenci.PictureAgent"};
        String aDatabase[] = { "-host", host,
            "-port",port,
            "-container-name","BazaDanych",
            "-container","AgentBazodanowy"+
            ":"+"jade.agenci.DatabaseAgent"};
        
            if(jCheckAInt.isSelected()) Boot.main(aInterface);
            if(jCheckADat.isSelected())Boot.main(aWykop);
            if(jCheckADB.isSelected())Boot.main(aDatabase);
    }//GEN-LAST:event_jButStartAgentsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButStartAgents;
    private javax.swing.JButton jButStartPlatform;
    private javax.swing.JCheckBox jCheckADB;
    private javax.swing.JCheckBox jCheckADat;
    private javax.swing.JCheckBox jCheckAInt;
    // End of variables declaration//GEN-END:variables
}
