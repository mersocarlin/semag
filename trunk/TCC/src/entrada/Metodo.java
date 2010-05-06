
package entrada;

/**
 *
 * @author Hemerson
 */
public class Metodo {
    /* xmax e ymax para plotar na tela */
    private double xmax;
    private double ymax;

    public Metodo() {
        this.xmax = 0.0;
        this.ymax = 0.0;
    }

    public Metodo(Metodo metodo) {
        this.xmax = metodo.getXmax();
        this.ymax = metodo.getYmax();
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public double getYmax() {
        return ymax;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }
}
