package campominadolp1;

import javax.swing.JFrame;//tela visual
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class JFrameCampo extends JFrame {

    JPanel panel;
    JButtonGrade[][] matBut;
    Campo c;
    JButton resetBut;

    JButton facilBut;
    JButton medBut;
    JButton difBut;
    JButton custBut;

    public JFrameCampo(Campo c) {
        confIniciais();
    }

    JFrameCampo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void hardReset() {
        CampoMinadoLP1.hardReset();
        this.dispose();
    }

    private void confIniciais() {
        this.c =new Campo();
        c.adicionarMinas();
        this.panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        matBut = new JButtonGrade[C.NUM_LINHAS][C.NUM_COLUNAS];
        int n = 0;
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                //matriz de botoes do jogo
                matBut[i][j] = new JButtonGrade(this.c, this);
                c.getGrade(i,j).setButton(matBut[i][j]);
                matBut[i][j].setPos(i, j);
                matBut[i][j].setSize(C.TAM_GRADE, C.TAM_GRADE);
                matBut[i][j].setFocusable(false);
                matBut[i][j].setLocation(C.TAM_GRADE * j, C.TAM_GRADE * i + C.CONF_SUP);
                //matBut[i][j].setText(Integer.toString(n++));
                panel.add(matBut[i][j]);
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(C.NUM_COLUNAS * C.TAM_GRADE, C.NUM_LINHAS * C.TAM_GRADE + C.CONF_SUP + C.ALTURA_SUP);
        this.setResizable(false);
        this.setVisible(true);

        this.resetBut = new JButton();
        this.resetBut.addActionListener((java.awt.event.ActionEvent evt) -> {

            this.reset();
        });
        this.resetBut.setSize(C.TAM_GRADE, C.TAM_GRADE);
        this.resetBut.setLocation((C.TAM_GRADE * C.NUM_COLUNAS) / 2 - C.TAM_GRADE / 2, C.CONF_SUP - C.TAM_GRADE);
        this.panel.add(this.resetBut);
        //5x5 espacos de tamanho 10x10
        //o botao reset deveria estar na posicao 20        
        //

        this.facilBut = new JButton("F");
        this.facilBut.addActionListener((java.awt.event.ActionEvent evt) -> {
            C.NUM_COLUNAS = 6;
            C.NUM_LINHAS = 6;
            C.NUM_MINAS = 6;
            this.hardReset();
        });
        this.facilBut.setSize((C.TAM_GRADE * C.NUM_COLUNAS) / 4, C.TAM_GRADE);
        this.facilBut.setLocation(0, 0);
        this.panel.add(this.facilBut);

        this.medBut = new JButton("M");
        this.medBut.addActionListener((java.awt.event.ActionEvent evt) -> {
            C.NUM_COLUNAS = 10;
            C.NUM_LINHAS = 10;
            C.NUM_MINAS = 15;
            this.hardReset();
        });
        this.medBut.setSize((C.TAM_GRADE * C.NUM_COLUNAS) / 4, C.TAM_GRADE);
        this.medBut.setLocation((C.TAM_GRADE * C.NUM_COLUNAS) / 4, 0);
        this.panel.add(this.medBut);

        this.difBut = new JButton("D");
        this.difBut.addActionListener((java.awt.event.ActionEvent evt) -> {
            C.NUM_COLUNAS = 16;
            C.NUM_LINHAS = 16;
            C.NUM_MINAS = 40;
            this.hardReset();

        });
        this.difBut.setSize((C.TAM_GRADE * C.NUM_COLUNAS) / 4, C.TAM_GRADE);
        this.difBut.setLocation((C.TAM_GRADE * C.NUM_COLUNAS) / 4 * 2, 0);
        this.panel.add(this.difBut);

        this.custBut = new JButton("C");
        this.custBut.addActionListener((java.awt.event.ActionEvent evt) -> {            
            int l = Integer.parseInt(JOptionPane.showInputDialog("Insira #linhas"));
            C.NUM_LINHAS = l;
            
            int c = Integer.parseInt(JOptionPane.showInputDialog("Insira #colunas"));
            C.NUM_COLUNAS = c;
            
            int m = Integer.parseInt(JOptionPane.showInputDialog("Insira #minas"));
            C.NUM_MINAS = m;
            
            this.hardReset();
            
        });
        this.custBut.setSize((C.TAM_GRADE * C.NUM_COLUNAS) / 4, C.TAM_GRADE);
        this.custBut.setLocation((C.TAM_GRADE * C.NUM_COLUNAS) / 4 * 3, 0);
        this.panel.add(this.custBut);
    }

     public void reset() {
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                matBut[i][j].reset();
            }
        }
        this.c.adicionarMinas();
    }

    public void revelarMinas() {
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                if (matBut[i][j].gradeLg.minada) {
                    matBut[i][j].revela("-1");
                }
            }
        }
    }

    public void desativaBotoes() {
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                matBut[i][j].setEnabled(false);
            }
        }
    }

    public void checkEstado() {
        System.out.println("Verificando se Ganhou ou Perdeu");
        if (this.c.Vencido()) {
            System.out.println("Venceu");
            this.desativaBotoes();
        }

        if (this.c.Perdido()) {
            System.out.println("Perdeu");
            this.desativaBotoes();
        }

    }
}
