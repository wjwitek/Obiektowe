package agh.ics.oop;

import java.util.Arrays;
import java.util.Scanner;

public class World {
    public World() {
    }

    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        String[] arguments = getInput.nextLine().split(" ");
        OptionParser parser = new OptionParser();
        Animal frog = new Animal();

        for (MoveDirection elem : parser.parse(arguments)){
            frog.move(elem);
            System.out.println(frog);
        }

//        run(stringToEnum(arguments));

//        MapDirection test = MapDirection.NORTH;
//        System.out.println(test);
//        System.out.println(test.next());
//        System.out.println(test.previous());
//        System.out.println(test.toUnitVector());
//        Vector2D test_2 = new Vector2D(1, 2);

//        Animal frog = new Animal();
//        System.out.println(frog);
//        frog.move(MoveDirection.FORWARD);
//        System.out.println(frog);
//        frog.move(MoveDirection.LEFT);
//        System.out.println(frog);
//        frog.move(MoveDirection.BACKWARD);
//        System.out.println(frog);
//        frog.move(MoveDirection.RIGHT);
//        System.out.println(frog);
//        frog.move(MoveDirection.FORWARD);
//        System.out.println(frog);
//        frog.move(MoveDirection.FORWARD);
//        System.out.println(frog);
//        frog.move(MoveDirection.FORWARD);
//        System.out.println(frog);
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