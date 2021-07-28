package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f gLipps Asvph h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("decode message here.");
		int key = 4;
		int f = 0;
		String newS = "";
		for (int i = 0; i < s.length(); i++) {
			f += (int) s.charAt(i) - key;
			if (!Character.isLetter(s.charAt(i))) {
				newS += s.charAt(i);

			}
			if (Character.isLetter(s.charAt(i))) {

				if (f< (int) 'A') {
					f = (int) 'Z' - key+1;
					System.out.println(f);

				}
				newS += (char) f;
				
			}
			f = 0;
		}

		System.out.println(newS);
		try {
			FileWriter fr = new FileWriter(new File("file.txt"));
			fr.write(newS);
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
