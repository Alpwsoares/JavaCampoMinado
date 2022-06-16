/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import javax.swing.JButton;

/**
 *
 * @author andre
 */
public class JButtonGrade extends JButton{
    int linha;
    int coluna;
    Campo c;
    String text;
    
    public JButtonGrade(Campo c, JFrameCampo cpg){
      //this.campoGrafico =cpg;
      this.text = "";
      this.setText(text);
      this.c = c;
      this.addActionListener((java.awt.event.ActionEvent evt) -> { 
             Pressionado(evt);
      });
    }  

    JButtonGrade(Campo c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void Pressionado(java.awt.event.ActionEvent evt){
            int ret = c.clicar(linha, coluna);
            this.text = Integer.toString(ret);
            this.setText(text);
            this.setEnabled(false);
        }  
     
    public void setPos(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;   
    }
   
}
