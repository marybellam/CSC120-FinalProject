import java.io.*;

class Entity {
    final String name, description;

    Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    Place act(Place here, String action, PrintStream out){
        System.out.println("You can't" + action + "the"+ name);
        return here;
    }
    
    void move(Place here, Place ther, PrintStream out){

    }

    void arrive(Place here, PrintStream out){

    }
    
}
