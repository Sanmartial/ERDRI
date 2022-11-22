package GUI;

import manager.ProcedureFive;
import procedure.FixList;
import procedure.ListCompare;
import procedure.ReadWriteInf;
import resource.StorageMemory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FormForChoice extends JFrame {
    private static final int FONT_SIZE = 14;

    JPanel panel = new  JPanel();
    JPanel panelW = new  JPanel();
    JPanel panelO = new  JPanel();
    JPanel panelS = new  JPanel();
    JPanel panelE = new  JPanel();

    public FormForChoice(int open) throws HeadlessException {
        super("ERDR #5");
        setSize(400, 200);

        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JButton button1 = new JButton("для ГУ");
        button1.setSize(50,50);

        JButton button2 = new JButton("для ДПД");
        button2.setSize(50,50);

        panel.add(button1, BorderLayout.WEST);
        panel.add(button2, BorderLayout.WEST);

        panel.setLayout(new FlowLayout());
     //panel.setLayout(new GridLayout(5, 2));
//panel.computeVisibleRect(new Rectangle(10,10,10,10));
        add(panel);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureFive procedureFive = new ProcedureFive(new StorageMemory(), new ReadWriteInf(), new ListCompare(), new FixList());
                try {
                    procedureFive.start(open, 5, 1);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ProcedureFive procedureFive = new ProcedureFive(new StorageMemory(), new ReadWriteInf(), new ListCompare(), new FixList());
                try {
                    procedureFive.start(open, 5, 2);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //add(panelE, BorderLayout.EAST);


    }
}
