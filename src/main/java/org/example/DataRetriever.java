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
}
