package IncanGoldHelper;

public class Artifact {
    int max, amt;

    public void artifactIns(){
        max++;
        amt = max;
    }

    public void draw(){
        amt--;
    }

    public void steal(){
        max--;
    }
}
