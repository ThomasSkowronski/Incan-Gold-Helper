package IncanGoldHelper;

public class BadCard {
    int amt = 3;
    int max = 3;
    int drawn = 0;
    int left = 0;

    public boolean draw(){
        drawn++;
        if (drawn == 2){
            max--;
            amt--;
        } else {
            amt --;
        }
        left = max - drawn;
        return (drawn >1);
    }
}
