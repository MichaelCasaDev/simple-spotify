package ui.components;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static ui.Gestore.dirBase;

public class Home extends JPanel {
  private JLabel casa;

  public Home() {
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(0, 0, 150, 100);

    ImageIcon originalIcon = new ImageIcon(dirBase + "home.png");
    Image newImage = originalIcon.getImage().getScaledInstance(375, 375, Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(newImage);
    this.setLayout(null);

    casa = new JLabel(imageIcon);
    casa.setBounds(25, 0, 100, 100);
    casa.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.out.println("casa");
        super.mouseClicked(e);
      }
    });

    this.add(casa);
  }
}