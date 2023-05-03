import java.util.*;
import java.io.*;

public class Adventure {
    Place here;
    Scanner scanner;
    String action;
    String noun;
    PrintStream out;

    /**
     * Sets up the map,exits, and objects in the map
     */
    void setup() {
        scanner = new Scanner(System.in);
        out = System.out;
        Place dining = new Place("dining", "You are in the dining room.\n" + "There are exists to the garden and the kitchen, and stairs!");
        Place garden = new Place("garden", "You are in the garden");
        Place kitchen = new Place("kitchen", "You are in the kitchen");
        Place living = new Place("living", "You are in the living room");
        Place stairs = new Place("stairs", "You are stairs, you can exit to the hall");
        Place upstairsHall = new Place("hall", "You in the stairs hall, you can go to the bedroom, gameroom, or stairs");
        Place bedroom = new Place("bedroom", "You are in the bedroom");
        Place gameRoom = new Place("gameroom","you are in the gameroom");

        Object key = new Object("key", "there is a key on the ground");
        Object diary = new Object("diary", "you found a diary");
        Puzzle chest = new Puzzle("chest", "there is a chest here");
        chest.doThis("open" , "key", new Object[] {diary}, "you need a key", "you opened the chest");


        dining.links(garden,kitchen,stairs, chest);
        garden.links(dining,key);
        kitchen.links(dining);
        living.links(dining);
        stairs.links(dining, upstairsHall);
        upstairsHall.links(stairs, bedroom, gameRoom);
        bedroom.links(upstairsHall);
        gameRoom.links(upstairsHall);
        here = dining;

    }
    /**
     * Runs the game
     */
    void run() {
        setup();
        here.act(here, "go", out);
        while(true){
            read();
            Entity e = here.find(noun);
            if (e == null){
                System.out.println("What " +noun+ "?");
                continue;
            }
            here = e.act(here, action, out);
        }
    }
    /**
     * Takes user input
     */
    void read(){
        System.out.println("> ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        action = words[0];
        noun = words[1];
    }

    public static void main(String[] args) {
        Adventure program = new Adventure();
        System.out.println("You are a world renound detective given the task to solve a murder case of Jospehine Astor, a famous billionare. You must find the room the body was murdered, find three clues, and correctly state who the murdere is.");
        System.out.println("Your possible Suspects are:");
        System.out.println("Andrew Smith: Josephines assistant.");
        System.out.println("Rahel Johnson: Josephines best friend, a CEO.");
        System.out.println("Harry James: Josephines fiancee, a surgeon.");
        System.out.println("Possible commands are");
        System.out.println(">go");
        System.out.println(">grab");
        System.out.println(">drop");
        program.run();
    }
}
