public class Parseur {
    private TokenManager tm;
    private char tc; // Current token

    public Parseur(TokenManager tm) {
        this.tm = tm;
        avancer(); // Initialize the first token
    }

    private void avancer() {
        tc = tm.suivant();
    }

    private void consommer(char attendu) {
        if (tc == attendu) {
            avancer();
        } else {
            throw new RuntimeException("Token attendu: " + attendu + ", " + tc + " trouvé");
        }
    }

    private void S() {
        if (tc == 'b') {
            consommer('b');
            S();
            consommer('b');
        } else if (tc == 'c') {
            consommer('c');
            A();
            consommer('c');
        } else {
            throw new RuntimeException("Token invalide dans S: " + tc);
        }
    }

    private void A() {
        if (tc == 'b') {
            consommer('b');
            A();
            A();
        } else if (tc == 'c') {
            consommer('c');
            A();
            S();
            consommer('A');
            consommer('b');
        } else if (tc == 'd') {
            consommer('d');
            consommer('c');
            consommer('b');
        } else {
            throw new RuntimeException("Token invalide dans A: " + tc);
        }
    }

    public void parse() {
        S();
        if (tc != '#') { // Ensure end of input is reached
            throw new RuntimeException("Token invalide à la fin : " + tc);
        }
    }
}
