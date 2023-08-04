import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public class Robot {
    private int x = 0;
    private int y = 0;
    int orientation;
    int nStep = 0;
    boolean haveReported = false;

    public Robot(){
        Random random = new Random();
        orientation = random.nextInt(0,3) * 90;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void step(){
        if(orientation == 0){
            x++;
        }
        else if(orientation == 90){
            y++;
        }
        else if(orientation == 180){
            x--;
        }
        else {
            y--;
        }
        nStep++;
    }
    public void turnToLeft(){
        orientation -= 90;
        if(orientation < 0) {
            orientation += 360;
        }
    }
    public void turnToRight(){
        orientation += 90;
        if(orientation >= 360) {
            orientation -= 360;
        }
    }
    void followCommand(char command)
    {
        if (command == 'S'){
            step();
        }
        else if (command == 'L'){
            turnToLeft();
        }
        else if (command == 'R'){
            turnToRight();
        }
        else {
            System.out.println("Неизвестная команда " + command);
        }
    }
    void followProgram(String program){
        nStep = 0;
        for (int i = 0; i < program.length(); i++) {
            followCommand(program.charAt(i));
        }
    }
}
