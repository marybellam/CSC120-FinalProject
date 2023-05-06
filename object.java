import java.io.*;
/**
 * Creates the Object object, which can be grabed, droped, move, and arrive
 */
class Object extends Entity{
    private boolean carried;

    /**
     * Object Constructor, stores the name and description of the object
     * @param name - name of object
     * @param description - description of object
     */
    Object(String name, String description)
    {
        super(name,description);
    }
    /**
     * Calls the drop or grab method for the object, or neither depending on action
     * @param here - place you are
     * @param action - what you want to do
     * @param out - prints out action
     */
    Place act(Place here, String action, PrintStream out){
        if (action.equals("grab") ){
            grab(here,out);
        }
        else if(action.equals("drop")){
            drop(here,out);
        }else {
            System.out.println("you cant" + action + "it");
        }
        return here;
    }
    /**
     * grabs the object and makes carried true, if already carried prints out a statement
     * @param here - place you are
     * @param out  - prints out grab
     */
    private void grab(Place here, PrintStream out){
        if(carried){
            System.out.println("already carried");
            return;
        }
        System.out.println("you pick up the " + name);
        carried = true;  
    }
    /**
     * drops the object and makes carried false, if not carried prints out a statement
     * @param here - place where you are
     * @param out - prints out the drop
     */
    private void drop(Place here, PrintStream out){
        if(!carried){
            System.out.println("not carried");
            return;
        }
        System.out.println("you drop the "+ name);
        carried = false;
    }
    /**
     * Moves the object to a different place
     * @param here - place you are
     * @param there - wher you are going
     * @param out - prints move
     */
    void move(Place here, Place there, PrintStream out){
        if(!carried){
            return;
        }
        here.get(name);
        there.put(this);
    }
    /**
     * The object arrives to a different place
     * @param here - place you are
     * @param out - prints arrive
     */
    void arrive(Place here, PrintStream out){
        if(carried){
            return;
        }
        System.out.println(description);
    }
}
