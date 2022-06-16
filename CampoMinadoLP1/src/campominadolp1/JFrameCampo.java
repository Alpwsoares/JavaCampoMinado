package campominadolp1;

import javax.swing.JFrame;//tela visual
import javax.swing.JPanel;

public class JFrameCampo extends JFrame {

    JPanel panel;
    JButtonGrade[][] matBut;
    Campo c;

    public JFrameCampo(Campo c) {
        confIniciais();
        this.c = c;
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matBut = new JButtonGrade[C.NUM_LINHAS][C.NUM_COLUNAS];
        int n = 0;
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                //matriz de botoes do jogo
                matBut[i][j] = new JButtonGrade(this.c);
                matBut[i][j].linha = i;
                matBut[i][j].coluna = j;
                matBut[i][j].setPos(i, j);
                matBut[i][j].setSize(C.TAM_GRADE, C.TAM_GRADE);
                matBut[i][j].setFocusable(false);
                matBut[i][j].setLocation(C.TAM_GRADE * j, C.TAM_GRADE * i + C.CONF_SUP);
                matBut[i][j].setText(Integer.toString(n++));
                panel.add(matBut[i][j]);
            }
        }

    }

    private void confIniciais() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(C.NUM_COLUNAS * C.TAM_GRADE, C.NUM_LINHAS * C.TAM_GRADE + C.CONF_SUP + C.ALTURA_SUP);
        this.setResizable(false);
        this.setVisible(true);
    }

}
