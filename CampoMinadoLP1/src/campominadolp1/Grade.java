package campominadolp1;

import java.util.ArrayList;

//representa cada espaco da matriz (botao)
public class Grade {

    boolean minada;
    boolean revelado;
    boolean marcado;
    boolean clicada;
    
    //cada espaco sabe seu numero de vizinhos
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
            this.revelado = true;
            return numMinasNosVizinhos();
        }
    }

    public int numMinasNosVizinhos() {
        int n = 0;
        /*
        percorre todos os vizinhos
        quando encontra um vizinho minado
        incrementa no n
         */
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
    
    //estado do botao
    public boolean Finalizado() {
        //quando o botao esta minado e tem bandeira
        if (this.minada && this.marcado) {
            return true;
        }
        //quando o botao nao tem mina nem bandeira e eh clicado
        if (!this.minada && !this.marcado && this.clicada) {
            return true;
        }
        //quando eh utilizavel o botao: nao foi clicado,
        //bandeira foi marcada no local errado
        return false;
    }

    public void setButton(JButtonGrade button) {
        this.button = button;
    }

    @Override
    public String toString() {
        if (this.minada) {
            return "-1";
        }
        return "+" + this.numMinasNosVizinhos();
    }

}
