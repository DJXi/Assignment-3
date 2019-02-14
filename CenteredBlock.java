package lab.polymorphism;

public class CenteredBlock implements TextBlock {
  // Field
  TextBlock block;
  int width;
  // Constructor
  public CenteredBlock(TextBlock block, int width) throws IllegalArgumentException {
    if (width < block.width()) {
      throw new IllegalArgumentException("Width is too small");
    }
    this.block = block;
    this.width = width;
  }
  // method of returning each row of the textblock
  public String row(int i) throws Exception {
      String row = this.block.row(i);
      while (row.charAt(row.length() - 1) == ' ') {
        row = row.substring(0,(row.length() - 1));
      }
      while (row.charAt(0) == ' ') {
        row = row.substring(1);
      }
      return TBUtils.spaces((this.width - row.length()) / 2) + row
          + TBUtils.spaces(this.width - row.length() -(this.width - row.length()) / 2);
    }
  // method of getting the height
  public int height() {
    return this.block.height();
  }
  // method of getting the width
  public int width() {
    return this.width;
  }
} // Class CenteredBlock
