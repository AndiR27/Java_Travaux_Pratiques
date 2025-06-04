package TP10_Correction.Ex2;

import TP10_Correction.Ex2.Domaine.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bdd {
    public static List<Table> getListeTables() {
        List<Table> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/TP10_Correction/Ex2/LstTables.csv"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] champs = ligne.split(";");
                if (champs[0].startsWith("R")) {
                    data.add(new TableRect(champs[0], Integer.parseInt(champs[1]), Matiere.valueOf(champs[2]), Integer.parseInt(champs[3]), Integer.parseInt(champs[4])));
                } else {
                    data.add(new TableRonde(champs[0], Integer.parseInt(champs[1]), Matiere.valueOf(champs[2]), Integer.parseInt(champs[3])));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
        return data;
    }
}