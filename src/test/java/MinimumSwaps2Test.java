import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class MinimumSwaps2Test {

    @Test
    public void minimumSwaps() {
        assertThat(MinimumSwaps2.minimumSwaps(new int[]{2, 3, 4, 1, 5})).isEqualTo(3);
    }

    @Test
    public void minimumSwaps2() {
        assertThat(MinimumSwaps2.minimumSwaps(new int[]{4, 3, 1, 2})).isEqualTo(3);
    }

    @Test
    public void minimumSwaps3() {
        assertThat(MinimumSwaps2.minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6})).isEqualTo(5);
    }

    @Test
    public void minimumSwapsLongList() {
        String line = new Scanner(MinimumSwaps2Test.class.getResourceAsStream("/MinimumSwaps2.txt")).useDelimiter("\\A").next();

        String[] splitted = line.split(" ");
        int[] values = Arrays.stream(splitted).mapToInt(Integer::valueOf).toArray();
        assertThat(MinimumSwaps2.minimumSwaps(values)).isEqualTo(99984);
    }


}