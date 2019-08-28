import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
public class winners extends JFrame implements ActionListener
{
JButton cont;
JTextArea wnam;
Board ba;
int max;
winners(int pl,int pos,int max)
{
setBackground(Color.black);
this.max=max;
setSize(300,300);
cont=new JButton("continue");
wnam=new JTextArea();
wnam.setEditable(false);
wnam.setLineWrap(true);
wnam.setFont(new Font("Serif",Font.PLAIN,40));
String s;
s=(pos==1)?"First":(pos==2)?"Second":(pos==3)?"Third":"loose better luck next time";
wnam.setText("player "+String.valueOf(pl)+" "+s);
setLayout(null);
add(cont);  add(wnam);
cont.setBounds(50,150,90,50);
wnam.setBounds(30,65,210,60);
cont.addActionListener(this);
show();
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==cont)
{
{
if(max!=0)
ba.setVisible(false);
setVisible(false);
}
}
}
}