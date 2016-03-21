import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Bean extends JFrame{ 
	final static int Slots = 10;
	final static int Rows = Slots - 2;
	
	JLabel Ball = new JLabel();
	private int shift = 0;
  	private int[] slots = new int[Slots];
 	private int moveCount = 0; 	
  	private BeanMachinePanel paintPanel = new BeanMachinePanel();
  	
  	private Timer timer = new Timer(100, new ActionListener(){
   	@Override
   	public void actionPerformed(ActionEvent e){
      		moveCount++;	
      			}
    		}
  	);
  
  	public Bean(){
		
		add(paintPanel);	
    		timer.start();
  	}
	
  	class BeanMachinePanel extends JPanel{
    	final static int Length1 = 25;
    	final static int Length2 = 20;
    	final static int RADIUS = 5;
    	final static int LENGTH_OF_SLOTS = 40;
    	final static int LENGTH_OF_OPENNING = 15;
    	final static int First = 1;
    	
		
   	@Override
    	protected void paintComponent(Graphics g){
      		super.paintComponent(g);

      		int y = First;
      		int xCenter = getWidth() / 2;


      	
      	g.setColor(Color.ORANGE);
      	for (int i = 0; i < Rows; i++){
        	y += Length2;
        	for (int k = 0; k <= i; k++){
          	g.fillOval(xCenter - i * Length1 / 2 + k * Length1 - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
        	}
      	}
      
      	
      	g.setColor(Color.BLACK);
      	y = y + RADIUS;
      	for (int i = 0; i < Slots; i++){
        	int x = xCenter - (Rows - 1) * Length1 / 2 + (i - 1) * Length1;
        	g.drawLine(x, y, x, y + LENGTH_OF_SLOTS);
      	}
      
      	
      	g.drawLine(xCenter - (Rows - 1) * Length1 / 2 - Length1, y + LENGTH_OF_SLOTS, 
        	xCenter - (Rows - 1) * Length1 / 2 + Rows * Length1, y + LENGTH_OF_SLOTS);
    
      	g.drawLine(xCenter +Length1 / 2, First + RADIUS, xCenter - (Rows - 1) * Length1 / 2 + Rows * Length1, y);
      	g.drawLine(xCenter -Length1 / 2, First + RADIUS, xCenter - (Rows - 1) * Length1 / 2 - Length1, y);
      	
      	g.drawLine(xCenter - Length1 / 2, First + RADIUS, xCenter - Length1 / 2,First - LENGTH_OF_OPENNING);
      	g.drawLine(xCenter + Length1 / 2, First + RADIUS, xCenter + Length1 / 2,First - LENGTH_OF_OPENNING);
      
      	// Paint the balls in the slots
      	g.setColor(Color.BLUE);      
      	for (int i = 0; i < slots.length; i++){
        	int x = xCenter - (Rows) * Length1 / 2 + i * Length1;
        	for (int j = 0; j < slots[i]; j++){
          	g.fillOval(x - RADIUS, y + LENGTH_OF_SLOTS - 2 * RADIUS - j * 2 * RADIUS, 2 * RADIUS, 2 * RADIUS);
        	}
      	}
    }
  }

  	public static void main(String[] args){			
		JFrame frame = new Bean();
    	frame.setTitle("Machine");
   	 	frame.setSize(600, 600);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLocationRelativeTo(null);
   		frame.setVisible(true);
  	}
}
