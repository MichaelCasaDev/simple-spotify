package ui.components;

import api.search.Item;
import api.search.Search;
import api.tracks.Tracks;
import utils.Fetcher;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import static ui.Gestore.dirBase;

public class Ricerca extends JPanel {
  private JPanel cerca;
  private JLabel lente;
  private JComboBox<String> comboBox;
  private JTextField ricerca_qualcosa;

  public Ricerca(Contenitore_tutto contenitore_tutto, Fetcher fetcher) {
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(150, 0, 980, 100);
    this.setLayout(null);

    cerca = new JPanel();
    cerca.setBorder(new LineBorder(new Color(129, 255, 217)));
    cerca.setBackground(new Color(5, 23, 38));
    cerca.setBounds(30, 25, 750, 50);
    this.add(cerca);
    cerca.setLayout(null);

    ImageIcon originalLente = new ImageIcon(dirBase + "lente.png");
    Image newLente = originalLente.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    ImageIcon imgLente = new ImageIcon(newLente);
    lente = new JLabel(imgLente);
    lente.setBounds(0, 0, 50, 50);
    cerca.add(lente);

    ricerca_qualcosa = new JTextField();
    ricerca_qualcosa.setForeground(Color.WHITE);
    ricerca_qualcosa.setBackground(new Color(5, 23, 38));
    ricerca_qualcosa.setBounds(62, 6, 682, 38);
    ricerca_qualcosa.setBorder(BorderFactory.createEmptyBorder());
    cerca.add(ricerca_qualcosa);
    ricerca_qualcosa.setColumns(10);

    comboBox = new JComboBox<>();
    comboBox.setForeground(Color.BLACK);
    comboBox.setBackground(Color.WHITE);
    comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "track", "artist", "album" }));

    comboBox.setBounds(810, 25, 140, 50);
    this.add(comboBox);

    lente.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        String str = ricerca_qualcosa.getText() + " - " + comboBox.getSelectedItem().toString();
        System.out.println(str);

        try {
          Search search = fetcher.search(ricerca_qualcosa.getText(), comboBox.getSelectedItem().toString());
          if(comboBox.getSelectedItem().toString().equals("track")) {
            for(Item t : search.getTracks().getItems()) {
              System.out.println(t.getName() + " - " + t.getAlbum().getArtists().getName());
            }
          }
          if(comboBox.getSelectedItem().toString().equals("artist")) {
            for (Item t : search.getArtists().getItems()) {
              System.out.println(t.getName());
            }
          }
          if(comboBox.getSelectedItem().toString().equals("album")) {
            for(Item t : search.getAlbums().getItems()) {
              System.out.println(t.getName());
            }
          }
          //contenitore_tutto.setTracks(search.getTracks());
          //contenitore_tutto.draw();
        } catch (Exception er) {
          er.printStackTrace();
        }
        super.mouseClicked(e);
      }
    });
  }
}
