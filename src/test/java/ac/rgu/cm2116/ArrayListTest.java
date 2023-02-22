package ac.rgu.cm2116;

import java.util.List;

public class ArrayListTest extends ListTest {

    @Override
    protected List<String> createInstance() {
        return new ArrayList<String>();
    }
}
