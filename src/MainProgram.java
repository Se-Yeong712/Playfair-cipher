import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class userDisplay extends JFrame{
	
	JPanel pan;
	JLabel jl1, jl2, jl3;
	JTextField key, plaintext, cyphertext;
	JButton encryption, decryption,exit;
	
	
	public userDisplay() {
		pan = new JPanel();
		pan.setLayout(null);
		
		//JLabel
		jl1 = new JLabel("KEY");
		jl2 = new JLabel("��");
		jl3 = new JLabel("��ȣ");
		
		jl1.setBounds(50, 20, 100, 30);
		jl2.setBounds(50, 60, 100, 30);
		jl3.setBounds(50, 100, 100, 30);
		
		pan.add(jl1);
		pan.add(jl2);
		pan.add(jl3);
		
		//JTextField
		key = new JTextField(300);
		plaintext = new JTextField(300);
		cyphertext = new JTextField(300);
		
		key.setBounds(130, 20, 300, 30);
		plaintext.setBounds(130, 60, 300, 30);
		cyphertext.setBounds(130, 100, 300, 30);
		
		pan.add(key);
		pan.add(plaintext);
		pan.add(cyphertext);
		
		//JButton
		encryption = new JButton("��ȣȭ");
		decryption = new JButton("��ȣȭ");
		exit = new JButton("�ݱ�");
		
		encryption.setBounds(50, 180, 100, 50);
		decryption.setBounds(190 , 180, 100, 50);
		exit.setBounds(330, 180, 100, 50);

		pan.add(encryption);
		pan.add(decryption);
		pan.add(exit);
		
		add(pan);		

		

		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���߹���ġȯ��ȣ���α׷�");
	
		setVisible(true);
		
	}
	
	
}


public class MainProgram{

	public static void main(String[] args) {
		userDisplay dis = new userDisplay();

	}

}
