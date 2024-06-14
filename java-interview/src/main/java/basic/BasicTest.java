package basic;

import io.vavr.control.Option;
import java.lang.*;
import java.util.*;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    if (n < 0) {
      return Option.none();
    }
    if (n == 0) {
      return Option.of(1);
    }

    long result = 1;
    long base = i;

    while (n > 0) {
      if (n % 2 == 1) {
        result *= base;
        if (result > Integer.MAX_VALUE) {
          return Option.none(); // OVERFLOW
        }
      }
      base *= base;
      if (base > Integer.MAX_VALUE) {
        return Option.none();
      }
      n /= 2;
    }
    return Option.of((int) result);
  }
}
