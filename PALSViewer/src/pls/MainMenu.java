/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pls;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Joe
 */
public class MainMenu extends javax.swing.JFrame {



    
    private Clip clip;
    private String state = "stopped";
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        flickerValue = new javax.swing.JLabel();
        tempValue = new javax.swing.JLabel();
        luxValue = new javax.swing.JLabel();
        greenValue = new javax.swing.JLabel();
        blueValue = new javax.swing.JLabel();
        blueValue2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        UVValue = new javax.swing.JLabel();
        redBar = new javax.swing.JProgressBar();
        IRValue = new javax.swing.JLabel();
        blueBar = new javax.swing.JProgressBar();
        redValue = new javax.swing.JLabel();
        blueBar2 = new javax.swing.JProgressBar();
        jLabel23 = new javax.swing.JLabel();
        greenBar = new javax.swing.JProgressBar();
        indexValue = new javax.swing.JLabel();
        UVBar = new javax.swing.JProgressBar();
        IRBar = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        jMenu3.setText("jMenu3");

        jMenu6.setText("jMenu6");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PALS Companion Software");
        setIconImage(new ImageIcon("PALS.png").getImage());
        setIconImages(null);
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(955, 600));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Red");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Green");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Blue");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("480 nm");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("UV");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("IR");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lux");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Flicker Rate");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Color Temperature");

        flickerValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        flickerValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        flickerValue.setText("N/A");

        tempValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tempValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tempValue.setText("N/A");

        luxValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        luxValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        luxValue.setText("N/A");

        greenValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        greenValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        greenValue.setText("N/A");

        blueValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        blueValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        blueValue.setText("N/A");

        blueValue2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        blueValue2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        blueValue2.setText("N/A");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Test Results");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel1KeyTyped(evt);
            }
        });

        UVValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UVValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UVValue.setText("N/A");

        redBar.setForeground(new java.awt.Color(255, 0, 0));
        redBar.setMaximum(1000);

        IRValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        IRValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IRValue.setText("N/A");

        blueBar.setForeground(new java.awt.Color(0, 153, 255));
        blueBar.setMaximum(1000);

        redValue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        redValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        redValue.setText("N/A");

        blueBar2.setForeground(new java.awt.Color(0, 0, 153));
        blueBar2.setMaximum(1000);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("UV Index");

        greenBar.setForeground(new java.awt.Color(0, 255, 0));
        greenBar.setMaximum(1000);

        indexValue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        indexValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        indexValue.setText("N/A");

        UVBar.setForeground(new java.awt.Color(102, 0, 102));
        UVBar.setMaximum(1000);

        IRBar.setForeground(new java.awt.Color(0, 0, 0));
        IRBar.setMaximum(1000);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton1.setLabel("PLAY AUDIO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Load Test Data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("About This Software");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Close");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(flickerValue, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(tempValue, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(luxValue, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(indexValue, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IRBar, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(IRValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(39, 39, 39)
                        .addComponent(UVBar, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(UVValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(blueBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(blueValue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addComponent(blueBar, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(blueValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(greenBar, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(greenValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(redBar, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(redValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(redBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(greenBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(blueBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(blueBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(blueValue2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(UVBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UVValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IRBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IRValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(3, 3, 3)
                                .addComponent(flickerValue))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(3, 3, 3)
                                .addComponent(tempValue))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(3, 3, 3)
                                .addComponent(luxValue))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(3, 3, 3)
                                .addComponent(indexValue))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser browser = new JFileChooser();
        browser.setFileFilter(new FileNameExtensionFilter(".rep", "rep"));
        int result = browser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
           String filename = browser.getSelectedFile().getPath();
           String dirname = browser.getSelectedFile().getParent();
           String audioFilename = dirname + "\\test.wav";
           this.setTitle("PALS Companion Software - " + filename);
            String [] data = new String[11];
            try {
                File file = new File(filename);

                Scanner input = new Scanner(file);

                int i = 0;

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String [] splitLine = line.split(" = ");
                    data[i] = splitLine[1];
                    i++;
                }
                input.close();

            } catch (Exception ex) {
            }
            int maximum = 1000;
            for(int i=0; i<6; i++){
                int temp = Integer.parseInt(data[i]);
                while (temp > maximum){
                    maximum += 1000;
                }
            }
            redBar.setMaximum(maximum);
            redBar.setValue(Integer.parseInt(data[0]));
            redValue.setText(data[0] + "/" + maximum);
            greenBar.setMaximum(maximum);
            greenBar.setValue(Integer.parseInt(data[1]));
            greenValue.setText(data[1] + "/" + maximum);
            blueBar.setMaximum(maximum);
            blueBar.setValue(Integer.parseInt(data[2]));
            blueValue.setText(data[2] + "/" + maximum);
            blueBar2.setValue(Integer.parseInt(data[3]));
            blueValue2.setText(data[3] + "/" + maximum);
            UVBar.setMaximum(maximum);
            UVBar.setValue(Integer.parseInt(data[4]));
            UVValue.setText(data[4] + "/" + maximum);
            IRBar.setMaximum(maximum);
            IRBar.setValue(Integer.parseInt(data[5]));
            IRValue.setText(data[5] + "/" + maximum);
            flickerValue.setText(data[6]);
            tempValue.setText(data[7]);
            luxValue.setText(data[8]);
            indexValue.setText(data[9]);
        
            // From: http://stackoverflow.com/questions/2416935/how-to-play-wav-files-with-java
            
            try {
                File yourFile;
                yourFile = new File(audioFilename);
                AudioInputStream stream;
                AudioFormat format;
                DataLine.Info info;


                stream = AudioSystem.getAudioInputStream(yourFile);
                format = stream.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(stream);
            }
            catch (Exception e) {
                //whatevers
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jLabel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyTyped

    }//GEN-LAST:event_jLabel1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean hitEnd = (clip.getMicrosecondPosition() == clip.getMicrosecondLength());
        try{
        if(state.equalsIgnoreCase("stopped") && !hitEnd){
            state = "playing";
            jButton1.setBackground(Color.red);
            jButton1.setText("Click To Pause/Stop");
            clip.start();
        }
        else if(state.equalsIgnoreCase("playing") && hitEnd){
            jButton1.setBackground(Color.green);
            jButton1.setText("Click to Restart");
            clip.setMicrosecondPosition(0);
            state = "stopped";
        }
        else if (state.equalsIgnoreCase("playing")){
            state = "stopped";
            jButton1.setBackground(Color.green);
            jButton1.setText("Click To Start");
            clip.stop();
        }
        }
        catch(Exception e){
            String errorMessage = "No Audio was Recorded for This Reading" ;
            JOptionPane.showMessageDialog(this,errorMessage , "NO AUDIO FILE!!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar IRBar;
    private javax.swing.JLabel IRValue;
    private javax.swing.JProgressBar UVBar;
    private javax.swing.JLabel UVValue;
    private javax.swing.JProgressBar blueBar;
    private javax.swing.JProgressBar blueBar2;
    private javax.swing.JLabel blueValue;
    private javax.swing.JLabel blueValue2;
    private javax.swing.JLabel flickerValue;
    private javax.swing.JProgressBar greenBar;
    private javax.swing.JLabel greenValue;
    private javax.swing.JLabel indexValue;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel luxValue;
    private javax.swing.JProgressBar redBar;
    private javax.swing.JLabel redValue;
    private javax.swing.JLabel tempValue;
    // End of variables declaration//GEN-END:variables

    // Used Code from http://www.journaldev.com/1050/java-timer-and-timertask-example-tutorial
public class MyTimerTask extends TimerTask {
 
    @Override
    public void run() {
        completeTask();
    }
 
    private void completeTask() {
        if(clip.getMicrosecondLength() == clip.getMicrosecondPosition()){
            clip.setMicrosecondPosition(0);
            state = "stopped";
            jButton1.setBackground(Color.green);
            jButton1.setText("Click To Start...");
        }
    }
     
    public void main(String args[]){
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 500);
        //cancel after sometime
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}

}
