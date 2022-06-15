package apoio.login;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import static apoio.login.CripSenha.transformaMD5;
import apresentacao.TelaCad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Authenticator {

    private DBConnectionManager conexao;

    public Authenticator() throws DataBaseException{
        this.conexao = new DBConnectionManager();
    }


    public static boolean senhasIguais(String a, String b) {
        boolean ok = false;

        if (a.equals(b)) {
            ok = true;
        }

        return ok;
    }

}
