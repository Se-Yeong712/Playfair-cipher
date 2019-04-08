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
		encryption = new JButton("암호화");
		exit = new JButton("닫기");
		
		//버튼ActionListener
		//암호화선택
		encryption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String keystr = key.getText();
				String teststr = plaintext.getText();
				encry = new encryption(keystr, teststr);
				
			}
		});
		
		//화면 닫기, 프로그램 종료
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
		setTitle("다중문자치환암호프로그램");
	
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
		
		
		
		title = new JLabel("결과");
		jl1 = new JLabel("암호화된 문자열");
		jl2 = new JLabel("복호화된 문자열");
		
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
		
		exit = new JButton("닫기");
		exit.setBounds(370, 300, 100, 50);
		pan.add(exit);
		
		add(pan);		

		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("다중문자치환암호프로그램");
	
		setVisible(true);
		
		
	}
}

class encryption{
	plate plate;
	String encryresult = "초기값";
	public encryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		encryresult = plaintext(text);
		
		
	}
	
	//평문 셋팅(공백제거, q/z변환 - > 표시하기(a이면 여기는 z가 q로 바뀐거다.), 삽입문자)  -> 암호화 하면 복호화도 같이 해주기 
	public String plaintext(String plaintext) {
		
		for(int i = 0;i<plaintext.length();i++) {
			if(plaintext.charAt(i) == ' ') {	//공백
					
			}
			else if(plaintext.charAt(i) == 'z') {	//q/z변환
					
			}
		}
		
		return plaintext;
		
	}

	public String getEncryresult() {
		return encryresult;
	}
	
}


//복호화
class decryption{
	plate plate;
	String decryresult = "초기값";
	
	public decryption(String key,String text) {
		
		System.out.println("key : " + key + "  text : " + text);
		plate = new plate(key);
		decryresult = cyphertext(text);
		
	}
	//암호문 셋팅
	public String cyphertext(String cyphertext) {
		
		
		
		return cyphertext;
	}
	
	public String getDecryresult() {
		return decryresult;
	}

	
}


//암호판 셋팅
class plate{
	public plate(String key) {
		String resultkey = "";
		String platekey[][] = new String[5][5];
		key += "abcdefghijklmnopqrstuvwxyz";
		
		//논리적오류 해결 : z를 q로 바꿔줌
		key = key.replace('z', 'q');
		
		//key중복제거
		for(int i = 0;i<key.length();i++) {
			if(!resultkey.contains(String.valueOf(key.charAt(i)))) {		
				resultkey += String.valueOf(key.charAt(i));
			}
		}
		System.out.println(resultkey);
		
		//암호판에 중복제거한 key삽입
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




