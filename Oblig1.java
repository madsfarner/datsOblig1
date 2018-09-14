import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args) {
        int rand1[] = {3, 8, 1, 4, 5, 2, 6, 7};
        int rand2[] = {1, 2, 3, 4, 6, 6, 6, 7 ,8 ,8 ,8};
        int rand3[] = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        char char1[] = {'A', 'B', 'C', 'D', 'R', 'G'};
        rotasjon(char1, 1);
        System.out.println(Arrays.toString(char1));


    }

    public static int maks(int[] a){
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen som blir sent til metoden maks er tom");
        }
        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]){
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
            }
        }
        return a[a.length-1];
    }

    /*  1 sammenlikning for å sjekke for noSuchElementException
        2 sammenlikninger i for-løkka (for + if)
        3n+1 sammenlikninger totalt for en tabell med n verdier */
    /*  Når blir det flest ombyttinger? -
            Når det blir gjort et bytte for hver if test, altså at største tall er først i rekka
        Når blir det færrest?
            Når tabellen står i stigende rekkefølge, så i hver sammenlikning er det større tallet senere i rekka
        Hvor mange blir det i gjennomsnitt? */

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen som blir sent til metoden ombyttinger er tom");
        }
        int teller = 0;
        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]) {
                int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
                teller++;
            }
        }
        return teller;
    }

    public static float gjennomsnittOmbyttinger(int a){
        int minetall[];
        int totaltBytter = 0;
        for( int i = 0; i < a; i++) {
            minetall = randomArray1(15);
            totaltBytter += ombyttinger(minetall);
        }
        return (float)(totaltBytter) / (float)(a);
    }

    /* Denne metoden er ganske mye tregere enn maks metodene tidligere, siden denne gjør mange ombytter for å sortere tabellen, før man finner maksverdi */

    //////////////////////
    // OPPG 2
    //////////////////////

    /* Intererer igjennom tabellen, sjekker først for feilsorteringer, så sjekker om verdier er ulike. Hvis de er det telles det opp i en variabel */

    public static int antallUlikeSortert(int[] a) {
        int ulike = 1;
        if ( a.length == 0) {
            return 0;
        }
        for ( int i = 0; i < a.length-1; ++i) {
            if (a[i] > a[i+1]) {
                throw new IllegalStateException("Tabellen er ikke stigende");
            }
            if (a[i] != a[i+1]) {
                ulike++;
            }
        }
        return ulike;
    }

    //////////////////////
    //  OPPG 3
    //////////////////////
    /*
    1. Søke igjennom hvert tall i rekka
    2. Sjekke opp mot tidligere gjennomsøkte tall
    3. Trigge hvis tidligere tall er blitt talt(hvis det finnes tidligere tall allerede i tabellen)
     */

    public static int antallUlikeUsortert(int[] a){
        if(a.length == 0) {
            return 0;
        }
        int teller = 0;
        boolean trigger;
        for ( int i = 0; i < a.length; ++i){
            trigger = false;
            for ( int j = i-1; j >= 0; --j){
                if( a[j] == a[i]){
                    trigger = true;
                    j = 0;
                }
            }
            if (trigger != true) {
                teller++;
            }
        }
        return teller;
    }


    ///////////////////////////
    // OPPG 4
    /////////////////////

    /*
    Denne fungerer ganske tilsvarende bubblesearch, men sjekker også etter tilfeller hvor et oddetall står før et partall og ignorerer disse.
    eller hvis det står et partall før et oddetall bytter den uansett
     */

    public static int[] delsortering(int[] a){
        for( int i = a.length; i > 0; --i) {
            for ( int j = 1; j < i; ++j) {
                if( a[j-1] > a[j]){
                    if(!(a[j-1] % 2 == 1 && a[j] % 2 == 0)){
                        bytt(a, j-1, j);
                    }
                } else if( a[j-1] % 2 == 0 && a[j] % 2 == 1) {
                    bytt(a, j-1, j);
                }
            }
        }
        return a;
    }

    //////////////////////
    // OPPG 5 + 6
    //////////////////////

    public static void rotasjon(char[] a){
        if(a.length <= 1){
            return;
        }
        char temp = a[a.length-1];
        for(int i = a.length-1; i >= 1; i--){
            a[i] = a[i-1];
        }
        a[0] = temp;
    }

    public static void rotasjon(char[] a, int k){
        int length = a.length;
        if(length <= 1){
            return;
        }
        k = ( k < 0 ) ? (k % length) + length : k % length;

        char temp = a[0];
        System.out.println("K: " + k);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            int getPos = (k > i) ? (i + length - k) : i - k;
            System.out.println("i: " + i + " getPos: " + getPos + " newK: " + k + "char: ");
            a[i] = (getPos==0) ? temp : a[getPos];
        }
        a[a.length - 1] = temp;
    }

    /////////////////////////
    // OPPGAVE 7
    /////////////////////////

    public static String flett(String s, String t) {
        return "";
    }

    /////////////////////////
    // OPPGAVE 8
    /////////////////////////

    public static int[] indekssortering(int[] a) {
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MINE EKSTRA METODER
    /////////////////

    public static int[] bytt(int[] a, int fra, int til){
        int temp = a[fra];
        a[fra] = a[til];
        a[til] = temp;
        return a;
    }
    public static void printCharArray(char[] a) {
        for (char element: a) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    // METODER FRA UNDERVISNINGEN
    /////////////////

    public static void printArray(int[] a) {
        for (int element: a) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
    public static int[] randomArray1(int num_values) {
        int values[] = new int[num_values];
        int taken[] = new int[num_values];

        // Loop over arrayen og fyll med tall
        for (int i=0; i<num_values; ++i) {
            //values[i] = i+1;
            int random_value = (int) (Math.random()*num_values + 1);
            if (taken[random_value-1] == 1) {
                i = i-1;
            }
            else {
                values[i] = random_value;
                taken[random_value-1] = 1;
            }
        }

        return values;
    }
}
