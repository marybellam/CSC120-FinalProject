# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 My overall approach to tackling this project was to biuld it piece by piece, because if I tried doing everything all at once then it would become too overwhelming. So firstly, I made the Adventure class, which would set up and run the game. This is where, the game starts and ends. Then, I had to make the different places and objects. I did this, and then added puzzles into the game. I then used the entity class, and was able to extend it into the puzzle, place, and object class to make everything more organized.
 - What **new thing(s)** did you learn / figure out in completing this project?
 New things I figured out was how to use a ConcurrentHashMap, since I was getting the ConcurrentModificationException. I figured out that the way to fix this was to use a ConcurrentHasMap, instead of HashMap. Then, I also figured out how to take advance of extending classes, and how to make the classes relate to each other.
 - Is there anything that you wish you had **implemented differently**?
 Something I wish I had implemented differently is the puzzle class, as it can be confusing to the user, because you have to use open <puzzle>, which may not seem obvious. So I wish I had implemented this class differntly to make it easier for the user to understand.
 - If you had **unlimited time**, what additional features would you implement?
 If I had more time I would implement dialouge. I would have more clues and more suspects, and I would make it possible to invterview the suspects. I really like the idea of making the user be able to speak or interact with the suspects.
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 The most helpful piece of feedbkack was to create the Entity class and extends it to the puzzle, object, and place class. This feedback was given to me by Rachel Michaud.
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 I would tell my past self to really focus on how you are going to make the map and objects. It was difficult to figure out how to make the map work because it was hard to be able to ake the user only be able to enter some of the rooms, as well as how to keep track of what room they are in. Advice would be to use links, and have the place object have links to places and object they can interact with.
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
 I did not work with a team.
