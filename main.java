public class main {
    public static void main(String[] args) {
        arvore ar = new arvore();

        ar.Adicionar(65);
        ar.Adicionar(95);
        ar.Adicionar(125);
        ar.Adicionar(35);
        ar.Adicionar(5);

        Node n = ar.buscar(5);
        System.out.println(n.info);

        ar.Adicionar(25);

        n = ar.buscar(25);
        System.out.println(n.info);
    }
}