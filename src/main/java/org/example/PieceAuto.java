package org.example;

public class PieceAuto {
    private int id;
    private ModeleVoiture modeleVoiture;
    private String numeroSerie;
    private double prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModeleVoiture getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(ModeleVoiture modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
