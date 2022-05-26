/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.campominado;

/**
 *
 * @author andre
 */
public class CampoMinado {

    public static void main(String[] args) {
        Grade e1 = new Grade();
        Grade e2 = new Grade();
        e1.adicionarVizinhos(e2);
        e2.minar();
        System.out.println(e1.clicar());
    }
}
