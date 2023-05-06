import java.io.*;
/**
* Creates an Entity Object, which is able to move, act, and arrive
*/
class Entity {
    final String name;
    final String description;

    /**
     * The constructor, which stores the name and decription of the entity
     * @param name - name of entity
     * @param description - description of entity
     */
    Entity(String name, String description){
        this.name = name;
        this.description = description;
    }
    /**
     * Does an action
     * @param here -  the place you are
     * @param action - thing you want to do
     * @param out - prints out the action
     * @return here - the place you are
     */
    Place act(Place here, String action, PrintStream out){
        System.out.println("You can't" + action + "the"+ name);
        return here;
    }
    /**
     * Moving the user from one place to another
     * @param here - place where you are
     * @param there - place you want to go
     * @param out - prints out that you are moving
     */
    void move(Place here, Place there, PrintStream out){
    }
    /**
     * Prints out when you arrive to the place, and updates where you are
     * @param here - place you are now
     * @param out - prints out the arrival
     */
    void arrive(Place here, PrintStream out){
    }   
}
