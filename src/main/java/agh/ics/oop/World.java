package agh.ics.oop;

import java.util.Scanner;

public class World {
    public World() {
    }

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        String[] arguments = getInput.nextLine().split(" ");
        run(stringToEnum(arguments));
    }

    public static Direction[] stringToEnum(String[] args) {
        Direction[] result = new Direction[args.length + 1];
        int j = 0;

        for (String arg : args) {
            switch (arg) {
                case "b" -> result[j] = Direction.BACKWARD;
                case "f" -> result[j] = Direction.FORWARD;
                case "l" -> result[j] = Direction.LEFT;
                case "r" -> result[j] = Direction.RIGHT;
                default -> j--;
            }
            j++;
        }

        // STOP is used so that program works with input other than b, f, l, r
        result[j] = Direction.STOP;
        j ++;
        while (j < args.length + 1){
            result[j] = Direction.STOP;
            j ++;
        }
        return result;
    }

    public static void run(Direction[] args) {
        System.out.println("Start");

        for(Direction argument : args) {
            switch (argument) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case STOP -> System.out.println("Stop");
            }

            if (argument.equals(Direction.STOP)) {
                break;
            }
        }

    }
}