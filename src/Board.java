import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class Board extends Frame implements ActionListener
{
 JLabel num[]=new JLabel [100];     //these are boards numbers
 JButton pl[]=new JButton[4];       //these are players chance buttons
 JTextArea ta[]=new JTextArea[4];   //IN THESE TXTAREA DICE SCORE WILL BE SHOWN
 JTextArea t=new JTextArea();       //t TEXT AREA IS FOR COMMENTS OF WHAT HAPPENS IN GAME
 static int interval;
 int k,redd,gree,blu,yel,dd,chance,max,pos,temp=0;;
static Timer timer;
winners w;
 Board(int m)
 {  
     
//designing.................................................................................................................................................................
     setLayout(null);
        addWindowListener(new close());
  redd=-1;yel=-1;gree=-1;blu=-1;chance=0;  max=m;  pos=0;
     int i,x,y,h,br;
     
     setSize(1000,1000);
     Color c=new Color(0,255,255);
    
     //labels or moves...........................
     for (i=0;i<100;i++)
      {
          num[i]=new JLabel(String.valueOf(i+1));
          num[i].setOpaque(true);
          if(i!=6||i!=21||i!=55||i!=79||i!=84||i!=98)
         { num[i].setBackground(Color.blue);
          num[i].setForeground(Color.white);
          }
          add(num[i]);
      }
      
//arranging Board.............................................................................................................................................................
      num[0].setBounds(50,50,50,50);        //SETTING UP FIRST NUMBER AT ITS LOCATION
      x=102;y=52;h=50;br=50;
      
      for(i=1;i<100;i++)
      {
          num[i].setBounds(x,y,br,h);
          if((i+1)%10==0)
          {
              x=50;
              y+=52;
          }
          else
          x+=52;
      }
      
      
//dicessss..................................................................................................................................................................
       for(i=0;i<4;i++)
      {
          pl[i]=new JButton("player"+(i+1));
          ta[i]=new JTextArea();
          add(pl[i]);
          pl[i].addActionListener(this);
          ta[i].setEditable(false);
          ta[i].setLineWrap(true);
          ta[i].setBackground(c);
          ta[i].setFont(new Font("Serif",Font.PLAIN,80));
          add(ta[i]);
      }
      
//COMMENT BOX................................................................................................................................................................      
       t.setEditable(false);
          t.setLineWrap(true);
          t.setBackground(Color.black);
          t.setFont(new Font("Serif",Font.PLAIN,35));
          add(t);
      t.setBounds(445,580,140,160);
      
//ARRANGING DICES AT THEIR RIGHT PLAC..........................................................................................................................................      
      pl[0].setBounds(60,580,80,50);
      ta[0].setBounds(60,650,80,90);
      
      
      x=150;     y=580;     br=80;
 for (i=1;i<m;i++)
      {
       pl[i].setBounds(x,y,br,h);
       ta[i].setBounds(x,650,80,90);
       x+=90;
      }
      
//DESIGNING DICES............................................................................................................................................................      
setBackground(new Color(238,119,255));
pl[0].setBackground(Color.red);     pl[1].setBackground(Color.yellow);      pl[2].setBackground(Color.orange);      pl[3].setBackground(Color.green);
pl[1].setEnabled(false);        pl[2].setEnabled(false);        pl[3].setEnabled(false);


//SNAKES.......................................................................................................................................................................
num[6].setBackground(Color.black);  num[6].setForeground(Color.white);      num[21].setBackground(Color.black);  num[21].setForeground(Color.white);        
num[55].setBackground(Color.black);  num[55].setForeground(Color.white);        num[79].setBackground(Color.black);  num[79].setForeground(Color.white);
num[84].setBackground(Color.black);  num[84].setForeground(Color.white);        num[98].setBackground(Color.black);  num[98].setForeground(Color.white);
}
  
 
 
 
//////ACTUAL working....................................................................................................................................................................  
  public void actionPerformed(ActionEvent zz)
  {
    char status[]=new char[4];
    for (int statusi=0;statusi<4;statusi++)
    status[statusi]='l';
//red..........................................................................................................................................................     
      if(zz.getSource()==pl[0])
       {       
          if(redd>99)
            {pl[0].setEnabled(false);     pl[1].setEnabled(true);}
            else
     {   int delay = 100;
       int period = 100;
       chance++;
       pl[1].setEnabled(true);
       timer = new Timer();
       timer.scheduleAtFixedRate(new TimerTask() 
       {

        public void run() 
        {
            ta[0].setText(String.valueOf(Math.random()*6+1));
            k=(int)Float.parseFloat(ta[0].getText());
            redd+=k;
            if(redd<100)
          {if(redd==55||redd==84||redd==98||redd==79||redd==6||redd==21)
             {num[redd-k].setBackground(Color.blue);    redd=-1;    t.setText("snake bites restart");}
             else if((redd==gree)&&(redd!=101&&redd!=-1))
                 {  gree=0;              t.setForeground(Color.red);     t.setText("green out by red");}
              else
              if((redd==yel)&&(redd!=101&&redd!=-1))
               { yel=0;          t.setForeground(Color.red);     t.setText("yellow out by red");}
             if((redd==blu)&&(redd!=101&&redd!=-1))
              {blu=0;          t.setForeground(Color.red);       t.setText("orange out by red");}
              
              { num[redd].setBackground(Color.red);        num[redd-k].setBackground(Color.blue);     pl[0].setEnabled(false);  }}
              else
              {status[0]='w';   pos++;       temp=pos==max?max:0;     w=new winners(1,pos,temp);       w.setVisible(true);  }
               timer.cancel(); 
            }
    }, delay, period);
  
if(chance!=0)
pl[0].setEnabled(false);   
if(chance==max)   {
chance=0;
pl[0].setEnabled(true);    
}
}
}
//yellow...............................................................................................................................................................
else



      if(zz.getSource()==pl[1])
       {
        
        int delay = 100;
       int period = 100;
       chance++;
       pl[2].setEnabled(true);
       timer = new Timer();
       timer.scheduleAtFixedRate(new TimerTask() 
       {

        public void run() 
        {
            ta[1].setText(String.valueOf(Math.random()*6+1));
           if (k==9)
        {
            
            k=(int)Float.parseFloat(ta[1].getText());
           if((yel+k)<100)
           { yel=yel+k;
             if(yel==55||yel==84||yel==79||yel==98||yel==6||yel==21)
             {num[yel-k].setBackground(Color.blue);    yel=-1;    t.setText("snake bites restart");}
             else if((yel==gree)&&(yel!=101&&yel!=-1))
                   {gree=0;          t.setForeground(Color.yellow);     t.setText("green out by yellow");}
              else
              if((yel==redd)&&(yel!=101&&yel!=-1))
                {redd=0;          t.setForeground(Color.yellow);    t.setText("red out by yellow");}
             if((yel==blu)&&(yel!=101&&yel!=-1))
              {blu=0;          t.setForeground(Color.yellow);       t.setText("orange out by yellow");}
              
              { num[yel].setBackground(Color.yellow);        num[yel-k].setBackground(Color.blue);     pl[1].setEnabled(false);  }}
               timer.cancel(); 
            }
    else ++k;

        }
    }, delay, period);
  
if(chance!=0)
pl[1].setEnabled(false);   
if(yel==99)
{pos++;       temp=pos==max?max:0;     w=new winners(1,pos,temp);       w.setVisible(true);}
if(chance==max )   {
    if(status[0]=='l');
    {pl[0].setEnabled(true);    chance=0;}}
    else
    pl[1].setEnabled(true);
}



//orange/blue......................................................................................................................................................................
else


if(zz.getSource()==pl[2])
{
int delay = 100;
    int period = 100;
     chance++;
       pl[3].setEnabled(true);
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() 
    {

        public void run() 
        {
            
            ta[2].setText(String.valueOf(Math.random()*6+1));
           if (k ==20)
        {
            k=(int)Float.parseFloat(ta[2].getText());
           if((blu+k)<100)
           {blu=blu+k;
             if(blu==55||blu==84||blu==79||blu==98||blu==6||blu==21)
             {num[blu-k].setBackground(Color.blue);     blu=-1;     t.setText("snake bites restart");}
             else if((blu==gree)&&(blu!=101&&blu!=-1))
                   {gree=0;          t.setForeground(Color.orange);     t.setText("green out by orange");}
              else
              if((blu==yel)&&(blu!=101&&blu!=-1))
                {yel=0;          t.setForeground(Color.orange);     t.setText("yellow out by orange");}
             if((blu==redd)&&(blu!=101&&blu!=-1))
              {redd=0;          t.setForeground(Color.orange);      t.setText("red out by orange");}
              
              { num[blu].setBackground(Color.orange);        num[blu-k].setBackground(Color.blue);   }}
               timer.cancel(); 
            }
    else ++k;

        }
    }, delay, period);

if(chance!=2)
pl[2].setEnabled(false);
if(chance==max && redd<=99)   {pl[0].setEnabled(true);    chance=0;}

if(blu==99)
{pos++;       temp=pos==max?max:0;     w=new winners(3,pos,temp);       w.setVisible(true);}
}


//green...........................................................................................................................................................................
else


if(zz.getSource()==pl[3])
{
int delay = 100;
    int period = 100;
     chance++;
       pl[0].setEnabled(true);
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() 
    {
        public void run() 
        {
            
            ta[3].setText(String.valueOf(Math.random()*6+1));
           if (k ==20)
        {
            
            k=(int)Float.parseFloat(ta[3].getText());
         if(gree+k<100)
         {gree=gree+k;
           if(gree==55||gree==84||gree==79||gree==98||gree==6||gree==21)
             { num[gree-k].setBackground(Color.blue);       gree=-1;    t.setText("snake bites restart");}
             else if((blu==gree)&&(gree!=101&&gree!=-1))
                   {blu=0;          t.setForeground(Color.green);      t.setText("orange out by green");}
              else
              if((gree==yel)&&(gree!=101&&gree!=-1))
                {yel=0;          t.setForeground(Color.green);     t.setText("yellow out by green");}
             if((gree==redd)&&(gree!=101&&gree!=-1))
              {redd=0;          t.setForeground(Color.green);      t.setText("red out by green");}
              
              { num[gree].setBackground(Color.green);        num[gree-k].setBackground(Color.blue);}}
               timer.cancel(); 
            }
    else ++k;

        }
    }, delay, period);

if(chance!=3)
pl[3].setEnabled(false);
if(chance==max && redd<=99)   {pl[0].setEnabled(true);    chance=0;}
}
if(gree==99)
{pos++;       temp=pos==max?max:0;     w=new winners(4,pos,temp);       w.setVisible(true);}
}
}

