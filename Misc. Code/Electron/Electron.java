public class Electron {

    private double charge = 1.60217662e-19; //coulombs
    private double mass = 9.10938356e-31; //kilograms
    private double rX;
    private double rY;
    private double vX;
    private double vY;

    public void setRX(double x) {
        this.rX = x;
    }

    public void setRY(double y) {
        this.rY = y;
    }

    public double getRX() {
        return rX;
    }

    public double getRY() {
        return rY;
    }

    public void setVX(double x) {
        this.vX = x;
    }

    public void setVY(double y) {
        this.vY = y;
    }

    public double getVX() {
        return vX;
    }

    public double setVY() {
        return vY;
    }

    public void interaction(Electron e) {
        double distance = Math.sqrt(Math.pow(this.rX - e.rX,2) + Math.pow(this.rY - e.rY,2));
        double force = 9e9 * this.charge * e.charge / Math.pow(distance,2);
        double acceleration = force / this.mass;
        if (this.vX > 0) {
            vX -= acceleration; 
        }
        else {
            vX += acceleration;
        }
        if (this.vY > 0) {
            vY -= acceleration; 
        }
        else {
            vY += acceleration;
        }
    }
        
    public void updatePosition() {
        rX += vX;
        rY += vY;
    }

}
