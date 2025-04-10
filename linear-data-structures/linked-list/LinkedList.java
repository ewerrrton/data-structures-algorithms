public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList() {
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.head == null;
    }
    
    public void addLast(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            
        } else {
        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        }
        this.size++;
        
    }
    
    public void addFirst() {
        Node newNode = new Node(value);
        if(isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        
        this.size++;
    }
    
    
    public void add(int index, int value) {
        if(index == 0) {
            addFirst(value);
        
        } else if(index == this.size) {
            addLast(value);
        }
        
        else {
            Node newNode = new Node(value);
            Node aux = this.head;
            for(int i = 0; i < index-1; i++) {
                aux = aux.next;
            }
            
            newNode.next = aux.next;
            aux.next = newNode;
            
            newNode.next.prev = newNode;
            newNode.prev = aux;
            
            this.size++;
            
        }
    }
    
    public int get(int index) {
        if(index < 0 || index >= this.size) {
            throw new RuntimeException();
        }
        
        if(index == 0) {
            return this.head.value;
        
        } else if(index == this.size-1) {
            return this.tail.value;

        } else {
            Node aux = this.head;
            
            for(int i = 0; i < index; i++) {
                aux = aux.next;
            }
            
            return aux.value;
        }
    }
    
    public int indexOf(int value) {
        Node aux = this.head;
        
        int index = 0;
        while(aux != null) {
            if(aux.value == value) {
                return index;
            
            } else {
                index++;
                aux = aux.next;
            }
        }
        return -1;
        
    }
    
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }
    
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        return this.head.value;
    }
    
    public int getLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        
        return this.tail.value;
    }
    
    public int removeFirst() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        
        int removido = this.head.value;
        
        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
                        
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;    
        return removido;
    }
    
    public int removeLast() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        
        int removido = this.head.value;
        
        if(this.head.next == null) {
            this.head = null;
            this.tail = null;
                        
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        
        this.size--;
        return removido
    }

    public int remove(int index) {
        if(index == 0) {
            return removeFirst();
        
        } else if(index == this.size-1) {
            return removeLast();
        }
        
        else {
            Node aux = this.head;
            for(int i = 0; i < index; i++) {
                aux = aux.next;
                
            }
            
            int removido = aux.value;
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
        }
        
        return removido
    }


}

