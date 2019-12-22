package 上机实验;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 使用JavaScript Engine来实现计算
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 计算器  extends JFrame implements ActionListener {
	JButton[] numButton=new JButton[10];
	 JButton add =new JButton("+");
	 JButton subtract =new JButton("-");
	 JButton mult =new JButton("*");
	 JButton divide =new JButton("/");
	 JButton equal =new JButton("=");
	 JButton clear_show =new JButton("C");
	 JTextField text = new JTextField(7);
	 
	 
	 计算器(){
		 JPanel center=new JPanel();
		 center.setLayout(new GridLayout(5,3));
		 for (int i=0;i<10;i++){
			 numButton[i]=new JButton(""+i);
			 numButton[i].addActionListener(this);
			 center.add(numButton[i]);
		 }
		 add.addActionListener(this);
		 center.add(add);
		 equal.addActionListener(this);
		 center.add(equal);
		 subtract.addActionListener(this);
		 center.add(subtract);
		 mult.addActionListener(this);
		 center.add(mult);
		 divide.addActionListener(this);
		 center.add(divide);
		 // 实现顶部组件
		 JPanel north=new JPanel();
		 north.setLayout(new FlowLayout());
		 clear_show.addActionListener(this);
		 north.add(text);
		 north.add(clear_show);
		 text.setColumns(20);
		 
		 add(north,BorderLayout.NORTH);
		 add(center,BorderLayout.CENTER);
		 
		 setTitle("整数加法计算器");
		 setLocation(100,100);
		 setSize(350,400);
		 setVisible(true);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 return;
	 }
	String ctext = "";
    public void actionPerformed(ActionEvent e){
   	 JButton curr=(JButton)e.getSource();
   	 
   	 if(curr==clear_show){
   		 text.setText("");
   		 ctext = "";
   		 return;
   	 }
   	 for(int i=0;i<10;i++){
   		 if(curr==numButton[i]){
   			 ctext += numButton[i].getText() + ".0";
   			 text.setText(ctext);
   		 }
   	 }
   	 if(curr==add){
   		 ctext += "+";
   		 text.setText(ctext);
   		 return; 
   	 }
   	if(curr==divide){
  		 ctext += "/";
  		 text.setText(ctext);
  		 return; 
  	 }
   	if(curr==mult){
  		 ctext += "*";
  		 text.setText(ctext);
  		 return; 
  	 }
   	if(curr==subtract){
  		 ctext += "-";
  		 text.setText(ctext);
  		 return; 
  	 }
   	 if(curr==equal){
   		ScriptEngineManager manager = new ScriptEngineManager();
   		ScriptEngine se = manager.getEngineByName("js");
   		double result = 0;
   		try {
   		result = (double)se.eval(ctext);
   		System.out.println(result);
   		} catch (ScriptException e1) {
   		e1.printStackTrace();
   		}
   		ctext += "=";
   		ctext += result;
   		text.setText(ctext);

   	 }
    }
	
	public static void main(String[] args) {
		new 计算器();
	}
}


