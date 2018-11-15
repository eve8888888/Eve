package flappybird;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Eve
 * @Date: 2018/11/15 10:00
 * @Version 1.0
 */
public class GamePanel extends JPanel {
    int score = 0;
    public static final int START = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;
    private int state = START;
    private static BufferedImage startImage;
    private static BufferedImage gameOverImage;
    static {
        try {
            startImage = ImageIO.read(GamePanel.class.getResource("start.png"));
            gameOverImage = ImageIO.read(GamePanel.class.getResource("gameover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Sky sky = new Sky();
    Bird bird = new Bird();
    Ground ground = new Ground();
    Column column = new Column();

    public boolean passColumn() {
        if(bird.x==column.x+79 || bird.x == column.x1 +179) {
            return true;
        }
        return false;
    }
    public boolean hitColumn() {
        //56表示小鸟的宽度
        //78表示水管的宽度
        if(bird.x>=column.x-56 && bird.x<= column.x+78) {
            if(bird.y<=column.y+530||bird.y>=column.y+622) {
                return true;
            }
        }
        if(bird.x>=column.x1-56 + 250 &&bird.x<=column.x1+78 + 250) {
            if(bird.y<=column.y1+530||bird.y>=column.y1+622) {
                return  true;
            }
        }
        return  false;
    }
    public boolean hitGround(){
        if(bird.y >= 450) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void paint(Graphics g){

        sky.paintObject(g);
        column.paintObject(g);
        bird.paintObject(g);
        ground.paintObject(g);
        switch (state){
            case START:
                g.drawImage(startImage,0,0,null);
                break;
            case GAMEOVER:
                g.drawImage(gameOverImage,0,0,null);
                break;
        }
        Font font = new Font(null,Font.BOLD,60);
        g.setFont(font);
	    g.setColor(Color.BLACK);
	    g.drawString(""+score, 196, 48);
        g.setColor(Color.WHITE);
        g.drawString(""+score, 196-2, 48-2);
    }
    public void action(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(state == START) {
                    state = RUNNING;
                }
                if(state == GAMEOVER){
                    sky = new Sky();
                    bird = new Bird();
                    ground = new Ground();
                    column = new Column();
                    score = 0;
                    state = START;
                }
                if(state == RUNNING)
                    bird.step();
            }
        });
        //使用定时器
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if(state == RUNNING) {
                    stepAction();
                    if(passColumn()){
                        score ++;
                    }
                }
                repaint();
            }
        },10,10);
    }
    public void stepAction(){
        sky.step();
        ground.step();
        column.step();
        bird.birdMove();
        if(hitColumn() || hitGround()){
            state = GAMEOVER;
        }
    }
}
