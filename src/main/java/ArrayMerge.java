public class ArrayMerge {

    public static void main(String[] args) {
    }

    //
    //    int[] a = new int[]{1, 3, 5, 11, 13, 15};
    //    int[] b = new int[]{0, 4, 12, 16};
    //    int[] desired_answer = new int[]{0, 1, 3, 4, 5, 11, 12, 13, 15, 16};
    // Assume for now that they don't have dups.

    // If you're stumped, work out a small example by hand.
    // Give things names.
    // Symmetric code is usually more likely to be correct.

    // Step-by-step.
    // a[0] vs b[0] -- 0 vs 1  {1, 3, 5, 11, 13, 15} {0, 4, 12, 16}
    // a[0] vs b[1] -- 1 vs 4  {0} {1, 3, 5, 11, 13, 15} {4, 12, 16}
    // a[1] vs b[1] -- 3 vs 4  {0, 1} {3, 5, 11, 13, 15} {4, 12, 16}
    // a[2] vs b[1] -- 5 vs 4  {0, 1, 3} {5, 11, 13, 15} {4, 12, 16}
    // a[2] vs b[2] -- 5 vs 12 {0, 1, 3, 4} {5, 11, 13, 15} {12, 16}
    // a[i] vs b[k]

    // Let's give things names
    public int[] merge(final int[] a, final int[] b) {
        final int[] merged = new int[a.length + b.length];
        int index = 0; // Index into merged
        int i = 0; // Index into a
        int k = 0; // Index into b

        // Single loop, not nested
        while (index < merged.length) {
            if (i == a.length) {
                merged[index] = b[k];
                k++;
            } else if (k == b.length) {
                merged[index] = a[i];
                i++;
            } else if (a[i] < b[k]) {
                merged[index] = a[i];
                i++;
            } else {
                merged[index] = b[k];
                k++;
            }
            index++;
        }

        return merged;
    }
}
