package org.example;

public class PTKia {
    private double prixKia;

    public double getPrixKia() {
        return prixKia;
    }

    public void setPrixKia(double prixKia) {
        this.prixKia = prixKia;
    }

    @Override
    public String toString() {
        return "PTKia{" +
                "prixKia=" + prixKia +
                '}';
    }
}
