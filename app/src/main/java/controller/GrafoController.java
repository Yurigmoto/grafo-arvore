package controller;

import model.Grafo;

public class GrafoController {

    private Grafo grafo;

    public GrafoController(Grafo grafo) {
        this.grafo = grafo;
    }

    public void bfs(int raiz) {
        boolean[]  visitado = new boolean[grafo.numVertices];
        Grafo.Fila fila = new Grafo.Fila(grafo.numVertices);

        for (int i = 0; i < grafo.numVertices; i++) {
            visitado[i]  = false;
            grafo.pai[i] = -2;
        }

        visitado[raiz] = true;
        grafo.pai[raiz] = -1;
        fila.enfileirar(raiz);

        while (!fila.estaVazia()) {
            int atual = fila.desenfileirar();

            Grafo.No vizinho = grafo.listaAdj[atual];
            while (vizinho != null) {
                if (!visitado[vizinho.vertice]) {
                    visitado[vizinho.vertice]  = true;
                    grafo.pai[vizinho.vertice] = atual;
                    fila.enfileirar(vizinho.vertice);
                }
                vizinho = vizinho.proximo;
            }
        }
    }
}