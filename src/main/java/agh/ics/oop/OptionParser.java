package agh.ics.oop;

import java.util.Arrays;

public class OptionParser {
    public MoveDirection[] parse(String[] input){
        // count correct inputs
        String[] correctInputs = {"f", "forward", "l", "left", "r", "right", "b", "backward"};
        int counter = 0;
        for (String elem : input){
            if (Arrays.asList(correctInputs).contains(elem)){
                counter += 1;
            }
        }
        MoveDirection[] output = new MoveDirection[counter];
        int i = 0;
        for (String elem : input){
            switch (elem){
                case "f", "forward" -> output[i] = MoveDirection.FORWARD;
                case "b", "backward" -> output[i] = MoveDirection.BACKWARD;
                case "l", "left" -> output[i] = MoveDirection.LEFT;
                case "r", "right" -> output[i] = MoveDirection.RIGHT;
                default -> i -= 1;
            }
            i += 1;
        }
        return output;
    }
}
