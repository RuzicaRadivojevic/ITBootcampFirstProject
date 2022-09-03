import java.util.Arrays;
import java.util.Scanner;

public class RuzicaRadivojevic {


    public static int[] nizOfInt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite duzinu niza: ");
        int n = sc.nextInt();
        int[] niz1 = new int[n];
        for (int i = 0; i < niz1.length; i++) {
            System.out.println("Unesite " + i + ". clan niza: ");
            niz1[i] = sc.nextInt();
        }
        System.out.println("Uneti niz je: " + Arrays.toString(niz1));
        return niz1;
    }

    public static String[] nizOfString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite duzinu niza: ");
        int n = sc.nextInt();
        String[] niz1 = new String[n];
        for (int i = 0; i < niz1.length; i++) {
            System.out.println("Unesite " + i + ". clan niza: ");
            niz1[i] = sc.nextLine();
        }

        return niz1;
    }

    public static char[] nizOfChar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite duzinu niza: ");
        int n = sc.nextInt();
        char[] niz1 = new char[n];
        for (int i = 0; i < niz1.length; i++) {
            System.out.println("Unesite " + i + ". clan niza: ");
            niz1[i] = sc.nextLine().charAt(i);
        }

        return niz1;
    }

    //Implementirati metodu int zbirCifara(int n) koja sabira cifre sve dok rezultat ne bude samo jedna cifra.
    //        Npr. 1234 -> 1, 43 -> 7, 55 -> 1, 556 -> 7

    public static int zbirCifara(int korisnikovBroj) {

        int brojCifara;
        int zbir = 0;

        while (true) {
            if (korisnikovBroj <= 0) {
                System.out.println("Uneti broj mora biti veci od 0!");
                break;
            }
            zbir = 0;
            while (korisnikovBroj > 0) {
                brojCifara = korisnikovBroj % 10;
                zbir += brojCifara;
                korisnikovBroj /= 10;
            }
            if (zbir <= 9) {
                break;
            }
            korisnikovBroj = zbir;

        }


        return zbir;

    }


//    Implementirati metodu boolean stepenBroja(int n, int m) koja vraća true ukoliko je n stepen broja m.
//    Npr: (9, 3) -> true, (125, 5) -> true, (13, 4) -> false

    public static boolean stepenBroja(int n, int m) {
        boolean mSeSadrziUN = true;
        int brojac = 1;
        while (brojac < m) {
            brojac *= n;
        }
        if (brojac != m) {
            mSeSadrziUN = false;
        }

        return mSeSadrziUN;
    }


//    Implementirati metodu int[] zbirIndexaNizaMeta(int[] niz, int meta) koja vraća indekse dva elementa koji kada se saberu daju rezultat koji je jednak meti.
//        Npr. ({2, 3, 10, -2}, 5) -> {0, 1}

    public static int[] zbirIndexaNizaMeta(int[] niz, int meta) {
        boolean b = true;

        int index1 = 0;
        int index2 = 0;
        int[] noviNiz;

        for (int i = 0; i < niz.length; i++) {
            for (int k = i + 1; k < niz.length; k++) {
                if (niz[i] + niz[k] == meta) {
                    index1 = i;
                    index2 = k;
                    b = false;
                    break;
                }
            }
        }
        if (b) {
            System.out.println("Trazeni broj nismo uspeli da dobijemo sabiranjem elemenata niza.");
        }
        noviNiz = new int[]{index1, index2};

        return noviNiz;

    }

//     Implementirati metodu String toBinary(int n) koja vraća broj n u binarnom formatu. Uzeti apsolutnu vredost n.
//             Npr. 10 -> 1010, 100 -> 1100100

    public static String toBinary(int n) {
        int brojac = n;
        String rezultat = "";

        while (brojac > 0) {
            String format;
            if ((brojac % 2) == 0) {
                format = "0";
            } else {
                format = "1";
            }

            rezultat = format + rezultat;
            brojac = brojac / 2;
        }
        return rezultat;
    }
    // Implementirati metodu int brojPonavljanja(String s, String recenica) koja vraća broj ponavljanja stringa "s" u rečenici. Hint: istražiti s.split("") metodu.
    //       Npr. ("cao", "cao kako si cao") -> 2

    public static int[] brojPonavljanja(String s, String recenica) {
        String[] razbijenaRec = recenica.split(" ");
        int brojac = 0;

        for (int i = 0; i < razbijenaRec.length; i++) {
            if (s.equals(razbijenaRec[i])) {
                brojac++;
            }
        }

        return new int[]{brojac};

    }

    //Implementirati metodu int[] pomeriNule(int[] niz) koja vraća niz u kome su sve nule pomerene na kraj niza.
    //      Npr. {1, 0, 0, 2, 3} -> {1, 2, 3, 0, 0}

    public static int[] pomeriNule(int[] niz) {

        int brojac = 0;
        for (int i = 0; i < niz.length; i++) {
            if (niz[i] != 0) {
                niz[brojac++] = niz[i];
            }
        }

        while (brojac < niz.length) {
            niz[brojac++] = 0;
        }
        return niz;
    }


    // Implementirati metodu int[] izbaciDuplikate(int[] niz) koja vraća niz bez duplikata.
    //       Npr. {1, 2, 3, 3} -> {1, 2, 3}, {3, 4, 3, 4, 3, 4, 5} -> {3, 4, 5}

    public static int[] izbaciDuplikate(int[] niz) {
        int duzina = niz.length;

        for (int i = 0; i < duzina; i++) {
            for (int j = i + 1; j < duzina; j++) {
                if (niz[i] == niz[j]) {
                    niz[j] = niz[duzina - 1];
                    duzina--;
                    j--;
                }
            }
        }
        int[] noviNiz = new int[duzina];
        System.arraycopy(niz, 0, noviNiz, 0, duzina);

        return noviNiz;

    }

    public static void main(String[] args) {

        //System.out.println("1.Zadatak - Ukupan jednocifren zbir svih unetih cifara je broj " + zbirCifara(12345) + ".");
        //System.out.println("\n2. Zadatak - Da li je uneti broj stepen broja: " + stepenBroja(5, 125));
        //System.out.println("\n3. Zadatak - Niz indeksa elemenata koji daju izabrani broj je :" + Arrays.toString(zbirIndexaNizaMeta(nizOfInt(), 5)));
        //System.out.println("\n4. Zadatak - Uneti broj prikazan u binarnom formatu je : " + (toBinary(50)));
        //System.out.println("\n5. Zadatak - Trazena rec se ponavlja " + Arrays.toString(brojPonavljanja("cao", "cao kako si cao  majko danas")) + " puta u recenici.");
        //  System.out.println("\n6. Zadatak - Niz sa pomerenim nulama na kraju je: " + Arrays.toString(pomeriNule(nizOfInt())));
        System.out.println("\n7. Zadatak - Niz bez duplikata je: " + Arrays.toString(izbaciDuplikate(nizOfInt())));

    }
}



