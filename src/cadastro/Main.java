package cadastro;

import apoio.db.DataBaseException;
import apoio.db.GeradorBanco;
import apoio.splash.SplashPanel;
import apresentacao.TelaLogin;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        try {
            GeradorBanco.createDB();
        } catch (SQLException ex) {
            try {
                SplashPanel s = new SplashPanel();
                s.setVisible(true);
                sleep(13000);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("Banco de dados encontrado! Acessando informações...");
        } catch (DataBaseException ex) {
            try {
                SplashPanel s = new SplashPanel();
                s.setVisible(true);
                sleep(13000);
            } catch (InterruptedException ex1) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("Banco de dados encontrado! Acessando informações...");
        }

        JFrame TelaLogin = new TelaLogin();
        TelaLogin.setLocationRelativeTo(null);
        TelaLogin.setVisible(true);
    }
}
