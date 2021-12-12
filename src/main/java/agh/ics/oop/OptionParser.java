package agh.ics.oop;

public class OptionParser {
    public MoveDirection[] parse(String[] input){
        MoveDirection[] output = new MoveDirection[input.length];
        int i = 0;
        
        for (String elem : input){
            switch (elem) {
                case "f", "forward" -> output[i] = MoveDirection.FORWARD;
                case "b", "backward" -> output[i] = MoveDirection.BACKWARD;
                case "l", "left" -> output[i] = MoveDirection.LEFT;
                case "r", "right" -> output[i] = MoveDirection.RIGHT;
                default -> throw new IllegalArgumentException("Argument " + elem + " is not legal move specification");
            }
            i += 1;
        }
        return output;
    }
}
