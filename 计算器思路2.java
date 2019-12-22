package 上机实验;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 计算器思路2  extends JFrame implements ActionListener {
	JButton[] numButton=new JButton[10];
	 JButton add =new JButton("+");
	 JButton subtract =new JButton("-");
	 JButton mult =new JButton("*");
	 JButton divide =new JButton("/");
	 JButton equal =new JButton("=");
	 JButton clear_show =new JButton("C");
	 JTextField text = new JTextField(7);
	 
	 
	 计算器思路2(){
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
		 
		 setTitle("计算器");
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
  		 try{
  			 int result = 0;
  			 String formula= text.getText();
  			 String[] nums = formula.split("\\p{Punct}");
  			 String[] puns = formula.split("\\p{Digit}");
//  			 System.out.println(nums.length);
  			 result += Integer.parseInt(nums[0]);
  			 
  			 int i;
  			 //
  			 
//  			 
//  			 int how_many = 0;
//  			 for(i=0; i<puns.length; i++) {
//  				 if(puns[i] == "*" || puns[i] == "/") {
//  					 how_many ++;
//  				 }
//  			 }
//  			 String[] nums2 = new String[nums.length - how_many];
// 			 String[] puns2 = new String[puns.length - how_many];

 			 // 以上想来实现完整的优先级算法，未完成
 			 int pun2;
 			 for(i=0; i<puns.length; i++) {
 				switch(puns[i]) {
 				case("*"):
 					pun2 = Integer.parseInt(nums[i-1]) * Integer.parseInt(nums[i]);
// 					puns2[i-1] = String.valueOf(pun2);
 					System.out.println(pun2);
 					break;
 				case("/"):
 					pun2 = Integer.parseInt(nums[i-1]) / Integer.parseInt(nums[i]);
// 					puns2[i-1] = String.valueOf(pun2);
 					System.out.println(pun2);
 					break;
 				 } 
 			 }
 			 
  			 //
  			 
  			 
  			 for(i=1; i<nums.length; i++){
  				 int num = Integer.parseInt(nums[i]);
  				 String pun = puns[i];
  				
  				 switch(pun) {
  				 case("+"):result += num;break;
  				 case("-"):result -= num;break;
  				 case("*"):result *= num;break;
  				 case("/"):result /= num;break;
  				 }
//  				System.out.println(result);
  				
  	 }
  			formula +="="+result;
			 text.setText(formula);
  			 
  		} 
  		 catch(Exception ex){
  			 text.setText("输入错误，请清空");
  		 }  		 
  	 }
    }
	
	public static void main(String[] args) {
		new 计算器思路2();
	}
}