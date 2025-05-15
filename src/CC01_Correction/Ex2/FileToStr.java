//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package CC01_Correction.Ex2;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileToStr {
    private static final int EOF = -1;
    private static final String DELIMITEURS_LIGNES = "\n\r";
    private static final String DELIMITEURS_DONNEES = ";\n\r\t\f";
    private static final String DELIMITEURS_MOTS = " .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789";

    private FileToStr() {
    }

    private static String read(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            StringBuilder b = new StringBuilder(in.available());

            for(int c = in.read(); c != -1; c = in.read()) {
                b.append((char)c);
            }

            in.close();
            return b.toString();
        } catch (FileNotFoundException e0) {
            e0.printStackTrace();
            return "";
        } catch (IOException e1) {
            e1.printStackTrace();
            return "";
        }
    }

    public static String[][] lireCsv(String fileName) {
        String str = read(fileName);
        List<String[]> a = new ArrayList();
        int nbChamps = 0;
        StringTokenizer sT = new StringTokenizer(str, "\n\r");

        while(sT.hasMoreTokens()) {
            StringTokenizer sTL = new StringTokenizer(sT.nextToken(), ";\n\r\t\f");
            List<String> lstChamps = new ArrayList();

            while(sTL.hasMoreTokens()) {
                lstChamps.add(sTL.nextToken());
            }

            Object[] o = lstChamps.toArray();
            nbChamps = o.length;
            String[] res = new String[o.length];

            for(int k = 0; k < o.length; ++k) {
                res[k] = (String)o[k];
            }

            a.add(res);
        }

        Object[] o = a.toArray();
        String[][] res = new String[o.length][nbChamps];

        for(int k = 0; k < o.length; ++k) {
            res[k] = (String[])o[k];
        }

        return res;
    }
}
