public class ElectronTest {

    public static void main(String[] args) {
        Electron e1 = new Electron();
        Electron e2 = new Electron();

        e1.setRX(-1);
        e1.setRY(0);

        e1.setVX(0.5);
        e1.setVY(0);

        e2.setRX(1);
        e2.setRY(0);

        e2.setVX(-0.5);
        e2.setVY(0);

        StdDraw.setXscale(-5,5);
        StdDraw.setYscale(-5,5);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.circle(e1.getRX(),e1.getRY(),1);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.circle(e2.getRX(),e2.getRY(),1);

        while(true) {
            e1.interaction(e2);
            e2.interaction(e1);
            e1.updatePosition();
            e2.updatePosition();

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.circle(e1.getRX(),e1.getRY(),1);

            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.circle(e2.getRX(),e2.getRY(),1);

        }

    }

}
