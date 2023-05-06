import java.util.*;
import java.io.*;
/**
 * Creates the puzzles, keeps track of where puzzle is, keeps track of puzzles contents, failures, and if success
 */
class Puzzle extends Entity{
    private String action;
    private String need;
    private String failure;
    private String success;
    private List<Object> contents;

    /**
     * Stores the name and description of the puzzle
     * @param name - name of puzzle
     * @param description - description of puzzle
     */
    Puzzle(String name, String description){
        super(name, description);
        contents = new ArrayList<Object>();
    }
    /**
     * Keeps track of action done, object needed, what is in th puzzle, and if player fails of succeeds
     * @param action - what player wants to do
     * @param need - object player needs
     * @param contents - what is in the puzzle
     * @param failure - if player fails
     * @param success - if player succeeds
     */
    void doThis(String action, String need, Object[] contents, String failure, String success){
        this.action = action;
        this.need = need;
        this.failure = failure;
        this.success = success;
        for(Object x: contents){
            this.contents.add(x);
        }
    }
    /**
     * Prints out the description of the puzzle when in place where puzzle is
     * @param here- place user currently is
     * @param out - prints out
     */
    void arrive(Place here, PrintStream out){
        System.out.println(description);
    }
    /**
     * Takes an action to use on the puzzle, if action is doable it will sucseed and the conetents will be released, if not then a statement is printed
     * @param here - place user currently is
     * @param action - actions user wants to do
     * @param out - prints act
     */
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
