package _03_To_Do_List;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame=new JFrame("To Do List");
	JPanel panel=new JPanel();
	JButton button1=new JButton("Add Task");
	JButton button2=new JButton("View Tasks");
	JButton button3=new JButton("Remove Tasks");
	JButton button4=new JButton("Save List");
	JButton button5=new JButton("Load List");

	ArrayList<String> arr=new ArrayList<String>();
	
	JFileChooser jfc = new JFileChooser();

	public static void main(String[] args) {
		ToDoList tdl=new ToDoList();
		tdl.start();
	}
	void start() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==button1) {
			String answer=JOptionPane.showInputDialog("Input task here");
arr.add(answer);
		}
		else	if (e.getSource()==button2) {
				System.out.println(arr);	
		}
		else if (e.getSource()==button3) {
			String remove=JOptionPane.showInputDialog("Which task would you like to remove?");
			for(int i=0;i<arr.size();i++) {
			 if (arr.get(i).equals(remove)) {
				arr.remove(i);
			}
			}
		}
		else if (e.getSource()==button4) {
			try {
				FileWriter fw = new FileWriter("file.txt");
				for(int i=0; i<arr.size();i++) {
					fw.write(arr.get(i)+"\n");
				}
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==button5) {
			String a=JOptionPane.showInputDialog("What file would you like to access?");
			try {
				BufferedReader br = new BufferedReader(new FileReader(a));
				
				arr.clear();
			
				String line = br.readLine();
				while(line != null){
					arr.add(line);
					System.out.println(line);
					line = br.readLine();
					
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			}
		}
	}

