import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /** Instance Variables */

  /** Constructor */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  // Add filter methods here...
  /*
   * Applies a saturation filter to the image
   */
public void saturateImage(int factor) {

Pixel[][] pixels = getImagePixels();
   
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
      Pixel current = pixels[row][col];
      int avg = (current.getRed() + current.getGreen() + current.getBlue()) / 3;
      int grayScale = avg + (avg + 255) * factor;
          current.setRed(2 * grayScale - current.getRed());
          current.setGreen(2 * grayScale - current.getGreen());
          current.setBlue(2 * grayScale - current.getBlue());
     
      }
    }

   /*
   * Inverts the colors in the image by setting the red,
   * green, and blue color values of each Pixel object to
   * the result of 255 minus their current values
   */
  }

  public void makeNegative() {
   Pixel[][] pixels = getImagePixels();
   
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
     
    Pixel currentPixel = pixels[row][col];
   int currentRed = currentPixel.getRed();
   int currentGreen = currentPixel.getGreen();
   int currentBlue = currentPixel.getBlue();

   int finalRed = 255 - currentRed;
   int finalGreen = 255 - currentGreen;
   int finalBlue = 255 - currentBlue;

   currentPixel.setRed(finalRed);
   currentPixel.setGreen(finalGreen);
   currentPixel.setBlue(finalBlue);

      }
    } 
  }


   /*
   * Shifts the color of each Pixel object by a fixed amount
   */
  public void colorShift(int value) {
   Pixel[][] pixels = getImagePixels();
   
for(int row = 0; row < pixels.length; row++){
    for(int col = 0; col < pixels[0].length; col++){
     
      Pixel currentPixel = pixels[row][col];
      
         int newRed = currentPixel.getRed() + value;
         int newGreen = currentPixel.getGreen() + value;
         int newBlue = currentPixel.getBlue() + value;


     newRed = Math.min(255, Math.max(0, newRed));
     newGreen = Math.min(255, Math.max(0, newGreen));
     newBlue = Math.min(255, Math.max(0, newBlue));

    currentPixel.setRed(newRed);
    currentPixel.setGreen(newGreen);
    currentPixel.setBlue(newBlue);
    
  }
}
  }

    /*
   * Applies a threshold filter to an image
   */
  public void threshold(int value) {
Pixel[][] pixels = getImagePixels();
    for(int row =  0;  row < pixels.length; row++){
      for(int col = 0; col < pixels[0].length; col++){
        Pixel current = pixels[row][col];
        int avg = (current.getRed() + current.getGreen() + current.getBlue()) / 3;
        if(avg < value){
          current.setColor(Color.BLACK);
        }else{
          current.setColor(Color.WHITE);
        }
        }
      }
  }

   /*
   * Applies a glitch filter to an image
   */
  public void glitchImage(){
    Pixel[][] pixels = getImagePixels();
    for(int row = 0; row < pixels.length; row++){
      for(int col = 0; col < pixels[0].length; col++){
        Pixel currentPixel = pixels[row][col];

        int newRed = (int)(Math.random() * 101) - 50;
        int newGreen = (int)(Math.random() * 101) - 50;
        int newBlue = (int)(Math.random() * 101) - 50;

        int finalRed = currentPixel.getRed() + newRed; 
        int finalGreen = currentPixel.getGreen() + newGreen; 
        int finalBlue = currentPixel.getBlue() + newBlue;

        if (finalRed > 255){
          finalRed = 255;
        } else if (finalRed < 0) {
          finalRed = 0;
        }

        if (finalGreen > 255){
          finalRed = 255;
        } else if (finalGreen < 0) {
          finalGreen = 0;
        }

        if (finalBlue > 255){
          finalRed = 255;
        } else if (finalBlue < 0) {
          finalBlue = 0;
        }

        currentPixel.setRed(finalRed);
        currentPixel.setGreen(finalGreen);
        currentPixel.setBlue(finalBlue);
  
      }
    }
  }
}