package lab.polymorphism;

public class TruncatedBlock implements TextBlock {
  private TextBlock truncatedTb;
  private int width;
 
  public TruncatedBlock(TextBlock tb, int width) throws Exception{
    if((width < 0) || (width > tb.width())) {
      throw new Exception("Invalid width!");
    } else {
      this.width = width;
      this.truncatedTb = tb;
    }
  }
 
  public int height() {
    return this.truncatedTb.height();
  }
 
  public int width() {
    return this.width;
  }
 
  public String row(int i) throws Exception {
    String row = this.truncatedTb.row(i);
    row = row.substring(0, this.width);
    return row;
  }
}

