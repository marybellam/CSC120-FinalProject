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

    void exits(Place...exits){
        for (Place p : exits){
            this.exits.put(p.name, p);
        }
    }

    String arrive(){
        String s = description + "\n";
        for (Object x: objects.values()) {
            s = s + x.description + "\n";
        }
        return s;
    }

    Place move(String name){
        Place place = exits.get(name);
            if(place != null){
                System.out.println(place.arrive());
                return place;
            }
            System.out.println("You can't go there");
            return this;
        }
    
    Place find(String name){
        return exits.get(name);
    }

    void put(Object x){
        objects.put(x.name,x);
    }

    Object get(String name){
        Object x = objects.get(name);
        objects.remove(name);
        return x;
    }
}