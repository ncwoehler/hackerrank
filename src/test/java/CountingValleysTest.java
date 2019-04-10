import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CountingValleysTest {

    @Parameterized.Parameters(name = "{index}: countingValleys({0}, {1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {8, "UDDDUDUU", 1},
                {8, "DDUUUUDD", 1}
        });
    }

    @Parameterized.Parameter
    public int numberOfSteps;

    @Parameterized.Parameter(1)
    public String steps;

    @Parameterized.Parameter(2)
    public int expected;

    @Test
    public void countingValleys() {
        assertThat(CountingValleys.countingValleys(numberOfSteps, steps)).isEqualTo(expected);
    }
}