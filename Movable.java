import java.util;
import java.lang.Math;

public interface Movable {

    public void heading(heading);
        int heading = math.abs(heading % 360);
        this.heading = heading;
    public void move();
        tmp = this.pos[];
        this.pos[0] = this.pos[0]+ math.cos(heading);
        this.pos[1] = this.pos[1]+ math.cos(heading);



    public void turnLeft(degree);
        return this.heading = this.heading + degree;

    public void turnRight();
}
