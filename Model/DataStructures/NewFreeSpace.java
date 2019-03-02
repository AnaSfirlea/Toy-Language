package Model.DataStructures;

public class NewFreeSpace {
    static int new_free =100;

    public NewFreeSpace() {
    }

    public int generateNewFree(){
        new_free = new_free+1;
        return new_free;
    }
}
