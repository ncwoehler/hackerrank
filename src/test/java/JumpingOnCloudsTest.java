import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class JumpingOnCloudsTest {

    @Parameterized.Parameters(name = "{index}: jumpingOnClouds({0})={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 0, 1, 0, 0, 1, 0}, 4},
                {new int[]{0, 0, 0, 0, 1, 0}, 3},
                {new int[]{0, 1, 0, 1, 0, 0}, 3},
                {new int[]{0, 0, 0, 1, 0, 1, 0, 1, 0}, 4}
        });
    }

    @Parameterized.Parameter
    public int[] clouds;

    @Parameterized.Parameter(1)
    public int expected;

    @Test
    public void jumpingOnClouds() {
        assertThat(JumpingOnClouds.jumpingOnClouds(clouds)).isEqualTo(expected);
    }
}