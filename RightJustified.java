package lab.polymorphism;

public class RightJustified implements TextBlock {
  private TextBlock Tb;
  private int width;
 
  public RightJustified(TextBlock tb, int width) throws Exception{
    if (width < tb.width()) {
      throw new IllegalArgumentException("Width is too small");
    }
      this.width = width;
      this.Tb = tb;
  }
 
  public int height() {
    return this.Tb.height();
  }
 
  public int width() {
    return this.width;
  }
 
  public String row(int i) throws Exception {
    String row = this.Tb.row(i);
    while (row.charAt(row.length() - 1) == ' ') {
      row = row.substring(0, (row.length() - 1));
    }
    row = TBUtils.spaces(this.width - row.length()) + row;
    return row;
  }
}
