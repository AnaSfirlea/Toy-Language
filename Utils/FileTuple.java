package Utils;

import java.io.BufferedReader;

public class FileTuple {
    private String fileName;
    private BufferedReader buffReader;

    public FileTuple(String fileName, BufferedReader buffReader) {
        this.fileName = fileName;
        this.buffReader = buffReader;
    }

    public String getFileName() {
        return fileName;
    }

    public BufferedReader getBuffReader() {
        return buffReader;
    }

    @Override
    public String toString(){
        return "(filename:"+fileName+","+"java file descriptor:"+buffReader+")";

    }

}
