package IncanGoldHelper;

public class BadCard {
    String name;
    int amt, max = 3;
    int drawn = 0;

    public void draw(){
        drawn++;
        if (drawn == 2){
            max--;
            amt--;
        } else {
            amt --;
        }
    }
}
