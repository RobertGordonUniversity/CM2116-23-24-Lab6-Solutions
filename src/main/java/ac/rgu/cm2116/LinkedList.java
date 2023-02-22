package ac.rgu.cm2116;

public class LinkedList<T> extends SoCList<T> {

    private ListNode<T> head;
    private int size;

    public LinkedList(){
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(T e){
        return false;
    }

    @Override
    public T remove(int index){
        return null;
    }

    @Override
    public boolean remove(Object e){
        return false;
    }

    @Override
    public T get(int index){
        return null;
    }

    @Override
    public int size(){
        return 0;
    }

    @Override
    public boolean isEmpty(){
        return true;
    }

    @Override
    public void clear(){
        
    }

    /** Don't edit below this line - here be dragons :) */

    /**
     * Inner class to represent a List Node
     * S is used as the type parameter to avoid conflict with T in the outer class
     */
    class ListNode<S>{

        private S value;
        private ListNode<S> next;

        public ListNode(S value){
            this.value = value;
            this.next = null;
        }

        public ListNode<S> getNext(){
            return this.next;
        }

        public void setNext(ListNode<S> next){
            this.next = next;
        }

        public S getValue(){
            return this.value;
        }
    }
    
}
