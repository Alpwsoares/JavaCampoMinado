/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.campominado;

import java.util.ArrayList;

/**
 *
 * @author andre
 * @author matheus
 */
public class Grade {
    boolean minada;
    boolean revelado;
    boolean marcado;
    boolean clicado;
    
    ArrayList<Grade> vizinhos;
    JButtonGrade button;
    
    public Grade(){
        this.minada = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
        
        this.vizinhos = new ArrayList();
    }
    public void adicionarVizinhos(Grade e){
        this.vizinhos.add(e);
    }
    public boolean minar(){
        if(!this.minada){
            this.minada = true;
            return true;
        }else{
            return false;
        }
    }
    public boolean marcar(){
        this.marcado = !this.marcado;
        return this.marcado;
    }
    //-1 clicou em uma mina
    //0 não possui minas nos vizinhos
    //n possui n minas nos vizinhos
    public int clicar(){
        this.clicado =true;
        if(this.minada){
            return -1;
        }else{
            return numMinasNosVizinhos();
        }
    }
    public int numMinasNosVizinhos(){
        int n = 0;
        for(Grade vizinha: this.vizinhos){
            if(vizinha.minada) n++;
        }
        return n;
    }
    public void reset(){
        this.minada = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
    }

    @Override
    public String toString() {
        if(this.minada)
            return "-1";
        return "+" + this.numMinasNosVizinhos();
    }
    
}
