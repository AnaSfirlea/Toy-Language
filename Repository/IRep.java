package Repository;
import Model.*;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.util.List;

public interface IRep {
    void logPrgStateExec(PrgState state);
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> states);
    String getLogFilePath();
}
