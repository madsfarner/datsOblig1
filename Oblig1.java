import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args) {
        delsortering(randomArray1(15));
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

    ///////////////////////////
    // OPPG 4
    /////////////////////

    public static void delsortering(int[] a){
        for( int i = 0; i < a.length; ++i) {
            for ( int j = 0; j < i; ++j) {
                if( a[j] > a[j+1]){

                }
            }
        }
    }


    /////////////////
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
