package leetcode;;

public class Main {

    public static void main(String[] args) {

    }

    public static int iterativeSum(int sum, int n) {
        if (n == 0) {
            return sum;

        } else {
            sum += n;
            return iterativeSum(sum, n - 1);
        }
    }

    public int sum(int n) {

        if (n >= 1) {
            return sum(n - 1) + n;
        }

        return n;
    }
}
