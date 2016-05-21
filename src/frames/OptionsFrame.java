package frames;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mateusz on 21.05.2016.
 * Project Samotnik
 */
public class OptionsFrame extends JDialog {
    public OptionsFrame(){
        setSize(300,150);
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Opcje");
        JLabel title = new JLabel("Wybierz typ Planszy",SwingConstants.CENTER);
        JPanel optionsGridLayout = new JPanel(new GridLayout(2,2));
        JLabel boardType = new JLabel("Kształt: ",SwingConstants.CENTER);
        JLabel boardSize = new JLabel("Rozmiar planszy: ",SwingConstants.CENTER);
        optionsGridLayout.add(boardType);
        boardTypeComboBox = new JComboBox<>();
        boardTypeComboBox.addItem("Klasyczna");
        boardTypeComboBox.addItem("Kwadratowa");
        boardTypeComboBox.addItem("Trójkątna");

        execute = new JButton("Graj");
        execute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        boardTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boardTypeComboBox.getSelectedIndex()==1 || boardTypeComboBox.getSelectedIndex()==2)
                    boardSizeComboBox.setEnabled(true);
                else {
                    boardSizeComboBox.setEnabled(false);
                    boardSizeComboBox.setSelectedIndex(1);
                }
            }
        });
        optionsGridLayout.add(boardTypeComboBox);
        boardSizeComboBox = new JComboBox<>();
        boardSizeComboBox.addItem("5x5");
        boardSizeComboBox.addItem("7x7");
        boardSizeComboBox.addItem("9x9");
        boardSizeComboBox.addItem("11x11");
        optionsGridLayout.add(boardSize);
        optionsGridLayout.add(boardSizeComboBox);
        boardSizeComboBox.setEnabled(false);
        JPanel mainBorderLayout = new JPanel(new BorderLayout());
        mainBorderLayout.add(optionsGridLayout,BorderLayout.CENTER);
        mainBorderLayout.add(title,BorderLayout.NORTH);
        mainBorderLayout.add(execute, BorderLayout.SOUTH);
        add(mainBorderLayout);
    }
    public int[] showDialog() {
        int values[] = new int[2];
        setVisible(true);
        values[0] = boardTypeComboBox.getSelectedIndex();
        values[1] = boardSizeComboBox.getSelectedIndex();

        return values;
    }
    private JButton execute;
    private JComboBox<String> boardTypeComboBox;
    private JComboBox<String> boardSizeComboBox;
}
