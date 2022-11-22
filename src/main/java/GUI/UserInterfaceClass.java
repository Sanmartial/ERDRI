package GUI;

import manager.*;
import procedure.*;
import resource.StorageMemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class UserInterfaceClass extends JFrame {

    private static final int FONT_SIZE = 14;

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    public UserInterfaceClass() throws HeadlessException {
        super("ERDR");
        int open = (int) System.currentTimeMillis();
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(700, 400);
//        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setLocation(50, 50);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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

        JTextField text1 = new JTextField("порiвняти два списки ЕРДР (listOne.txt listTwo.txt)");
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE);
        text1.setFont(font);
        JTextField text2 = new JTextField("порiвняти будь-якi два аналогiчнi списки (listOne.txt listTwo.txt)");
        text2.setFont(font);
        JTextField text3 = new JTextField("пiдготувати список ердр у форматi 1 2021 10001-1234567 ( listOne.txt )");
        text3.setFont(font);
        JTextField text4 = new JTextField("пiдготувати список ердр у форматi 12021100011234567000 (з 000 наприкiнцi) (listOne.txt)");
        text4.setFont(font);
        JTextField text5 = new JTextField("перетворити форму статi ККУ cт.185 ч.1 у просту форму 185 (listOne.txt)");
        text5.setFont(font);
        JTextField text6 = new JTextField("додавання рядкiв, а також перевiрка списку прiзвищ (для виплат) (listOne.txt)");
        text6.setFont(font);
        JTextField text7 = new JTextField("створення форми для вiдрядження. Увага! Можлива неповна назва посади (listOne.txt)");
        text7.setFont(font);
        JTextField text8 = new JTextField("порiвняти два списки працiвникiв (поточний - listOne, попереднiй - ListTwo)");
        text8.setFont(font);

        panel2.add(text1);
        panel2.add(text2);
        panel2.add(text3);
        panel2.add(text4);
        panel2.add(text5);
        panel2.add(text6);
        panel2.add(text7);
        panel2.add(text8);

        panel.setLayout(new GridLayout(8, 1));
        panel2.setLayout(new GridLayout(8, 1));

        add(panel, BorderLayout.WEST);
        add(panel2, BorderLayout.CENTER);

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
}
