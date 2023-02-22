package ac.rgu.cm2116;

import java.util.List;

public class LinkedListTest extends ListTest{

    @Override
    protected List<String> createInstance() {
        return new LinkedList<String>();
    }
    
}
