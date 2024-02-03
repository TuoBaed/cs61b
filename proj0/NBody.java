public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int count = in.readInt();
        in.readDouble();
        Planet[] ps = new Planet[count];

        int index = 0;
        while (index < count) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            ps[index] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            index++;
        }

        return ps;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.exit(0);
        }
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String path = args[2];
        String background = new String("images/starfield.jpg");

        // universe radius
        double radius = NBody.readRadius(path);
        Planet[] ps = NBody.readPlanets(path);

        
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();

        StdDraw.picture(0, 0, background);

        for (int i = 0; i < ps.length; i++) {
            StdDraw.picture(ps[i].xxPos, ps[i].yyPos, "images/" + ps[i].imgFileName);
        }

        StdDraw.show();
        StdDraw.pause(2000);
        
        // String imageToDraw = "examples/advice.png";

        // StdDraw.setScale(-100, 100);

        /* Clears the drawing window. */
        // StdDraw.clear();

        /* Stamps three copies of advice.png in a triangular pattern. */
        // StdDraw.picture(0, 75, background);
        // StdDraw.picture(-75, -75, background);
        // StdDraw.picture(75, -75, imageToDraw);

        /* Shows the drawing to the screen, and waits 2000 milliseconds. */
        // StdDraw.show();
        // StdDraw.pause(2000);
    }
}
