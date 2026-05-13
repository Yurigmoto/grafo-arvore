package view;

import model.Grafo;

public class GrafoView {

    private Grafo grafo;

    public GrafoView(Grafo grafo) {
        this.grafo = grafo;
    }

    public void exibirGrafo() {
        System.out.println("Grafo original (lista de adjacência)");
        for (int i = 0; i < grafo.numVertices; i++) {
            System.out.print("  " + i + " -> ");
            Grafo.No atual = grafo.listaAdj[i];
            while (atual != null) {
                System.out.print(atual.vertice);
                if (atual.proximo != null) System.out.print(" -> ");
                atual = atual.proximo;
            }
            System.out.println(" (null)");
        }
    }

    public void exibirArvore() {
        System.out.println("\nÁrvore");
        System.out.println("Arestas da árvore (peso 1):");

        int totalArestas = 0;
        for (int v = 0; v < grafo.numVertices; v++) {
            if (grafo.pai[v] >= 0) {
                System.out.println("  " + grafo.pai[v] + " -- " + v + "  (peso: 1)");
                totalArestas++;
            }
        }

        System.out.println("\nPai de cada nó:");
        for (int v = 0; v < grafo.numVertices; v++) {
            if (grafo.pai[v] == -1)
                System.out.println("  Nó " + v + " = raiz");
            else if (grafo.pai[v] >= 0)
                System.out.println("  Nó " + v + " -> pai: " + grafo.pai[v]);
        }

        System.out.println("\nTotal de arestas: " + totalArestas
                + " (esperado: " + (grafo.numVertices - 1) + ")");
    }
}