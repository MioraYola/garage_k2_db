package org.example;

public class Vente {
    private int id;
    private PieceAuto pieceAuto;
    private int quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PieceAuto getPieceAuto() {
        return pieceAuto;
    }

    public void setPieceAuto(PieceAuto pieceAuto) {
        this.pieceAuto = pieceAuto;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
