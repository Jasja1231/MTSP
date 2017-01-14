/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.AlgorithmSolution;
import Model.Model;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JTextField;
import org.openstreetmap.gui.jmapviewer.Coordinate;

/**
 *
 * @author K
 */
public class MainView extends javax.swing.JFrame implements Observer , ActionListener{

    //elements
    private MapPanel mapPanel;
    private JMenu fileMenu;
    private OptionsPanel optionsPanel;
    private final JFileChooser FILE_CHOOSER = new JFileChooser();
      
    //MVC
    public  final Model model;
    private final Controller controller;
    
    /**
     * Creates new form MainView
     * @param model  application model
     * @param controller application controller
     */
    public MainView(Model model, Controller controller) {
        initComponents();
        init();
        
        //set window parameters
        this.setSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(500,500));
        
         //connect to model and controller 
        this.model = model;
        this.controller = controller; 
        this.model.addObserver(this);
        controller.setMainView(this);

        this.constructMenu();
        this.fileMenu.add(new JTextField("   Seach ....  "));
        
        this.pack();
    }

  

    /**
     * Initiates elements of MainView Class 
     */
    private void init(){
        mapPanel = new MapPanel(this);
        optionsPanel = new OptionsPanel(this);
        //Add Map in the centre
        this.add(mapPanel,BorderLayout.CENTER);
        this.add(optionsPanel,BorderLayout.WEST);
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info :  javax.swing.UIManager.getInstalledLookAndFeels()) {
                  if ("Nimbus".equals(info.getName())) {
                     javax.swing.UIManager.setLookAndFeel(info.getClassName());
                     break;
                  }
            }
         }catch(Exception e){}
    }
    
    
    private void constructMenu(){
      fileMenu = new JMenu("File");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        loadFilejMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        saveSolutionScreenShotMenuItem = new javax.swing.JMenuItem();
        saveinputMenuItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        EditInputMenuItem = new javax.swing.JMenuItem();
        resetMenuItem = new javax.swing.JMenuItem();
        clearAllRoadsjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuBar1.setBackground(new java.awt.Color(0, 204, 204));

        FileMenu.setText("File");
        FileMenu.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                FileMenuStateChanged(evt);
            }
        });

        loadFilejMenuItem.setText("Load input file");
        loadFilejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFilejMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(loadFilejMenuItem);

        jMenuItem1.setText("Generate multiple random files");
        jMenuItem1.setVisible(false);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        FileMenu.add(jMenuItem1);

        saveSolutionScreenShotMenuItem.setText("Save solution screenshot");
        saveSolutionScreenShotMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSolutionScreenShotMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveSolutionScreenShotMenuItem);

        saveinputMenuItem.setText("Save input file");
        saveinputMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveinputMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveinputMenuItem);

        jMenuBar1.add(FileMenu);

        EditMenu.setText("Edit");

        EditInputMenuItem.setText("Edit input data");
        EditInputMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditInputMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(EditInputMenuItem);

        resetMenuItem.setText("Reset data");
        resetMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(resetMenuItem);

        clearAllRoadsjMenuItem.setText("Clear all roads");
        clearAllRoadsjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllRoadsjMenuItemActionPerformed(evt);
            }
        });
        EditMenu.add(clearAllRoadsjMenuItem);

        jMenuBar1.add(EditMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFilejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFilejMenuItemActionPerformed
        FILE_CHOOSER.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = FILE_CHOOSER.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = FILE_CHOOSER.getSelectedFile();
                this.controller.loadInputFile(file);
            } 
            catch (Exception ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loadFilejMenuItemActionPerformed

    private void FileMenuStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_FileMenuStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_FileMenuStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void EditInputMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditInputMenuItemActionPerformed
        this.optionsPanel.setVisible(true);
    }//GEN-LAST:event_EditInputMenuItemActionPerformed

    private void resetMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMenuItemActionPerformed
        this.mapPanel.clearMap();
        this.controller.resetData();
    }//GEN-LAST:event_resetMenuItemActionPerformed

    private void clearAllRoadsjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllRoadsjMenuItemActionPerformed
        this.mapPanel.clearAllRoads();
    }//GEN-LAST:event_clearAllRoadsjMenuItemActionPerformed

    private void saveSolutionScreenShotMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSolutionScreenShotMenuItemActionPerformed
         //open directory chooser to choose which directory to open to save file into
        FILE_CHOOSER.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = FILE_CHOOSER.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            this.controller.saveSolutionScreenShot(this.mapPanel,FILE_CHOOSER.getSelectedFile());
        }
    }//GEN-LAST:event_saveSolutionScreenShotMenuItemActionPerformed

    private void saveinputMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveinputMenuItemActionPerformed
        //open file chooser to choose direcrtory
        this.model.setSalesmenCount(this.optionsPanel.getSalesmanCount());
         FILE_CHOOSER.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = FILE_CHOOSER.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            this.controller.saveInputFile(FILE_CHOOSER.getSelectedFile());
        }
    }//GEN-LAST:event_saveinputMenuItemActionPerformed

    /***
     * 
     * @param o
     * @param arg : arg == 1 loaded new input file
     *              arg == ArrayList list of dots in order they should be connected
     */
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof AlgorithmSolution){
            AlgorithmSolution algSol = (AlgorithmSolution)arg;
            this.optionsPanel.displaySolution(algSol.getCycles()); //TODO: change to take whole solution
            
            if(this.model.getSelectedMetric() != 0)
                this.mapPanel.drawCycles(algSol.getCycles());
            else
                this.mapPanel.drawCyclesEuclideanLines(algSol.getCycles());
        }
        int argInt = -1;
        try{
            argInt = (int) arg;
        }catch(Exception e){}
        
        if(argInt == 1){
            //clear map
            this.mapPanel.clearMap();
            //set new markers with their ids
            this.mapPanel.setNewMarkerDots(this.model.getCoordinates());
            // set num of salesman in checkbox
            this.optionsPanel.inputDataPanel.setNumOfSalesmanTextField(this.model.getSalesmenCount());
        }
    }

    /**
     * @param args the command line arguments
     */
   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EditInputMenuItem;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem clearAllRoadsjMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem loadFilejMenuItem;
    private javax.swing.JMenuItem resetMenuItem;
    private javax.swing.JMenuItem saveSolutionScreenShotMenuItem;
    private javax.swing.JMenuItem saveinputMenuItem;
    // End of variables declaration//GEN-END:variables

    void addCoordinate(Coordinate coo) {
       this.controller.addCoordinate(coo);
    }

    void addAlgorithm(int i) {
        this.controller.addAlgorithm(i);
    }

    void clearAlgorithms() {
       controller.clearAlgorithms();
    }

    void setSalesmenCount(int salesmanCount) {
        this.controller.setSalesmen(salesmanCount);
    }
    
  
    void startComputation() {
       controller.startComputation();
    }

    void setSelectedMetric(int selectedMetric) {
        this.controller.setSelectedMetric(selectedMetric);
    }

    void clearModelMapData() {
        this.controller.resetData();
    }

     void setNewStartingPoint(Coordinate co) {
       this.controller.setNewStartingPoint(co);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
