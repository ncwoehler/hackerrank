import java.util.Scanner;

class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        System.out.println(getMinumumBribes(q));
    }

    static String getMinumumBribes(int[] q) {
        int numberOfBribes = 0;
        try {
            for(int i = 0; i < q.length - 1; i++) {
                int currentValue = q[i];
                int nextValue = q[i + 1];
                if(currentValue > nextValue) {
                    if(i < currentValue - 3) {
                        throw new IllegalStateException();
                    }
                    q[i] = q[i+1];
                    q[i+1] = currentValue;
                    if(i > 0 && q[i-1] > nextValue) {
                        i--;
                    }
                    i--;
                    ++numberOfBribes;
                }
            }
        } catch(IllegalStateException e) {
            return "Too chaotic";
        }
        return String.valueOf(numberOfBribes);
    }

    public static void main(String[] args) {
        minimumBribes(new int[] {2, 4, 1, 3, 7, 5, 6, 8});
    }
}
