package co.geeksters.radar;

/**
 * Created by Karam Ahkouk on 04/06/15.
 */
public class RadarPoint {
    float x;
    float y;
    int radius;

    String identifier;

    public RadarPoint(String identifier, float x, float y, int radius){
        this.identifier = identifier;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public RadarPoint(String identifier, float x, float y){
        this.identifier = identifier;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
}
