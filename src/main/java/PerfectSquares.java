import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.*;

class PerfectSquares {
    public int solution(int A, int B) {
        if(A > B) {
            throw new IllegalArgumentException("A needs to be greater than B");
        }
        if(A < 2 || A > 1_000_000_000) {
            throw new IllegalArgumentException("Illegal argument for A. Has to be between 2 and 1_000_000_000 but was " + A);
        }

        if(B < 2 || B > 1_000_000_000) {
            throw new IllegalArgumentException("Illegal argument for B. Has to be between 2 and 1_000_000_000 but was " + B);
        }
        return perfectSquare(A, B, 0);
    }

    // fastest solution
    private int perfectSquare(int a, int b, int numberOfSquares){
        int lowestSqrt = (int) ceil(sqrt(a));
        int highestSqrt = (int) ceil(sqrt(b));

        if(lowestSqrt == 2 && highestSqrt == 2) {
            return numberOfSquares;
        } else {
            return perfectSquare(lowestSqrt, highestSqrt, numberOfSquares + 1);
        }
    }

    // parallel solution. A=2, B=1_000_000_000 takes about 8,7 seconds on my machine
    private int getSequential(int A, int B) {
        int numberOfRepeatedSquares = 0;
        System.out.println(perfectSquare(A, B, 0));

        for(int i = A; i <= B; i++) {
            numberOfRepeatedSquares =
                    Math.max(numberOfRepeatedSquares, recursiveSquare(i, 0));
        }
        return numberOfRepeatedSquares;
    }

    // parallel solution. A=2, B=1_000_000_000 takes about 1,6 seconds on my machine
    private int getParallel(int A, int B) {
        return IntStream
                .range(A, B + 1)
                .parallel()
                .map(i -> recursiveSquare(i, 0))
                .max().orElse(0);
    }

    private int recursiveSquare(int number, int numberOfSquares) {
        double sqrtDouble = sqrt(number);
        int sqrt = (int) sqrtDouble;
        if(sqrt == sqrtDouble) {
            return recursiveSquare(sqrt, numberOfSquares + 1);
        }
        return numberOfSquares;
    }
}