// ------------------------
// Zarządzanie numerem 112.
// ------------------------

import java.util.*; // Importowanie wszystkich klas z pakietu java.util
import java.util.Scanner; // Importowanie klasy Scanner do odczytu danych od użytkownika
import java.util.concurrent.TimeUnit; // Importowanie klasy TimeUnit do manipulacji czasem

public class Main { // Definicja klasy głównej
    private static class Write { // Klasa pomocnicza do wypisywania tekstu z opóźnieniem
        private static void inOrder(String Text) throws InterruptedException { // Metoda do wyświetlania tekstu znak po znaku z opóźnieniem
            for(int i = 0; i < Text.length(); i++) { // Iteracja przez każdy znak w podanym tekście
                System.out.print(Text.charAt(i)); // Wyświetlanie aktualnego znaku
                TimeUnit.MILLISECONDS.sleep(100); // Pauza między znakami (100 ms)
            }
            System.out.println(" "); // Dodanie nowej linii po zakończeniu tekstu
        }
    }

    public static void main(String[] args) throws InterruptedException { // Główna metoda programu
        String isReportPlural; // Zmienna do przechowywania formy liczby mnogiej lub pojedynczej
        String[][][] reports = new String[6][2][]; // Tablica trójwymiarowa do przechowywania zgłoszeń
        reports[0][0] = new String[] {"Straż Pożarna"}; // Kategoria "Straż Pożarna"
        reports[0][1] = new String[] {"Widzę palący się samochód, wydaje się, że nikogo w nim nie ma", "Z jednego z domków jednorodzinnych wydobywa się dym", "Proszę tu kogoś przysłać, właśnie doszło do wybuchu butli gazowej", "Palą się dwa śmietniki, takie większe - kontenerowe"}; // Przykłady zgłoszeń do Straży Pożarnej

        reports[1][0] = new String[] {"Pogotowie Ratunkowe"}; // Kategoria "Pogotowie Ratunkowe"
        reports[1][1] = new String[] {"Tutaj leży nieprzytomna kobieta", "Facet stracił przytomność, nie reaguje", "Jakieś dziecko ma trudności z oddychaniem, wydaje się być w poważnym stanie", "Mam tutaj rannego chłopaka, po upadku, nie może wstać", "Ból w klatce piersiowej, osoba wygląda na bardzo osłabioną"}; // Przykłady zgłoszeń do Pogotowia Ratunkowego

        reports[2][0] = new String[] {"Policja"}; // Kategoria "Policja"
        reports[2][1] = new String[] {"Ktoś ukradł właśnie moją walizke, mam tam bardzo cenne przedmioty", "Pracuje w ochronie, jeden z przechodniów poinformował mnie, że widział jak jakiś dziwny chłopak zostawił pod ławką plecak. Na pewno specjalnie", "Jakiś idiota próbował, ukraść mój rower. Potrzebny patrol", "Widzę grupke osób z kijami bejsbolowymi, którzy idą środkiem drogi"}; // Przykłady zgłoszeń do Policji

        reports[3][0] = new String[] {"Pogotowie Ratunkowe i Policja"}; // Kategoria "Pogotowie Ratunkowe i Policja"
        reports[3][1] = new String[] {"Mężczyzna leży na ławce, chyba jest pijany", "Jacyś kibole wracająć ze stadionu pobili chłopaka bo się do nich odezwał. Teraz leży i się nie rusza. Ta grupa widze jak stoi jakieś 100 metrów od niego. Potrzebna pomoc", "Jestem kierowcą taksówki, był kurs z lotniska i jakaś dziewczyna zwymiotowała w moim aucie. Mówi, że się źle czuje i ciągle powtarza, żeby z niej to wyciągneli. Przyszlijście tu kogoś i niech ją zabiorą"}; // Przykłady zgłoszeń dla obu służb

        reports[4][0] = new String[] {"Policja i Straż Pożarna"}; // Kategoria "Policja i Straż Pożarna"
        reports[4][1] = new String[] {"Niedaleko mojego mieszkania jakaś dziewczyna najpierw krzyczała, a teraz trzyma w ręku butelke i zapalniczke. Wygląda jakby krzyczatała do któregoś z okien", "Lokalni huligani podpalili kiosk. Uciekli za blok nr 2"}; // Przykłady zgłoszeń dla Policji i Straży Pożarnej

        reports[5][0] = new String[] {"Straż Pożarna i Pogotowie Ratunkowe"}; // Kategoria "Straż Pożarna i Pogotowie Ratunkowe"
        reports[5][1] = new String[] {"Doszło do wypadku, na drodze powiatowej nr 72. Jeden samochód leży na boku, w drugim jest nieprzytomny mężczyzna", "Wypadek z dużymi uszkodzeniami, w okolicy czuję spaleniznę"}; // Przykłady zgłoszeń dla obu służb

        List<String> reporters = Arrays.asList( // Lista przykładowych imion i nazwisk zgłaszających
                "Jan Kowalski", "Michał Nowak", "Klaudia Wiśniewska", "Andrzej Lewandowski", "Tomasz Zieliński",
                "Alicja Wójcik", "Krzysztof Szymański", "Paweł Kwiatkowski", "Łukasz Jabłoński", "Wiktoria Dąbrowska",
                "Kacper Mazurek", "Bogdan Limanowski", "Emilia Kaluga", "Jakub Rajewski", "Kamila Pieczonka" // 15
        );
        List<String> locations = Arrays.asList( // Lista przykładowych lokalizacji
                "Na wysokości ulicy Sudeckiej 40", "Skrzyżowanie Jaracza i Kołątaja", "Obok teatru na Szpitalnej",
                "Kościuszki 20", "Cmentarna", "Aleje Jana Pawła II", "Plac Piłsudskiego", "Obok urzędu miasta, szybko",
                "Rondo Inwalidów", "ulica Pięciomorgowa 12", "ul. Pięciomorgowa 12", "ul. Królewska", "plac Zbawiciela",
                "ul. Długa 34", "ul. Warszawska i Wrocławska", "al. Niepodległości", "ul. Mickiewicza 7", "plac Bankowy" // 18
        );

        int operatorBadge = myMath.random(1,50); // Losowanie numeru identyfikatora operatora

        while(true) { // Pętla nieskończona symulująca działanie centrum zgłoszeń
            TimeUnit.SECONDS.sleep(myMath.random(5,10)); // Czas oczekiwania przed kolejnym zgłoszeniem (5-10 sekund) z użyciem autorskiej klasy i metody do losowania liczby
            int whichReport = myMath.random(0, reports.length); // Losowanie rodzaju zgłoszenia

            System.out.println("----------"); // Separator wizualny
            System.out.println("Dzwoni telefon!".toUpperCase()); // Wyświetlenie informacji o dzwoniącym telefonie (duże litery)
            System.out.println("----------"); // Separator wizualny
            System.out.println("Wpisz 'Odbieram' lub 'Rozłączam'"); // Instrukcja dla operatora
            Scanner scanner = new Scanner(System.in); // Inicjalizacja odczytu danych od użytkownika
            String phoneDecision = scanner.nextLine(); // Odczyt decyzji użytkownika (odbieram/rozłączam)

            if(phoneDecision.equals("Odbieram")) { // Sprawdzenie, czy użytkownik zdecydował się odebrać
                TimeUnit.SECONDS.sleep(1); // Pauza na realizm
                Write.inOrder("Operator: Operator " + operatorBadge + ", w czym mogę pomóc?"); // Wyświetlenie pytania od operatora
                TimeUnit.SECONDS.sleep(1); // Pauza na realizm
                Write.inOrder("Zgłaszający: " + reports[whichReport][1][myMath.random(0,reports[whichReport][1].length)]); // Wyświetlenie treści zgłoszenia
                TimeUnit.SECONDS.sleep(1); // Pauza na realizm
                System.out.println("   [1] Lokalizacja miejsca zdarzenia"); // Opcja pytania o lokalizację
                System.out.println("   [2] Imię i nazwisko zgłaszającego"); // Opcja pytania o dane zgłaszającego
                scanner = new Scanner(System.in); // Odczyt wyboru użytkownika
                String whichQuestion = scanner.nextLine(); // Zapis wyboru użytkownika
                TimeUnit.SECONDS.sleep(1); // Pauza
                switch(whichQuestion) { // Obsługa wyboru pytania
                    case "1":
                        Write.inOrder("Operator: Gdzie to się dzieje?"); // Pytanie o lokalizację
                        TimeUnit.SECONDS.sleep(1); // Pauza
                        Write.inOrder("Zgłaszający: " + locations.get(myMath.random(0, locations.size()))); // Wyświetlenie losowej lokalizacji z tablicy
                        break;
                    default:
                        Write.inOrder("Operator: Proszę podać swoję imię i nazwisko"); // Pytanie o dane zgłaszającego
                        TimeUnit.SECONDS.sleep(1); // Pauza
                        Write.inOrder("Zgłaszający: " + reporters.get(myMath.random(0, reporters.size()))); // Wyświetlenie losowego zgłaszającego z tablicy
                }
                TimeUnit.SECONDS.sleep(1); // Pauza
                if(whichQuestion.equals("1")) { // Jeśli pytanie o lokalizację
                    System.out.println("   [2] Imię i nazwisko zgłaszającego"); // Propozycja pytania o dane zgłaszającego
                } else {
                    System.out.println("   [1] Lokalizacja miejsca zdarzenia"); // Propozycja pytania o lokalizację
                }
                scanner = new Scanner(System.in); // Odczyt wyboru użytkownika
                String whichQuestion2 = scanner.nextLine(); // Zapis wyboru użytkownika
                TimeUnit.SECONDS.sleep(1); // Pauza
                switch(whichQuestion2) { // Obsługa drugiego pytania
                    case "1":
                        Write.inOrder("Operator: Gdzie to się dzieje?"); // Pytanie o lokalizację
                        TimeUnit.SECONDS.sleep(1); // Pauza
                        Write.inOrder("Zgłaszający: " + locations.get(myMath.random(0, locations.size()))); // Wyświetlenie losowej lokalizacji z tablicy
                        break;
                    default:
                        Write.inOrder("Operator: Proszę podać swoję imię i nazwisko"); // Pytanie o dane zgłaszającego
                        TimeUnit.SECONDS.sleep(1); // Pauza
                        Write.inOrder("Zgłaszający: " + reporters.get(myMath.random(0, reporters.size()))); // Wyświetlenie losowego zgłaszającego z tablicy
                }
                TimeUnit.SECONDS.sleep(1); // Pauza
                if(whichReport>=3) { // Określenie liczby mnogiej w zależności od kategorii zgłoszenia
                    isReportPlural = "są"; // Forma liczby mnogiej
                } else {
                    isReportPlural = "jest"; // Forma liczby pojedynczej
                }
                Write.inOrder("Dziękuje, " + reports[whichReport][0][0] + " " + isReportPlural + " w drodze!"); // Wyświetlenie potwierdzenia dla zgłaszającego
                System.out.println(".........."); // Separator wizualny
                TimeUnit.SECONDS.sleep(10); // Pauza przed kolejnym zgłoszeniem
            } else if(phoneDecision.equals("Rozłączam")) { // Sprawdzenie, czy użytkownik rozłączył się
                System.out.println("Rozłączono"); // Wyświetlenie komunikatu o rozłączeniu
            } else {
                System.exit(0); // Zakończenie programu w przypadku błędnej decyzji
            }
        }
    }
}