import java.util.*;

class Place{
    private String name;
    private String description;
    private Map<String, Object> objects;
    private Map<String, Place> exits;

    Place(String name, String description){
        this.name = name;
        this.description = description;
        objects = new HashMap<String,Object>();
        exits = new HashMap<String,Place>();
    }
    /**
     * Has the exits of each place
     * @param exits
     */
    void exits(Place...exits){
        for (Place p : exits){
            this.exits.put(p.name, p);
        }
    }
    /**
     * The desciprion of the place, and tells user they are in the place
     * @return str - description
     */
    String arrive(){
        String str = description + "\n";
        for (Object o: objects.values()) {
            str = str + o.description + "\n";
        }
        return str;
    }

    /**
     * Moves te location of where you are
     * @param name - name of place
     * @return name
     */
    Place move(String name){
        Place place = exits.get(name);
            if(place != null){
                System.out.println(place.arrive());
                return place;
            }
            System.out.println("I can't go there!");
            return this;
        }
    /**
     * Returns the name of the exits, of the room you're in
     * @param name
     * @return the name of the exit
     */
    Place find(String name){
        return exits.get(name);
    }
    /**
     * Puts the object o into a room
     * @param o - object
     */
    void put(Object o){
        objects.put(o.name,o);
    }
    /**
     * Returns the object
     * @param name - name of object
     * @return object
     */
    Object get(String name){
        Object o = objects.get(name);
        objects.remove(name);
        return o;
    }
}