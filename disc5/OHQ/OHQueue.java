package OHQ;

import java.util.Iterator;

public class OHQueue implements Iterable<OHRequest> {
    public OHRequest first;
    public OHQueue(OHRequest queue){
        first = queue;
    }

    @Override
    public Iterator<OHRequest> iterator() {
        return new OHIterator(this.first);
    }

    public static void main(String [] args){
        OHRequest s5 = new OHRequest("I deleted all of my files", "Allyson", null);
        OHRequest s4 = new OHRequest("Conceptual: what is java", "Omar", s5);
        OHRequest s3 = new OHRequest("git: i never did lab 1", "Conor", s4);
        OHRequest s2 = new OHRequest("Help", "Hug", s3);
        OHRequest s1 = new OHRequest("No i haven't tried stepping through", "Itai", s2);

        OHQueue q = new OHQueue(s1);
        String names = "";

        for (OHRequest a : q){
            names += a.name;
        }
        System.out.println(names);


    }
}
