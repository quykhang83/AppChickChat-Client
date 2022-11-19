package viewer;

import model.Account;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginFrame extends javax.swing.JFrame {

    private String host = "localhost";
    private int port = 9999;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private Account account;

    public LoginFrame() {
        initComponents();
        labelNotification.setVisible(false);
        setIconImage();
        scaleImage();
        //Replacing the password character to dot
        txtPassword.setEchoChar('\u25cf');

        this.lbHidePW.setVisible(false);
    }

    //title
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/tchat_title_white.png")));
    }

    public void scaleImage() {
        //logo
        ImageIcon thongtinKhachHang_icon = new ImageIcon(getClass().getResource("/Image/tchat_logo.png"));
        Image thongtinKH_img = thongtinKhachHang_icon.getImage();
        Image thongtinKHImgScale = thongtinKH_img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon thongtinKHScaledIcon = new ImageIcon(thongtinKHImgScale);
//        lblLogo.setIcon(thongtinKHScaledIcon);

        //Show password icon
        ImageIcon show_icon = new ImageIcon(getClass().getResource("/Image/show_icon.png"));
        Image showicon_img = show_icon.getImage();
        Image showIconImgScale = showicon_img.getScaledInstance(lbShowPW.getWidth(), lbShowPW.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon showIconScaledIcon = new ImageIcon(showIconImgScale);
        lbShowPW.setIcon(showIconScaledIcon);

        //Hide password icon
        ImageIcon hide_icon = new ImageIcon(getClass().getResource("/Image/hide_icon.png"));
        Image hideicon_img = hide_icon.getImage();
        Image hideIconImgScale = hideicon_img.getScaledInstance(lbHidePW.getWidth(), lbHidePW.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hideIconScaledIcon = new ImageIcon(hideIconImgScale);
        lbHidePW.setIcon(hideIconScaledIcon);
    }

    // kiem tra ten tai khoan co chua khoang trong khong
    public boolean checkUsername(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch == ' ') {
                return false;
            }

        }
        return true;
    }

    public String check() {

        if (txtUserName.getText().equals("") && txtPassword.getText().equals("")) {
            return "Please enter username and password.";
        } else if (txtUserName.getText().equals("")) {
            return "Please enter your password.";
        } else if (txtPassword.getText().equals("")) {
        } else if (txtPassword.getText().length() < 8) {
            return "Password must be at least 8 characters.\n";
        } else if (!checkUsername(txtUserName.getText())) {
            return "Username does not contain spaces.";
        }
        return "OK";
    }

    public String login(Account a) {
        try {
            connectToServer();
            output.writeUTF("Log in");
            output.writeUTF(a.getUserName());
            output.writeUTF(a.getPassword());
            output.flush();
            String response;
            response = input.readUTF();
            String linkavatar = input.readUTF();
            account.setAvatar(linkavatar);
            System.out.println("da" + response);
            return response;
        } catch (IOException e) {
            return "Network error: " + e.getMessage();
        }
    }

    public String signup(Account acc) {
        try {
            connectToServer();
            output.writeUTF("Sign up");
            output.writeUTF(acc.getUserName());
            output.writeUTF(acc.getPassword());
            output.flush();
            String response = input.readUTF();
            return response;
        } catch (IOException e) {
            return "Network error: " + e.getMessage();
        }
    }

    public void connectToServer() {
        try {
            if (socket != null) {
                socket.close();
            }
            socket = new Socket(host, port);
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUserName = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        labelNotification = new javax.swing.JLabel();
        lbShowPW = new javax.swing.JLabel();
        lbHidePW = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TchaT");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        labelUserName.setBackground(new java.awt.Color(0, 0, 0));
        labelUserName.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelUserName.setText("Username");
        jPanel1.add(labelUserName);
        labelUserName.setBounds(60, 180, 130, 31);

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cc.PNG"))); // NOI18N
        jPanel1.add(lblLogo);
        lblLogo.setBounds(160, 10, 154, 150);

        txtUserName.setBackground(new java.awt.Color(222, 222, 222));
        txtUserName.setFont(new java.awt.Font("Bahnschrift", 0, 22)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(91, 90, 90));
        txtUserName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtUserName);
        txtUserName.setBounds(180, 180, 180, 34);

        labelPassword.setBackground(new java.awt.Color(0, 0, 0));
        labelPassword.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelPassword.setText("Password");
        jPanel1.add(labelPassword);
        labelPassword.setBounds(60, 220, 130, 34);

        btnLogin.setBackground(new java.awt.Color(30, 30, 30));
        btnLogin.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(70, 310, 130, 39);

        btnSignUp.setBackground(new java.awt.Color(30, 30, 30));
        btnSignUp.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(255, 255, 255));
        btnSignUp.setText("Sign Up");
        btnSignUp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSignUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUp);
        btnSignUp.setBounds(270, 310, 130, 39);

        labelNotification.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(labelNotification);
        labelNotification.setBounds(210, 240, 230, 34);

        lbShowPW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/show_icon.png"))); // NOI18N
        lbShowPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbShowPWMousePressed(evt);
            }
        });
        jPanel1.add(lbShowPW);
        lbShowPW.setBounds(370, 220, 40, 40);

        lbHidePW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hide_icon.png"))); // NOI18N
        lbHidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHidePWMousePressed(evt);
            }
        });
        jPanel1.add(lbHidePW);
        lbHidePW.setBounds(370, 220, 40, 40);

        txtPassword.setBackground(new java.awt.Color(222, 222, 222));
        txtPassword.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtPassword);
        txtPassword.setBounds(180, 220, 180, 34);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (!check().equals("OK")) {
            labelNotification.setVisible(true);
            labelNotification.setForeground(Color.red);
            labelNotification.setText(check());
        } else {
            labelNotification.setVisible(false);
            account = new Account();
            account.setUserName(txtUserName.getText());
            account.setPassword(txtPassword.getText());
            String response = login(account);
            if (response.equals("Login successful")) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            ChatFrame frame = new ChatFrame(account, input, output);
                            frame.setVisible(true);
                            setVisible(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                labelNotification.setVisible(true);
                btnLogin.setEnabled(true);
                btnSignUp.setEnabled(true);
                txtPassword.setText("");
                labelNotification.setText(response);
            }
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        if (check().equals("OK")) {
            labelNotification.setVisible(false);
            Account newUser = new Account();
            newUser.setUserName(txtUserName.getText());
            newUser.setPassword(txtPassword.getText());
            String response = signup(newUser);
            if (response.equals("Sign up successful")) {
                JOptionPane.showMessageDialog(rootPane, "Sign up successful");
                labelNotification.setText(" ");
            } else {
                labelNotification.setVisible(true);
                labelNotification.setText(response);
            }
        } else {
            labelNotification.setVisible(true);
            labelNotification.setText(check());
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void lbShowPWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShowPWMousePressed
        lbHidePW.setVisible(true);
        lbShowPW.setVisible(false);
        txtPassword.setEchoChar((char) 0);
    }//GEN-LAST:event_lbShowPWMousePressed

    private void lbHidePWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHidePWMousePressed
        lbShowPW.setVisible(true);
        lbHidePW.setVisible(false);
        txtPassword.setEchoChar('\u25cf');
    }//GEN-LAST:event_lbHidePWMousePressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!check().equals("OK")) {
                labelNotification.setVisible(true);
                labelNotification.setForeground(Color.red);
                labelNotification.setText(check());
            } else {
                labelNotification.setVisible(false);
                account = new Account();
                account.setUserName(txtUserName.getText());
                account.setPassword(txtPassword.getText());
                String response = login(account);
                if (response.equals("Login successful")) {
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ChatFrame frame = new ChatFrame(account, input, output);
                                frame.setVisible(true);
                                setVisible(false);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    labelNotification.setVisible(true);
                    btnLogin.setEnabled(true);
                    btnSignUp.setEnabled(true);
                    txtPassword.setText("");
                    labelNotification.setText(response);
                }
            }

        }
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel lbHidePW;
    private javax.swing.JLabel lbShowPW;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
