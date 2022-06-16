package campominadolp1;

import java.util.ArrayList;

public class Grade {

    boolean minada;
    boolean revelado;
    boolean marcado;
    boolean clicada;

    ArrayList<Grade> vizinhos;
    JButtonGrade button;

    public Grade() {
        this.minada = false;
        this.revelado = false;
        this.marcado = false;
        this.clicada = false;

        this.vizinhos = new ArrayList();
    }

    public void adicionarVizinhos(Grade e) {
        this.vizinhos.add(e);
    }

    public boolean minar() {
        if (!this.minada) {
            this.minada = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean marcar() {
        this.marcado = !this.marcado;
        return this.marcado;
    }

    //-1 clicou em uma mina
    //0 não possui minas nos vizinhos
    //n possui n minas nos vizinhos
    public int clicar() {
        this.clicada = true;
        if (this.minada) {
            return -1;
        } else {
            return numMinasNosVizinhos();
        }
    }

    public int numMinasNosVizinhos() {
        int n = 0;
        for (Grade vizinha : this.vizinhos) {
            if (vizinha.minada) {
                n++;
            }
        }
        return n;
    }

    public void reset() {
        this.minada = false;
        this.revelado = false;
        this.marcado = false;
        this.clicada = false;
    }
      public boolean Finalizado(){
        if(this.minada && this.marcado) return true;
        if(!this.minada && !this.marcado && this.clicada) return true;
        return false;
    }
    
    public void setButton(JButtonGrade button){
        this.button = button;
    }
    @Override
    public String toString() {
        if (this.minada)
            return "-1";
        return "+" + this.numMinasNosVizinhos();
    }

}
