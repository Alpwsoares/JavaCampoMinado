 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

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
                matriz[i][j].adicionarVizinhos(matriz[]);
            }  
        }
    }
}