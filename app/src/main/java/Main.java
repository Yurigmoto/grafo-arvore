import model.Grafo;
import controller.GrafoController;
import view.GrafoView;

public class Main {

    public static void main(String[] args) {
    
        Grafo grafo = new Grafo(6);

        grafo.adicionarAresta(0, 1);
        grafo.adicionarAresta(0, 2);
        grafo.adicionarAresta(1, 2); 
        grafo.adicionarAresta(1, 3);
        grafo.adicionarAresta(2, 3); 
        grafo.adicionarAresta(3, 4);
        grafo.adicionarAresta(3, 5);
        grafo.adicionarAresta(4, 5); 

        GrafoView view = new GrafoView(grafo);
        GrafoController controller = new GrafoController(grafo);

        view.exibirGrafo();
        controller.bfs(0);
        view.exibirArvore();
    }
}
