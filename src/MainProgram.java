import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class userDisplay extends JFrame{
	
	JPanel pan;
	JLabel jl1, jl2;
	JTextField key, text;
	JButton encryption, decryption,exit;
	encryption encry;
	decryption decry;
	
	
	public JTextField getKey() {
		return key;
	}


	public JTextField getText() {
		return text;
	}


	public userDisplay() {
		pan = new JPanel();
		pan.setLayout(null);
		
		//JLabel
		jl1 = new JLabel("KEY");
		jl2 = new JLabel("��/��ȣ");
		
		jl1.setBounds(50, 20, 100, 50);
		jl2.setBounds(50, 80, 100, 50);
		
		pan.add(jl1);
		pan.add(jl2);
		
		//JTextField
		key = new JTextField(300);
		text = new JTextField(300);
		
		key.setBounds(130, 20, 300, 50);
		text.setBounds(130, 80, 300, 50);
		
		pan.add(key);
		pan.add(text);
		
		//JButton
		encryption = new JButton("��ȣȭ");
		decryption = new JButton("��ȣȭ");
		exit = new JButton("�ݱ�");
		
		//��ưActionListener
		//��ȣȭ����
		encryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String keystr = key.getText();
				String teststr = text.getText();
				encry = new encryption(keystr, teststr);
				
			}
		});
		
		//��ȣȭ ����
		decryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String keystr = key.getText();
				String teststr = text.getText();
				decry = new decryption(keystr, teststr);
				
			}
		});
		
		//ȭ�� �ݱ�, ���α׷� ����
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
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

class encryption{
	plate plate;
	public encryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		
		
		
	}
}

class decryption{
	plate plate;
	public decryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		
		
	}
}

//��ȣ�� ����
class plate{
	public plate(String key) {
		String resultkey = "";
		String platekey[][] = new String[5][5];
		key += "abcdefghijklmnopqrstuvwxyz";
		
		//�������� �ذ� : z�� q�� �ٲ���
		key = key.replace('z', 'q');
		
		//key�ߺ�����
		for(int i = 0;i<key.length();i++) {
			if(!resultkey.contains(String.valueOf(key.charAt(i)))) {		
				resultkey += String.valueOf(key.charAt(i));
			}
		}
		System.out.println(resultkey);
		
		//��ȣ�ǿ� �ߺ������� key����
		for(int i = 0,k = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				platekey[i][j] = String.valueOf(resultkey.charAt(k));
				k++;
			}
		}
		
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<5;j++) {
				System.out.print(platekey[i][j] + " ");
			}
			System.out.println("");
		}
		
	}
}

//��, ��ȣ�� ����
class textset{
	public textset() {
		// TODO Auto-generated constructor stub
	}
}


public class MainProgram{

	public static void main(String[] args) {
		userDisplay dis = new userDisplay();

	}

}




