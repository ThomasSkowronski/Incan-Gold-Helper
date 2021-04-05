package IncanGoldHelper;

public class Artifact {
    String name = "Artifact";
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
