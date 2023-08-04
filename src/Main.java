import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        String progFileName = "INPUT.txt";
        String program;
        try {
            Scanner inTxtScanner = new Scanner(new File(progFileName));
            program = inTxtScanner.nextLine();
        }
        catch(Exception e){
            System.out.println("Ошибка чтения " + progFileName);
            return;
        }
        RobotMatrix rm = new RobotMatrix();
        int stepCounter = 0;
        for (int i = 0; i < program.getBytes().length; i++) {
            char c = program.charAt(i);
            robot.followCommand(c);
            if(c == 'S'){
                stepCounter++;
                if(rm.getField(robot.getX(), robot.getY()) == false ){
                    rm.setField(robot.getX(), robot.getY());
                }
                else{
                    System.out.println("Шаг " + stepCounter + " робот уже был здесь.");
                }

            }

        }
        robot.followProgram(program);
        //System.out.println("Робот на " + k78.getX() + ":" + k78.getY());

    }
}