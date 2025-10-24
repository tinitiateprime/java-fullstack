// ==============================================================================
//  Organization : TINITIATE TECHNOLOGIES PVT LTD
//  Website      : tinitiate.com
//  Script Title : Java Tutorial
//  Description  : Java arrays
//  Author       : Team Tinitiate
// ==============================================================================

import java.util.Arrays;

/**
 * WHAT THIS CODE IS ABOUT:
 * Understanding the limitations of arrays—mainly FIXED SIZE and a few gotchas.
 *
 * BEGINNER NOTES:
 * - Arrays cannot grow or shrink. Size is fixed when created.
 * - To "add" an element, you must create a NEW array and copy the old data.
 * - Be careful with out-of-bounds indices.
 * - For nested arrays (2D+), use deepToString / deepEquals for proper display/compare.
 */
public class ArraysLimitations_FixedSizePitfalls {
    public static void main(String[] args) {
        int[] ports = {8080, 8081, 8082};
        System.out.println("original: " + Arrays.toString(ports)); // [8080, 8081, 8082]

        // ❌ Can't do ports.add(9090); (no such method)
        // ✅ "Append" by creating a bigger array and copying:
        int[] bigger = Arrays.copyOf(ports, ports.length + 1); // one extra slot
        bigger[bigger.length - 1] = 9090;                      // put new value at the end
        System.out.println("after append: " + Arrays.toString(bigger)); // [8080, 8081, 8082, 9090]

        // Out-of-bounds example (DON'T DO THIS):
        // int x = ports[99]; // would throw ArrayIndexOutOfBoundsException

        // Multi-dimensional display gotcha:
        int[][] grid = {{1,2},{3,4}};
        // System.out.println(grid);             // shows type+hash (not human-friendly)
        System.out.println(Arrays.deepToString(grid)); // [[1, 2], [3, 4]] ✅
    }
}
