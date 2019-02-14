package lab.polymorphism;
// import packages
import java.io.PrintWriter;

public class Grid implements TextBlock {
  // Fields
  int width;
  int height;
  char ch;
  // Constructor
  public Grid (int width, int height, char ch) {
    this.width = width;
    this.height = height + 2;
    this.ch = ch;
  }
  // the method of getting height
  public int height() {
    return this.height; 
  }
  // method of getting width
  public int width() {
    return this.width;
  }
  // method of returning each row of the textblock
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
  // testing
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock grid = new Grid(4, 6, '8');
    TBUtils.print(pen, grid);
  }
}
