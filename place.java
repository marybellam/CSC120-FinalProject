import java.util.*;
import java.io.*;

class Place extends Entity{
    private Map<String, Entity> links;

    Place(String name, String description){
      super(name, description);
    }
    
    void links(Entity...links){
        if(this.links != null) throw new Error("can only set links once");
        this.links = new HashMap<String, Entity>();
        for (Entity e:links) this.links.put(e.name,e);
    }
    
    Entity find(String name){
        return links.get(name);
    }

    Object get(String name){
        Object x = (Object) links.get(name);
        links.remove(name);
        return x;
    }

    void put(Entity x){
        links.put(x.name,x);
    }

    Place act(Place from, String action, PrintStream out){
        if (!action.equals("go")) {
            System.out.println("You can't do that to a place");
            return from;
        }
        Place to = this;
        for (Entity e: from.links.values())
        {
            e.move(from, to, out);
        }
        out.println(description);
        for (Entity e: links.values()) e.arrive(to, out);
        return to;
    }
}