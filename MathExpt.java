package lab.polymorphism;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * A few simple experiments with our utilities.
 * Version 1.1 of February 2019.
 */
public class MathExpt {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++) {
      double root = MathUtils.squareRoot(i);
      pen.println("The square root of " + i + " seems to be " + root);
      pen.println(root + "^2 = " + (root * root));
    } // for i

    
    
    double root = MathUtils.squareRoot(new Integer(6));
    pen.println("The square root of Integer " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    root = MathUtils.squareRoot(new Float(6));
    pen.println("The square root of Float " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    root = MathUtils.squareRoot(new Double(6));
    pen.println("The square root of Double " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    root = MathUtils.squareRoot(new BigInteger("6"));
    pen.println("The square root of BigInteger " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    root = MathUtils.squareRoot(new BigDecimal("6"));
    pen.println("The square root of BigDecimal " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    double i = 6.0;
    root = MathUtils.squareRoot(i);
    pen.println("The square root of double " + 6 + " seems to be " + root);
    pen.println(root + "^2 = " + (root * root));
    
    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
