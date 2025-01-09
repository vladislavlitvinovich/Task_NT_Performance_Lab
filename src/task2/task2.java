package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader circle = new BufferedReader(new FileReader(args[0]));
        BufferedReader point = new BufferedReader(new FileReader(args[1]));
        String buff = circle.readLine();
        int circleX = Integer.parseInt(buff.split(" ")[0]);
        int circleY = Integer.parseInt(buff.split(" ")[1]);
        int radius = Integer.parseInt(circle.readLine());
        buff = point.readLine();
        while (buff != null) {
            int pointX = Integer.parseInt(buff.split(" ")[0]);
            int pointY = Integer.parseInt(buff.split(" ")[1]);
            System.out.println(checkPointPosition(circleX, circleY, radius, pointX, pointY));
            buff = point.readLine();
        }
    }

    public static int checkPointPosition(int circleX, int circleY, int radius, int pointX, int pointY) {
        double distance = Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));
        if (distance < radius) {
            return 1;
        } else if (distance > radius) {
            return 2;
        } else {
            return 0;
        }
    }
}
