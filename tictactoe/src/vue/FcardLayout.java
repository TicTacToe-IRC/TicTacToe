package vue;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import controler.TicTacToeControler;

public class FcardLayout extends JFrame {
  final static String menu = "Menu";
  final static String param = "Parametres";
  
  private TicTacToeControler controler;
  Panel Cards;
  JPanel p1 = new MenuGUI(this);
  JPanel p2 = new ParamGUI(this);

  public FcardLayout(String title, TicTacToeControler controler, Dimension dim) {
	  /*try {
		  for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		   }
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 this.controler = controler;
     this.setLayout(new FlowLayout());
     this.setTitle(title);
     this.setSize(dim);

     Cards = new Panel();
     Cards.setLayout(new CardLayout());
    
     Cards.add(menu,p1);

     Cards.add(param,p2);
     
     add(Cards);
   } 
  
  public void setPanelByName(String panelName) {
	  if (panelName.equals("param"))   {
          ((CardLayout) Cards.getLayout()).show(Cards,param);
      };
      if (panelName.equals("menu"))   {
          ((CardLayout) Cards.getLayout()).show(Cards,menu);
       };
  }
} 