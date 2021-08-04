package recognition;

import java.util.Scanner;

public class Neuro {
    final int NUMBER_CELLS_IN_GRID = 15;
    final int NUMBER_SOURCE_ITEMS = 10;

    int[] a0 = new int[NUMBER_CELLS_IN_GRID];
    int[] a1 = new int[NUMBER_SOURCE_ITEMS];

    ReferenceValues referenceValues;

    Scanner scanner = new Scanner(System.in);

    public void init() {
        referenceValues = new ReferenceValues();
        referenceValues.initWeights();

        System.out.println("Input grid:");
        StringBuilder sourceGrid = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sourceGrid.append(scanner.nextLine());
        }

        for (int i = 0; i < a0.length; i++) {
            a0[i] = sourceGrid.charAt(i) == '_' ? 0 : 1;
        }
    }

    public void getResult() {
        referenceValues = new ReferenceValues();
        referenceValues.initWeights();

        for (int i = 0; i < NUMBER_SOURCE_ITEMS; i++) {
            for (int j = 0; j < NUMBER_CELLS_IN_GRID; j++) {
                a1[i] += a0[j] * referenceValues.referenceWeights.get(i)[j];
            }
            a1[i] += referenceValues.referenceBias[i];
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < NUMBER_SOURCE_ITEMS; i++) {
            if (a1[i] > max) {
                max = a1[i];
                result = i;
            }
        }
        System.out.printf("This number is %d\n", result);
    }


}
