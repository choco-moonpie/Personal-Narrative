import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {

  /** Instance Variables */
private String [][] bookWrap;
private String [][] booksRead;
private ImageFilter [][] filters;
public static final int SAMPLE_RATE = 44100; // for audioClip
  
  /** Constructor */
  public SceneOne(){
  }

  public SceneOne(String[][] bookWrap, String[][] booksRead, ImageFilter [][] filters){
    this.bookWrap = bookWrap;
    this.booksRead = booksRead;
    this.filters = filters;
  }
  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    playBackgroundTrack(25);
    clear("pink");
    drawText("- 2025 Book Wrap -", 105, 175);
    pause(1);
    clear("white");
    drawBookRecap();
    
  }
  
  // other methods...
 /**
   * Draws a white box with a shadow to display text
   */
  public void drawCaptionBox(int xPos, int yPos, int width, int height, String text) {
    // shadow box, 5px offset
    setFillColor("black");
    drawRectangle(xPos + 5, yPos + 5, width, height);

      // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    int fontSize = 50;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 10;
    int yLinePos = yPos + fontSize;
    drawText(text, xLinePos, yLinePos);
  }
  
  /**
   * Draws a white box with a shadow to display text
   */
  public void drawCaptionBox(int xPos, int yPos, int width, int height, String[] lines) {
    // shadow box, 5px offset
    setFillColor("black");
    drawRectangle(xPos + 5, yPos + 5, width, height);
    
    // front box
    setFillColor("white");
    drawRectangle(xPos, yPos, width, height);

    // text style (adjust to fit style/size)
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextColor("black");
    
    int fontSize = 24;
    setTextHeight(fontSize);

    // drawing text (adjust offsets)
    int xLinePos = xPos + 10;
    int yLinePos = yPos + fontSize;
    for (String line : lines) {
      drawText(line, xLinePos, yLinePos);
      yLinePos += fontSize;
      fontSize = 14;
      setTextHeight(fontSize);
      
    }
  }

  // draws book images from an array and applies a filter over them based on randomness. along with the images it also displays a caption box.
  public void drawBookRecap() {
    for (int row = 0; row < booksRead.length; row++) {
         //for (int col = 0; col < booksRead[0].length; col++){
      clear("white");
      ImageFilter leftBook = new ImageFilter(booksRead[row][0]);
      ImageFilter rightBook = new ImageFilter(booksRead[row][1]);
      drawImage(leftBook, 0, 105, 210, 320, 0);
      drawImage(rightBook, 220, 105, 210, 320, 0);
      applyRandomFilter(leftBook);
      applyRandomFilter(rightBook);
      drawImage(leftBook, 0, 105, 210, 320, 0);
      drawImage(rightBook, 220, 105, 210, 320, 0);
      // adjust these arguments to move text box left/right, up/down, width, height
      String[] caption = { bookWrap[1][row], bookWrap[0][row] };
      drawCaptionBox(50, 10, 300, 70, caption); 
      pause(1);
    }
}
  
/**
   * Draws a random number from 1-5, which determines the filter that will be applied to the book images 
   */
  public void applyRandomFilter(ImageFilter image) {
    int randomNumber = (int) (Math.random() * 5) + 1;
    if (randomNumber == 1) {
      image.saturateImage(10);
    } else if (randomNumber == 2) {
      image.makeNegative();
    } else  if (randomNumber == 3) {
      image.colorShift(100);
    } else if (randomNumber == 4) {
      image.threshold(100);
    } else  if (randomNumber  == 5) {
      image.glitchImage();
    }
  }
  
/**
   * plays the background track according to the number of seconds 
   */
    public void playBackgroundTrack(int numSeconds) {
    double[] audio = SoundLoader.read("backgroundMusic.wav");
    // just play the first numSeconds
    double[] clip = createClip(audio, 0, numSeconds);
    playSound(clip);
  }

  /**
   * Creates an audio clip from a given start time to a end time
   */
  public static double[] createClip(double[] sound, int start, int end) {
    int startIndex = start * SAMPLE_RATE;
    int endIndex = end * SAMPLE_RATE;
    
    double[] newSound = new double[endIndex - startIndex];

    int index = 0;
    
    while (startIndex < endIndex) {
      newSound[index] = sound[startIndex];
      startIndex++;
      index++;
    }

    return newSound;
   }
  }