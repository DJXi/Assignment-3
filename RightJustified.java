package lab.polymorphism;

public class RightJustified implements TextBlock {
  // Field
  private TextBlock Tb;
  private int width;
  // Constructor
  public RightJustified(TextBlock tb, int width) throws Exception{
    if (width < tb.width()) {
      throw new IllegalArgumentException("Width is too small");
    }
      this.width = width;
      this.Tb = tb;
  }
  // Method of getting the height
  public int height() {
    return this.Tb.height();
  }
  // method of getting the width
  public int width() {
    return this.width;
  }
  // method of return each row of the textblock
  public String row(int i) throws Exception {
    String row = this.Tb.row(i);
    while (row.charAt(row.length() - 1) == ' ') {
      row = row.substring(0, (row.length() - 1));
    }
    row = TBUtils.spaces(this.width - row.length()) + row;
    return row;
  }
} // Class RightJustified
