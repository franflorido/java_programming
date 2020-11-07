package org.uma.mbd.mdCovid.covid;

public class Region {
    private String region;
    private double ia14;
    private double ia7;
    private double positividad;
    private double ocupCamas;
    private double ocupUCIs;

    public Region(String com, double a14, double a7, double pos, double oc, double ou) {
        region = com;
        ia14 = a14;
        ia7 = a7;
        positividad = pos;
        ocupCamas = oc;
        ocupUCIs = ou;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getIa14() {
        return ia14;
    }

    public void setIa14(double ia14) {
        this.ia14 = ia14;
    }

    public double getIa7() {
        return ia7;
    }

    public void setIa7(double ia7) {
        this.ia7 = ia7;
    }

    public double getPositividad() {
        return positividad;
    }

    public void setPositividad(double positividad) {
        this.positividad = positividad;
    }

    public double getOcupCamas() {
        return ocupCamas;
    }

    public void setOcupCamas(double ocupCamas) {
        this.ocupCamas = ocupCamas;
    }

    public double getOcupUCIs() {
        return ocupUCIs;
    }

    public void setOcupUCIs(double ocupUCIs) {
        this.ocupUCIs = ocupUCIs;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = obj instanceof Region;
        Region region = res?(Region)obj: null;
        return res && this.region.equals(region.region);
    }

    @Override
    public int hashCode() {
        return region.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%-30s%8.2f%8.2f%8.2f%8.2f%8.2f", region, ia14,ia7,positividad,ocupCamas,ocupUCIs);
    }
}
