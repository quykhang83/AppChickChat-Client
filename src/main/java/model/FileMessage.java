/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.*;

/**
 *
 * @author quykhang
 */
public class FileMessage extends Message {

    String filename;
    byte[] file;

    public FileMessage(String filename, byte[] file, String sender, String receiver, boolean yourMessage) {
        super(sender, receiver, yourMessage);
        this.filename = filename;
        this.file = file;
    }

    @Override
    public void printMessage(String sender, JTextPane chatWindows) {
        StyledDocument doc = chatWindows.getStyledDocument();
        //SimpleAttributeSet right = new SimpleAttributeSet();
        //StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);

        Style userStyle = doc.getStyle("User style");
        if (userStyle == null) {
            userStyle = doc.addStyle("User style", null);
            StyleConstants.setBold(userStyle, true);
        }

        if (yourMessage == true) {
            //StyleConstants.setForeground(userStyle, Color.red);
            try {
                doc.insertString(doc.getLength(), "You: ", userStyle);
            } catch (BadLocationException e) {
            }
        } else {
            //StyleConstants.setForeground(userStyle, Color.BLUE);
            try {
                doc.insertString(doc.getLength(), sender + ": ", userStyle);
            } catch (BadLocationException e) {
            }
        }

        Style linkStyle = doc.getStyle("Link style");
        if (linkStyle == null) {
            linkStyle = doc.addStyle("Link style", null);
            StyleConstants.setForeground(linkStyle, Color.BLUE);
            StyleConstants.setUnderline(linkStyle, true);
            StyleConstants.setBold(linkStyle, true);
            linkStyle.addAttribute("link", new HyberlinkListener(filename, file) {
            });
        }

        if (chatWindows.getMouseListeners() != null) {
            // T???o MouseListener cho c??c ???????ng d???n t???i v??? file
            chatWindows.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    Element ele = doc.getCharacterElement(chatWindows.viewToModel(e.getPoint()));
                    AttributeSet as = ele.getAttributes();
                    HyberlinkListener listener = (HyberlinkListener) as.getAttribute("link");
                    if (listener != null) {
                        listener.execute();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub

                }

            });
        }

        // In ra ???????ng d???n t???i file
        try {
            doc.insertString(doc.getLength(), "<" + filename + ">", linkStyle);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }

        // Xu???ng d??ng
        try {
            doc.insertString(doc.getLength(), "\n", userStyle);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * MouseListener cho c??c ???????ng d???n t???i file.
     */
    class HyberlinkListener extends AbstractAction {

        String filename;
        byte[] file;

        public HyberlinkListener(String filename, byte[] file) {
            this.filename = filename;
            this.file = Arrays.copyOf(file, file.length);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            execute();
        }

        public void execute() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(filename));
            int rVal = fileChooser.showSaveDialog(null); //see it
            if (rVal == JFileChooser.APPROVE_OPTION) {

                // M??? file ???? ch???n sau ???? l??u th??ng tin xu???ng file ????
                File saveFile = fileChooser.getSelectedFile();
                BufferedOutputStream bos = null;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(saveFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // Hi???n th??? JOptionPane cho ng?????i d??ng c?? mu???n m??? file v???a t???i v??? kh??ng
                int nextAction = JOptionPane.showConfirmDialog(null, "Saved file to " + saveFile.getAbsolutePath() + "\nDo you want to open this file?", "Successful", JOptionPane.YES_NO_OPTION);
                if (nextAction == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (bos != null) {
                    try {
                        bos.write(this.file);
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
