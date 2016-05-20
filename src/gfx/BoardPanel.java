package gfx;

import logic.Board;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;

/**
 * Created by Mateusz on 20.05.2016.
 * Project InferenceEngine
 */
public class BoardPanel extends Canvas{
    public BoardPanel(Board board) {
        this.board = board;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isSelected) {
                    if((e.getX()>margin && e.getX()<getWidth()-margin) && (e.getY()>margin && e.getY()<getHeight()-margin))
                        System.out.println("tak");
                }
            }
        });
    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        drawBoardFrame();
        g.dispose();
        bs.show();
    }
    private void drawBoardFrame(){
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(margin,margin,getWidth()-2*margin,getHeight()-2*margin);

        oneFieldWidth = (width-margin*2)/board.width;
        oneFieldHeight = (height-margin*2)/board.height;
      /*  for(int i = 1; i < board.width;i++) {
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(i*oneFieldWidth+margin,margin,i*oneFieldWidth+margin,getHeight()-margin);
        }
        for(int i = 1; i < board.height;i++) {
            g2.setStroke(new BasicStroke(1));
            g2.drawLine(margin,i*oneFieldHeight+margin,getWidth()-margin,i*oneFieldHeight+margin);
        }*/
        g2.setColor(new Color(238,44,44));
        for(int i = 0; i < board.height;i++) {
            for(int j = 0; j < board.width;j++) {
                if(board.board[j][i]==0 || board.board[j][i]==1)
                {
                    g2.setColor(new Color(142,142,56));
                    g2.fillOval(j*oneFieldWidth+margin+fieldBackgroundMargin,i*oneFieldHeight+margin+fieldBackgroundMargin,oneFieldWidth-2*fieldBackgroundMargin,oneFieldHeight-2*fieldBackgroundMargin);
                }
                if(board.board[j][i]==1) {
                    g2.setColor(Color.BLACK);
                    g2.fillOval(j*oneFieldWidth+margin+inFieldMargin,i*oneFieldHeight+margin+inFieldMargin,oneFieldWidth-2*inFieldMargin,oneFieldHeight-2*inFieldMargin);
                }
            }
        }

        //g2.setColor(Color.CYAN);
        //g2.drawOval(0,0,50,50);
        //g2.fillOval(0,0,50,50);
    }
    private Board board;

    private int margin = 20;
    private int inFieldMargin = 12;
    private int fieldBackgroundMargin= 8;

    private int oneFieldWidth;
    private int oneFieldHeight;

    private boolean isSelected = false;
    private int selectedX;
    private int selectedY;

    private Graphics g;
}
