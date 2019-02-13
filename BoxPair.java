package lab.polymorphism;

public class BoxPair implements TextBlock {
  private TextBlock Tb;
 
  public BoxPair(TextBlock tb) {
      this.Tb = tb;
  }
 
  public int height() {
    return this.Tb.height();
  }
 
  public int width() {
    return 2*this.Tb.width();
  }
 
  public String row(int i) throws Exception {
    String row = this.Tb.row(i) + this.Tb.row(i);
    return row;
  }
}