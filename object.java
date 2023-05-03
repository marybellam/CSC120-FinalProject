import java.io.*;
import java.util.*;

class Object extends Entity{
    private boolean carried;

    Object(String name, String description)
    {
        super(name,description);
    }

    Place act(Place here, String action, PrintStream out){
        if (action.equals("grab") ){
            take(here,out);
        }

        else if(action.equals("drop")) drop(here,out);
        else if(action.equals("read")){
            System.out.println("Once you open it the most recent entry reads:\n" + "I am afraid Rachel is becoming more and more aggresive. I refuse to lend her money for her chemisty company, as previous loans have still not been repaid. She came up today and we had a odd tasting cup of tea which my assistant made. Hopefully we can overcome this.");
            System.out.println("CLUE ONE FOUND");
        }
        else System.out.println("you cant" + action + "it");
        return here;
    }
    private void take(Place here, PrintStream out){
        if(carried){
            System.out.println("alr carried");
            return;
        }
        if(name.equals("diary") == false){
            System.out.println("you pick up the "+ name);
            carried = true;
        }else{
            System.out.println("you cant pick up the " + name);
            carried = false;
        }
    }

    private void drop(Place here, PrintStream out){
        if(!carried){
            System.out.println("not carried");
            return;
        }
        System.out.println("you drop the "+ name);
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
