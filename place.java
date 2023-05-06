import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Creates the places, and allows for  movement from place to place, and stores links
 */
class Place extends Entity{
    private Map<String, Entity> links;

    Place(String name, String description){
      super(name, description);
    }
    /**
     * Stores links of the entity
     * @param links - the links of the entity
     */
    void links(Entity...links){
        if(this.links != null){
            throw new Error("can only set links once");
        }
        this.links = new ConcurrentHashMap<String, Entity>();
        for (Entity e:links){
            this.links.put(e.name,e);
        }
    }
    /**
     * finds the links of the entity
     * @param name - name of entity
     * @return links of the entity
     */
    Entity find(String name){
        return links.get(name);
    }
    /**
     * Gets the links of the object
     * @param name - name of object
     * @return links of the object
     */
    Object get(String name){
        Object x = (Object)links.get(name);
        links.remove(name);
        return x;
    }
    /**
     * Makes the links for that entity
     * @param x - the entity
     */
    void put(Entity x){
        links.put(x.name,x);
    }
    /**
     * Moves user from one place to another if there is a link, if not prints out a message
     * @param from - place you are coming from
     * @param action - what you want to do
     * @param out - prints out act
     */
    Place act(Place from, String action, PrintStream out){
        if (!action.equals("go")) {
            System.out.println("you can't do that to a place");
            return from;
        }
        Place to = this;
        for (Entity e: from.links.values()){
            e.move(from, to, out);
        }
        System.out.println(description);
        for (Entity e: links.values()) {
            e.arrive(to, out);
        }
        return to;
    }
}