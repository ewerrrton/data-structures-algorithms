import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

public class BST {

    private Node root;
    private int size;

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] entradas = sc.nextLine().split(" ");
        System.out.println();

        for(String i : entradas) {
            bst.add(Integer.parseInt(i));
        }

        System.out.print("Entradas em pre Ordem: ");
        bst.preOrder();
        System.out.println("\n");

        System.out.print("Entradas em BSF: ");
        bst.printBFS();
        System.out.println("\n");

    }

    public BST() {
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        Node newNode = new Node(element);
        this.size++;

        if(isEmpty()) {
            this.root = newNode;
            return;

        } 
        
        Node aux = this.root;
        while(aux != null) {
            if(element < aux.value) {
                if(aux.left == null) {
                    aux.left = newNode;
                    newNode.parent = aux;
                    return;
                }

                aux = aux.left;
            
            } else {
                if(aux.right == null) {
                    aux.right = newNode;
                    newNode.parent = aux;
                    return;
                }

                aux = aux.right;
            }
        }
    }

    public Node max() {
        if(isEmpty()) {
            return null;
        }

        return max(this.root);
    }

    private Node max(Node node) {
        if(node.right == null) {
            return node;
        }

        return max(node.right);
    }


    public Node min() {
        if(isEmpty()) {
            return null;
        }

        return min(this.root);
    }

    private Node min(Node node) {
        if(node.left == null) {
            return node;
        }

        return min(node.left);
    }



    public Node sucessor(Node node) {
        if(node.right != null) {
            return min(node.right);
        
        } else {

            Node aux = node.parent;
            while(aux != null && aux.value < node.value) {
                aux = aux.parent;
            }
            return aux;
        }
    }



    public Node predecessor(Node node) {
        if(node.left != null) {
            return max(node.left);
        
        } else {

            Node aux = node.parent;
            while(aux != null && aux.value > node.value) {
                aux = aux.parent;
            }

            return aux;
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if(node == null) {
            return -1;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }
    

    
    public Node search(int value) {
        if(isEmpty()) {
            return null;
        }

        return search(this.root, value);
    
    }

    private Node search(Node node, int value) {
        if(node == null) {
            return null;
        }

        if(node.value == value) {
            return node;
        }

        if(value < node.value) {
            return search(node.left, value);
        }

        else {
            return search(node.right, value);
        }

    }



    public void remove(int element) {
        Node toRemove = search(element);
        
        if(toRemove != null) {
            remove(toRemove);
            this.size--;
        }
    }

    private void remove(Node toRemove) {
        if( toRemove.isLeaf()) {
            if(toRemove == this.root) {
                this.root = null;
            
            } else { 

                if(toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = null;
                } else {
                    toRemove.parent.right = null;
                }
            }
        }

        else if(toRemove.hasOnlyLeftChild()) {
            if(toRemove == this.root) {
                this.root = toRemove.left;
                this.root.parent = null;
            } else {
                toRemove.left.parent = toRemove.parent;
                if(toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.left;
                } else {
                    toRemove.parent.right = toRemove.left;
                }
            }
        }

        else if(toRemove.hasOnlyRightChild()) {
            if(toRemove == this.root) {
                this.root = toRemove.right;
                this.root.parent = null;
            
            } else {
                toRemove.right.parent = toRemove.parent;
                if(toRemove.value < toRemove.parent.value) {
                    toRemove.parent.left = toRemove.right;
                } else {
                    toRemove.parent.right = toRemove.right;
                }
            }
        }

        else {
            Node sucessor = sucessor(toRemove);
            toRemove.value = sucessor.value;
            remove(sucessor);
        }
    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.value + " ");
            
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(this.root);
    }


    private void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void posOrder() {
        posOrder(this.root);
    }

    private void posOrder(Node node) {
        if(node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void printBFS() {
        Deque <Node> deque = new LinkedList<Node>();

        if(!isEmpty()) {
            deque.addLast(this.root);
            
            while(!deque.isEmpty()) {               
                Node removido = deque.removeFirst();

                System.out.print(removido.value + " ");

                if(removido.left != null) {
                    deque.addLast(removido.left);
                }

                if(removido.right != null) {
                    deque.addLast(removido.right);
                }
            }
        }
    }







        
    // Questao Predecessor TST 
    public void predecessorTST(Node node) {
        String saida = "";

        saida+= "[" + node.value;

        if(node.left != null) {
            max(node.left, saida);
            return;

        } else {

            Node aux = node.parent;
            while(aux != null) {
                saida += ", " + aux.value;
                if(aux.value > node.value) {
                    aux = aux.parent;
                } else {
                    break;
                }
            }
            saida += "]";
        }

        System.out.println(saida);
    }


    private void max(Node node, String saida) {

        if(node.right == null) {
            saida += node.value + "]";
            System.out.println(saida);
            return;
        } else {
            saida += ", " + node.value + ", ";
        }
         
        
        max(node.right, saida);
      }

    // Questao conta nos internos TST
    
    public int contaNosInternos() {
        return contaNosInternos(this.root);
    }

    private int contaNosInternos(Node node) {
        if(node == null || node.isLeaf()) {
            return 0;
        }

        return 1 + contaNosInternos(node.left) + contaNosInternos(node.right);
    }

    // Questao Soma Folhas TST

    public int somaFolhas() {
        int soma = 0;
        return somaFolhas(this.root, soma);
    }

    private int somaFolhas(Node node, int soma) {
        if(node == null) {
            return 0;
        }

        if(node.isLeaf()) {
            return soma += node.value;
        }
        
        else {
            return somaFolhas(node.left, soma) + somaFolhas(node.right, soma);
        }
    }













}
