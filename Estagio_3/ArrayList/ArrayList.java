public ArrayList {

    private static final int CAPACIDADE_DEFAULT = 20;
    private int size;
    private int[] lista;

    public ArrayList() {
        this.lista = new int[CAPACIDADE_DEFAULT];
        this.size = 0;
    }

    public ArrayList(int capacidade) {
        this.lista = new int[capacidade];
        this.size = 0;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.lista.length;
    }

    public void addFirst(int valor) {
        if(isEmpty()) {
            this.lista[size] = valor;
            this.size++;
            return;
        }

        shiftPDireita(0);
        this.lista[0] = aluno;
        this.size++
    }

    public void addLast(int valor) {
        if(isEmpty()) {
            this.lista[size] = valor;
            this.size++;
            return;
        }

        if(isFull()) {
            this.resize(this.size * 2)
        }

        this.fila[++size] = valor;

    }

    public void add(int index, int valor) {
        if(index < 0 || index > this.size) {
            throw new RuntimeException("Indice fora dos parametros");
        }

        if(index == 0) {
            addFirst(valor);
        
        } else if(index == this.size+1) {
            addLast(valor);
        }

        else {
            if(isFull()) {
                resize();
            }

            shiftPdireita(index);
            this.fila[index] = valor;
            this.size++;
        }
    }


    private void shiftPDireita(int index) {
        if(isFull()) {
            resize(this.size * 2);
        }

        for(int i = this.size; i > index; i--) {
            this.lista[i] = this.lista[i-1];
        }

    }


    private void resize(int novaCapacidade) {

        Aluno[] newLista = new Aluno[capacidade];
        for(int i = 0; i < this.lista.length; i++) {
            newLista[i] = this.lista[i];
        }

        this.lista = newLista;
    }

    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        return this.lista[0];
    }

    public int getLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }

        return this.lista[this.size-1];
    }


    public int get(int index) {
        if(index < 0 || index > this.size-1) {
            throw RuntimeException();
        }


        return this.lista[index];
    }


    public int removeFirst() {
         if(isEmpty()) {
              throw new RuntimeException();
         }

         int removido = this.lista[0];
         shiftPEsquerda(1);
         this.size--;

         return removido;
    }

    private void shifPEsquerda(int index) {
        for(int i = index; i < this.size; i++) {
            this.lista[i-1] = this.lista[i];
        }
    }

    
    public int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        int removido = this.lista[this.size-1];
        this.size--;

        return removido;
    }

    public int remove(int index) {
        if(isEmpty()) {
            throw new RuntimeException();
        }

        if(index == 0) {
            return removeFirst();
        }

        else if(index == this.size-1) {
            return removeLast();
        }

        int removido = this.lista[index];

        else {
            shiftPEsquerda(index+1);
        }

        return removido;
    }
        

}
