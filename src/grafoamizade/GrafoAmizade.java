package grafoamizade;

public class GrafoAmizade {

    static final int ordem = 4;
    static int[][] matriz = new int[ordem][ordem];
    static String[] visinho = {"Maria", "Joane", "Pedro", "Luiz"};

    public static void inializa() {
        for (int i = 0; i < ordem; i++) //Linha
        {
            for (int j = 0; j < ordem; j++) //coluna
            {
                matriz[i][j] = 0;
            }
        }
    }

    public static void conecta(int v, int w) {
        matriz[v][w] = 1;
        matriz[w][v] = 1;
    }

    public static void desconecta(int v, int w) {
        matriz[v][w] = 0;
        matriz[w][v] = 0;
    }

    public static void imprime() {
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void imprimeVisinhos(int v) {
        System.out.print("Visinhos do " + visinho[v] + ": ");
        for (int j = 0; j < ordem; j++) {//colunas
            if (matriz[v][j] == 1) {
                System.out.print(visinho[j] + " ");
            }
        }
        System.out.print("\n");
    }

    public static Boolean isRegular() {
       int grauPadrao = grauDeAdjacencia(0);
       for (int j = 0; j < ordem; j++) {//colunas
            if(grauDeAdjacencia(j)!= grauPadrao){
                return false;
            }
        }
        return true;
    }
    
    public static Boolean isCompleto() {
       int grauPadrao = ordem - 1;
       for (int j = 0; j < ordem; j++) {//colunas
            if(grauDeAdjacencia(j)!= grauPadrao){
                return false;
            }
        }
        return true;
    }

    public static int grauDeAdjacencia(int v) {
        int qtd = 0;
        for (int j = 0; j < ordem; j++) {//colunas
            if (matriz[v][j] == 1) {
                qtd++;
            }
        }
       return qtd;
    }

    public static void main(String[] args) {
        inializa();
        //imprime();
        conecta(0, 1);
        conecta(1, 3);
        conecta(2, 3);
        conecta(0, 2);
        imprime();
        
        System.out.println("Grafo regular:"+isCompleto());
//        imprimeVisinhos(0);
//        grauDeAdjacencia(0);

//        desconecta(0, 1);
//        imprime();
//        imprimeVisinhos(0);
//        grauDeAdjacencia(0);
    }

}
