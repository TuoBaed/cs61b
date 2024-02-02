public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    static final double GC = 6.67e-11;

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass  = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass  = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        return GC * this.mass * p.mass / (distance * distance);
    }

    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public boolean equals(Planet p) {
        return this == p;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double netForceX = 0.0;
        for (int i = 0; i < ps.length; i++) {
            if (!this.equals(ps[i])) {
                netForceX += this.calcForceExertedByX(ps[i]);
            }
        }

        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double netForceY = 0.0;
        for (int i = 0; i < ps.length; i++) {
            if (!this.equals(ps[i])) {
                netForceY += this.calcForceExertedByY(ps[i]);
            }
        }

        return netForceY;
    }

    public void update(double dt, double fx, double fy) {
        this.xxVel = this.xxVel + fx / this.mass * dt;
        this.yyVel = this.yyVel + fy / this.mass * dt;

        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
}
