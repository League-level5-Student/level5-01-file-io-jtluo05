package _01_File_Recorder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {
		// Create a program that takes a message from the user and saves it to a file.
		String s=JOptionPane.showInputDialog("Input your message here.");
		try {
			FileWriter fr = new FileWriter(new  File ("file.txt"));
			fr.write(s);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 	}
	
}
