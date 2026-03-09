package org.example;

public class VenteParModele {
    private int pieceGetz;
    private int piecePride;
    private int pieceLacetti;

    public int getPieceGetz() {
        return pieceGetz;
    }

    public void setPieceGetz(int pieceGetz) {
        this.pieceGetz = pieceGetz;
    }

    public int getPieceLacetti() {
        return pieceLacetti;
    }

    public void setPieceLacetti(int pieceLacetti) {
        this.pieceLacetti = pieceLacetti;
    }

    public int getPiecePride() {
        return piecePride;
    }

    public void setPiecePride(int piecePride) {
        this.piecePride = piecePride;
    }

    @Override
    public String toString() {
        return "VenteParModele{" +
                "pieceGetz=" + pieceGetz +
                ", piecePride=" + piecePride +
                ", pieceLacetti=" + pieceLacetti +
                '}';
    }

}
