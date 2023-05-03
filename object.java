import java.io.*;
import java.util.*;

class Object extends Entity{
    private boolean carried;

    Object(String name, String description)
    {
        super(name,description);
    }

    Place act(Place here, String action, PrintStream out){
        if (action.equals("grab")) take(here,out);
        else if(action.equals("drop")) drop(here,out);
        else System.out.println("you cant" + action + "it");
        return here;
    }
    private void take(Place here, PrintStream out){
        if(carried){
            System.out.println("alr carried");
            return;
        }
        System.out.println("you pick up the "+ name);
        carried = true;
    }

    private void drop(Place here, PrintStream out){
        if(!carried){
            System.out.println("not carried");
            return;
        }
        System.out.println("you dop the "+ name);
        carried = false;
    }

    void move(Place here, Place there, PrintStream out){
        if(!carried) return;
        here.get(name);
        there.put(this);
    }

    void arrive(Place here, PrintStream out){
        if(carried) return;
        System.out.println(description);
    }
}
