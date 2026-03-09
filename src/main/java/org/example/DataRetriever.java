package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    List<VenteParMarque> venteParMarques() {
        DBConnection dbConnection = new DBConnection();
        List<VenteParMarque> list = new ArrayList<>();
        try(Connection connection = dbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("""
                select m.marque, sum(v.quantite) as nbre_piece
                from vente v
                join piece_auto pa on v.id_piece_auto = pa.id
                join modele_voiture m on pa.id_modele_voiture = m.id
                group by m.marque;
""");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()) {
                String marque = resultSet.getString("marque");
                int nbrePiece = resultSet.getInt("nbre_piece");
                VenteParMarque v = new VenteParMarque(marque, nbrePiece);
                list.add(v);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    VenteParModele venteParModele() {
        DBConnection dbConnection = new DBConnection();
        try(Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("""
                    select
                            sum(case when m.modele='GETZ' then v.quantite else 0 end) as piece_getz,
                            sum(case when m.modele='PRIDE' then v.quantite else 0 end) as piece_pride,
                            sum(case when m.modele='LACETTI' then v.quantite else 0 end) as piece_lacetti
                    from vente v
                    join piece_auto pa on v.id_piece_auto = pa.id
                    join modele_voiture m on pa.id_modele_voiture = m.id;
""");
                ResultSet resultSet = preparedStatement.executeQuery()) {
                    if(resultSet.next()){
                        VenteParModele venteParModele = new VenteParModele();
                        venteParModele.setPieceGetz(resultSet.getInt("piece_getz"));
                        venteParModele.setPiecePride(resultSet.getInt("piece_pride"));
                        venteParModele.setPieceLacetti(resultSet.getInt("piece_lacetti"));
                        return venteParModele;

                    }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    PTKia prixTotalPourKIA() {
        DBConnection dbConnection = new DBConnection();
        try(Connection connection = dbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("""
                    select
                        sum(case when mv.marque = 'KIA' then v.quantite*pa.prix else 0 end) as pt_kia
                    from vente v
                    join piece_auto pa on v.id_piece_auto = pa.id
                    join modele_voiture mv on pa.id_modele_voiture = mv.id;
""");
                ResultSet resultSet = preparedStatement.executeQuery()){
            if(resultSet.next()){
                PTKia prixKia = new PTKia();
                prixKia.setPrixKia(resultSet.getDouble("pt_kia"));
                return prixKia;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
