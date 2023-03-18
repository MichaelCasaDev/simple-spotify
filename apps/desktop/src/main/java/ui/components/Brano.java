package ui.components;

import utils.Fetcher;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static ui.Gestore.dirBase;

public class Brano extends JPanel {
  private JLabel branoImg;

  public Brano() {
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(0, 592, 150, 100);
    this.setLayout(null);

    ImageIcon originalBrano = new ImageIcon(dirBase + "brano.png");
    Image newBrano = originalBrano.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
    ImageIcon imgBrano = new ImageIcon(newBrano);
    branoImg = new JLabel(imgBrano);
    branoImg.setBounds(25, 0, 100, 100);
    this.add(branoImg);
  }
}
