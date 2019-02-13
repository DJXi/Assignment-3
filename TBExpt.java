package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);
    /*
     TextBlock block1 = new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
     TextBlock block2 = new RightJustified(block1, 20);
     TBUtils.print(pen, block1);
     TBUtils.print(pen, block2);
     block2 = new CenteredBlock(block2, 20);
     TBUtils.print(pen, block2);
     TBUtils.print(pen, block2);
     TextBlock block3 = new BoxPair(block1);
     TBUtils.print(pen, block3);
     */
    // Clean up after ourselves.
    
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb1.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    pen.println(tb1.line);
    pen.close();

  } // main(String[])
} // class TBExpt
