package ac.rgu.cm2116;

public class ArrayList<T> extends SoCList<T> {

    private Object[] array;
    private int size; // added size field because efficiency update means we can't rely on the array size

    public ArrayList() {
        this.array = new Object[10]; // revised, more efficient version that gives the array an initial size > 0
        this.size = 0;
    }

    @Override
    public boolean add(T e) {

        /*
         * Do we need to resize our array? Yes, if this.size is the length of the array
         */
        if (this.size == array.length) {
            Object[] temp = new Object[array.length + 10];

            for (int i = 0; i < this.array.length; i++) {
                temp[i] = this.array[i];
            }

            this.array = temp;
        }

        /* Add the item and increment size */
        this.array[this.size] = e;
        this.size++;

        return true;
    }

    @Override
    public T remove(int index) {

        T value = null;

        /* Index must be less than size - otherwise, it's out of bounds */
        if (index < size) {
            value = (T) this.array[index];

            /* Create a new array that's the size of the current array - remember, the size might be bigger than the number of elements being stored */
            Object[] temp = new Object[this.array.length];

            /* Copy over all elements before index */
            for (int i = 0; i < index; i++) {
                temp[i] = this.array[i];
            }

            /* Copy over all elements after index */
            for (int i = index + 1; i < this.size; i++) {
                temp[i - 1] = this.array[i];
            }

            /* Reduce the size */
            this.size--;
        }

        return value;
    }

    @Override
    public boolean remove(Object e) {
        /* Search for the item in the list; if it exists, use the remove(int index) method to actually remove it */
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.array[i])) {
                if (this.remove(i) != null) {
                    return true;
                }
            }
        }

        /* If we get this far, we can only return false */
        return false;

    }

    @Override
    public T get(int index) {
        T value = null;
        /* Index must be less than size */
        if (index < this.size) {
            value = (T) this.array[index];
        }

        return value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /* An empty list has a size of 0 */
        return (this.size == 0);
    }

    @Override
    public void clear() {
        /* Clearing is easy - new empty array and size=0 */
        this.array = new Object[10];
        this.size = 0;
    }
}
