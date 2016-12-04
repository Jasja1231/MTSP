/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author Krzysztof
 */
public class AlgorithmChoicesPanel extends javax.swing.JPanel {

    String[] algorithmNames= {   
                "mixed integer programming algorithm",
                "dynamic programming algprithm",
                "burute-force algorithm",
                "heuristic",
                "approximation algorithm"
    };
    
    JCheckBox[] checkBoxes = new JCheckBox[algorithmNames.length]; 
    MainView parentView;
    /**
     * Creates new form AlgorithmChoicesPanel
     */
    public AlgorithmChoicesPanel(MainView mainView) {
        initComponents();
        this.parentView = mainView;
        this.setBackground(Color.WHITE);
        this.setMaximumSize(new Dimension(400,150));
        createCheckBoxes();
        addCheckBoxes();
    }

    
    private void createCheckBoxes(){
        int i; 
        for(i=0; i< algorithmNames.length; i++){
            JCheckBox c = new JCheckBox(algorithmNames[i]);
            //add to panel  
            checkBoxes[i] = c;
        }
    }
    
    private void addCheckBoxes(){
        for (JCheckBox jc  : checkBoxes){
            this.add(jc);
            jc.setVisible(true);
            jc.setBackground(Color.WHITE);
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        setLayout(new java.awt.GridLayout(5, 0, 10, 10));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    void readSelectedAlgorithms() {
       for(int i = 0; i < checkBoxes.length; i++){
           if(checkBoxes[i].isSelected()){
               this.parentView.addAlgorithm(i);
           }
       }
    }

}
