package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import api.me.Me;
import api.search.Item;
import api.tracks.Tracks;
import ui.components.*;
import utils.Fetcher;

import java.awt.*;

public class Gestore extends JFrame {
  public static final String dirBase = System.getProperty("user.dir") + "/src/main/resources/imgs/";

  private JPanel contentPane;

  public Gestore(Fetcher fetcher) {
    try {
      Item[] followingArtists = fetcher.following().getArtists().getItems();
      Me me = fetcher.me();
      Tracks savedTracks =  fetcher.tracks();

      Home home = new Home();
      Brano brano = new Brano();
      Player player = new Player(fetcher);
      Img_player img_player = new Img_player(me.getImages().getUrl());
      Logout_nome logout_nome = new Logout_nome(me.getDisplay_name());
      Artisti_ascoltati artisti_ascoltati = new Artisti_ascoltati(followingArtists);
      Contenitore_tutto contenitore_tutto = new Contenitore_tutto(savedTracks);
      Ricerca ricerca = new Ricerca(contenitore_tutto, fetcher);

      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1280, 720);

      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
      contentPane.setLayout(null);
      contentPane.setBackground(new Color(5, 23, 38));

      setContentPane(contentPane);

      //contentPane.add(home);
      //contentPane.add(brano);
      contentPane.add(player);
      contentPane.add(img_player);
      contentPane.add(logout_nome);
      contentPane.add(artisti_ascoltati);
      contentPane.add(ricerca);
      contentPane.add(contenitore_tutto);

      this.setTitle("Simple Spotify");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
