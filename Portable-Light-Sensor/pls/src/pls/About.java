/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pls;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 */
public class About extends javax.swing.JFrame {

    /**
     * Creates new form Template
     */
    public About() {
        this.setCursor(this.getToolkit().createCustomCursor(
            new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
            "null"));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 480));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pls/title.png"))); // NOI18N

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextPane1.setText("Sponsor:  Dr. John Kapenga\n\nDevelopers: Joseph Hagan & Lucas Everts\n\nDevice Description:\nThis is a portable light sensor, for use in testing ambient lighting with regards to human health implications. If there are any questions or concerns one should read the documentation and then contact a member of the design team if necessary.\n\nDeveloped in 2015 & 2016 @ Western Michigan University.\n\nGo Broncos!\n");
        jTextPane1.setToolTipText("");
        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPane1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextPane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyTyped
        if (evt.getKeyChar() == 'q'){
            this.dispose();
        }
    }//GEN-LAST:event_jTextPane1KeyTyped

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
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Template.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Template().setVisible(true);
            }
        });
    }

    public void loadAbout(){
        /* Retrieved from http://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java */
        InetAddress i = null;
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException ex) {
            Logger.getLogger(About.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            String IFName  = n.getDisplayName();
            while (ee.hasMoreElements())
            {
                if(IFName.equalsIgnoreCase("wlan0")){
                    i = (InetAddress) ee.nextElement();
                }
                else{
                    ee.nextElement();
                }
            }
        }
        String IPAddress = "IP Address: " + i.getHostAddress();
        /* From http://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java */
        String timeStamp = new SimpleDateFormat("MM/dd/yyyy @ HH:mm:ss").format(Calendar.getInstance().getTime());
        String DateTime = "Date/Time: " + timeStamp;
        String currentText = jTextPane1.getText();
        String newText = (currentText + "\n" + DateTime + "\n" + IPAddress 
                 + "\n");
        jTextPane1.setText(newText);
        this.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
