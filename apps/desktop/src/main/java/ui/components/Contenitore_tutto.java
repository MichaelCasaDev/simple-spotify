package ui.components;

import api.search.Item;
import api.tracks.Track;
import api.tracks.Tracks;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import static ui.Gestore.dirBase;

public class Contenitore_tutto extends JPanel {
  private JLabel foto_brano;
  private JLabel nome_brano;
  private JLabel durata;
  private JLabel artista;

  private Tracks tracks;

  public Contenitore_tutto(Tracks tracks) {
    this.tracks = tracks;

    draw();
  }

  public void setTracks(api.search.Tracks tracks) {
    // TODO
  }

  public void draw() {
    this.removeAll();

    this.setBorder(null);
    this.setBounds(150, 100, 980, 592);
    this.setBackground(new Color(5, 23, 38));
    this.setLayout(null);

    JLabel la = new JLabel("Ultimi 8 brani salvati");
    la.setForeground(new Color(255,255,255));
    la.setBounds(40, 500, 500, 20);
    this.add(la);

    try {
      for (int i = 0; i < 8; i++) {
        this.add(brano(i == 0 ? 0 : (i * 60), 40, tracks.getItems().get(i).getTrack()));
        // this.add(artista(0, i * 150));
        // this.add(album(0, i * 150));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private JPanel brano(int posY, int posX, Track track) throws Exception {
    JPanel temp = new JPanel();

    temp.setBackground(new Color(5, 23, 38));
    temp.setLayout(null);
    temp.setBounds(posX, posY, 900, 50);
    temp.setBorder(new LineBorder(new Color(129, 255, 217)));
    temp.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        temp.setBackground(Color.LIGHT_GRAY);
        super.mouseEntered(e);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        temp.setBackground(new Color(5, 23, 38));
        super.mouseExited(e);
      }
    });

    try {
      URL url = new URL(track.getAlbum().getImages().getUrl());
      Image image = ImageIO.read(url);
      ImageIcon imgFoto1 = new ImageIcon(image);
      foto_brano = new JLabel(imgFoto1);

      foto_brano.setBounds(0, 0, 50, 50);
      temp.add(foto_brano);
    } catch (Exception e) {

    }

    nome_brano = new JLabel(track.getName());
    nome_brano.setForeground(Color.WHITE);
    nome_brano.setBounds(60, 15, 360, 20);
    temp.add(nome_brano);

    Date date = new Date(track.getDuration_ms());
    DateFormat formatter = new SimpleDateFormat("mm:ss");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    String dateFormatted = formatter.format(date);

    durata = new JLabel(dateFormatted);
    durata.setForeground(Color.WHITE);
    durata.setBounds(850, 15, 82, 20);
    temp.add(durata);

    artista = new JLabel(track.getAlbum().getArtists().getName());
    artista.setForeground(Color.WHITE);
    artista.setBounds(500, 15, 374, 20);
    temp.add(artista);

    return temp;
  }

  private JPanel album(int posY, int posX) {
    JPanel temp = new JPanel();
    JLabel p_artista;
    JLabel p_artista_nome;

    temp.setBorder(null);
    temp.setBackground(new Color(5, 23, 38));
    temp.setBounds(posX, posY, 150, 492);
    temp.setLayout(null);

    ImageIcon originalPArtista = new ImageIcon(dirBase + "player.png");
    Image newPArtista = originalPArtista.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
    ImageIcon imgPArtista = new ImageIcon(newPArtista);
    p_artista = new JLabel(imgPArtista);
    p_artista.setBounds(25, 22, 100, 100);
    temp.add(p_artista);

    p_artista_nome = new JLabel(posX / 150 + "");
    p_artista_nome.setHorizontalAlignment(SwingConstants.CENTER);
    p_artista_nome.setForeground(Color.WHITE);
    p_artista_nome.setBounds(44, 132, 61, 16);
    temp.add(p_artista_nome);

    return temp;
  }

  private JPanel artista(int posY, int posX) {
    JPanel temp = new JPanel();
    JLabel p_artista;
    JLabel p_artista_nome;

    temp.setBorder(null);
    temp.setBackground(new Color(5, 23, 38));
    temp.setBounds(posX, posY, 150, 492);
    temp.setLayout(null);

    ImageIcon originalPArtista = new ImageIcon(dirBase + "player.png");
    Image newPArtista = originalPArtista.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
    ImageIcon imgPArtista = new ImageIcon(newPArtista);
    p_artista = new JLabel(imgPArtista);
    p_artista.setBounds(25, 22, 100, 100);
    temp.add(p_artista);

    p_artista_nome = new JLabel(posX / 150 + "");
    p_artista_nome.setHorizontalAlignment(SwingConstants.CENTER);
    p_artista_nome.setForeground(Color.WHITE);
    p_artista_nome.setBounds(44, 132, 61, 16);
    temp.add(p_artista_nome);

    return temp;
  }
}
