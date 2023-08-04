public class RobotMatrix {
    public boolean[][] data;

    public RobotMatrix() {
        data = new boolean[101][101];
        data[50][50] = false;
    }
    public void setField(int x, int y){
        data[x + 50][y + 50] = true;
    }

    public boolean getField(int x, int y){
        return data[x + 50][y + 50];
    }
}
