package problems.queue;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] tickets = {1,2,3};
        int k = 1;
        System.out.println(timeRequiredToBuy(tickets, k));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int count = tickets[k];
        for (int i = 0; i < k; ++i) {
            count += Math.min(tickets[k], tickets[i]);
        }

        for (int i = k + 1; i < tickets.length; ++i) {
            count += Math.min(tickets[k] - 1, tickets[i]);
        }

        return count;
    }
}
