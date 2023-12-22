package OHQ;

import java.util.NoSuchElementException;

public class TYIterator extends OHIterator{
    private OHRequest curr;
    public TYIterator(OHRequest queue){
//        curr = queue; /*child class should use super class's constructor*/
        super(queue);
    }

    @Override
    public OHRequest next(){
//        if (!hasNext()){
//            throw new NoSuchElementException();
//        }
//        OHRequest r = curr;
//        if (curr.description.contains("thank u")){
//            curr = curr.next.next;
//        } else {
//            curr = curr.next;
//        }
//        return r;
        /*we shouldn't copy the code from superclass and then change it. we should inherit from it.*/
        OHRequest r = super.next();
        if (r.description.contains("thank u")){
//            curr = curr.next.next;
            curr = curr.next; /*curr already equals to curr.next in super class so here only needs one next.*/
        }
//        } else {
//            curr = curr.next; /*curr already equals to curr.next in super class. so it doesn't need this line.*/
//        }
        return r;
    }


}
