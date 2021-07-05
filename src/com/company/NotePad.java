/*
 * Created by JFormDesigner on Tue Feb 16 12:13:18 EET 2021
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author unknown
 */
public class NotePad extends JFrame {

    JFileChooser jFileChooser=new JFileChooser();
    File saveNewFileAndSaveOpenFile =null;
    public NotePad() {
        initComponents();

    }


    private void newfileActionPerformed(ActionEvent e) {
        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT","txt"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF","pdf"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("WORD","docx"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("HTML","html"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JAVA","java"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CPP","cpp"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("C","c"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSS","css"));
        int result=jFileChooser.showSaveDialog(this);
        if(result==0)
        {
            saveNewFileAndSaveOpenFile =new File(jFileChooser.getSelectedFile().getPath()+"."+jFileChooser.getFileFilter().getDescription());
            try {
                saveNewFileAndSaveOpenFile.createNewFile();
                textArea1.setText("");
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
    }

    private void menuItem2ActionPerformed(ActionEvent e) {



        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT","txt"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF","pdf"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("WORD","docx"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("HTML","html"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JAVA","java"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CPP","cpp"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("C","c"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSS","css"));

        int result=jFileChooser.showOpenDialog(this);

        BufferedInputStream bufferedInputStream=null;
        if(result==0)
        {
            File path=jFileChooser.getSelectedFile();
            try {
                saveNewFileAndSaveOpenFile =new File(path.getPath());
                bufferedInputStream=new BufferedInputStream(new FileInputStream(path));

                textArea1.setText("");

                int c;
                String s="";

                while((c=bufferedInputStream.read())!=-1)
                    textArea1.setText(s+=(char)c);

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            } finally {
                if(bufferedInputStream!=null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException ioException) {
                        System.out.println(ioException.getMessage());
                    }
                }
            }

        }

    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        save();
    }

    private void save() {
        PrintWriter pw=null;
        try {
            pw=new PrintWriter(saveNewFileAndSaveOpenFile);
            pw.print(textArea1.getText());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }finally {
            if(pw!=null)
                pw.close();
        }
    }

    private void menuItem4ActionPerformed(ActionEvent e) {

        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT","txt"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF","pdf"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("WORD","docx"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("HTML","html"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JAVA","java"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CPP","cpp"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("C","c"));
        jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("CSS","css"));
        int result=jFileChooser.showSaveDialog(this);
        if(result==0)
        {
            File saveAs =new File(jFileChooser.getSelectedFile().getPath()+"."+jFileChooser.getFileFilter().getDescription());
            try {
                saveAs.createNewFile();
                PrintWriter pw=new PrintWriter(saveAs);
                pw.print(textArea1.getText());
                pw.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
    }

    private void PrintActionPerformed(ActionEvent e) {
        try {
            textArea1.print();
        } catch (PrinterException printerException) {
            System.out.println(printerException.getMessage());
        }
    }

    private void ExitActionPerformed(ActionEvent e) {
        if(saveNewFileAndSaveOpenFile!=null)
            save();
        System.exit(0);
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        textArea1.cut();
    }

    private void menuItem7ActionPerformed(ActionEvent e) {
        textArea1.copy();
    }

    private void menuItem8ActionPerformed(ActionEvent e) {
        textArea1.paste();
    }

    private void menuItem9ActionPerformed(ActionEvent e) {
        textArea1.selectAll();
    }

    private void menuItem10ActionPerformed(ActionEvent e) {
        Color color=JColorChooser.showDialog(this,"Change Color", Color.BLACK);

        textArea1.setForeground(color);
    }

    private void textArea1KeyPressed(KeyEvent e) {

        String name=textArea1.getFont().getFontName();
        int style=textArea1.getFont().getStyle();
        int size=textArea1.getFont().getSize();

        if(e.getKeyCode()==e.VK_UP && e.getModifiers()==e.CTRL_MASK)
        {
            Font font=new Font(name,style,++size);
            textArea1.setFont(font);
        }else if(e.getKeyCode()==e.VK_DOWN && e.getModifiers()==e.CTRL_MASK)
        {
            Font font=new Font(name,style,--size);
            textArea1.setFont(font);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mahmoud Noor
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        newfile = new JMenuItem();
        OpenFile = new JMenuItem();
        SaveFile = new JMenuItem();
        SaveFileAs = new JMenuItem();
        Print = new JMenuItem();
        Exit = new JMenuItem();
        menu2 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menu3 = new JMenu();
        menuItem10 = new JMenuItem();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("NotePad(M)");
        var contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- newfile ----
                newfile.setText("NewFile");
                newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
                newfile.addActionListener(e -> newfileActionPerformed(e));
                menu1.add(newfile);

                //---- OpenFile ----
                OpenFile.setText("OpenFile");
                OpenFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
                OpenFile.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(OpenFile);

                //---- SaveFile ----
                SaveFile.setText("SaveFile");
                SaveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
                SaveFile.addActionListener(e -> {
                    menuItem3ActionPerformed(e);
                    menuItem3ActionPerformed(e);
                });
                menu1.add(SaveFile);

                //---- SaveFileAs ----
                SaveFileAs.setText("SaveAs");
                SaveFileAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK|KeyEvent.SHIFT_MASK));
                SaveFileAs.addActionListener(e -> menuItem4ActionPerformed(e));
                menu1.add(SaveFileAs);

                //---- Print ----
                Print.setText("Print");
                Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
                Print.addActionListener(e -> PrintActionPerformed(e));
                menu1.add(Print);

                //---- Exit ----
                Exit.setText("Exit");
                Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
                Exit.addActionListener(e -> ExitActionPerformed(e));
                menu1.add(Exit);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Edit");

                //---- menuItem6 ----
                menuItem6.setText("Cut");
                menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
                menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                menu2.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("Copy");
                menuItem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
                menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                menu2.add(menuItem7);

                //---- menuItem8 ----
                menuItem8.setText("Past");
                menuItem8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
                menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                menu2.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("SelectAll");
                menuItem9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
                menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                menu2.add(menuItem9);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Coordinate");

                //---- menuItem10 ----
                menuItem10.setText("ChangeColor");
                menuItem10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.ALT_MASK));
                menuItem10.addActionListener(e -> {
                    menuItem10ActionPerformed(e);
                    menuItem10ActionPerformed(e);
                });
                menu3.add(menuItem10);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    textArea1KeyPressed(e);
                }
            });
            scrollPane1.setViewportView(textArea1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mahmoud Noor
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem newfile;
    private JMenuItem OpenFile;
    private JMenuItem SaveFile;
    private JMenuItem SaveFileAs;
    private JMenuItem Print;
    private JMenuItem Exit;
    private JMenu menu2;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenu menu3;
    private JMenuItem menuItem10;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
