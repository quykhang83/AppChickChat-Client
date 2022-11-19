
package viewer;

import model.Account;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ChangePassworFrame extends javax.swing.JFrame {

    DataInputStream input;
    DataOutputStream output;
    Account account;
    String host = "localhost";
    private int port = 9999;
    private Socket socket;
   ChatFrame chatFrame;
    public ChangePassworFrame(ChatFrame chat,Account account, DataInputStream dis, DataOutputStream dos) {
        initComponents();
        chatFrame = chat;
        this.account = account;
        input = dis;
        output = dos;
        labelNotification.setVisible(false);
        setIconImage();  
        txtCurrentPassword.setEchoChar('\u25cf');
        txtNewPassword.setEchoChar('\u25cf');
        txtConfirmPassword.setEchoChar('\u25cf');
        this.lbHidePW.setVisible(false);       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelChangePass = new javax.swing.JLabel();
        txtCurrentPassword = new javax.swing.JPasswordField();
        labelCurrentPass = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        labelNewPass = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        labelConfirmPass = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnChange = new javax.swing.JButton();
        labelNotification = new javax.swing.JLabel();
        lbShowPW = new javax.swing.JLabel();
        lbHidePW = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TchaT Change Password");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        labelChangePass.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        labelChangePass.setText("Change Password");
        jPanel1.add(labelChangePass);
        labelChangePass.setBounds(160, 20, 300, 40);

        txtCurrentPassword.setBackground(new java.awt.Color(222, 222, 222));
        txtCurrentPassword.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        txtCurrentPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtCurrentPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtCurrentPassword);
        txtCurrentPassword.setBounds(270, 80, 160, 34);

        labelCurrentPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelCurrentPass.setText("Current Password");
        jPanel1.add(labelCurrentPass);
        labelCurrentPass.setBounds(80, 90, 160, 23);

        txtNewPassword.setBackground(new java.awt.Color(222, 222, 222));
        txtNewPassword.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        txtNewPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtNewPassword);
        txtNewPassword.setBounds(270, 130, 160, 34);

        labelNewPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelNewPass.setText("New Password");
        jPanel1.add(labelNewPass);
        labelNewPass.setBounds(80, 140, 160, 23);

        txtConfirmPassword.setBackground(new java.awt.Color(222, 222, 222));
        txtConfirmPassword.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(txtConfirmPassword);
        txtConfirmPassword.setBounds(270, 180, 160, 34);

        labelConfirmPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelConfirmPass.setText("Confirm Password");
        jPanel1.add(labelConfirmPass);
        labelConfirmPass.setBounds(80, 190, 180, 23);

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(51, 51, 51));
        btnBack.setText("Back");
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(270, 300, 130, 39);

        btnChange.setBackground(new java.awt.Color(30, 30, 30));
        btnChange.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChange.setForeground(new java.awt.Color(255, 255, 255));
        btnChange.setText("Change");
        btnChange.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        jPanel1.add(btnChange);
        btnChange.setBounds(430, 300, 130, 39);

        labelNotification.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelNotification.setForeground(new java.awt.Color(204, 0, 0));
        jPanel1.add(labelNotification);
        labelNotification.setBounds(220, 260, 340, 40);

        lbShowPW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/show_icon.png"))); // NOI18N
        lbShowPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbShowPWMousePressed(evt);
            }
        });
        jPanel1.add(lbShowPW);
        lbShowPW.setBounds(450, 130, 40, 40);

        lbHidePW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hide_icon.png"))); // NOI18N
        lbHidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHidePWMousePressed(evt);
            }
        });
        jPanel1.add(lbHidePW);
        lbHidePW.setBounds(450, 130, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cc.PNG"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 220, 150, 160);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //title
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/tchat_title_white.png")));
    }
    public void scaleImage(){
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
    public String checkPassword(){
         if(txtCurrentPassword.getText().equals("") || txtNewPassword.getText().equals("") || txtConfirmPassword.getText().equals("")){
             return "Please enter full information";            
         }
         else if(txtNewPassword.getText().length()<8){
             return "Password must be at least 8 characters";
         }
         else if(txtNewPassword.getText().equals(txtConfirmPassword.getText())==false){
             return "Password does not match";
         }
         else return "OK";
        
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        chatFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        String notification = checkPassword();
        if(notification.equals("OK")==false) {
            labelNotification.setVisible(true);
           labelNotification.setText(notification);
        }
        else{
            try {
                connectToServer();
                output.writeUTF("Change Password");
                output.writeUTF(account.getUserName());
                output.writeUTF(txtCurrentPassword.getText());
                output.writeUTF(txtNewPassword.getText());
                String respon = input.readUTF();
                if(respon.equals("Current Password does not match")){
                    labelNotification.setVisible(true);
                    labelNotification.setText(respon);
                }
                else if(respon.equals("Not Update")){
                    labelNotification.setVisible(true);
                    labelNotification.setText("ERROR");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Update Successful");
                    account.setPassword(txtNewPassword.getText());
                    labelNotification.setText("");
                    labelNotification.setVisible(false);
                    txtConfirmPassword.setText("");
                    txtNewPassword.setText("");
                    txtCurrentPassword.setText("");
                    chatFrame.setPassword(account.getPassword());
                }
            } catch (IOException ex) {
                Logger.getLogger(ChangePassworFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnChangeActionPerformed

    private void lbShowPWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShowPWMousePressed
        lbHidePW.setVisible(true);
        lbShowPW.setVisible(false);
        txtCurrentPassword.setEchoChar((char)0);
        txtNewPassword.setEchoChar((char)0);
        txtConfirmPassword.setEchoChar((char)0);
    }//GEN-LAST:event_lbShowPWMousePressed

    private void lbHidePWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHidePWMousePressed
        lbShowPW.setVisible(true);
        lbHidePW.setVisible(false);
        txtCurrentPassword.setEchoChar('\u25cf');
        txtNewPassword.setEchoChar('\u25cf');
        txtConfirmPassword.setEchoChar('\u25cf');
    }//GEN-LAST:event_lbHidePWMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelChangePass;
    private javax.swing.JLabel labelConfirmPass;
    private javax.swing.JLabel labelCurrentPass;
    private javax.swing.JLabel labelNewPass;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel lbHidePW;
    private javax.swing.JLabel lbShowPW;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPassword;
    // End of variables declaration//GEN-END:variables
}
