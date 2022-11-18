package viewer;

import model.Account;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import model.FileMessage;
import model.Message;
import model.TextMessage;

public class ChatFrame extends javax.swing.JFrame {

    private Account account = new Account();
    private DataInputStream input;
    private DataOutputStream output;
    Thread receiverThread;
    // Tạo HashMap với khóa là tên người nhận tin nhắn và values là nội dung chat của người dùng hiện tại với khóa(người dùng dc chat chung)
    protected HashMap<String, String> messageContent = new HashMap<String, String>();

    public ChatFrame(Account users, DataInputStream dis, DataOutputStream dos) {
        initComponents();
        labelUserName.setText(users.getUserName());
        account.setUserName(users.getUserName());
        account = users;
        input = dis;
        output = dos;
        //Tạo luồng cho người vừa đăng nhập
        receiverThread = new Thread(new ChatFrame.Receiver(dis));
        receiverThread.start();
        panelAccount.setVisible(false);
        loadavatar();
        setIconImage();
        scaleImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbOnlineUsers = new javax.swing.JComboBox<>();
        labelChatWith = new javax.swing.JLabel();
        panelAccount = new javax.swing.JPanel();
        btnChangePassword = new javax.swing.JButton();
        btnChangeAvatar = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextPane();
        lblLogo = new javax.swing.JLabel();
        labelAvatar = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        btnSendFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TchaT Chat");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(222, 222, 222));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbOnlineUsers.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbOnlineUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online Users" }));
        cbOnlineUsers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbOnlineUsers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOnlineUsersItemStateChanged(evt);
            }
        });

        labelChatWith.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelChatWith.setText("Chat with");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelChatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelChatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1);
        jPanel1.setBounds(540, 30, 400, 60);

        panelAccount.setBackground(new java.awt.Color(222, 222, 222));
        panelAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(51, 51, 51));
        btnChangePassword.setText("Change Password");
        btnChangePassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnChangeAvatar.setBackground(new java.awt.Color(255, 255, 255));
        btnChangeAvatar.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChangeAvatar.setForeground(new java.awt.Color(51, 51, 51));
        btnChangeAvatar.setText("Change Avatar");
        btnChangeAvatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChangeAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeAvatarActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(30, 30, 30));
        btnLogOut.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAccountLayout = new javax.swing.GroupLayout(panelAccount);
        panelAccount.setLayout(panelAccountLayout);
        panelAccountLayout.setHorizontalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnChangeAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelAccountLayout.setVerticalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChangeAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel3.add(panelAccount);
        panelAccount.setBounds(10, 10, 210, 190);

        txtChat.setBackground(new java.awt.Color(222, 222, 222));
        txtChat.setFont(new java.awt.Font("Bahnschrift", 0, 20)); // NOI18N
        txtChat.setForeground(new java.awt.Color(91, 90, 90));
        txtChat.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });
        jPanel3.add(txtChat);
        txtChat.setBounds(240, 490, 550, 39);

        btnSend.setBackground(new java.awt.Color(30, 30, 30));
        btnSend.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("Send");
        btnSend.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        jPanel3.add(btnSend);
        btnSend.setBounds(860, 490, 80, 39);

        jPanel4.setBackground(new java.awt.Color(222, 222, 222));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        chatWindow.setBackground(new java.awt.Color(222, 222, 222));
        chatWindow.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        chatWindow.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        chatWindow.setForeground(new java.awt.Color(91, 90, 90));
        jScrollPane2.setViewportView(chatWindow);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4);
        jPanel4.setBounds(230, 100, 710, 370);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tchat_logo6.png"))); // NOI18N
        lblLogo.setText("jLabel1");
        jPanel3.add(lblLogo);
        lblLogo.setBounds(10, 10, 220, 520);

        labelAvatar.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        labelAvatar.setText("avatar");
        labelAvatar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        labelAvatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAvatarMouseClicked(evt);
            }
        });
        jPanel3.add(labelAvatar);
        labelAvatar.setBounds(230, 10, 80, 80);

        labelUserName.setFont(new java.awt.Font("Bahnschrift", 1, 27)); // NOI18N
        labelUserName.setForeground(new java.awt.Color(91, 90, 90));
        jPanel3.add(labelUserName);
        labelUserName.setBounds(320, 50, 165, 39);

        btnSendFile.setBackground(new java.awt.Color(30, 30, 30));
        btnSendFile.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSendFile.setForeground(new java.awt.Color(255, 255, 255));
        btnSendFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/attached.png"))); // NOI18N
        btnSendFile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFileActionPerformed(evt);
            }
        });
        jPanel3.add(btnSendFile);
        btnSendFile.setBounds(800, 490, 50, 39);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //title

    private void autoScroll() {
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMaximum());
    }

    public void setAvatar(String avatar) {
        account.setAvatar(avatar);
        loadavatar();
    }

    public void setPassword(String pass) {
        account.setPassword(pass);
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/tchat_title_white.png")));
    }

    public void scaleImage() {
        //logo
        ImageIcon thongtinKhachHang_icon = new ImageIcon(getClass().getResource("/Image/tchat_logo6.png"));
        Image thongtinKH_img = thongtinKhachHang_icon.getImage();
        Image thongtinKHImgScale = thongtinKH_img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon thongtinKHScaledIcon = new ImageIcon(thongtinKHImgScale);
        lblLogo.setIcon(thongtinKHScaledIcon);
    }

    private void loadavatar() {
        labelAvatar.setText("");
        labelAvatar.setIcon(new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/" + account.getAvatar())).getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
    }

    public void newMessage(String sender, String receiveString, String message, Boolean yourMessage) {
        TextMessage tm = new TextMessage(message, sender, receiveString, yourMessage);

        if (yourMessage == false && cbOnlineUsers.getSelectedItem().equals(sender) == false) {
            String tmp = messageContent.get(sender);
            messageContent.replace(sender, tmp + sender + ": " + message + "\n");
        } else if (yourMessage == false && sender.equals(cbOnlineUsers.getSelectedItem())) {
//            String v = chatWindow.getText();
//            chatWindow.setText(v + sender + ": " + message + "\n");

            tm.printMessage(sender, chatWindow);
            messageContent.replace(sender, chatWindow.getText());
        } else {
//            String v = chatWindow.getText();
//            chatWindow.setText(v + "You" + ": " + message + "\n");

            tm.printMessage(sender, chatWindow);
            messageContent.replace((String) cbOnlineUsers.getSelectedItem(), chatWindow.getText());
        }
    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
            Thread sendTextThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String messageSent = "Text" + "," + labelUserName.getText() + ","
                                + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();
                        output.writeUTF(messageSent);
                        output.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        newMessage("ERROR", "ERROR", "Network error!", true);
                    }
                    newMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                    autoScroll();
                    txtChat.setText("");
                }

            });
            sendTextThread.start();
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void cbOnlineUsersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOnlineUsersItemStateChanged
        chatWindow.setText("");
        for (String i : messageContent.keySet()) {
            if (i.equals(cbOnlineUsers.getSelectedItem())) {
                chatWindow.setText(messageContent.get(i));
            }
        }
    }//GEN-LAST:event_cbOnlineUsersItemStateChanged

    private void txtChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
                Thread sendTextThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String messageSent = "Text" + "," + labelUserName.getText() + ","
                                    + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();
                            output.writeUTF(messageSent);
                            output.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                            newMessage("ERROR", "ERROR", "Network error!", true);
                        }
                        newMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                        autoScroll();
                        txtChat.setText("");
                    }

                });
                sendTextThread.start();
            }
        }
    }//GEN-LAST:event_txtChatKeyPressed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        ChangePassworFrame jframe = new ChangePassworFrame(this, account, input, output);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int tmp = JOptionPane.showConfirmDialog(chatWindow, "Are you sure Log out?");
        if (tmp == 0) {

            try {
                output.writeUTF("Log out");

                LoginFrame jframe;
                jframe = new LoginFrame();
                jframe.setVisible(true);
                setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnChangeAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeAvatarActionPerformed

        ChangeAvatarFrame jframe = new ChangeAvatarFrame(this, account, input, output);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChangeAvatarActionPerformed
    int click = 0;
    private void labelAvatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAvatarMouseClicked
        if (click == 0) {
            panelAccount.setVisible(true);
            click = 1;
        } else {
            panelAccount.setVisible(false);
            click = 0;
        }
    }//GEN-LAST:event_labelAvatarMouseClicked

    private void btnSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFileActionPerformed
//        Thread sendFileThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                
//            }
//
//        });
//        sendFileThread.start();

        // Hiển thị hộp thoại cho người dùng chọn file để gửi
        JFileChooser fileChooser = new JFileChooser();
        int rVal = fileChooser.showOpenDialog(null);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            byte[] selectedFile = new byte[(int) fileChooser.getSelectedFile().length()];
            BufferedInputStream bis;
            try {
                bis = new BufferedInputStream(new FileInputStream(fileChooser.getSelectedFile()));
                // Đọc file vào biến selectedFile
                bis.read(selectedFile, 0, selectedFile.length);

                String messageSent = "File" + ","
                        + labelUserName.getText() + "," + (String) cbOnlineUsers.getSelectedItem() + ","
                        + fileChooser.getSelectedFile().getName() + "," + String.valueOf(selectedFile.length);

                output.writeUTF(messageSent);

                int size = selectedFile.length;
                int bufferSize = 2048;
                int offset = 0;

                // Lần lượt gửi cho server từng buffer cho đến khi hết file
                while (size > 0) {
                    output.write(selectedFile, offset, Math.min(size, bufferSize));
                    offset += Math.min(size, bufferSize);
                    size -= bufferSize;
                }

                output.flush();

                bis.close();

                // In ra màn hình file
                FileMessage fm = new FileMessage(fileChooser.getSelectedFile().getName(), selectedFile,
                        labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), true);
                fm.printMessage(labelUserName.getText(), chatWindow);
                autoScroll();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSendFileActionPerformed

    class Receiver implements Runnable {

        private DataInputStream input;

        public Receiver(DataInputStream dis) {
            this.input = dis;
        }

        @Override
        public void run() {
            try {
                while (true) {
//                    Thread readMessageThread = new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });
//                    readMessageThread.start();
                    // Chờ thông điệp từ server
                    String[] messageReceived = input.readUTF().split(",");

                    if (messageReceived[0].equals("Text")) {
                        // Nhận một tin nhắn văn bản
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String message = messageReceived[3];
                        // In tin nhắn lên màn hình chat với người gửi
                        newMessage(sender, receiver, message, false);
                        autoScroll();

                    } else if (messageReceived[0].equals("File")) {
                        // Nhận một file
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String filename = messageReceived[3];
                        int size = Integer.parseInt(messageReceived[4]);
                        int bufferSize = 2048;
                        byte[] buffer = new byte[bufferSize];
                        ByteArrayOutputStream file = new ByteArrayOutputStream();

                        while (size > 0) {
                            input.read(buffer, 0, Math.min(bufferSize, size));
                            file.write(buffer, 0, Math.min(bufferSize, size));
                            size -= bufferSize;
                        }

                        // In ra màn hình file
                        FileMessage fm = new FileMessage(filename, file.toByteArray(),
                                sender, receiver, false);
                        fm.printMessage(sender, chatWindow);
                        autoScroll();

                    } else if (messageReceived[0].equals("Online users")) {
                        // Nhận yêu cầu cập nhật danh sách người dùng trực tuyến
                        String[] users = input.readUTF().split(",");

                        String chat = (String) cbOnlineUsers.getSelectedItem();
                        cbOnlineUsers.removeAllItems();
                        boolean isChattingOnline = false;

                        for (String u : users) {
                            if (u.equals(account.getUserName()) == false) {
                                // Cập nhật danh sách các người dùng trực tuyến vào ComboBox onlineUsers (trừ bản thân)
                                cbOnlineUsers.addItem(u);
                                if (messageContent.get(u) == null) {
                                    messageContent.put(u, "");
                                }
                            }
                            if ((chat != null) && chat.equals(u)) {
                                isChattingOnline = true;
                            }
                        }
                        if (isChattingOnline == true) {
                            cbOnlineUsers.setSelectedItem(chat);
                        } else if (cbOnlineUsers.getSelectedItem() != null) {
                            cbOnlineUsers.setSelectedIndex(0);
                        }
                        cbOnlineUsers.validate();
                    }

                }

            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    } else {
                        System.out.println("Have redundant data...");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeAvatar;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JComboBox<String> cbOnlineUsers;
    private javax.swing.JTextPane chatWindow;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAvatar;
    private javax.swing.JLabel labelChatWith;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel panelAccount;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables

}
