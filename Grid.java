package lab.polymorphism;
import java.io.PrintWriter;

public class Grid implements TextBlock {



  int width;
  int height;
  char ch;
  
  public Grid (int width, int height, char ch) {
    this.width = width;
    this.height = height + 2;
    this.ch = ch;
  }
  
  public int height() {
    return this.height; 
  }
  
  public int width() {
    return this.width;
  }
  
  public String row(int i) throws Exception {
    // The top and bottom of the box
    String value = Character.toString(ch);
    if ((i == 0) || (i == this.height - 1)) {
      return "+" + TBUtils.dashes(this.width) + "+";
    }
    // Stuff within the box
    else if ((i > 0) && (i <= this.height)) {
      return "|" + value.repeat(this.width) + "|";
    }
    // Everything else
    else {
      throw new Exception("Invalid row " + i);
    }
  }
  
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock grid = new Grid(4, 6, '8');
    TBUtils.print(pen, grid);
  }
}
