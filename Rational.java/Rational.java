public class Rational extends Number implements Comparable<Rational> {
    private long num;
    private long denom;

    public Rational() {
        num = 0;
        denom = 1;
    }

    public Rational(long num, long denom) {
        long gcd = gcd(num, denom);
        if (denom > 0) {
            this.num = num / gcd;
        }
        else {
            this.num = -num / gcd;
        }
        this.denom = Math.abs(denom) / gcd;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }

    public long getNumerator() {
        return num;
    }

    public long getDenominator() {
        return denom;
    }

    public Rational add(Rational r) {
        long n = num * r.denom + denom * r.num;
        long d = denom * r.denom;
        return new Rational(n, d);
    }

    public Rational subtract(Rational r) {
        long n = num * r.denom - denom * r.num;
        long d = denom * r.denom;
        return new Rational(n, d);
    }

    public Rational multiply(Rational r) {
        long n = num * r.denom;
        long d = denom * r.num;
        return new Rational(n, d);
    }

    public Rational divide(Rational r) {
        long n = num * r.denom;
        long d = denom * r.num;
        return new Rational(n, d);
    }

    public double doubleValue() {
        return (double) num / denom;
    }

    public float floatValue() {
        return (float) num / denom;
    }

    public int intValue() {
        return (int) (num / denom);
    }

    public long longValue() {
        return (long) num / denom;
    }

    @Override
    public String toString() {
        if (denom == 1) {
            return num + "";
        }
        else {
            return num + "/" + denom;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this.subtract((Rational) (other)).getNumerator() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator() > 0) {
            return 1;
        }
        else if (this.subtract(o).getNumerator() < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
