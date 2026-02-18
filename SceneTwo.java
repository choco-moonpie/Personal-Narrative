import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  /** Instance Variables */
  private String [][] bakedGoods;
    
  /** Constructor */
  public SceneTwo() {

  }

  public SceneTwo(String [][] bakedGoods) {
  this.bakedGoods = bakedGoods;
  }
  
  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    clear("silver");
    drawText("- Pastries I've Made -", 105, 175);
    clear("silver");
    bakedPastries();
  }

  // other methods...
  /**
   * Draws a white box with a shadow to display text
   */
  public void drawCaptionBox(int xPos, int yPos, int width, int height, String text) {
  setFillColor("black");
  drawRectangle(xPos + 5, yPos + 5, width, height);
    
    // front box
    setFillColor("white");
    drawRectangle(xPos, yPos, width, height);

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
   * draws baking images from a 2D array along with its category
   */
  public void bakedPastries(){
    String[] categories = {"Cookies", "Cakes", "Breads"};
    for (int row = 0; row < categories.length; row++) {
  // adjust these arguments to move text box left/right, up/down, width, height
      drawCaptionBox(50, 10, 300, 70, categories[row]); 
     for(int col = 0; col < bakedGoods[0].length; col++){
     if (bakedGoods[row][col] != null) {
        drawImage(bakedGoods [row][col], 80, 90, 250, 300, 0);
        pause(1);
        drawImage(bakedGoods [row][col], 80, 90, 250, 300, 0);
       }
      }
      pause(1);
    }
  }
}