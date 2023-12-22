package OHQ;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OHIterator implements Iterator<OHRequest> {
    public OHRequest curr;

    public OHIterator(OHRequest queue) {
        curr = queue;
    }

    public boolean isGood(String description) {
        return description != null && description.length() > 5;

    }
    @Override
    public boolean hasNext() {
        while (curr != null) {
            if (isGood(curr.description)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }
    @Override
    public OHRequest next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        OHRequest r = curr;
        curr = curr.next;
        return r;
    }

}
