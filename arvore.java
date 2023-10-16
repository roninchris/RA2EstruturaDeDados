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
            System.out.println("Raiz adicionada de valor: " + novo.getInfo());
        } else {
            Node atual = raiz;
            Node anterior;
            while (true) {
                anterior = atual;
                if (valor <= atual.info) {
                    atual = atual.esquerda;
                    if (atual == null) {
                        System.out.println("O pai desta folha eh: " + anterior.getInfo());
                        anterior.esquerda = novo;
                        System.out.println("O valor adicionado na esquerda foi: " + anterior.esquerda.getInfo());
                        return;
                    }
                } else {
                    atual = atual.direita;
                    if (atual == null) {
                        System.out.println("O pai desta folha eh: " + anterior.getInfo());
                        anterior.direita = novo;
                        System.out.println("O valor adicionado na direita foi: " + anterior.direita.getInfo());
                        return;
                    }
                }
            }
        }
    }

    public void emOrdem(Node atual) {
        if (atual != null) {
            emOrdem(atual.esquerda);
            System.out.println(atual.info + " ");
            emOrdem(atual.direita);
        }
    }

    public void preOrdem(Node atual) {
        if(atual != null) {
            System.out.println(atual.info + " ");
            preOrdem(atual.esquerda);
            preOrdem(atual.direita);
        }
    }

    public void posOrdem(Node atual) {
        if(atual != null) {
            posOrdem(atual.esquerda);
            posOrdem(atual.direita);
            System.out.println(atual.info + " ");
        }
    }
    public Node buscar(int elemento){
        Node atual = raiz;
        while(atual != null && atual.getInfo()!=elemento){
            if(atual.getInfo()>elemento)
                atual = atual.getEsquerda;
            else
                atual = atual.getDireita;
        }
        return null;    
    }
    public static int Altura(Node no){
        if (no == null){
            return -1;
        }
        int esquerda = Altura(no.esquerda);
        int direita = Altura(no.direita);
        if (esquerda > direita)
            return 1+ esquerda;
        return 1 + direita;
    }
    
    public Node RotDireita(Node no){
        Node novaRaiz = raiz.esquerda;
        Node temp = novaRaiz.esquerda;
        novaRaiz.direita = raiz;
        raiz.esquerda = temp;
        return novaRaiz;
        }
    public Node RotEsquerda(Node no){
        Node novaRaiz = raiz.direita;
        Node temp = novaRaiz.esquerda;
        novaRaiz.esquerda = raiz;
        raiz.direita = temp;
        return novaRaiz;
        }        
}

