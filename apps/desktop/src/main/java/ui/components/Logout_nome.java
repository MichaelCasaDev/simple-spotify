package ui.components;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Logout_nome extends JPanel {
  private JLabel Nome;
  private JLabel logout;

  public Logout_nome(String nome) {
    this.setBackground(new Color(5, 23, 38));
    this.setBounds(1130, 592, 150, 100);
    this.setLayout(null);

    Nome = new JLabel(nome);
    Nome.setForeground(Color.WHITE);
    Nome.setBounds(20, 25, 120, 16);
    this.add(Nome);

    logout = new JLabel("Logout");
    logout.setForeground(Color.WHITE);
    logout.setBounds(57, 62, 50, 16);
    logout.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        System.exit(0);
        super.mouseClicked(e);
      }
    });

    this.add(logout);
  }
}
