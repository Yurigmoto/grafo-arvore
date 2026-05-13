package model;
public class Grafo {

    public static class No {
        public int vertice;
        public No proximo;

        public No(int vertice) {
            this.vertice = vertice;
            this.proximo = null;
        }
    }

    public static class Fila {
        int[] dados;
        int inicio, fim, tamanho;

        public Fila(int capacidade) {
            dados = new int[capacidade];
            inicio = 0;
            fim = 0;
            tamanho = 0;
        }

        public void enfileirar(int x) {
            dados[fim] = x;
            fim = (fim + 1) % dados.length;
            tamanho++;
        }

        public int desenfileirar() {
            int x = dados[inicio];
            inicio = (inicio + 1) % dados.length;
            tamanho--;
            return x;
        }

        public boolean estaVazia() {
            return tamanho == 0;
        }
    }

    public int  numVertices;
    public No[] listaAdj;   
   
    public int[] pai;     

    public Grafo(int n) {
        numVertices = n;
        listaAdj = new No[n];
        pai = new int[n];

        for (int i = 0; i < n; i++) {
            listaAdj[i] = null;
            pai[i]      = -2;
        }
    }

    public void adicionarAresta(int u, int v) {
        No novoU = new No(v);
        novoU.proximo = listaAdj[u];
        listaAdj[u] = novoU;

        No novoV = new No(u);
        novoV.proximo = listaAdj[v];
        listaAdj[v] = novoV;
    }
}
