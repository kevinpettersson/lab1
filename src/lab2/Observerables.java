package lab2;
import lab1.*;
import java.util.ArrayList;

public interface Observerables {
    void notifyOb(int x, int gasAmount);
    void addObserver(Observer ob);
    void removeObserver(Observer ob);

}
