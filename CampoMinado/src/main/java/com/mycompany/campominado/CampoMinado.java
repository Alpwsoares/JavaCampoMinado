/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.campominado;

import java.util.Random;

/**
 *
 * @author andre
 */
public class CampoMinado {

    public static void main(String[] args) {         
    Campo c = new Campo();
    c.adicionarMinas();
    System.out.println(c);
    }
}
