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
        
        StdDraw.enableDoubleBuffering();
        double time = 0;
        for (; time < T; time += dt) {
            double[] xForces = new double[ps.length];
            double[] yForces = new double[ps.length];
            for (int i = 0; i < ps.length; i++) {
                xForces[i] = ps[i].calcNetForceExertedByX(ps);
                yForces[i] = ps[i].calcNetForceExertedByY(ps);
                ps[i].update(dt, xForces[i], yForces[i]);

            }

            StdDraw.clear();
            StdDraw.picture(0, 0, background);
            for (int i = 0; i < ps.length; i++) {
                ps[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                            ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                            ps[i].yyVel, ps[i].mass, ps[i].imgFileName);   
        }
    }
}
