
package entrada;

/**
 *
 * @author Hemerson
 */
public class Ponto implements Comparable{
    private double x;
    private double y;
    private double z;

    public Ponto() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public Ponto(Ponto ponto) {
        this.x = ponto.getX();
        this.y = ponto.getY();
        this.z = ponto.getZ();
    }

    public Ponto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public int compareTo(Object o) {
        Ponto ponto = (Ponto)o;
        if(this.x == ponto.getX()){
            if(this.y == ponto.getY()){
                if(this.z == ponto.getZ()){
                    return 0;
                }
            }
        }
        return 1;
    }

    public double distancia(Ponto ponto){
        return Math.sqrt(Math.pow(this.x - ponto.getX(), 2) + Math.pow(this.y - ponto.getY(), 2));
    }

}
