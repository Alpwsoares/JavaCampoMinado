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
    boolean minado;
    boolean revelado;
    boolean marcado;
    boolean clicado;
    
    ArrayList<Grade> vizinhos;
    public Grade(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
        
        this.vizinhos = new ArrayList();
    }
    public void adicionarVizinhos(Grade e){
        this.vizinhos.add(e);
    }
    public boolean minar(){
        if(!this.minado){
            this.minado = true;
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
    //0 não possue minas nos vixzinhos
    //n possui n minas nos vizinhos
    public int clicar(){
        if(this.minado){
            return -1;
        }else{
            return numMinasNosVizinhos();
        }
    }
    public int numMinasNosVizinhos(){
        int n = 0;
        for(Grade e: this.vizinhos){
            if(e.minado) n++;
        }
        return n;
    }
    public void reset(){
        this.minado = false;
        this.revelado = false;
        this.marcado = false;
        this.clicado = false;
    }

    @Override
    public String toString() {
        if(minado)
            return "-1";
        return "+" + this.numMinasNosVizinhos();
    }
    
}
