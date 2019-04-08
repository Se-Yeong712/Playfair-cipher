import java.awt.Button;
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
	JTextField key, plaintext;
	JButton encryption,exit;
	encryption encry;


	public userDisplay() {
		pan = new JPanel();
		pan.setLayout(null);
		
		//JLabel
		jl1 = new JLabel("KEY");
		jl2 = new JLabel("PlainText");
		
		jl1.setBounds(50, 20, 100, 50);
		jl2.setBounds(50, 80, 100, 50);
		
		pan.add(jl1);
		pan.add(jl2);
		
		//JTextField
		key = new JTextField(300);
		plaintext = new JTextField(300);
		
		key.setBounds(130, 20, 300, 50);
		plaintext.setBounds(130, 80, 300, 50);
		
		pan.add(key);
		pan.add(plaintext);
		
		//JButton
		encryption = new JButton("��ȣȭ");
		exit = new JButton("�ݱ�");
		
		//��ưActionListener
		//��ȣȭ����
		encryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String keystr = key.getText();
				String teststr = plaintext.getText();
				encry = new encryption(keystr, teststr);
				
			}
		});
		
		//ȭ�� �ݱ�, ���α׷� ����
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose();
				
				resultDisplay result = new resultDisplay();
				
			}
		});
		
		encryption.setBounds(50, 180, 100, 50);
		exit.setBounds(330, 180, 100, 50);

		pan.add(encryption);
		pan.add(exit);
		
		add(pan);		

		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���߹���ġȯ��ȣ���α׷�");
	
		setVisible(true);
		
	}
	
	
}

class resultDisplay extends JFrame{
	JPanel pan;
	JLabel title, encryresult, decryresult,jl1,jl2;
	String cryptogram, plaintext;
	encryption encry;
	decryption decry;
	JButton exit;

	
	public resultDisplay() {
		pan = new JPanel();
		pan.setLayout(null);
		
		
		
		title = new JLabel("���");
		jl1 = new JLabel("��ȣȭ�� ���ڿ�");
		jl2 = new JLabel("��ȣȭ�� ���ڿ�");
		
		pan.add(title);
		pan.add(jl1);
		pan.add(jl2);
		
		title.setBounds(220, 20, 100, 20);
		jl1.setBounds(30, 40, 300, 50);
		jl2.setBounds(30, 80, 300, 50);
		
		//cryptogram = encry.getEncryresult();
		//plaintext = decry.getDecryresult();
		
		encryresult = new JLabel("cryptogram");
		decryresult = new JLabel("plaintext");
		
		
		encryresult.setBounds(130, 20, 300, 50);
		decryresult.setBounds(130, 80, 300, 50);
		
		exit = new JButton("�ݱ�");
		exit.setBounds(370, 300, 100, 50);
		pan.add(exit);
		
		add(pan);		

		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���߹���ġȯ��ȣ���α׷�");
	
		setVisible(true);
		
		
	}
}

class encryption{
	plate plate;
	String encryresult = "�ʱⰪ";
	public encryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		encryresult = plaintext(text);
		
		
	}
	
	//�� ����(��������, q/z��ȯ - > ǥ���ϱ�(a�̸� ����� z�� q�� �ٲ�Ŵ�.), ���Թ���)  -> ��ȣȭ �ϸ� ��ȣȭ�� ���� ���ֱ� 
	public String plaintext(String plaintext) {
		
		for(int i = 0;i<plaintext.length();i++) {
			if(plaintext.charAt(i) == ' ') {	//����
					
			}
			else if(plaintext.charAt(i) == 'z') {	//q/z��ȯ
					
			}
		}
		
		return plaintext;
		
	}

	public String getEncryresult() {
		return encryresult;
	}
	
}


//��ȣȭ
class decryption{
	plate plate;
	String decryresult = "�ʱⰪ";
	
	public decryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		decryresult = cyphertext(text);
		
	}
	//��ȣ�� ����
	public String cyphertext(String cyphertext) {
		
		
		
		return cyphertext;
	}
	
	public String getDecryresult() {
		return decryresult;
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




public class MainProgram{

	public static void main(String[] args) {
		//userDisplay dis = new userDisplay();
		resultDisplay result = new resultDisplay();

	}

}




