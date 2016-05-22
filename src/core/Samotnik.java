package core;


import frames.MainFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mateusz on 20.05.2016.
 * Project InferenceEngine
 */
public class Samotnik {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            mainFrame = new MainFrame();
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setVisible(true);
        });
    }

    //public Board board;
    public static MainFrame mainFrame;
}
