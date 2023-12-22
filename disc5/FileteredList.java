import java.util.*;
import java.util.function.Predicate;

public class FileteredList<T> implements Iterable<T> {
    public List l;
    public Predicate filter;
    public FileteredList(List<T> L, Predicate<T> filter){
        l = L;
        filter = filter;
    }

    @Override
    public Iterator<T> iterator(){
        return new FileteredIterator();
    }

    private class FileteredIterator implements Iterator<T>{
        int index;

        public FileteredIterator(){
            index = 0;
            moveindex(); //find the first proper element in the ilst.

        }

        @Override
        public boolean hasNext(){
            return index < l.size();
        }

        @Override
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            T answer = (T) l.get(index);
            index += 1;
            moveindex();
            return answer;
        }

        private void moveindex(){
            while (hasNext() && !filter.test(l.get(index))){
                index += 1;
            }
        }
    }

}
