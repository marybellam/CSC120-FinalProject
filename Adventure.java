import java.util.*;
import java.io.*;
/**
 * Sets up, runs the game, and takes in player input
 */
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
        Place dining = new Place("dining", "You are in the 'dining' room.\n" + "There are exits to the 'garden' and the 'kitchen', 'living' room, and 'stairs'!");
        Place garden = new Place("garden", "You are in the 'garden'");
        Place kitchen = new Place("kitchen", "You are in the 'kitchen'");
        Place living = new Place("living", "You are in the 'living' room");
        Place stairs = new Place("stairs", "You are stairs, you can exit to the 'hall'");
        Place upstairsHall = new Place("hall", "You in the upstairs hall, you can go to the 'bedroom', 'library', or 'stairs'");
        Place bedroom = new Place("bedroom", "You are in the 'bedroom'");
        Place library = new Place("library","you are in the 'library'");
        Place secretPassageway = new Place("passageway", "While you are walking in the passage way you see a trail of blood leading to the exit. On the wall there is the phrase 'GLEAN'... an anagram. There seems to be an exit to the 'kitchen' and 'library'\n" +" CLUE THREE FOUND ");

        Object book = new Object("book","there is a book on the table");
        Object key = new Object("key", "there is a key on the ground");
        Object gloves = new Object("gloves", "there is a pair of gloves on the counter");
        Object diary = new Object("diary", "you found a diary.Once you open it the most recent entry reads:\n" + "I am afraid Harry is becoming more and more aggrEsive. I refuse to Lend him money for her chemisty comPany, as previous loans have still not been repaid. She came up today and we had a odd tasting cup of tea which My assistant madE. Hopefully we can overcome this.\n" + "CLUE ONE FOUND\n" +"HELP ME... sounds like the murderer forced her to write the diary entry and Josephine want to give us a clue.");
        Object knife = new Object("knife", "there is a knife covered in bood lying next to the body");
        Object paper = new Object("paper", "this is a torn slip of 'paper', I wonder where the other half is?");
        Object paper2 = new Object("second paper", "you found the second halve of the slip of paper, it reads:\n"+ "PETITION FOR DISSOLUTION OF MARRIAGE\n"+"Looks like Josephine was trying to divorse her husband.\n"+"CLUE 2 FOUND");
        Puzzle safe = new Puzzle("safe","there is a safe here...it looks like i can pry it open with a knife");
        Puzzle chest = new Puzzle("chest", "there is a chest here");
        Puzzle body = new Puzzle("body", "there is a body lying on the floor with multiple stab wounds here, she seems to be holding something. I should take a closer look.");
        Puzzle bookshelf = new Puzzle("bookshelf", "There is a bookshelf with a missing book near the wall, where you see spots of blood around the bookshelf.");

        chest.doThis("open" , "key", new Object[] {diary}, "you need a key", "you opened the chest");
        body.doThis("examine" , "gloves", new Object[] {paper}, "you need gloves", "you got a torn slip of paper");
        safe.doThis("open", "knife", new Object[] {paper2}, "you need a knife", "You opened the safe");
        bookshelf.doThis("insert", "book", new Object[] {}, "you're missing something","The bookshelf slides to the right to reveal a secret 'passageway'");
        dining.links(garden,kitchen,stairs, chest,living);
        garden.links(dining,key);
        kitchen.links(dining,gloves,secretPassageway);
        living.links(dining,knife,body);
        stairs.links(dining,upstairsHall);
        upstairsHall.links(stairs, bedroom, library,book);
        bedroom.links(upstairsHall,safe);
        library.links(upstairsHall,secretPassageway,bookshelf);
        secretPassageway.links(kitchen, library);
        here = dining;

    }
    /**
     * Runs the game, ends game once the user guesses who the murder is. Gives different endings if player guesses wrong.
     */
    void run() {
        setup();
        here.act(here, "go", out);
        while(true){
            read();
            if(action.equals("sus")){
                if(noun.equals("angel") || noun.equals("Angel")){
                    System.out.println("After the police looked through your evidence they found you were right! James confessed to the murder after being questioned!");
                    System.out.println("**YOU WIN***");
                    break;
                }
                if(noun.equals("angel") == false){
                    System.out.println("After the police looked through your evidence they found you were wrong! The murderer is still out there ! :( ");
                    System.out.println("**YOU LOSE***");
                    break;
                }
            }
            Entity e = here.find(noun);
            if (e == null){
                System.out.println("What " +noun+ "?");
                continue;
            }
            here = e.act(here, action, out);
        }

    }
    /**
     * Takes user input and splits it up into action and noun
     */
    void read(){
        System.out.println("> ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        try{
        action = words[0];
        noun = words[1];
        }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Use an action and a noun");
        }
    }

    public static void main(String[] args) {
        Adventure program = new Adventure();
        System.out.println("You are a world renowned detective given the task to solve a murder case of Jospehine Astor, a famous billionare. You must find the room the body was murdered, find the three clues, and correctly state who the murdere is to win.");
        System.out.println("Your possible Suspects are:");
        System.out.println("Andrew: Josephines assistant.");
        System.out.println("Harry: Josephines best friend, a CEO.");
        System.out.println("Angel: Josephines fiancee, a surgeon.");
        System.out.println("Possible commands are(USE ALL LOWERCASE THROUGHOUT THE GAME)");
        System.out.println(">go <place>");
        System.out.println(">grab <object>");
        System.out.println(">drop <object>");
        System.out.println(">open <object>");
        System.out.println(">insert <object you want to insert into>");
        System.out.println(">examine <object>");
        System.out.println("When you are ready to say who the murdere use 'sus' and the name of the killer.");

        program.run();
    }
}
