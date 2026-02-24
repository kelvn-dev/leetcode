package problems.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        int[] deck = {17,13,11,2,3,5,7};
        System.out.println(deckRevealedIncreasing(deck));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; ++i) {
            queue.add(i);
        }

        int[] result = new int[deck.length];
        for (int card: deck) {
            result[queue.poll()] = card;
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return result;
    }
}
