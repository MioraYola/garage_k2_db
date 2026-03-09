package org.example;

import java.util.Objects;

public class VenteParMarque {
    private String marque;
    private int nbrePiece;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public VenteParMarque(String marque, int nbrePiece) {
        this.marque = marque;
        this.nbrePiece = nbrePiece;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VenteParMarque that)) return false;
        return getNbrePiece() == that.getNbrePiece() && Objects.equals(getMarque(), that.getMarque());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMarque(), getNbrePiece());
    }

    @Override
    public String toString() {
        return "VenteParMarque{" +
                "marque='" + marque + '\'' +
                ", nbrePiece=" + nbrePiece +
                '}';
    }
}
