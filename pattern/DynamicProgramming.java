package pattern;

public class DynamicProgramming {
  public static void main(String[] args) {
//    System.out.println(getFibonacci(6));
//    System.out.println(reverseInteger(12, 0));
    System.out.println(getOccurrenceOfChar("abcdea", 'a'));
  }

  // 0, 1, 1, 2, 3, 5
  public static int getFibonacci(int n) {
    if (n <= 1) {
      return n;
    }
    return getFibonacci(n - 1) + getFibonacci(n - 2);
  }

  public static int getBinaryForm(int num) {
    if (num == 0) {
      return 0;
    }
    return getBinaryForm(num / 2) * 10 + num % 2;
  }

  public static int reverseInteger(int num, int result) {
    if (num == 0) {
      return result;
    }
    return reverseInteger(num / 10, result * 10 + num % 10);
  }

  public static int getOccurrenceOfChar(String str, char c) {
    if (str.isEmpty()) {
      return 0;
    }
    return (str.charAt(0) == c ? 1 : 0) + getOccurrenceOfChar(str.substring(1), c);
  }

  public static int getGcdByEuclid(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    }
    return getGcdByEuclid(num2, num1 % num2);
  }

  // n! = n * (n-1) * ... * 1
  public static int factorial(int num) {
    if (num == 1) {
      return 1;
    }
    return num * factorial(num - 1);
  }

  // x^n
  public static int exponential(int num, int exponent) {
    if (exponent == 1) {
      return num;
    }
    return num * exponential(num, exponent - 1);
  }

  public static int countDigit(int num) {
    if (num == 0) {
      return 0;
    }
    return 1 + countDigit(num / 10);
  }

  public static boolean checkPrime(int num, int divisor) {
    if (num <= 1) {
      return false;
    }
    if (divisor * divisor > num) {
      return true;
    }
    if (num % divisor == 0) {
      return false;
    }
    return checkPrime(num, divisor + 1);
  }

  public static int getMinElement(int[] arr, int size) {
    if (size == 1) {
      return arr[0];
    }
    return Math.min(arr[size - 1], getMinElement(arr, size - 1));
  }
}
