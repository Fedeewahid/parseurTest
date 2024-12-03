public class TokenManager {
    private String entree;
    private int iCourant = 0; // Current index

    public TokenManager(String entree) {
        this.entree = entree;
    }

    char suivant() {
        if (iCourant < entree.length())
            return entree.charAt(iCourant++);
        return '#'; // End of input marker
    }
}
