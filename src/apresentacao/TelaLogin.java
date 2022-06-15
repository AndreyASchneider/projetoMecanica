/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apresentacao;

import apoio.db.DBConnectionManager;
import apoio.db.DataBaseException;
import apoio.login.Authenticator;
import static apoio.login.CripSenha.transformaMD5;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import negocio.Usuario;
import persistencia.UsuarioDAOPostgreSQL;

/**
 *
 * @author Usuario
 */
public class TelaLogin extends javax.swing.JFrame {

    private Usuario usuario;
    private DBConnectionManager conexao;

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LoginUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LoginPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        LoginEnter = new javax.swing.JButton();
        RecuperaSenha = new javax.swing.JLabel();
        ChamaCadastro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Usuário: ");

        jLabel2.setText("Senha:");

        LoginEnter.setText("Entrar");
        LoginEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginEnterActionPerformed(evt);
            }
        });

        RecuperaSenha.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        RecuperaSenha.setText("Esqueceu a senha?");
        RecuperaSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RecuperaSenhaMousePressed(evt);
            }
        });

        ChamaCadastro.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ChamaCadastro.setText("Ainda não possui conta?");
        ChamaCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ChamaCadastroMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("LOGIN:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RecuperaSenha)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(LoginUser)
                                .addComponent(LoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(LoginEnter)
                                .addGap(24, 24, 24))
                            .addComponent(ChamaCadastro))
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(127, 127, 127))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RecuperaSenha)
                .addGap(69, 69, 69)
                .addComponent(LoginEnter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChamaCadastro)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RecuperaSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecuperaSenhaMousePressed
        System.out.println("Problema é teu!");
    }//GEN-LAST:event_RecuperaSenhaMousePressed

    private void ChamaCadastroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChamaCadastroMousePressed
        JFrame TelaNovoUsuario = new TelaNovoUsuario();
        TelaNovoUsuario.setLocationRelativeTo(null);
        TelaNovoUsuario.setVisible(true);
        dispose();
    }//GEN-LAST:event_ChamaCadastroMousePressed

    private void LoginEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginEnterActionPerformed
        String user = LoginUser.getText();
        String senha = LoginPassword.getText();
        
        conexao = new DBConnectionManager();

        try {
            String sql = "select id from usuario where login = ? and senha = ?;";

            PreparedStatement ps = null;
            try {
                ps = conexao.getConnection().prepareStatement(sql);
            } catch (DataBaseException ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

            ps.setString(1, user);
            ps.setString(2, transformaMD5(senha));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (user.equals("Admin")) {
                    JFrame TelaInicio = new TelaInicio();
                    TelaInicio.setLocationRelativeTo(null);
                    TelaInicio.setVisible(true);
                    dispose();
                } else {
                    //Tela de usuário
                    System.out.println("Aqui terá uma tela de usuário");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_LoginEnterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChamaCadastro;
    private javax.swing.JButton LoginEnter;
    private javax.swing.JPasswordField LoginPassword;
    private javax.swing.JTextField LoginUser;
    private javax.swing.JLabel RecuperaSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
