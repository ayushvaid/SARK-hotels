package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import Welcome.WelcomePage;

public class AdminLogin implements ActionListener{

	JFrame j;
	JLabel jl1,jl2,logo_label;
	JButton jb1,jb2,jb3;
	JTextField jt1;
	JPasswordField jp;
	Icon logo_image;
	JButton backButton;
	Connection con;
	public AdminLogin()
	{
		j = new JFrame();
		
		jl1 = new JLabel("LOGIN");
		backButton = new JButton("Return");
		fillContent();
		this.j.setVisible(true);
	}
	
	public void fillContent()
	{
		j.setLayout(null);
		logo_image = new ImageIcon("Capture5 - Copy.PNG");
		logo_label = new JLabel(logo_image);
		logo_label.setBounds(1000, 35, 366 , 156);
		
		//j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setTitle("Administrator Login");
		j.setResizable(true);
		//j.setExtendedState(JFrame.MAXIMIZED_BOTH);
		j.setBounds(0,0,1366,768);
		j.add(logo_label);
		
		backButton.setBounds(10, 10, 100, 35);
		j.add(backButton);
		
		jl1 = new JLabel("LOGIN");
		Font f1= new Font("Ariel",Font.BOLD,25);
		jl1.setFont(f1);
		jl1.setForeground(Color.white);
		jl1.setBounds(450,150,400,400);
		j.add(jl1);
		
		jl2 = new JLabel("PASSWORD");
		jl2.setFont(f1);
		jl2.setForeground(Color.white);
		jl2.setBounds(450,200,800,400);
		j.add(jl2);
		
		jt1=new JTextField();
		jt1.setBounds(610,335,250,35);
		j.add(jt1);
		
		jp = new JPasswordField();
		jp.setBounds(610, 380, 250, 35);
		j.add(jp);
		
		jb1= new JButton("Submit");
		jb1.setBounds(550, 460,100,35);
		j.add(jb1);
		
		jb2= new JButton("Cancel");
		jb2.setBounds(680, 460,100,35);
		j.add(jb2);
		
		j.setBackground(Color.decode("#1A242A"));
		
		j.setVisible(true);
		j.getContentPane().setBackground(Color.decode("#1A242A"));
		jb1.addActionListener(this); //submit
		jb2.addActionListener(this); //cancel
		backButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == jb1)
		{
			try {
				con = new AcquireConnection().acquireConnection();
				ResultSet rs = con.prepareStatement("select * from AdminDetail"/* where AdminID ='"+jt1.getText()+"' and Password='"+jp.getPassword().toString()+"'"*/).executeQuery();
				
				int count = 0;
				
				/*while(rs.next())
				{
					count++;
				}*/
				//System.out.println(new String(jp.getPassword()));
				
				while(rs.next())
				{	
					//System.out.println(rs.getString(2)+" "+new String(jp.getPassword())+" "+rs.getString(1)+" "+jt1.getText());
					String password=new String(jp.getPassword());
					if(jt1.getText().equals(rs.getString(1)) && password.equals(rs.getString(2)))
					{
					this.j.setVisible(false);
					AdminHome H = new AdminHome(con,jt1.getText());
					H.frame.setVisible(true);
					break;
					}
				}
				
				if(!rs.next())
					JOptionPane.showMessageDialog(this.j, "No such record exists.");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(arg0.getSource() == jb2 ||arg0.getSource() == backButton )
		{
			this.j.setVisible(false);
			new WelcomePage().frame.setVisible(true);
		}
		
	}
	
	public static void main(String...s)
	{
		new AdminLogin().j.setVisible(true);
	}
}
