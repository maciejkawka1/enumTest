package enumy;

public enum Continent {

    ASIA(44.6),
    AFRICA(30.4),
    NORTHAMERICA(24.2),
    SOUTHAMERICA(17.8),
    ANTARCTICA(13.2),
    EUROPE(10.2),
    AUSTRALIA(7.7);

    private final double area;

    public double getArea() {
        return area;
    }

    Continent(double area){
        this.area = area;
    }

    public static Continent findTheSmallest() {
        double max = Double.MAX_VALUE;
        Continent finded = Continent.AFRICA;

        for (Continent continent : Continent.values()) {
            if (continent.getArea() <= max) {
                max = continent.getArea();
                finded = continent;
            }
        }
        return finded;
    }

    public static Continent findTheLargest() {
        double min = Double.MIN_VALUE;
        Continent finded = Continent.AFRICA;

        for (Continent continent : Continent.values()) {
            if (continent.getArea() >= min) {
                min = continent.getArea();
                finded = continent;
            }
        }
        return finded;
    }



}
