import java.util.*;
import java.io.*;

class Puzzle extends Entity{
    private String action, need, failure, success;
    private List<Object> contents;

    Puzzle(String name, String description){
        super(name, description);
        contents = new ArrayList<Object>();
    }
    
    void doThis(String action, String need, Object[] contents, String failure, String success){
        this.action = action;
        this.need = need;
        this.failure = failure;
        this.success = success;
        for(Object x: contents) this.contents.add(x);
    }

    void arrive(Place here, PrintStream out){
        System.out.println(description);
    }

    Place act(Place here, String action, PrintStream out) {
        if (! action.equals(this.action)) {
            out.println("Do what to the " + name + "?");
            return here;
        }
        if (here.find(need) == null) {
            out.println(failure);
            return here;
        }
        System.out.println(success);
        for (Object c: contents) {
            out.println(c.description);
            here.put(c);
        }
        return here;
    }
    
}
