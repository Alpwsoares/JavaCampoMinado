package campominadolp1;

import java.awt.event.MouseEvent;
import java.awt.Image;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class JButtonGrade extends JButton {

    int linha;
    int coluna;
    Campo campoLg;
    Grade gradeLg;
    JFrameCampo campoGrafico;
    String text;

    public JButtonGrade(Campo c, JFrameCampo cpg) {
        this.campoGrafico = cpg;
        this.text = "";
        this.setText(text);
        this.campoLg = c;
        this.addActionListener((java.awt.event.ActionEvent evt) -> {
            Pressionado(false);
        });
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    Pressionado(true);
                }
            }
        });

    }

    public void reset() {
        this.gradeLg.reset();
        this.text = "";
        this.setText(text);
        this.setEnabled(true);
        this.setIcon(null);
    }

    JButtonGrade(Campo c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void Pressionado(boolean BotaoDireito) {
        if (!BotaoDireito) { //botao esquerdo
            if (!this.gradeLg.marcado) {
                this.clicar();
            }
        } else {
            this.marcar();
        }
        this.campoGrafico.checkEstado();
    }

    public void clicar() {
        System.out.println("linha: " + linha + " coluna: " + coluna);

        //Retorna numVizinhosMinados se Espaco Atual NAAAAO POSSUI MINA
        int numVizinhosMinados = gradeLg.clicar();

        if (this.gradeLg.minada) {
            this.campoGrafico.revelarMinas();
        }
        if (this.gradeLg.revelado) {
            this.campoGrafico.revelarAbertos();
        }

        if (numVizinhosMinados == 0) {
            for (Grade vizinha : gradeLg.vizinhos) {
                if (!vizinha.clicada) {
                    vizinha.button.clicar();
                }
            }
            //return;
        }
        this.text = Integer.toString(numVizinhosMinados);
        this.revela(this.text);

    }

    public void marcar() {
        if (this.gradeLg.clicada) {
            return;
        }
        boolean estaMarcado = this.gradeLg.marcar();
        if (this.gradeLg.marcado) {
            try {
                Image img = ImageIO.read(getClass().getResource("pato.png"));
                img = img.getScaledInstance(C.TAM_GRADE, C.TAM_GRADE, java.awt.Image.SCALE_SMOOTH);
                this.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                this.setText("M");
                System.out.println("ERRO!");
            }
        } else {
            this.setIcon(null);
            this.setText("");
        }
    }

    public void setPos(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.gradeLg = campoLg.getGrade(linha, coluna);
    }

    public void revela(String cod) {

        if (cod.equals("-1")) {
            try {
                Image img = ImageIO.read(getClass().getResource("nando.png"));
                img = img.getScaledInstance(C.TAM_GRADE, C.TAM_GRADE, java.awt.Image.SCALE_SMOOTH);
                this.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                this.setText("-1");
                System.out.println("ERRO!");
            }
        } else {
            this.setText(cod);
            //matBut[i][j].setLayout( null );
            //matBut[i][j].setBackground(Color.black);
        }

        this.setEnabled(false);
    }
}
