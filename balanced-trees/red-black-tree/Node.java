public class Node {

    enum Color {
        VERMELHO, PRETO;
    }

    Node left;
    Node right;
    Node parent;
    int value;
    Color cor;

    Node(int value, Color cor) {
        this.value = value;
        this.cor = cor;
    }
}
