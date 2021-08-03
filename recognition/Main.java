package recognition;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[9];
        int[] weight = new int[]{2, 1, 2, 4, -4, 4, 2, -1, 2};
        int bias = -5;
        int result = 0;

        System.out.println("Input grid:");

        String sourceGrid = "";
        for (int i = 0; i < 3; i++) {
            sourceGrid += scanner.nextLine();
        }

        for (int i = 0; i < 9; i++) {
            a[i] = sourceGrid.charAt(i) == '_' ? 0 : 1;
        }

        for (int i = 0; i < a.length; i++) {
            result += a[i] * weight[i];
        }
        result += bias;
        System.out.printf("This number is %d", result > 0 ? 0 : 1);
    }
}
