package stack;

import java.util.Scanner;
import java.util.Stack;

class Game {
    private Stack<Integer> arr1;
    private Stack<Integer> arr2;
    private int count = 0;

    public Game(Stack<Integer> arr1, Stack<Integer> arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public String play() {
        while (count < 106  && !arr1.isEmpty() && !arr2.isEmpty()) {
            Integer val1 = arr1.pop();
            Integer val2 = arr2.pop();
            int comp = val1.compareTo(val2);
            if (val1 == 9 && val2 == 0) {
                comp = -1;
            }
            if (val2 == 9 && val1 == 0) {
                comp = 1;
            }
            if (comp > 0) {
                arr1.add(0, val1);
                arr1.add(0, val2);
            } else if (comp < 0) {
                arr2.add(0, val2);
                arr2.add(0, val1);
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
        Stack<Integer> arr1 = new Stack<>();
        Stack<Integer> arr2 = new Stack<>();
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
