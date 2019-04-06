import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class NewYearChaosTest {

    @Test
    public void minimumBribes1() {
        assertThat(NewYearChaos.getMinumumBribes(new int[]{1, 3, 2})).isEqualToIgnoringCase("1");
    }

    @Test
    public void minimumBribes2() {
        assertThat(NewYearChaos.getMinumumBribes(new int[]{1, 4, 2, 5, 3})).isEqualToIgnoringCase("3");
    }

    @Test
    public void minimumBribes3() {
        assertThat(NewYearChaos.getMinumumBribes(new int[]{2, 3, 4, 5, 6, 1})).isEqualToIgnoringCase("5");
    }

    @Test
    public void minimumBribes4() {
        assertThat(NewYearChaos.getMinumumBribes(new int[]{2, 3, 4, 6, 5, 1})).isEqualToIgnoringCase("6");
    }

    @Test
    public void minimumBribes5() {
        assertThat(NewYearChaos.getMinumumBribes(new int[]{2, 3, 6, 4, 5, 1})).isEqualToIgnoringCase("Too chaotic");
    }

    @Test
    public void minimumBribesLongList() {
        String line = new Scanner(NewYearChaosTest.class.getResourceAsStream("/NewYearsChaos.txt")).useDelimiter("\\A").next();

        String[] splitted = line.split(" ");
        int[] values = Arrays.stream(splitted).mapToInt(Integer::valueOf).toArray();
        assertThat(NewYearChaos.getMinumumBribes(values)).isLessThanOrEqualTo("119814");
    }
}