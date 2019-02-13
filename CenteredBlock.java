package lab.polymorphism;

public class CenteredBlock implements TextBlock {

  TextBlock block;
  int width;

  public CenteredBlock(TextBlock block, int width) throws IllegalArgumentException {
    if (width < block.width()) {
      throw new IllegalArgumentException("Width is too small");
    }
    this.block = block;
    this.width = width;
  }

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

 

  public int height() {
    return this.block.height();
  }


  public int width() {
    return this.width;
  }


}