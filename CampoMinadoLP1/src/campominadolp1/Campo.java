package campominadolp1;

import java.util.Random;

public class Campo {

    Grade[][] matriz;

    public Campo() {
        //instanciei a matriz
        matriz = new Grade[C.NUM_LINHAS][C.NUM_COLUNAS];
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                //povoei a matriz
                matriz[i][j] = new Grade();
            }
        }
        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                /*
                [0][0]  [0][1]  [0][2]
                [1][0]  [1][1]  [1][2]
                [2][0]  [2][1]  [2][2]
                 */
                //quando é i-1 para garantir que não acesse posição -1
                if (i > 0) {
                    //quando é j-1 para garantir que não acesse posição -1
                    if (j > 0) {
                        matriz[i][j].adicionarVizinhos(matriz[i - 1][j - 1]);
                    }
                    matriz[i][j].adicionarVizinhos(matriz[i - 1][j]);
                    //se j for 2, ele não pode acessar j+1
                    if (j < C.NUM_COLUNAS - 1) {
                        matriz[i][j].adicionarVizinhos(matriz[i - 1][j + 1]);
                    }
                }
                if (j > 0) {
                    matriz[i][j].adicionarVizinhos(matriz[i][j - 1]);
                }
                if (j < C.NUM_COLUNAS - 1) {
                    matriz[i][j].adicionarVizinhos(matriz[i][j + 1]);
                }

                if (i < C.NUM_LINHAS - 1) {
                    if (j > 0) {
                        matriz[i][j].adicionarVizinhos(matriz[i + 1][j - 1]);
                    }
                    matriz[i][j].adicionarVizinhos(matriz[i + 1][j]);
                    if (j < C.NUM_COLUNAS - 1) {
                        matriz[i][j].adicionarVizinhos(matriz[i + 1][j + 1]);
                    }
                }
            }
        }
    }

    public void adicionarMinas() {
        int n = C.NUM_MINAS;
        Random rand = new Random();
        while (n > 0) {
            int l = rand.nextInt(C.NUM_LINHAS);
            int c = rand.nextInt(C.NUM_COLUNAS);
            //evitar repetição de mina no espaço
            if (matriz[l][c].minar()) {
                n--;
            }
        }
        System.out.println(this);
    }

    public int clicar(int linha, int coluna) {
        return matriz[linha][coluna].clicar();
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < C.NUM_LINHAS; i++) {
            for (int j = 0; j < C.NUM_COLUNAS; j++) {
                str += matriz[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}
