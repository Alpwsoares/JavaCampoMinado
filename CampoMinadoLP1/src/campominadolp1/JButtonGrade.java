package campominadolp1;

import javax.swing.JButton;

public class JButtonGrade extends JButton {

    int linha;
    int coluna;
    Campo c;
    String text;

    public JButtonGrade(Campo c, JFrameCampo cpg) {
        //this.campoGrafico =cpg;
        this.text = "";
        this.setText(text);
        this.c = c;
        this.addActionListener((java.awt.event.ActionEvent evt) -> {
            Pressionado(evt);
        });
    }

    private void Pressionado(java.awt.event.ActionEvent evt) {
        int ret = c.clicar(linha, coluna);
        this.text = Integer.toString(ret);
        this.setText(text);
        this.setEnabled(false);
    }

    public void setPos(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

}
