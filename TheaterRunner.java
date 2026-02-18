import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

// Create any 2D arrays & variables to be passed as parameters to constructor
String [][] bookWrap =
  { {"Onyx Storm and Rock, Paper, Scissors", 
    "The Outsiders and Your Name",
    "A Haunting In Venice and Shatter Me", 
    "Lock Every Door and Fearless", 
    "Ward D and A Silent Voice", 
    "The Long Walk and The Gods Lie", 
    "The Maidens and Promised Neverland", 
    "The Chain and Horimiya",
    "Behind Closed Doors and Then She Was Gone",
    "Local Women Missing and The Silent Patient",
    "In My Dreams I Hold A Knife and The Patient", 
    "Never Lie and Ride Your Wave"},
    {"January", "February", "March", 
     "April", "May", "June", "July",
     "August", "September", "October", 
     "November", "December"}
  };

    String[][] booksRead = {
   {"onyx-storm.png", "rock-paper-scissors.png"},
   {"the-outsiders.png", "your-name.png"},
   {"a-haunting-in-venince.png", "shatter-me.png"},
   {"lock-every-door.png", "fearless.png"},
   {"the-long-walk.png","the-gods-lie.png"},
   {"ward-d.png", "silent-patient.png"},
   {"the-maidens.png", "the-promised-neverland.png"},
   {"the-chain.png", "horimiya.png"}, 
   {"behind-closed-doors.png", "then-she-was-gone.png"},
   {"local-women-missing.png", "silent-patient.png"},
   {"in-my-dreams-i-hold-a-knife.png", "the-patient.png"},
   {"never-lie.png", "ride-your-wave.png"},
   };

    String[][] bakedGoods = {
      {"IMG_5313.png", "chocolate-crinkle-cookies.png", "red-velvet-cookies.png", "s'mores-cookies.png"},
      {"chocolate-cake.png", "carrot-cake.png", null, null},
      {"IMG_6229.png", "IMG_5171.png", null, null},
    };

    ImageFilter [][] filters = {
      {new ImageFilter("onyx-storm.png"), new ImageFilter("rock-paper-scissors.png")}, 
      {new ImageFilter("the-outsiders.png"), new ImageFilter("your-name.png")},
      {new ImageFilter("a-haunting-in-venince.png"), new ImageFilter("shatter-me.png")},
      {new ImageFilter("lock-every-door.png"), new ImageFilter("fearless.png")},
      {new ImageFilter("the-long-walk.png"), new ImageFilter("the-gods-lie.png")},
      {new ImageFilter("ward-d.png"), new ImageFilter("silent-patient.png")},
      {new ImageFilter("the-maidens.png"), new ImageFilter("the-promised-neverland.png")},
      {new ImageFilter("the-chain.png"), new ImageFilter("horimiya.png")}, 
      {new ImageFilter("behind-closed-doors.png"), new ImageFilter("then-she-was-gone.png")},
      {new ImageFilter("local-women-missing.png"), new ImageFilter("silent-patient.png")},
      {new ImageFilter("in-my-dreams-i-hold-a-knife.png"), new ImageFilter("the-patient.png")},
      {new ImageFilter("never-lie.png"), new ImageFilter("ride-your-wave.png") },
      };
    
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(bookWrap, booksRead, filters);
    SceneTwo scene2 = new SceneTwo(bakedGoods);
    
  
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();

    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    


    

    
    
  }
}