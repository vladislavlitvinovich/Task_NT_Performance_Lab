package task1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        String[] str = (new Scanner(System.in).nextLine()).split(" ");
        System.out.println(CircleArray(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
    }

    public static String CircleArray(int n, int m) {
        int rem = 1;
        StringBuilder res = new StringBuilder("1");
        while (true) {
            rem = (rem + m - 1) % n;
            if (rem == 1)
                break;
            if (rem == 0)
                rem += n;
            res.append(rem);
        }
        return res.toString();
    }
}
