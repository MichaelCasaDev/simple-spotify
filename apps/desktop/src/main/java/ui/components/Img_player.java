package ui.components;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static ui.Gestore.dirBase;

public class Img_player extends JPanel {
  private JLabel imgPlayer;

  public Img_player(String uri) {
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(1130, 0, 150, 100);
    this.setLayout(null);

    try {
      URL url = new URL(uri);
      Image image = ImageIO.read(url);
      ImageIcon imgPlayerS = new ImageIcon(image);
      imgPlayer = new JLabel(imgPlayerS);
      imgPlayer.setBounds(25, 0, 100, 100);
      this.add(imgPlayer);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
