package ui.components;

import utils.Fetcher;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import static ui.Gestore.dirBase;

public class Player extends JPanel {
  private JLabel tempo_fine;
  private JLabel tempo_passato;
  private JProgressBar progressBar;
  private JLabel skip_avanti;
  private JLabel playPausa;
  private JLabel skip_Indietro;

  public Player(Fetcher fetcher) {

    this.setBackground(new Color(5, 23, 38));
    this.setBounds(0, 100, 150, 492);
    this.setLayout(null);

    tempo_fine = new JLabel("Tempo");
    tempo_fine.setForeground(Color.WHITE);
    tempo_fine.setBounds(97, 41, 61, 16);
    this.add(tempo_fine);

    tempo_passato = new JLabel("Tempo");
    tempo_passato.setForeground(Color.WHITE);
    tempo_passato.setBounds(97, 441, 61, 16);
    this.add(tempo_passato);

    CustomProgressBarUI customUI = new CustomProgressBarUI(new Color(129, 255, 217), Color.white);
    progressBar = new JProgressBar();
    progressBar.setUI(customUI);
    progressBar.setForeground(Color.WHITE);
    progressBar.setOrientation(SwingConstants.VERTICAL);
    progressBar.setValue(89);
    progressBar.setBackground(Color.WHITE);
    progressBar.setBounds(115, 71, 4, 350);
    this.add(progressBar);

    ImageIcon originalSkipAvanti = new ImageIcon(dirBase + "skip_sopra.png");
    Image newSkip = originalSkipAvanti.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
    ImageIcon imgSkip = new ImageIcon(newSkip);
    skip_avanti = new JLabel(imgSkip);
    skip_avanti.setBounds(17, 56, 100, 100);
    this.add(skip_avanti);

    ImageIcon originalPlayPausa = new ImageIcon(dirBase + "play_pausa.png");
    Image newPlay = originalPlayPausa.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
    ImageIcon imgPlay = new ImageIcon(newPlay);
    playPausa = new JLabel(imgPlay);
    playPausa.setBounds(17, 182, 100, 100);
    this.add(playPausa);

    ImageIcon originalSkipIndietro = new ImageIcon(dirBase + "skip_sotto.png");
    Image newSkipIndietro = originalSkipIndietro.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
    ImageIcon imgSkipIndietro = new ImageIcon(newSkipIndietro);
    skip_Indietro = new JLabel(imgSkipIndietro);
    skip_Indietro.setBounds(17, 305, 100, 100);
    this.add(skip_Indietro);

    try {
      api.player.Player p = fetcher.player();
      skip_avanti.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            fetcher.nextPlayer(p.getDevice().getId());
          } catch (Exception exception) {
            exception.printStackTrace();
          }
          super.mouseClicked(e);
        }
      });
      playPausa.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            fetcher.playStopPlayer(p.getDevice().getId());
          } catch (Exception exception) {
            exception.printStackTrace();
          }
          super.mouseClicked(e);
        }
      });
      skip_Indietro.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            fetcher.previousPlayer(p.getDevice().getId());
          } catch (Exception exception) {
            exception.printStackTrace();
          }          super.mouseClicked(e);
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
