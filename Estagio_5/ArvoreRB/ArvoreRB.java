import java.util.ArrayList;

public class ArvoreRB {

    private Node root;



    public static void main(String[] args) {
        ArrayList<String> saida = new ArrayList<>();

        ArvoreRB rb1 = new ArvoreRB();
        ArvoreRB rb2 = new ArvoreRB();
        ArvoreRB dif = new ArvoreRB();

        int[] entradas = new int[]{50, 30, 70, 20, 40, 60, 80};

        int[] entradasDiferentes = new int[]{50, 25, 70, 20,40, 60, 80};

        for(int i : entradas) {
            rb1.add(i);
        }

        System.out.println(rb1.verificaArvorePV(rb1.root));

        //System.out.println("As árvores rb1 e rb2 são iguais? " + rb1.equals(rb2));
        //System.out.println("As árvores rb1 e rbDiferente são iguais? " + rb1.equals(dif));
        rb1.preOrdem(rb1.root, saida);
        System.out.println(saida);

        //rb.printaNivel(rb.root, 0, 3);


    }

    public boolean verificaArvorePV(Node root) {
        return verificaRaizPreta(root) &&
               verificaNosVermelhosConsecutivos(root) &&
               verificaAlturaPreta(root);
    }


    public boolean verificaRaizPreta(Node root) {
        return root.cor == Node.Color.PRETO;
    }

    public boolean verificaNosVermelhosConsecutivos(Node node) {
        if(node == null) {
            return true;
        }

        if(node.cor == Node.Color.VERMELHO) {
            if((node.left != null && node.left.cor == Node.Color.VERMELHO) ||
               (node.right != null && node.right.cor == Node.Color.VERMELHO)) {
                return false;
             }
        }

     return verificaNosVermelhosConsecutivos(node.left) &&
            verificaNosVermelhosConsecutivos(node.right);
    }

    public boolean verificaAlturaPreta(Node node) {
    
        if(node == null) {
            return true;
        }

        int alturaPretaEsq = contaNosPretos(node.left);
        int alturaPretaDir = contaNosPretos(node.right);

        if(alturaPretaEsq != alturaPretaDir) {
            return false;
        }

        return verificaAlturaPreta(node.left) && verificaAlturaPreta(node.right);
    }

    private int contaNosPretos(Node node) {
        if(node == null) {
            return 1 ;
        
        }
        int alturaPreta = contaNosPretos(node.left);

        if(node.cor == Node.Color.PRETO) {
            alturaPreta++;
        }
        return alturaPreta;
    }

    public boolean equals(ArvoreRB outra) {
        return equals(this.root, outra.root);
    }

    private boolean equals(Node n1, Node n2) {
        if(n1 == null && n2 == null) {
            return true;
        }

        if(n1 == null || n2 == null) {
            return false;
        }

        if(n1.value != n2.value || n1.cor != n2.cor) {
            return false;
        }

        return equals(n1.left, n2.left) && equals(n2.right, n1.right);
    }


    public void preOrdem(Node node, ArrayList<String> lista) {
        if (node != null) {

            lista.add(node.value + ", Cor: " +
            (node.cor == Node.Color.PRETO ? "Preto" : "Vermelho"));

            preOrdem(node.left, lista);
            preOrdem(node.right, lista);
        }
    }

    public boolean isEmpty() {
        return this.root == null;

    }


    public void add(int element) {
        Node newNode = new Node(element, Node.Color.VERMELHO);
        if(isEmpty()) {
            this.root = newNode;
            this.root.cor = Node.Color.PRETO;
            return;

        } else {
            Node aux = this.root;

            while(aux != null) {
                if(element < aux.value) {
                    if(aux.left == null) {
                        aux.left = newNode;
                        newNode.parent = aux;
                        corrigeArvore(newNode);
                        return;
                     }
                    aux = aux.left;


                } else {
                    if(aux.right == null) {
                        aux.right = newNode;
                        newNode.parent = aux;
                        corrigeArvore(newNode);
                        return;

                    }
                        aux = aux.right;
                }

            }
        }
    }

    private void recolor(Node pai, Node avo, Node tio) {
        if(pai != null && pai.cor == Node.Color.VERMELHO) {
            pai.cor = Node.Color.PRETO;
        } else {
            pai.cor = Node.Color.VERMELHO;
        }

        if(avo != null && avo.cor == Node.Color.VERMELHO) {
            avo.cor = Node.Color.PRETO;
        } else {
            avo.cor = Node.Color.VERMELHO;
        }

        if(tio != null && tio.cor == Node.Color.VERMELHO) {
            tio.cor = Node.Color.PRETO;
        } else {
            tio.cor = Node.Color.VERMELHO;
        }

    }

    public void recolor(Node node) {
        Node pai = node.parent;

        if(pai == pai.parent.left) {
            recolor(pai, pai.parent, pai.parent.right);

        } else {
            recolor(pai, pai.parent, pai.parent.left);
        }
    }



    public void corrigeArvore(Node node) {
        if(node == this.root) {
            node.cor = Node.Color.PRETO;
            return;
        }

        if(node.parent.cor == Node.Color.PRETO) {
            return;
        }

        boolean tioVermelho = colorTio(node);

        if(tioVermelho) {
            recolor(node);
            corrigeArvore(node.parent.parent);

        } else {
            Node pai = node.parent;
            if(naEsquerda(pai)) {
                if(pai.left == node) {
                    rotacaoParaDireita(pai.parent);

                } else {
                    rotacaoEsquerdaDireita(pai.parent);
                }
            } else {
                if(pai.right == node) {
                    rotacaoParaEsquerda(pai.parent);

                } else {
                    rotacaoDireitaEsquerda(pai.parent);
                }
            }
        }
    }


    public boolean naEsquerda(Node node) {
        return node == node.parent.left;
    }

    public boolean colorTio(Node node) {
        Node pai = node.parent;
        Node tio;
        if(pai == pai.parent.left) {
            tio = pai.parent.right;
        } else {
            tio = pai.parent.left;
        }

        if(tio != null && tio.cor == Node.Color.VERMELHO) {
            return true;
        }

        return false;
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
        }

        else {
            if(pai == pai.parent.left) {
                pai.parent.left = novoPai;
            }
            else {
                pai.parent.right = novoPai;
            }
        }
        pai.parent = novoPai;
        return novoPai;
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


}
