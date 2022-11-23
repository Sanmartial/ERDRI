package GUI;

import manager.*;
import org.apache.commons.math3.util.MathArrays;
import procedure.*;
import resource.StorageMemory;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static java.awt.BorderLayout.*;
import static java.awt.Color.*;

public class UserInterfaceClass extends JFrame {

    private static final int FONT_SIZE = 12;

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    public UserInterfaceClass() throws HeadlessException {
        super("ERDR");
        int open = (int) System.currentTimeMillis();
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(700, 300);
//        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setLocation(50, 50);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE);
        Border border = BorderFactory.createEmptyBorder(10,10,20,5);
        Border border1 = BorderFactory.createEmptyBorder(10,5,20,5);
        Border border2 = BorderFactory.createEmptyBorder(70,5,70,10);
        Border border3 = BorderFactory.createTitledBorder(border2, "ВІДКРИТИ", TitledBorder.CENTER, TitledBorder.CENTER, font, RED);
        panel.setBorder(border);
        panel2.setBorder(border1);
        panel3.setBorder(border3);
        JButton button1 = new JButton("Press 1");
        panel.add(button1);
        JButton button2 = new JButton("Press 2");
        panel.add(button2);
        JButton button3 = new JButton("Press 3");
        panel.add(button3);
        JButton button4 = new JButton("Press 4");
        panel.add(button4);
        JButton button5 = new JButton("Press 5");
        panel.add(button5);
        JButton button6 = new JButton("Press 6");
        panel.add(button6);
        JButton button7 = new JButton("Press 7");
        panel.add(button7);
        JButton button8 = new JButton("Press 8");
        panel.add(button8);


        JButton buttonN1 = new JButton("listOne");
        panel3.add(buttonN1);

        JButton buttonN2 = new JButton("listTwo");
        panel3.add(buttonN2);

        JButton buttonN3 = new JButton("Result");
        panel3.add(buttonN3);


        JTextField text1 = new JTextField("порiвняти два списки ЕРДР (listOne.txt listTwo.txt)");
        text1.setFont(font);
        text1.setEditable(false);
        JTextField text2 = new JTextField("порiвняти будь-якi два аналогiчнi списки (listOne.txt listTwo.txt)");
        text2.setFont(font);
        text2.setEditable(false);
        JTextField text3 = new JTextField("пiдготувати список ЕРДР у форматi 1 2021 10001-1234567 ( listOne.txt )");
        text3.setFont(font);
        text3.setEditable(false);
        JTextField text4 = new JTextField("пiдготувати список ЕРДР у форматi 12021100011234567000 (з 000 наприкiнцi) (listOne.txt)");
        text4.setFont(font);
        text4.setEditable(false);
        JTextField text5 = new JTextField("перетворити форму статi ККУ cт.185 ч.1 у просту форму 185 (listOne.txt)");
        text5.setFont(font);
        text5.setEditable(false);
        JTextField text6 = new JTextField("додавання рядкiв, а також перевiрка списку прiзвищ (для виплат) (listOne.txt)");
        text6.setFont(font);
        text6.setEditable(false);
        JTextField text7 = new JTextField("створення форми для вiдрядження (listOne.txt)");
        text7.setFont(font);
        text7.setEditable(false);
        JTextField text8 = new JTextField("порiвняти два списки працiвникiв (поточний - listOne, попереднiй - ListTwo)");
        text8.setFont(font);
        text8.setEditable(false);

        panel2.add(text1);
        panel2.add(text2);
        panel2.add(text3);
        panel2.add(text4);
        panel2.add(text5);
        panel2.add(text6);
        panel2.add(text7);
        panel2.add(text8);

        panel.setLayout(new GridLayout(panel.getComponentCount(), 1));
        panel2.setLayout(new GridLayout(panel2.getComponentCount(), 1));
        panel3.setLayout(new GridLayout(panel3.getComponentCount(), 1));
        System.out.println(panel3.getComponentCount());
        add(panel, WEST);
        add(panel2, CENTER);
        add(panel3, EAST);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureOne procedureOne = new ProcedureOne(new StorageMemory(), new ReadWriteInf(), new FormatForCompare(), new ListCompare());
                try {
                    procedureOne.start(open, 1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureTwo procedureTwo = new ProcedureTwo(new StorageMemory(), new ReadWriteInf(), new Format(), new ListCompare());
                try {
                    procedureTwo.start(open, 2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureThree procedureThree = new ProcedureThree(new StorageMemory(), new ReadWriteInf(), new FormatForFormThree(), new ListCompare());
                try {
                    procedureThree.start(open, 3);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureFour procedureFour = new ProcedureFour(new StorageMemory(), new ReadWriteInf(), new FormatForFormFour(), new ListCompare());
                try {
                    procedureFour.start(open, 4);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                FormForChoice form = new FormForChoice(open);
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureSix procedureSix = new ProcedureSix(new StorageMemory(), new ReadWriteInf(), new FormatForFormSix(), new ListCompare());
                try {
                    procedureSix.start(open, 6);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                printInfoMessage("Увага!!! Можлива неповна назва посади  ");
                ProcedureSeven procedureSeven = new ProcedureSeven(new StorageMemory(), new ReadWriteInf());
                try {
                    procedureSeven.start(open, 7);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureEight procedureEight = new ProcedureEight(new StorageMemory(), new ReadWriteInf());
                try {
                    procedureEight.start(open, 8);

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });



        buttonN1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\ErdrPlus\\listOne.txt"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        buttonN2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\ErdrPlus\\listTwo.txt"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonN3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\ErdrPlus\\Result.txt"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

//        public void printInfoMessage(String message) {
//            JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
//        }
//
//
//        public void printErrorMessage(String message) {
//            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
//        }
        //container.add(button);
    }
    public void printInfoMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    };
}
