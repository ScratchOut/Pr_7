package deQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

class Game {
    private ArrayDeque<Integer> arr1;
    private ArrayDeque<Integer> arr2;
    private int count = 0;

    public Game(ArrayDeque<Integer> arr1, ArrayDeque<Integer> arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public String play() {
        while (count < 106  && !arr1.isEmpty() && !arr2.isEmpty()) {
            Integer val1 = arr1.poll();
            Integer val2 = arr2.poll();
            int comp = val1.compareTo(val2);
            if (val1 == 9 && val2 == 0) {
                comp = -1;
            }
            if (val2 == 9 && val1 == 0) {
                comp = 1;
            }
            if (comp > 0) {
                arr1.add(val1);
                arr1.add(val2);
            } else if (comp < 0) {
                arr2.add(val2);
                arr2.add(val1);
            }
            count++;
        }
        if (count == 106) {
            return "botva";
        } else if (arr1.isEmpty()) {
            return "second " + count;
        } else {
            return "first" + count;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> arr1 = new ArrayDeque<>(10);
        ArrayDeque<Integer> arr2 = new ArrayDeque<>(10);
        for (int i = 0; i < 5; i++) {
            arr1.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            arr2.add(scanner.nextInt());
        }
        Game game = new Game(arr1, arr2);
        System.out.println(game.play());
    }
}
