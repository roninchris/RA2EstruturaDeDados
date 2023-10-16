public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivamente(raiz, valor);
    }

    private No inserirRecursivamente(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivamente(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivamente(atual.direita, valor);
        }

        return atual;
    }

    public boolean buscar(int valor) {
        return buscarRecursivamente(raiz, valor);
    }

    private boolean buscarRecursivamente(No atual, int valor) {
        if (atual == null) {
            return false;
        }

        if (valor == atual.valor) {
            return true;
        }

        return valor < atual.valor
                ? buscarRecursivamente(atual.esquerda, valor)
                : buscarRecursivamente(atual.direita, valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivamente(raiz, valor);
    }

    private No removerRecursivamente(No atual, int valor) {
        if (atual == null) {
            return null;
        }

        if (valor == atual.valor) {
            if (atual.esquerda == null) {
                return atual.direita;
            } else if (atual.direita == null) {
                return atual.esquerda;
            }

            atual.valor = encontrarMenorValor(atual.direita);
            atual.direita = removerRecursivamente(atual.direita, atual.valor);
        } else if (valor < atual.valor) {
            atual.esquerda = removerRecursivamente(atual.esquerda, valor);
        } else {
            atual.direita = removerRecursivamente(atual.direita, valor);
        }

        return atual;
    }

    private int encontrarMenorValor(No no) {
        return no.esquerda == null ? no.valor : encontrarMenorValor(no.esquerda);
    }

    private class No {
        int valor;
        No esquerda;
        No direita;

        No(int valor) {
            this.valor = valor;
            esquerda = null;
            direita = null;
        }
    }
}
