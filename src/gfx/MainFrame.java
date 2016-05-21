package gfx;

import logic.Board;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Mateusz on 20.05.2016.
 * Project InferenceEngine
 */
public class MainFrame extends JFrame implements Runnable {
    public MainFrame(){
        setTitle("Samotnik");
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        mainBorderLayout = new JPanel(new BorderLayout());
        gameBorderLayout = new JPanel(new BorderLayout());
        JLabel gameName = new JLabel("Samotnik",SwingConstants.CENTER);
        JPanel buttonsGridLayout = new JPanel(new GridLayout(2,1));
        //boardPanel = new BoardPanel();
        buttonsGridLayout.setBorder(new EmptyBorder(100,100,100,100));
        JButton run = new JButton("Graj");
        run.addActionListener(e -> {
            board = new Board();
            boardPanel = new BoardPanel(board);
            gameBorderLayout.add(boardPanel,BorderLayout.CENTER);
            this.getContentPane().removeAll();
            this.getContentPane().add(gameBorderLayout);
            this.revalidate();
            this.repaint();
            running = true;
            game = new Thread(this);
            game.start();

        });
        JButton exit = new JButton("Wyjdź");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonsGridLayout.add(run);
        buttonsGridLayout.add(exit);

        mainBorderLayout.add(buttonsGridLayout,BorderLayout.CENTER);
        gameName.setFont(new Font("Comic Sans MS",Font.PLAIN,80));
        mainBorderLayout.add(gameName,BorderLayout.NORTH);
        add(mainBorderLayout);


    }



    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D/FRAMERATE;

        int frames = 0;
        int ticks = 0;

        long lastTimer = System.currentTimeMillis();
        double delta = 0;
        boolean shouldRender = false;
            while (running) {
                long now = System.nanoTime();
                delta += (now = lastTime) / nsPerTick;
                lastTime = now;
                while (delta >= 1) {
                    shouldRender = true;
                    ticks++;
                    tick(ticks);
                    delta -= 1;
                }
                if (shouldRender) {
                    frames++;
                    boardPanel.render();
                    shouldRender = false;
                }
                if (System.currentTimeMillis() - lastTimer >= 1000) {
                    lastTimer += 1000;
                    //System.out.println(ticks + " ticks, " + frames + " frames");
                    frames = 0;
                    ticks = 0;
                }
            }
    }
    public void tick(int ticks) {

    }
    public Thread game;
    private Board board;
    private BoardPanel boardPanel;
    private int FRAMERATE = 60;
    JPanel mainBorderLayout;
    JPanel gameBorderLayout;
    boolean running = false;
}
