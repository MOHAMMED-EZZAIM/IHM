package Aplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Allication {
    Allication(){
        JFrame f=new JFrame();
        f.setLayout(new BorderLayout());
        f.add(new pane() ,BorderLayout.CENTER);
        f.add(new fouter(),BorderLayout.SOUTH);
        f.add(new west(),BorderLayout.EAST);
        f.setVisible(true);
        f.setSize(500,500);
    }
    public static void main(String[] args) {
        new Allication();
    }
}

class pane extends  JPanel{
    pane(){
        Font font=new Font("", Font.PLAIN,30);
        setLayout(new BorderLayout(10,10));

        JPanel north=new JPanel();
        north.setLayout(new GridLayout(4,1));

        JLabel l1=new JLabel("Nom");
        l1.setFont(font);
       l1.setForeground(Color.blue);
        TextField nom =new TextField(50);
        nom.setFont(font);
        north.add(l1);
        north.add(nom);

        JLabel l2=new JLabel("Prenom");
        l2.setFont(font);
        l2.setForeground(Color.blue);;

        TextField prenom =new TextField(50);
        prenom.setFont(font);
        north.add(l2);
        north.add(prenom);

        JPanel center=new JPanel();
        center.setLayout(new GridLayout(2,1));

        JLabel l3=new JLabel("Adress");
        l3.setFont(font);
        l3.setForeground(Color.blue);
        TextArea adress =new TextArea();
        adress.setFont(font);
        center.add(l3);
        center.add(adress);

        JPanel fouter=new JPanel();
        fouter.setLayout(new FlowLayout());
        JLabel l4=new JLabel("Sexe");
        l4.setFont(font);
        l4.setForeground(Color.blue);
        ButtonGroup btn=new ButtonGroup();
        JRadioButton h=new JRadioButton("Homme");
        h.setFont(font);
        JRadioButton f=new JRadioButton("femme");
        f.setFont(font);
        btn.add(h);
        btn.add(f);
        fouter.add(l4);
        fouter.add(h);
        fouter.add(f);

        add(north,BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        add(fouter,BorderLayout.SOUTH);

    }
}

class fouter extends JPanel implements ActionListener {
    fouter(){
        Font font=new Font("", Font.PLAIN,30);
        JButton ok=new JButton("envoyer");
        ok.setBackground(new Color(51200));
        ok.setBounds(0, 0, 100,30 );
        ok.addActionListener(this);

        ok.setFont(font);
        JButton annuler=new JButton("annuler");
        annuler.setBounds(100,0 , 100,30 );
        annuler.addActionListener(this);
        annuler.setBackground(new Color(6579455));

        annuler.setFont(font);
        setLayout(new FlowLayout());
        add(ok);
        add(annuler);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message=e.getActionCommand();
            JOptionPane.showMessageDialog(this,"hello prof IHM ,Button tapper est :"+message);
    }
}
class  west extends  JPanel {
    west(){
        Font font=new Font("", Font.PLAIN,30);
        setLayout(new GridLayout(9,1));
        String t[]={"IHM","FootBall","VolleyBoll","swmin","Tennis","java","React","Spring","DataBase"};
        int taill=9;
        JCheckBox Tchekbo[]=new JCheckBox[9];
        Tchekbo[0]=new JCheckBox(t[0],true);
        Tchekbo[0].setFont(font);
        Tchekbo[0].setForeground(Color.red);
        add(Tchekbo[0]);
     for(int i=1;i<taill;i++){
         Tchekbo[i]=new JCheckBox(t[i]);
         Tchekbo[i].setFont(font);
         add(Tchekbo[i]);
     }

    }
}
