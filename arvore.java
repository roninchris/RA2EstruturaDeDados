

public class arvore {

    Node raiz;

    public arvore() {
        raiz = null;
    }

    public void Adicionar(int valor) {
        Node novo = new Node();
        novo.info = valor;
        novo.direita = null;
        novo.esquerda = null;

        if (raiz == null) {
            raiz = novo;
            return;
        }

        Node atual = raiz;
        Node anterior;
        while (true) {
            anterior = atual;
            if (valor <= atual.info) {
                if (atual.esquerda == null) {
                    anterior.esquerda = novo;
                    return;
                }
                atual = atual.esquerda;
            } else {
                if (atual.direita == null) {
                    anterior.direita = novo;
                    return;
                }
                atual = atual.direita;
            }
        }
    }

    public Node buscar(int elemento) {
        Node atual = raiz;
        List<Node> caminho = new ArrayList<>();
        while (atual != null && atual.info != elemento) {
            caminho.add(atual);
            if (atual.info > elemento)
                atual = atual.esquerda;
            else
                atual = atual.direita;
        }
        if (atual == null)
            return null;
        return atual;
    }

    public static int Altura(Node no) {
        if (no == null) {
            return -1;
        }
        int esquerda = Altura(no.esquerda);
        int direita = Altura(no.direita);
        if (esquerda > direita)
            return 1 + esquerda;
        return 1 + direita;
    }

    public Node RotDireita(Node no) {
        Node novaRaiz = no.esquerda;
        Node temp = novaRaiz.direita;
        novaRaiz.direita = no;
        no.esquerda = temp;
        return novaRaiz;
    }

    public Node RotEsquerda(Node no) {
        Node novaRaiz = no.direita;
        Node temp = novaRaiz.esquerda;
        novaRaiz.esquerda = no;
        no.direita = temp;
        return novaRaiz;
    }

    public void imprimirArvore(Node no) {
        if (no == null)
            return;
        imprimirArvore(no.esquerda);
        System.out.println(no.info);
        imprimirArvore(no.direita);
    }

    public Graph gerarGrafo(Node no) {
        Graph g = new SingleGraph("Arvore");
        g.setAutoCreate(true);
        g.setStrict(false);

        Node n = g.addNode(no.info);
        g.addAttribute("ui.label", no.info);

        if (no.esquerda != null) {
            Node nE = gerarGrafo(no.esquerda);
            g.addEdge("E", n, nE);
        }

        if (no.direita != null) {
            Node nD = gerarGrafo(no.direita);
            g.addEdge("D", n, nD);
        }

        return g;
    }

    public static void main(String[] args) {
        arvore ar = new arvore();

        ar.Adicionar(65);
        ar.Adicionar(95);
        ar.A```
    }
}