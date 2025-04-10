import java.util.Scanner;

public class AVL {

    private Node root;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVL avl = new AVL();

        String[] entradas = sc.nextLine().split(" ");

        for(String i: entradas) {
            avl.add(Integer.parseInt(i));
        }

        avl.preOrder();

        System.out.println(avl.isAVL());

    }

    public boolean isAVL() {
        return isAVL(this.root);
    }

    private boolean isAVL(Node node) {
        if(node == null) {
            return true;
        }

        int balance = height(node.left) - height(node.right);

        if(balance < -1 || balance > 1 ) {
            return false;
        }

        return isAVL(node.left) && isAVL(node.right);

    }

    public void preOrder() {
        StringBuilder sb = new StringBuilder();

        preOrder(this.root, sb);
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.print(sb.toString());
        System.out.println();
    }


    private void preOrder(Node node, StringBuilder sb) {

        if(node == null) {
            return;
        }

        sb.append(node.value).append(" ");

        preOrder(node.left, sb);
        preOrder(node.right, sb);


    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if(isEmpty()) {
            this.root = newNode;
            return;
        }
        else {
        Node aux = this.root;
        while(aux != null) {
            if(element < aux.value) {
                if(aux.left == null) {
                    aux.left = newNode;
                    newNode.parent = aux;
                    rebalance(newNode, newNode);
                    return;
                }
                aux = aux.left;
            } else {
                if(aux.right == null) {
                    aux.right = newNode;
                    newNode.parent = aux;
                    rebalance(newNode, newNode);
                    return;
                }
                aux = aux.right;
            }
        }
    }
    }



    public void rebalance(Node node, Node newNode) {
        if(node == null) {
            return;
        }

        int balance = height(node.left) - height(node.right);

        if(balance == 0 || Math.abs(balance) == 1) {
            rebalance(node.parent, newNode);
            return;
        }


        else if(balance > 1) {
            boolean zigzag = zigZag(node.left, newNode, balance);

            if(zigzag) {
                rotacaoEsquerdaDireita(node);

            } else {
                    rotacaoParaDireita(node);
            }

        } else {
            boolean zigzag = zigZag(node.right, newNode, balance);

            if(zigzag) {
                rotacaoDireitaEsquerda(node);

            } else {
                rotacaoParaEsquerda(node);
            }
        }

    }


    public Node rotacaoParaEsquerda(Node pai) {
        Node novoPai = pai.right;
        pai.right = novoPai.left;

        if(novoPai.left != null) {
            novoPai.left.parent = pai;
        }

        novoPai.left = pai;
        novoPai.parent = pai.parent;

        if(pai == this.root) {
            this.root = novoPai;
        } else {

            if(pai == pai.parent.left) {
                pai.parent.left = novoPai;
            } else {
                pai.parent.right = novoPai;
            }
        }

        pai.parent = novoPai;
        return novoPai;
    }

    public Node rotacaoParaDireita(Node pai) {
        Node novoPai = pai.left;
        pai.left = novoPai.right;

        if(novoPai.right != null) {
            novoPai.right.parent = pai;
        }

        novoPai.right = pai;
        novoPai.parent = pai.parent;

        if(pai == this.root) {
            this.root = novoPai;

        } else {
            if(pai == pai.parent.left) {
                pai.parent.left = novoPai;
            } else {
                pai.parent.right = novoPai;
            }
        }

        pai.parent = novoPai;
        return novoPai;
    }


    public boolean zigZag(Node filhoDesbalanceado, Node novoNo, int balance) {

        if(filhoDesbalanceado == novoNo) {
            return false;
        }

        if (balance > 1) {
            if(novoNo == filhoDesbalanceado.right) {
                return true;
             }

        } else {
            if(novoNo == filhoDesbalanceado.left) {
                return true;
             }
        }

        return zigZag(filhoDesbalanceado, novoNo.parent, balance);


    }



    public void rotacaoEsquerdaDireita(Node node) {
        Node filho = node.left;
        node.left = rotacaoParaEsquerda(filho);
        rotacaoParaDireita(node);
    }



    public void rotacaoDireitaEsquerda(Node node) {
        Node filho = node.right;
        node.right = rotacaoParaDireita(filho);
        rotacaoParaEsquerda(node);
    }


    public int height(Node node) {
        if(node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

}
