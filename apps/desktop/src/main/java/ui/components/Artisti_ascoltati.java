package ui.components;

import api.search.Artists;
import api.search.Item;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import static ui.Gestore.dirBase;

public class Artisti_ascoltati extends JPanel {
  private JLabel p_artista;
  private JLabel p_artista_nome;
  private JLabel s_artista;
  private JLabel s_artista_nome;
  private JLabel t_artista;
  private JLabel t_artista_nome;

  public Artisti_ascoltati(Item[] item) {
    this.setBorder(null);
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(1130, 100, 150, 492);
    this.setLayout(null);

    try {
      URL url = new URL(item[0].getImages().getUrl());
      Image image = ImageIO.read(url);
      ImageIcon originalPArtista = new ImageIcon(image);
      p_artista = new JLabel(originalPArtista);
      p_artista.setBounds(25, 22, 100, 100);
      this.add(p_artista);
    } catch (Exception e) {
      e.printStackTrace();
    }

    p_artista_nome = new JLabel(item[0].getName());
    p_artista_nome.setHorizontalAlignment(SwingConstants.CENTER);
    p_artista_nome.setForeground(Color.WHITE);
    p_artista_nome.setBounds(23, 132, 100, 16);
    this.add(p_artista_nome);

    try {
      URL url = new URL(item[1].getImages().getUrl());
      Image image = ImageIO.read(url);
      ImageIcon originalPArtista = new ImageIcon(image);
      s_artista = new JLabel(originalPArtista);
      s_artista.setBounds(25, 186, 100, 100);
      this.add(s_artista);
    } catch (Exception e) {
      e.printStackTrace();
    }

    s_artista_nome = new JLabel(item[1].getName());
    s_artista_nome.setHorizontalAlignment(SwingConstants.CENTER);
    s_artista_nome.setForeground(Color.WHITE);
    s_artista_nome.setBounds(23, 296, 100, 16);
    this.add(s_artista_nome);

    try {
      URL url = new URL(item[2].getImages().getUrl());
      Image image = ImageIO.read(url);
      ImageIcon imgTArtista = new ImageIcon(image);
      t_artista = new JLabel(imgTArtista);
      t_artista.setBounds(25, 350, 100, 100);
      this.add(t_artista);
    } catch (Exception e) {
      e.printStackTrace();
    }

    t_artista_nome = new JLabel(item[2].getName());
    t_artista_nome.setHorizontalAlignment(SwingConstants.CENTER);
    t_artista_nome.setForeground(Color.WHITE);
    t_artista_nome.setBounds(23, 460, 100, 16);
    this.add(t_artista_nome);
  }
}
