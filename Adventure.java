import java.util.*;

public class Adventure {
    Place here;
    Scanner scanner;
    String verb;
    String noun;
    Map<String, Object> inventory;

    /**
     * Sets up the map,exits, and objects in the map
     */
    void setup() {
        scanner = new Scanner(System.in);
        Place dining = new Place("dining", "You are in the dining room.\n" + "There are exists to the garden and the kitchen, and stairs!");
        Place garden = new Place("garden", "You are in the garden");
        Place kitchen = new Place("kitchen", "You are in the kitchen");
        Place living = new Place("living", "You are in the living room");
        Place stairs = new Place("stairs", "You are stairs, you can exit to the hall");
        Place upstairsHall = new Place("hall", "You in the stairs hall, you can go to the bedroom, gameroom, or stairs");
        Place bedroom = new Place("bedroom", "You are in the bedroom");
        Place gameRoom = new Place("gameroom","you are in the gameroom");

        dining.exits(garden,kitchen,stairs);
        garden.exits(dining);
        kitchen.exits(dining);
        living.exits(dining);
        stairs.exits(dining, upstairsHall);
        upstairsHall.exits(stairs, bedroom, gameRoom);
        bedroom.exits(upstairsHall);
        gameRoom.exits(upstairsHall);

        here = dining;
        Object knife = new Object("knife", "There is a bloody knife on the ground.");
        garden.put(knife);
        Object book = new Object("book", "There is a heavy book on the ground.");
        bedroom.put(book);
        inventory = new HashMap<String, Object>();
    }
    /**
     * Runs the game
     */
    void run() {
        setup();
        System.out.print(here.arrive());
        while (true) {
            read();
            if (verb.equals("go")){
                Place there = here.find(noun);
                if (there != null) {
                    System.out.print(there.arrive());
                    here = there;
                }else{
                    System.out.println("You can't go there!");
                }
            }
            else if (verb.equals("grab")){
                Object x = here.get(noun);
                if (x != null){
                    System.out.println("Picked up the " + x.name);
                    inventory.put(noun,x);
                }
                else System.out.println("What "+noun+" ?");
            }else if (verb.equals("drop")){
                Object x = inventory.get(noun);
                if (x != null){
                    System.out.println("Dropped the " + x.name);
                    here.put(x);
                }
                else System.out.println("What " + noun + "?");
            }
            else System.out.println("Do what?");
        }
    }
    /**
     * Takes user input
     */
    void read(){
        System.out.println("> ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        verb = words[0];
        noun = words[1];
    }

    public static void main(String[] args) {
        Adventure program = new Adventure();
        program.run();
    }
}
