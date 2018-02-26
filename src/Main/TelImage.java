/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author lukas
 */
public class TelImage extends javax.swing.JFrame {
    String imga;
    AddOrder addorder = new AddOrder();
    String marka = addorder.mark.replaceAll("\\s", "");
    String model = addorder.mod.replaceAll("\\s", "");
    Image image;
    /**
     * Creates new form TelImage
     */
    public TelImage() {
       initComponents();
       takeURL();
       showImage();
    }
    private void takeURL(){
       // try {
            Document doc = null;
            try {
                doc = Jsoup.connect("http://www.mgsm.pl/pl/katalog/"+marka+"/"+model+"/").userAgent("mozilla/17.0").get();
            } catch (IOException ex) {
                //Logger.getLogger(TelImage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Niepoprawne dane telefonu. Popraw i spróbuj ponownie");
            }
            Elements img = doc.select("#right-con > div:nth-child(4) > div.large-5.medium-12.small-12.columns.right-sheet-column > div:nth-child(1) > div.large-7.medium-7.columns.phone-thumb-large.text-center > a > img");
            for (Element el : img) {
                imga = el.absUrl("src");
            }
          //  URL url = new URL(imga);
            //try {
              //  image = ImageIO.read(url);
           // } catch (IOException ex) {
             //   Logger.getLogger(ShowTelImage.class.getName()).log(Level.SEVERE, null, ex);
            //}
        //} catch (MalformedURLException ex) {
          //  Logger.getLogger(TelImage.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    private void showImage(){
        URL url;
        try {
            url = new URL(imga);
            image = ImageIO.read(url);
        } catch (MalformedURLException ex) {
            //Logger.getLogger(TelImage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Niepoprawne dane telefonu. Popraw i spróbuj ponownie");
        } catch (IOException ex) {
           // Logger.getLogger(TelImage.class.getName()).log(Level.SEVERE, null, ex);
        }
       // labele = new JLabel(new ImageIcon(image));
        labele.setIcon(new ImageIcon(image));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labele = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(150, 425));
        jPanel1.setLayout(null);

        labele.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labele);
        labele.setBounds(0, 0, 480, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(497, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelImage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labele;
    // End of variables declaration//GEN-END:variables
}