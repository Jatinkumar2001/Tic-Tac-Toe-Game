import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe {
	JFrame fr =new JFrame("TicTacToe");
	JPanel [] pa= new JPanel[3];
	JLabel label=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JButton [] bt = new JButton[9];
	JButton reset = new JButton("RESET"); 
	JLabel player =new JLabel("Player 1 turn ......");
	ImageIcon icon1 = new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2 = new ImageIcon(getClass().getResource("images/user2.png"));
	int playerTurn=1;
	boolean winnerFound=false;
	int ctr=0;
	
	//Set frame
	public TicTacToe()
	{
		fr.setSize(400,600);
		fr.setResizable(false);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(3);
		addLabel();
		fr.setVisible(true);
	}
	
	
	//Adding label
	private void addLabel()
	{   
	
     label.setLayout(null);
 	fr.add(label);  
     for(int i=0;i<3;i++)
     {
    	 pa[i]=new JPanel();    	
         label.add(pa[i]);	    	 
     }
     pa[0].setBounds(20, 20, 360,40);
     pa[1].setBounds(20, 80, 360,400);
     pa[2].setBounds(20, 500, 360,40);
     addButton();
    
	}
	
	//Adding buttons
	private void addButton()
	{   player.setFont(new Font("arial",Font.BOLD,20));
	    player.setForeground(Color.white);
	    pa[0].setOpaque(false);
		pa[0].add(player);
		
		pa[1].setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++)
		{    bt[i]=new JButton();
		     bt[i].setBackground(Color.darkGray);
		     bt[i].addActionListener(new TicListener());
			pa[1].add(bt[i]);
		}
		pa[2].setOpaque(false);
		pa[2].add(reset);
		reset.addActionListener(new ResetListener());
		reset.setEnabled(false);
		
	}
	
	
	
	
	public class TicListener  implements ActionListener
	{        public void actionPerformed(ActionEvent evt)
			{ JButton bb=(JButton)evt.getSource();			
			if(playerTurn==1)
			{
				bb.setIcon(icon1);
				player.setText("Player 2 turn ......");
				playerTurn=2;
				checkWinner(icon1);
			}
			else if(playerTurn==2)
			{
				bb.setIcon(icon2);
				player.setText("Player 1 turn ......");
			    playerTurn=1;
			    checkWinner(icon2);
			}
			ctr++;
			if(!winnerFound && ctr==9)
			{
				JOptionPane.showMessageDialog(fr, "Its a Draw");
				player.setText("Game Over");
				player.setForeground(Color.red);
				reset.setEnabled(true);
			}
				
			
		}
		
	}
	
	
	
	

	private void checkWinner(ImageIcon icon)
	{
		if(bt[0].getIcon()==icon && bt[1].getIcon()==icon && bt[2].getIcon()==icon)
		announceWinner(0,1,2);	
		if(bt[3].getIcon()==icon && bt[4].getIcon()==icon && bt[5].getIcon()==icon)
			announceWinner(3,4,5);
		if(bt[6].getIcon()==icon && bt[7].getIcon()==icon && bt[8].getIcon()==icon)
			announceWinner(6,7,8);
		if(bt[0].getIcon()==icon && bt[3].getIcon()==icon && bt[6].getIcon()==icon)
			announceWinner(0,3,6);	
		if(bt[0].getIcon()==icon && bt[1].getIcon()==icon && bt[2].getIcon()==icon)
			announceWinner(1,4,7);
		if(bt[2].getIcon()==icon && bt[5].getIcon()==icon && bt[8].getIcon()==icon)
			announceWinner(2,5,8);
		if(bt[0].getIcon()==icon && bt[4].getIcon()==icon && bt[8].getIcon()==icon)
			announceWinner(0,4,8);
		if(bt[2].getIcon()==icon && bt[4].getIcon()==icon && bt[6].getIcon()==icon)
			announceWinner(2,4,6);			
	}

	
	
	
	private void announceWinner(int i,int j,int k)
	{  
		bt[i].setBackground(Color.WHITE);
		bt[j].setBackground(Color.WHITE);
		bt[k].setBackground(Color.WHITE);
		player.setText("Game Over");
		player.setForeground(Color.red);
		
		
		if(playerTurn==2)
			JOptionPane.showMessageDialog(fr, "Congratulation Player 1 WON...");			
		else if(playerTurn==1)
			JOptionPane.showMessageDialog(fr, "Congratulation Player 2 WON...");
		for(int o=0;o<9;o++)
		{
			bt[o].setEnabled(false);
		}
		reset.setEnabled(true);
		   
     }
	
	
	
	
	public class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{   
			
			for(int i=0;i<9;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.darkGray);
				bt[i].setEnabled(true);
			}
			playerTurn=1;
			player.setText("Player 1 turn ......");
		    player.setForeground(Color.white);
			reset.setEnabled(false);
			ctr=0;
		}
	}
	
	
	
	
	public static void main(String[] args) 
	{ 
		new TicTacToe();		
		
	}

}
