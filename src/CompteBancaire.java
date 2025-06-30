public class CompteBancaire {
    private double solde;

    public CompteBancaire() {
        this.solde = 0.0;
    }

    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public boolean retirer(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            return true;
        } else {
            return false;
        }
    }

    public double getSolde() {
        return solde;
    }
}
