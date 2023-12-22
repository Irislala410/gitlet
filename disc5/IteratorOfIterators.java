import java.util.*;
public class IteratorOfIterators implements Iterator<Integer> {
    public int index;
    public List<Iterator<Integer>> l;
    public IteratorOfIterators(List<Iterator<Integer>> a){
        index = 0;
        l = a;
    }

    @Override
    public boolean hasNext(){
        for (int i = 0; i < l.size(); i++){
            if (l.get(i).hasNext()){
                return true;
            }
        }
        return false;

    }
    @Override
    public Integer next(){
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        int answer = l.get(index).next();
        /*move index to the next iterator which is not empty.**/
        index += 1;
        while (hasNext() && !l.get(index).hasNext()){
            index += 1;
        }

        return answer;
    }
}
