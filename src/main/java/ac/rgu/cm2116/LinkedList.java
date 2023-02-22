package ac.rgu.cm2116;

public class LinkedList<T> extends SoCList<T> {

    private ListNode<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(T e) {
        /* ListNode to store the value */
        ListNode<T> newNode = new ListNode<>(e);

        /* If we've no head...we do now */
        if (this.head == null) {
            this.head = newNode;
        } else {
            /* Otherwise, iterate until we find the last ListNode and attach the new one to it */
            ListNode<T> temp = this.head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }
        this.size++;
        return true;
    }

    @Override
    public T remove(int index) {

        T value = null;

        /* We can only remove if the index is less than the size of the list */
        if (index < this.size) {

            /* An index of 0 is the head */
            if (index == 0) {
                value = this.head.getValue();
                /* We make the new head the old head's next */
                this.head = this.head.getNext();
            } else {
                /* Otherwise, we loop through each node, incrementing a counter until we reach the node ONE BEFORE the one we want */
                ListNode<T> temp = this.head;

                int counter = 0;

                while (counter < index - 1) {
                    temp = temp.getNext();
                    counter++;
                }

                /* We get the value from the NEXT node, then make the current node's next the next node's next */
                value = temp.getNext().getValue();
                temp.setNext(temp.getNext().getNext());
            }
            /* Remember to reduce the size of the list */
            this.size--;
        }
        return value;
    }

    @Override
    public boolean remove(Object e) {
        ListNode<T> temp = this.head;
        int counter = 0;

        /* Loop over all nodes until we find the value we want, if it exists */
        while(temp != null){
            /* If the value does exist, use the remote(int index) method to actually remove it */
            if(temp.getValue().equals(e)){
                if(this.remove(counter) != null){
                    return true;
                }
            }
            counter++;
        }
        return false;
    }

    @Override
    public T get(int index) {
        T value = null;

        /* We can only get an index less than the size of the list */
        if (index < this.size) {

            /* If the index is 0, it's the value stored in head */
            if (index == 0) {
                value = this.head.getValue();
            } else {

                /* Otherwise, iterate until our counter reaches the index */
                ListNode<T> temp = this.head;

                int counter = 0;

                while (counter < index) {
                    temp = temp.getNext();
                    counter++;
                }
                value = temp.getValue();
            }

        }
        return value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /* An empty list has a sie of 0 */
        return (this.size == 0);
    }

    @Override
    public void clear() {
        /* Setting head=null and size=0 is enough to clear a list 
         * In other languages without automatic garbage collection (e.g. C, C++) you'd need to delete each node individually
        */
        this.head = null;
        this.size = 0;
    }

    /** Don't edit below this line - here be dragons :) */

    /**
     * Inner class to represent a List Node
     * S is used as the type parameter to avoid conflict with T in the outer class
     */
    class ListNode<S> {

        private S value;
        private ListNode<S> next;

        public ListNode(S value) {
            this.value = value;
            this.next = null;
        }

        public ListNode<S> getNext() {
            return this.next;
        }

        public void setNext(ListNode<S> next) {
            this.next = next;
        }

        public S getValue() {
            return this.value;
        }
    }

}
