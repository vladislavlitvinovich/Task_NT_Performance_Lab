package task1;

public class task1 {
    public static void main(String[] args) {
        System.out.println(CircleArray(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
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
