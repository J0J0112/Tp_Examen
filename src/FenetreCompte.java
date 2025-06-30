import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FenetreCompte extends JFrame implements ActionListener {
    private CompteBancaire compte;
    private JLabel soldeLabel;
    private JTextField montantField;
    private JButton deposerButton, retirerButton;
    private JLabel messageLabel;

    public FenetreCompte() {
        compte = new CompteBancaire();

        setTitle("Gestion de Compte Bancaire");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        soldeLabel = new JLabel("Solde actuel : 0.0 $");
        soldeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(soldeLabel);

        montantField = new JTextField();
        add(new JLabel("Montant :"));
        add(montantField);

        JPanel buttonPanel = new JPanel();
        deposerButton = new JButton("Déposer");
        retirerButton = new JButton("Retirer");
        deposerButton.addActionListener(this);
        retirerButton.addActionListener(this);
        buttonPanel.add(deposerButton);
        buttonPanel.add(retirerButton);
        add(buttonPanel);

        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String texte = montantField.getText();
        double montant;

        try {
            montant = Double.parseDouble(texte);
        } catch (NumberFormatException ex) {
            messageLabel.setText("Veuillez entrer un montant valide.");
            return;
        }

        if (e.getSource() == deposerButton) {
            compte.deposer(montant);
            messageLabel.setText("Dépôt effectué.");
        } else if (e.getSource() == retirerButton) {
            if (compte.retirer(montant)) {
                messageLabel.setText("Retrait effectué.");
            } else {
                messageLabel.setText("Fonds insuffisants !");
            }
        }

        afficherSolde();
        montantField.setText("");
    }

    private void afficherSolde() {
        soldeLabel.setText("Solde actuel : " + compte.getSolde() + " €");
    }

    public static void main(String[] args) {
        new FenetreCompte();
    }
}
