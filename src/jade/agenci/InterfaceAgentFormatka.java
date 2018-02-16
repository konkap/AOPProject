package jade.agenci;

//@author Konrad

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;


public class InterfaceAgentFormatka extends javax.swing.JFrame {

    private final InterfaceAgent agentInterfejsu;
    List<String> picD;
    URL link;
    Image im = null;
    int nr = 0;
    boolean gotowe = false;
    int doPobrania = 0;
    ArrayList<String> schowek = new ArrayList<String>();
    int kolejnyPlik = 0;
    int ktoreZapytanie = 0;
       
    public InterfaceAgentFormatka(InterfaceAgent IA) {
        agentInterfejsu = IA;
        initComponents();
    }
    public void showGui() {
        super.setVisible(true);
    }
    
    public void zaktualizujListeObrazow(List<String> picD) {
        this.picD = new ArrayList<String>(picD);
        agentInterfejsu.wyslijZapytanieTagi(jTxFdTag.getText());
    }
    public void zaktualizujListeProponowanych(List<String> lista) {
        String l = lista.toString();
        jLabProponowane.setText("Proponowane tagi: " + l);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButSzukaj = new javax.swing.JButton();
        jTxFdTag = new javax.swing.JTextField();
        jButNastepny = new javax.swing.JButton();
        jButPoprzedni = new javax.swing.JButton();
        jButDodaj = new javax.swing.JButton();
        jLabWyswietlacz = new javax.swing.JLabel();
        jLabIloscOb = new javax.swing.JLabel();
        jButPobierz = new javax.swing.JButton();
        jLabProponowane = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButSzukaj.setText("Szukaj po tagu");
        jButSzukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButSzukajActionPerformed(evt);
            }
        });

        jTxFdTag.setText("#fotografia");

        jButNastepny.setText(">");
        jButNastepny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButNastepnyActionPerformed(evt);
            }
        });

        jButPoprzedni.setText("<");
        jButPoprzedni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButPoprzedniActionPerformed(evt);
            }
        });

        jButDodaj.setText("Dodaj");
        jButDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButDodajActionPerformed(evt);
            }
        });

        jLabWyswietlacz.setBackground(new java.awt.Color(204, 204, 204));
        jLabWyswietlacz.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabIloscOb.setText("Do pobrania: 0");

        jButPobierz.setText("Pobierz");
        jButPobierz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButPobierzActionPerformed(evt);
            }
        });

        jLabProponowane.setText("Proponowane tagi: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTxFdTag)
                        .addComponent(jButSzukaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButPoprzedni)
                        .addGap(18, 18, 18)
                        .addComponent(jButNastepny))
                    .addComponent(jButDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabIloscOb, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButPobierz, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabProponowane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabWyswietlacz, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButSzukaj)
                        .addGap(18, 18, 18)
                        .addComponent(jTxFdTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButPoprzedni)
                            .addComponent(jButNastepny))
                        .addGap(18, 18, 18)
                        .addComponent(jButDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabIloscOb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButPobierz))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabWyswietlacz, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabProponowane, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButSzukajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButSzukajActionPerformed
        gotowe = false;
        nr=0;
        agentInterfejsu.wyslijZapytanieObrazy(jTxFdTag.getText());
        while(!gotowe)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        wyswietlObraz(nr,"-");
    }//GEN-LAST:event_jButSzukajActionPerformed

    private void jButNastepnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButNastepnyActionPerformed
        if(nr < picD.size()){
            nr++;
            wyswietlObraz(nr,">");
        }
    }//GEN-LAST:event_jButNastepnyActionPerformed
   
    private void jButPoprzedniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButPoprzedniActionPerformed
        if(nr > 0)
        {
            nr--;
            wyswietlObraz(nr,"<");
        }
    }//GEN-LAST:event_jButPoprzedniActionPerformed

    private void jButDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButDodajActionPerformed
        schowek.add(picD.get(nr));
        doPobrania++;
        jLabIloscOb.setText("Do pobrania: " + doPobrania);
    }//GEN-LAST:event_jButDodajActionPerformed

    private void jButPobierzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButPobierzActionPerformed
        jLabIloscOb.setText("Do pobrania: 0");
        doPobrania = 0;
        try {
            savePictures(schowek);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(Level.SEVERE, null, ex);
        }
        schowek = new ArrayList<String>();
    }//GEN-LAST:event_jButPobierzActionPerformed
    
    public void wyswietlObraz(int nrp, String strona)
    {
        if(nr > -1 && nr < picD.size())
            {
                try {
                    link = new URL(picD.get(nrp));
                    im = ImageIO.read(link);
                    int[] s = ScaledImageSize(im,jLabWyswietlacz);
                    im = RatioResize(im,s[0],s[1]);
                } catch (Exception ex) {
                    System.out.println("Wyswietlanie obrazu: "+ ex.getMessage());
                }
                ImageIcon imm = new ImageIcon(im);
                jLabWyswietlacz.setIcon(imm);
            } 
    }
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
            java.util.logging.Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAgentFormatka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InterfaceAgentFormatka().setVisible(true);
            }
        });
    }
    
    public Image RatioResize(Image originalImage, int biggerWidth, int biggerHeight) {    
        int type = BufferedImage.TYPE_INT_ARGB;
        BufferedImage resizedImage = new BufferedImage(biggerWidth, biggerHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(originalImage,0,0, biggerWidth, biggerHeight,this);
        g.dispose();
        return resizedImage;
    }
    public int[] ScaledImageSize(Image image, Component canvas) {
        int imgWidth = image.getWidth(null);
        int imgHeight = image.getHeight(null);
        double imgAspect = (double) imgHeight / imgWidth;
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        double canvasAspect = (double) canvasHeight / canvasWidth;
        int x1 = 0; // top left X position
        int y1 = 0; // top left Y position
        int x2 = 0; // bottom right X position
        int y2 = 0; // bottom right Y position
        if (imgWidth < canvasWidth && imgHeight < canvasHeight) {
            // the image is smaller than the canvas
            x1 = (canvasWidth - imgWidth)  / 2;
            y1 = (canvasHeight - imgHeight) / 2;
            x2 = imgWidth + x1;
            y2 = imgHeight + y1;           
        } else {
            if (canvasAspect > imgAspect) {
                y1 = canvasHeight;
                // keep image aspect ratio
                canvasHeight = (int) (canvasWidth * imgAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else {
                x1 = canvasWidth;
                // keep image aspect ratio
                canvasWidth = (int) (canvasHeight / imgAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }
        int[] tab = {x2-x1,y2-y1};
        return tab;
    }
    
    public double getScaleFactor(int iMasterSize, int iTargetSize){
        double dScale = 1;
        if (iMasterSize > iTargetSize) dScale = (double) iTargetSize / (double) iMasterSize;
        else dScale = (double) iTargetSize / (double) iMasterSize;
        return dScale;
    }

    public double getScaleFactorToFit(Dimension original, Dimension toFit) {
        double dScale = 1d;
        if (original != null && toFit != null) {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;
    }
    
    public void savePicture(String u) throws MalformedURLException, IOException {
        URL url = new URL(u);
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
           out.write(buf, 0, n);
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        String path = home.getAbsolutePath() + "/plik" + kolejnyPlik + u.substring(u.length()-4,u.length());
        kolejnyPlik++;
        //FileOutputStream fos = new FileOutputStream("D://borrowed_image.jpg");
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(response);
        fos.close();
    }
    public void savePictures (ArrayList<String> list) throws IOException {
         for(String link : schowek)
            savePicture(link);
    }
    
    
    //########################################################3
    
    //#########################################################
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButDodaj;
    private javax.swing.JButton jButNastepny;
    private javax.swing.JButton jButPobierz;
    private javax.swing.JButton jButPoprzedni;
    private javax.swing.JButton jButSzukaj;
    private javax.swing.JLabel jLabIloscOb;
    private javax.swing.JLabel jLabProponowane;
    private javax.swing.JLabel jLabWyswietlacz;
    private javax.swing.JTextField jTxFdTag;
    // End of variables declaration//GEN-END:variables
}
