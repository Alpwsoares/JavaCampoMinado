 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import java.util.Random;

/**
 *
 * @author andre
 */
public class Campo {
    Grade[][] matriz;
    
    public Campo(){
    matriz = new Grade[C.NUM_LINHAS][C.NUM_COLUNAS];
        for (int i=0; i<C.NUM_LINHAS; i++){
            for (int j=0; j<C.NUM_COLUNAS; j++){
                matriz[i][j] = new Grade();
            }  
        }
         for (int i=0; i<C.NUM_LINHAS; i++){
            for (int j=0; j<C.NUM_COLUNAS; j++){
                if (i>0){
                    if (j>0)matriz[i][j].adicionarVizinhos(matriz[i-1][j-1]);
                    matriz[i][j].adicionarVizinhos(matriz[i-1][j]);
                    if (j < C.NUM_COLUNAS-1) matriz[i][j].adicionarVizinhos(matriz[i-1][j+1]);
                }
                if(j>0) matriz[i][j].adicionarVizinhos(matriz[i][j-1]);
                if (j < C.NUM_COLUNAS-1)matriz[i][j].adicionarVizinhos(matriz[i][j+1]);
                
                if (i < C.NUM_LINHAS-1){
                    if(j>0)matriz[i][j].adicionarVizinhos(matriz[i+1][j-1]);
                    matriz[i][j].adicionarVizinhos(matriz[i+1][j]);
                    if (j < C.NUM_COLUNAS-1)matriz[i][j].adicionarVizinhos(matriz[i+1][j+1]);
                }
            }  
        }
    }

    public void adicionarMinas(){
         int n = C.NUM_MINAS;
         
         while (n>0){
             Random rand = new Random();
             int l =rand.nextInt(C.NUM_LINHAS);
             int c = rand.nextInt(C.NUM_COLUNAS);
             
             if(matriz[l][c].minar()){ 
                 n--;
             }
         }
    }

    @Override
    public String toString() {
        String str = "";
        
        for(int i = 0; i<C.NUM_LINHAS; i++){
            for(int j = 0; j<C.NUM_COLUNAS; j++){
                str += matriz[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}