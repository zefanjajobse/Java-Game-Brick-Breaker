import GameObjects.*;
import GameObjects.Types.Cordinates;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private boolean play = false;

	// game objects
	private Player player = new Player();
	private Ball ball = new Ball();
	private Border border = new Border();
	private Score score = new Score();
	private EndScreen endscreen = new EndScreen("", 0);
	private Background background = new Background();
	private MapGenerator bricks;

	private int totalBricks = 48;
	
	private Timer timer;
	private int delay=8;
	
	public Gameplay() {
		bricks = new MapGenerator(4, 12);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
		timer.start();
	}

	public void paint(Graphics g) {
		// when you won the game
		if(totalBricks <= 0)
		{
			play = false;
			ball.stop();
			endscreen = new EndScreen("won", score.getScore());
		}

		// when you lose the game
		if(ball.getPosition().getY() > 570)
		{
			play = false;
			ball.stop();
			endscreen = new EndScreen("lost", score.getScore());
		}

		// draw game objects
		background.draw((Graphics2D) g);
		bricks.draw((Graphics2D) g);
		border.draw((Graphics2D) g);
		score.draw((Graphics2D) g);
		player.draw((Graphics2D) g);
		ball.draw((Graphics2D) g);
		endscreen.draw((Graphics2D) g);

		g.dispose();
	}	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.moveRight();
			play = true;
        }

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.moveLeft();
			play = true;
        }
		// if game over
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				ball = new Ball();
				player = new Player();
				score = new Score();
				endscreen = new EndScreen("", 0);
				totalBricks = 21;
				bricks = new MapGenerator(3, 7);

				repaint();
			}
        }
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	public void actionPerformed(ActionEvent e) {
		Cordinates ballPosition = ball.getPosition();

		timer.start();
		if(play) {
			// Hit detection with player
			if(ball.drawHitDetection().intersects(player.drawHitDetection("middle"))) {
				ball.reverseYDir();

				// if hit on the left edge
				if(ball.drawHitDetection().intersects(player.drawHitDetection("left"))) {
					ball.forceLeft();
				}
				// if hit on the right edge
				else if(ball.drawHitDetection().intersects(player.drawHitDetection("right"))) {
					ball.forceRight();
				}
			}
			
			// check map collision with the ball		
			A: for(int i = 0; i<bricks.map.length; i++) {
				for(int j =0; j<bricks.map[0].length; j++) {
					if(bricks.map[i][j] > 0) {
						//scores++;
						int brickX = j * bricks.brickWidth + 80;
						int brickY = i * bricks.brickHeight + 50;
						int brickWidth = bricks.brickWidth;
						int brickHeight = bricks.brickHeight;

						Rectangle ballRect = ball.drawHitDetection();
						Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						
						if(ballRect.intersects(brickRect)) {
							bricks.setBrickValue(0, i, j);
							score.add(5);
							totalBricks--;
							
							// when ball hit right or left of brick
							if(ballPosition.getX() + 19 <= brickRect.x || ballPosition.getX() + 1 >= brickRect.x + brickRect.width) {
								ball.reverseXDir();
							}
							// when ball hits top or bottom of brick
							else {
								ball.reverseYDir();
							}
							
							break A;
						}
					}
				}
			}
			
			ball.move();
			repaint();		
		}
	}
}
