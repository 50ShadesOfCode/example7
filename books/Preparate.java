package books;

import java.io.*;
import java.util.*;

public class Preparate implements Serializable {
    // class release version:
    private static final long serialVersionUID = 1L;
    // areas with prompts:
    int apNumber;
    static final String P_apNumber = "ApNumber";
    String name;
    static final String P_name = "Name";
    int amount;
    static final String P_amount = "Amount";
    String dateFrom;
    static final String P_dateFrom = "DateFrom";
    String dateTo;
    static final String P_dateTo = "DateTo";
    double price;
    static final String P_price = "Price";

    // validation methods:
    /*static Boolean validISBN(String str) {
        int i = 0, ndig = 0;
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                ndig++;
                continue;
            }
            if (ch != '-') {
                return false;
            }
        }
        return (ndig == 13 || ndig == 10);
    }*/

    public static boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_apNumber, fin, out);
    }

    static boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static Preparate read(Scanner fin, PrintStream out) throws IOException,
            NumberFormatException {
        String str;
        Preparate preparate = new Preparate();
        preparate.apNumber = Integer.parseInt(fin.nextLine().trim());
        if (!nextRead(P_name, fin, out)) {
            return null;
        }
        preparate.name = fin.nextLine();
        if (!nextRead(P_amount, fin, out)) {
            return null;
        }
        preparate.amount = Integer.parseInt(fin.nextLine());
        if (!nextRead(P_price, fin, out)) {
            return null;
        }
        str = fin.nextLine();
        preparate.price = Double.parseDouble(str);
        if (!nextRead(P_dateFrom, fin, out)){
            return null;
        }
        preparate.dateFrom = fin.nextLine();
        if (!nextRead(P_dateTo, fin, out)){
            return null;
        }
        preparate.dateTo = fin.nextLine();
        return preparate;
    }

    public Preparate() {
    }

    public static final String areaDel = "\n";

    public String toString() {
        return
                apNumber + areaDel +
                        name + areaDel +
                        amount + areaDel +
                        price + areaDel +
                        dateFrom + areaDel +
                        dateTo;
    }
}
