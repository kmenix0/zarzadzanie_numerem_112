// ------------------------
// Zarządzanie numerem 112.
// ------------------------

import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean isOnDuty = true;
        String isReportPlural;
        String[][][] reports = new String[6][2][];
        reports[0][0] = new String[] {"Straż Pożarna"};
        reports[0][1] = new String[] {"Widzę palący się samochód, wydaje się, że nikogo w nim nie ma", "Z jednego z domków jednorodzinnych wydobywa się dym", "Proszę tu kogoś przysłać, właśnie doszło do wybuchu butli gazowej", "Palą się dwa śmietniki, takie większe - kontenerowe"};

        reports[1][0] = new String[] {"Pogotowie Ratunkowe"};
        reports[1][1] = new String[] {"Tutaj leży nieprzytomna kobieta", "Facet stracił przytomność, nie reaguje", "Jakieś dziecko ma trudności z oddychaniem, wydaje się być w poważnym stanie", "Mam tutaj rannego chłopaka, po upadku, nie może wstać", "Ból w klatce piersiowej, osoba wygląda na bardzo osłabioną"};

        reports[2][0] = new String[] {"Policja"};
        reports[2][1] = new String[] {"Ktoś ukradł właśnie moją walizke, mam tam bardzo cenne przedmioty", "Pracuje w ochronie, jeden z przechodniów poinformował mnie, że widział jak jakiś dziwny chłopak zostawił pod ławką plecak. Na pewno specjalnie", "Jakiś idiota próbował, ukraść mój rower. Potrzebny patrol", "Widzę grupke osób z kijami bejsbolowymi, którzy idą środkiem drogi"};

        reports[3][0] = new String[] {"Pogotowie Ratunkowe i Policja"};
        reports[3][1] = new String[] {"Mężczyzna leży na ławce, chyba jest pijany", "Jacyś kibole wracająć ze stadionu pobili chłopaka bo się do nich odezwał. Teraz leży i się nie rusza. Ta grupa widze jak stoi jakieś 100 metrów od niego. Potrzebna pomoc", "Jestem kierowcą taksówki, był kurs z lotniska i jakaś dziewczyna zwymiotowała w moim aucie. Mówi, że się źle czuje i ciągle powtarza, żeby z niej to wyciągneli. Przyszlijście tu kogoś i niech ją zabiorą"};

        reports[4][0] = new String[] {"Policja i Straż Pożarna"};
        reports[4][1] = new String[] {"Niedaleko mojego mieszkania jakaś dziewczyna najpierw krzyczała, a teraz trzyma w ręku butelke i zapalniczke. Wygląda jakby krzyczatała do któregoś z okien", "Lokalni huligani podpalili kiosk. Uciekli za blok nr 2"};

        reports[5][0] = new String[] {"Straż Pożarna i Pogotowie Ratunkowe"};
        reports[5][1] = new String[] {"Doszło do wypadku, na drodze powiatowej nr 72. Jeden samochód leży na boku, w drugim jest nieprzytomny mężczyzna", "Wypadek z dużymi uszkodzeniami, w okolicy czuję spaleniznę"};

        List<String> reporters = Arrays.asList(
                "Jan Kowalski", "Michał Nowak", "Piotr Wiśniewski", "Andrzej Lewandowski", "Tomasz Zieliński",
                "Adam Wójcik", "Krzysztof Szymański", "Paweł Kwiatkowski", "Łukasz Jabłoński", "Mateusz Dąbrowski"
        );
        List<String> locations = Arrays.asList(
                "Na wysokości ulicy Sudeckiej 40", "Skrzyżowanie Jaracza i Kołątaja", "Obok teatru na Szpitalnej",
                "Kościuszki 20", "Cmentarna", "Aleje Jana Pawła II", "Plac Piłsudskiego", "Obok urzędu miasta, szybko",
                "Rondo Inwalidów", "ulica Pięciomorgowa 12", "ul. Pięciomorgowa 12", "ul. Królewska", "plac Zbawiciela",
                "ul. Długa 34", "ul. Warszawska i Wrocławska", "al. Niepodległości", "ul. Mickiewicza 7", "plac Bankowy"
        );

        int operatorBadge = myMath.random(1,50);

        while(isOnDuty) {
            TimeUnit.SECONDS.sleep(myMath.random(5,10));
            int whichReport = myMath.random(0, reports.length);

            System.out.println("----------");
            System.out.println("Dzwoni telefon!".toUpperCase());
            System.out.println("----------");
            System.out.println("Wpisz 'Odbieram' lub 'Rozłączam'");
            Scanner scanner = new Scanner(System.in);
            String phoneDecision = scanner.nextLine();

            if(phoneDecision.equals("Odbieram")) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Operator: Operator " + operatorBadge + ", w czym mogę pomóc?");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Zgłaszający: " + reports[whichReport][1][myMath.random(0,reports[whichReport][1].length)]);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("   [1] Lokalizacja miejsca zdarzenia");
                System.out.println("   [2] Imię i nazwisko zgłaszającego");
                scanner = new Scanner(System.in);
                String whichQuestion = scanner.nextLine();
                TimeUnit.SECONDS.sleep(1);
                switch(whichQuestion) {
                    case "1":
                        System.out.println("Operator: Gdzie to się dzieje?");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Zgłaszający: " + locations.get(myMath.random(0, locations.size())));
                        break;
                    default:
                        System.out.println("Operator: Proszę podać swoję imię i nazwisko");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Zgłaszający: " + reporters.get(myMath.random(0, reporters.size())));
                }
                TimeUnit.SECONDS.sleep(1);
                if(whichQuestion.equals("1")) {
                    System.out.println("   [2] Imię i nazwisko zgłaszającego");
                } else {
                    System.out.println("   [1] Lokalizacja miejsca zdarzenia");
                }
                scanner = new Scanner(System.in);
                String whichQuestion2 = scanner.nextLine();
                TimeUnit.SECONDS.sleep(1);
                switch(whichQuestion2) {
                    case "1":
                        System.out.println("Operator: Gdzie to się dzieje?");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Zgłaszający: " + locations.get(myMath.random(0, locations.size())));
                        break;
                    default:
                        System.out.println("Operator: Proszę podać swoję imię i nazwisko");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("Zgłaszający: " + reporters.get(myMath.random(0, reporters.size())));
                }
                TimeUnit.SECONDS.sleep(1);
                if(whichReport>=3) {
                    isReportPlural = "są";
                } else {
                    isReportPlural = "jest";
                }
                System.out.println("Dziękuje, " + reports[whichReport][0][0] + " " + isReportPlural + " w drodze!");
                System.out.println("..........");
                TimeUnit.SECONDS.sleep(10);
            } else if(phoneDecision.equals("Rozłączam")) {
                System.out.println("Rozłączono");
            } else {
                System.exit(0);
            }
        }
    }
}