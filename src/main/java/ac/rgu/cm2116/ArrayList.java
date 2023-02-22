package ac.rgu.cm2116;

public class ArrayList<T> extends SoCList<T> {

    private Object[] array;

    public ArrayList(){
        this.array = new Object[0];
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
}
