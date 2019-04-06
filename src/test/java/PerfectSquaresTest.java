import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PerfectSquaresTest {

    @Test
    public void solutionTest1() {
        int solution = new PerfectSquares().solution(10,20);

        assertEquals(2, solution);
    }

    @Test
    public void solutionTest2() {
        int solution = new PerfectSquares().solution(6000,7000);

        assertEquals(3, solution);
    }

    @Test
    public void solutionTest3() {
        int solution = new PerfectSquares().solution(2,1_000_000_000);

        assertEquals(4, solution);
    }

    @Test
    public void solutionTest4() {
        int solution = new PerfectSquares().solution(2,2);

        assertEquals(0, solution);
    }

    @Test(expected = IllegalArgumentException.class)
    public void solutionTestIllegalArg() {
        new PerfectSquares().solution(1,1_000_000_000);
    }

}