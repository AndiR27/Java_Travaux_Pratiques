package TP11_Correction_Exa_2020.ExaQ1_GestionExamens;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

/** 
 * Lecture d'un fichier texte dans un tableau de String
 * @author Ch. Stettler - HEG-Genève */
 
public class FileToStr
{
    private FileToStr() { }
    
    private static final int EOF = -1;
    private static final String DELIMITEURS_LIGNES = "\n\r";
    private static final String DELIMITEURS_DONNEES = ";\n\r\t\f";
    private static final String DELIMITEURS_MOTS = " .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789";

    private static String read(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            StringBuilder b = new StringBuilder(in.available());
            int c = in.read();
            while (c != EOF) {
                b.append((char)c);
                c = in.read();
            }
            in.close();
            return b.toString();
        }
        catch (FileNotFoundException e0) {e0.printStackTrace(); return "";}
        catch (IOException e1) {e1.printStackTrace(); return "";}
    }

    /** Lecture d'un fichier texte dans un String[][].
     * Lit le fichier dont le nom est précisé en paramètre, le découpe par ligne, et découpe chaque ligne par champ.
     * Si le fichier n'existe pas ou s'il y a une erreur de lecture, un tableau de taille 0 est retourné.
     * @param fileName Le nom du fichier texte à lire.
     * @return le String[][] contenant l'ensemble des lignes du fichier lu, découpées par champ. */
    public static String[][] lireCsv(String fileName) {
        String str = read(fileName);
        List<String[]> a = new ArrayList<>();
        int nbChamps = 0;
        StringTokenizer sT = new StringTokenizer(str, DELIMITEURS_LIGNES);
        while (sT.hasMoreTokens()) {
            StringTokenizer sTL = new StringTokenizer(sT.nextToken(), DELIMITEURS_DONNEES);
            List<String> lstChamps = new ArrayList<>();
            while (sTL.hasMoreTokens()) {lstChamps.add(sTL.nextToken());}
            Object[] o = lstChamps.toArray(); nbChamps = o.length; String[] res = new String[o.length];
            for (int k = 0; k < o.length; k++) {res[k] = (String)o[k];}
            a.add(res);
        }
        Object[] o = a.toArray(); String[][] res = new String[o.length][nbChamps];
        for (int k = 0; k < o.length; k++) {res[k] = (String[])o[k];}
        return res;
    }
}