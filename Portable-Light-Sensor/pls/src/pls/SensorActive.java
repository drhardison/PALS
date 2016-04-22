/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pls;

import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


/**
 *
 * @author Joe
 */
public class SensorActive extends javax.swing.JFrame implements PropertyChangeListener{
    private Boolean record = false;
    private int NumberOfIterations = 0;
    private int ProgressEndPoint = 0;
    private Task task;
    PrintWriter RGBFile;
    PrintWriter UVFile;
    PrintWriter BlueFile;
    String reportFile;
    
    /**
     * Creates new form Template
     */
    public SensorActive() throws FileNotFoundException, UnsupportedEncodingException {
        initComponents();
        ClearDir();
        RGBFile = new PrintWriter("/home/pi/CurrentTest/RGB.txt", "UTF-8");
        RGBFile.println("RED\tGREEN\tBLUE\tCLEAR\tTEMP\tLUX");
        UVFile = new PrintWriter("/home/pi/CurrentTest/UV+IR.txt", "UTF-8");
        UVFile.println("VIS\tIR\tUV\tUV INDEX");
        BlueFile = new PrintWriter("/home/pi/CurrentTest/Blue.txt", "UTF-8");
        GetRunNumber();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(this.MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(750, 430));
        setSize(new java.awt.Dimension(800, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sensor is Running... Please Wait.");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setForeground(new java.awt.Color(0, 255, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sensor Active");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1CaretUpdate

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
       if(evt.getKeyChar() == 'q'){
            task.cancel(true);
            jTextArea1.setText(null);
            this.dispose();
            
        }
    }//GEN-LAST:event_jTextArea1KeyTyped

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
    public void startSensor(){
        ConfirmRecord confirmRec = new ConfirmRecord();
        confirmRec.setVisible(true);
        
    }
    
    private void GetRunNumber(){
        try {
            File file = new File("/home/pi/config.txt");

            Scanner input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                String [] data = line.split(" = ");
                NumberOfIterations = Integer.parseInt(data[1]);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void exec(Boolean rec){
        Visible(true);
        record = rec;
        jProgressBar1.setStringPainted(true);
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
    
    private void UpdateIterNo(){
        NumberOfIterations = 33;
    }
    
    private void ClearDir(){
        String [] cleanCurCmd = {"/bin/bash", "-c", "rm -rf /home/pi/CurrentTest/*"};
         try {
             Runtime.getRuntime().exec(cleanCurCmd);
         } catch (IOException ex) {
         }
    }
    
    private void Record(){
        
        List<String> list = new ArrayList<String>();
        list.add("arecord");
        list.add("-D");
        list.add("plughw:1,0");
        list.add("-d");
        list.add("30");
        list.add("-f");
        list.add("cd");
        list.add("-t");
        list.add("wav");
        list.add("/home/pi/CurrentTest/test.wav");
        
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void toggleRGBSensors(String sensor) {
        String programPath = "";
        List<String> list = new ArrayList<String>();
        list.add("python");
        switch(sensor){
            case "blue": programPath = "/home/pi/Python/Blue/switchToBlue.py";
                         break;
            case "RGB" : programPath = "/home/pi/Python/RGB/switchToRGB.py";
                         break;
            default:
                         break;
        }
        list.add(programPath);
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GetRGB(){
        List<String> list = new ArrayList<String>();
        list.add("python");
        list.add("/home/pi/Python/RGB/sensor.py");
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            InputStream iStream = process.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iStreamReader);
            String line;
            while ((line = bReader.readLine()) != null){
                String [] values = line.split(":");
                RGBFile.print(values[1]);
                RGBFile.print("\t");
                jTextArea1.append(line + "\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            }
            RGBFile.println();
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GetBlue(){
        List<String> list = new ArrayList<String>();
        list.add("python");
        list.add("/home/pi/Python/Blue/sensor.py");
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            InputStream iStream = process.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iStreamReader);
            String line;
            while ((line = bReader.readLine()) != null){
                String [] values = line.split(":");
                BlueFile.print(values[1]);
                jTextArea1.append(line + "\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
        BlueFile.println();
    }
    
    private void GetUV(){
        List<String> list = new ArrayList<String>();
        list.add("python");
        list.add("/home/pi/Python/UVandIR/sensor.py");
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            InputStream iStream = process.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iStreamReader);
            String line;
            while ((line = bReader.readLine()) != null){
                String [] values = line.split(":");
                UVFile.print(values[1]);
                UVFile.print("\t");
                jTextArea1.append(line + "\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
        UVFile.println();
    }
    
    private void GetFlicker(){
        List<String> list = new ArrayList<String>();
        list.add("python");
        list.add("/home/pi/Python/AtoD/sensor.py");
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            InputStream iStream = process.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iStreamReader);
            String line;
            while ((line = bReader.readLine()) != null){
                jTextArea1.append(line + "\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GenerateReport(){
        List<String> list = new ArrayList<String>();
        list.add("python");
        list.add("/home/pi/Python/Report/makeReport.py");
        try {
            //Borrowed code from http://stackoverflow.com/questions/13991007/execute-external-program-in-java
            Process process = new ProcessBuilder(list).start();
            InputStream iStream = process.getInputStream();
            InputStreamReader iStreamReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iStreamReader);
            String line;
            while ((line = bReader.readLine()) != null){
                reportFile = line;
                jTextArea1.append(line + "\n");
                jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void Visible(boolean b) {
        this.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }
    private void Dispose(){
        this.dispose();
    }
    
    public class ConfirmRecord extends javax.swing.JFrame {
    

    public ConfirmRecord() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setExtendedState(this.MAXIMIZED_BOTH);
        setForeground(java.awt.Color.black);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 480));

        jList1.setBackground(new java.awt.Color(51, 25, 0));
        jList1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jList1.setForeground(new java.awt.Color(238, 177, 17));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Yes", "No" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectedIndex(0);
        jList1.setSelectionBackground(new java.awt.Color(238, 177, 17));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jList1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 25, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Record A Message?");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    

    
    private void jList1KeyTyped(java.awt.event.KeyEvent evt) {                                
        if (evt.getKeyChar() == '\n'){
            int index = jList1.getSelectedIndex();
            switch(index){
                case 0:
                    this.dispose();
                    SensorActive.this.exec(true);
                    break;
                case 1:
                    this.dispose();
                    SensorActive.this.exec(false);
                    break;
                default:
                    break;
            }
        }
        else if (evt.getKeyChar() == 'q'){
            this.dispose();
        }
    }                               
     

    
    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}

    
    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() throws InterruptedException {
            if(record){
                jLabel1.setText("Recording/Testing in: 3");
                Thread.sleep(1000);
                jLabel1.setText("Recording/Testing in: 2");
                Thread.sleep(1000);
                jLabel1.setText("Recording/Testing in: 1");
                Thread.sleep(1000);
                jLabel1.setText("Recording/Testing in: 0");
                jTextArea1.append("I Am Recording You. You Have 30 seconds.\n");
                Record();
            }
            
            
            int currentProgress = 0;
            //Initialize progress property.
            setProgress(currentProgress);
            UpdateIterNo();
            ProgressEndPoint = 3*NumberOfIterations + 1;
            jTextArea1.append("Sensor Starting...\n");
            int i = 0;
            jLabel1.setText("Warming Up RGB Sensor...");
            jTextArea1.append("Warming Up RGB Sensor...\n");
            toggleRGBSensors("RGB");
            if(this.isCancelled()){
                return null;
            }
            for(i=0; i<7; i++){
                GetRGB();
            }
            jLabel1.setText("Collecting RGB Data...");
            jTextArea1.append("Collecting RGB Data...\n");
            if(this.isCancelled()){
                return null;
            }
            // RGB Loop
            for(i=0; i<NumberOfIterations; i++){
               GetRGB();
               currentProgress++;
               setProgress(Math.min(currentProgress, ProgressEndPoint));
            }
            RGBFile.close();
            if(this.isCancelled()){
                return null;
            }
            jLabel1.setText("Warming Up Blue Sensor...");
            jTextArea1.append("Warming Up Blue Sensor...\n");
            if(this.isCancelled()){
                return null;
            }
            toggleRGBSensors("blue");
            for(i=0; i<7; i++){
                GetBlue();
            }
            jLabel1.setText("Collecting Blue Data...");
            jTextArea1.append("Collecting Blue Data...\n");
            // Blue Loop
            for(i=0; i<NumberOfIterations; i++){
                GetBlue();
                currentProgress++;
                setProgress(Math.min(currentProgress, ProgressEndPoint));
            }
            if(this.isCancelled()){
                return null;
            }
            BlueFile.close();
            jLabel1.setText("Warming Up UV Sensor...");
            jTextArea1.append("Warming Up UV Sensor...\n");
            for(i=0; i<7; i++){
               GetUV();
            }
            if(this.isCancelled()){
                return null;
            }
            jLabel1.setText("Collecting UV Data...");
            jTextArea1.append("Collecting UV Data...\n");
            // UV Loop
            for(i=0; i<NumberOfIterations; i++){
                //GetUV();
                GetUV();
                currentProgress++;
                setProgress(Math.min(currentProgress, ProgressEndPoint));
                if(this.isCancelled()){
                    return null;
                }
            }
            UVFile.close();
            jLabel1.setText("Collecting Flicker Data...");
            jTextArea1.append("Collecting Flicker Data...\n");
            GetFlicker();
            jLabel1.setText("Generating Report...");
            jTextArea1.append("Generating Report...\n");
            GenerateReport();
            setProgress(ProgressEndPoint);
            WhatNext next = new WhatNext();
            next.setVisible(true);
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            jLabel1.setText("Done!");
            jTextArea1.append("Done!\n");
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
            jProgressBar1.setValue(100);
        }


    }


    /**
     * Invoked when the user presses the start button.
     */


    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            jProgressBar1.setValue(progress);
            jTextArea1.append(String.format(
                    "Completed %d%% of task.\n", task.getProgress()));
        } 
    }
 public class WhatNext extends javax.swing.JFrame {
    

    public WhatNext() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setExtendedState(this.MAXIMIZED_BOTH);
        setForeground(java.awt.Color.black);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 480));

        jList1.setBackground(new java.awt.Color(51, 25, 0));
        jList1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jList1.setForeground(new java.awt.Color(238, 177, 17));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "View Results", "Take Another Measurement", "Return to Main Menu" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setSelectedIndex(0);
        jList1.setSelectionBackground(new java.awt.Color(238, 177, 17));
        jList1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jList1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 25, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("What Next?");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        
    
    private void jList1KeyTyped(java.awt.event.KeyEvent evt) {                                
        if (evt.getKeyChar() == '\n'){
            int index = jList1.getSelectedIndex();
            switch(index){
                case 0:
                    SensorActive.this.dispose();
                    this.dispose();
                    Results resultantData = new Results();
                    resultantData.setVisible(true);
                    resultantData.init("/home/pi/CurrentTest/" + reportFile);
                    break;
                case 1:
                    SensorActive.this.dispose();
                    this.dispose();
                    SensorActive newSensor = null;
                    try {
                        newSensor = new SensorActive();
                    } catch (Exception ex) {
                        Logger.getLogger(SensorActive.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    newSensor.startSensor();
                    
                    break;
                case 2:
                    SensorActive.this.dispose();
                    this.dispose();
                    break;
                default:
                    break;
            }
        }
        else if (evt.getKeyChar() == 'q'){
            SensorActive.this.dispose();
            this.dispose();
        }
    }                               

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
    }
   
    
}
