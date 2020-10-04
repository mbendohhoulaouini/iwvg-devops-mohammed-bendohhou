package es.upm.miw.iwvg_devops.code;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return this.numerator > this.denominator;
    }

    public Fraction add(Fraction fraction) {
        int numerator = (this.numerator * fraction.getDenominator()) +
                (fraction.getNumerator() * this.denominator);
        Fraction resultFraction = new Fraction(numerator, this.denominator * fraction.getDenominator());
        resultFraction.reduce();
        return resultFraction;
    }

    public Fraction multiply(Fraction fraction) {
        Fraction resultFraction = new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
        resultFraction.reduce();
        return resultFraction;
    }

    public Fraction divide(Fraction fraction) {
        Fraction resultFraction = new Fraction(numerator * fraction.getDenominator(), denominator * fraction.numerator);
        resultFraction.reduce();
        return resultFraction;
    }

    private int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    private void reduce() {
        int calculateGCD = calculateGCD(this.numerator, this.denominator);
        this.numerator /= calculateGCD;
        this.denominator /= calculateGCD;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
