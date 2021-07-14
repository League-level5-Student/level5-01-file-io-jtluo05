package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a messager.
	 * Use any key you want (1 - 25) to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String s=JOptionPane.showInputDialog("Input your message here.");
		int key=8;
		int f=0;
		char newS = 10;
		for(int i=0;i>s.length();i++) {
			f+=(int)s.charAt(i)+key;
			if(f>28) {
				f=f-26;
			}
			newS+=(char)f;
		}

		try {
			FileWriter fr=new FileWriter(new File("file.txt"));
			fr.write(newS);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
