/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import javax.swing.JFrame;//tela visual
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class JFrameCampo extends JFrame{
    JPanel panel;
    JButtonGrade[][] matBut;
    Campo c;
    
    public JFrameCampo(Campo c){
        this.c = c;
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matBut = new JButtonGrade[C.NUM_LINHAS][C.NUM_COLUNAS];
        int n=0;
        for(int i = 0; i<C.NUM_LINHAS; i++){
            for(int j = 0; j<C.NUM_COLUNAS; j++){
                matBut[i][j] = new JButtonGrade(this.c);
                matBut[i][j].linha = i;
                matBut[i][j].coluna = j;
                matBut[i][j].setSize(30,30);
                matBut[i][j].setLocation(30*j, 30*i);
                matBut[i][j].setText(Integer.toString(n++));
                panel.add(matBut[i][j]);
            } 
        }
        confIniciais();
    }
    private void confIniciais(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(C.NUM_COLUNAS*C.TAM_GRADE+15,C.NUM_LINHAS*C.TAM_GRADE+300);
        this.setResizable(false);
        this.setVisible(true);
    }

}
