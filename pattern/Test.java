package pattern;

public class Test {
  public static void main(String[] args) {
    InPlaceReversal inPlaceReversal = new InPlaceReversal();
    inPlaceReversal.addFirst(5);
    inPlaceReversal.addFirst(4);
    inPlaceReversal.addFirst(3);
    inPlaceReversal.addFirst(2);
    inPlaceReversal.addFirst(1);
//    inPlaceReversal.reverse();
    inPlaceReversal.reverseBetween(2, 4);
    inPlaceReversal.print();
  }
}
