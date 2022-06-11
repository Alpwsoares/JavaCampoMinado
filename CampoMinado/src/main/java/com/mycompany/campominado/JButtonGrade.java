/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import java.awt.event.ActionEvent;
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
    
    public JButtonGrade(Campo c){
      text = "";
      this.setText(text);
      this.c = c;
      this.addActionListener((java.awt.event.ActionEvent evt) -> { 
             Pressionado(evt);
      });
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
