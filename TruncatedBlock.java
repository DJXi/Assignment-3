package lab.polymorphism;

public class TruncatedBlock implements TextBlock {
  // Fields
  private TextBlock truncatedTb;
  private int width;
  // Constructor
  public TruncatedBlock(TextBlock tb, int width) throws Exception{
    if((width < 0) || (width > tb.width())) {
      throw new Exception("Invalid width!");
    } else {
      this.width = width;
      this.truncatedTb = tb;
    }
  }
  // method of getting the height
  public int height() {
    return this.truncatedTb.height();
  }
  // method of getting the width
  public int width() {
    return this.width;
  }
  // method of returning each row of the textblock
  public String row(int i) throws Exception {
    String row = this.truncatedTb.row(i);
    row = row.substring(0, this.width);
    return row;
  }
}// Class for TruncatedBlock

