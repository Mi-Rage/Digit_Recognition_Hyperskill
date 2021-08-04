package recognition;

import java.util.HashMap;
import java.util.Map;

public class ReferenceValues {
    Map<Integer, int[]> referenceWeights = new HashMap<>();
    String[] sources = new String[] {"XXXX_XX_XX_XXXX", "_X__X__X__X__X_", "XXX__XXXXX__XXX",
            "XXX__XXXX__XXXX", "X_XX_XXXX__X__X", "XXXX__XXX__XXXX", "XXXX__XXXX_XXXX", "XXX__X__X__X__X",
            "XXXX_XXXXX_XXXX", "XXXX_XXXX__XXXX"};
    int[] referenceBias = new int[] {-1, 6, 1, 0, 2, 0, -1, 3, -2, -1};

    public void initWeights() {
        for (int index = 0; index < sources.length; index++) {
            int[] weight = new int[sources[index].length()];
            for (int i = 0; i < sources[index].length(); i++) {
                weight[i] = sources[index].charAt(i) == '_' ? -1 : 1;
            }
            referenceWeights.put(index, weight);
        }
    }
}
