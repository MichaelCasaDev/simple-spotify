package ui.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class CustomProgressBarUI extends BasicProgressBarUI {
  private Color progressColor;
  private Color background;

  public CustomProgressBarUI(Color progressColor, Color background) {
    this.progressColor = progressColor;
    this.background = background;
  }

  public void setProgressColor(Color progressColor) {
    this.progressColor = progressColor;
  }

  public void setBackground(Color background) {
    this.background = background;
  }

  @Override
  protected void paintDeterminate(Graphics g, JComponent c) {
    Graphics2D g2d = (Graphics2D) g;
    Insets b = progressBar.getInsets();
    int barRectWidth = progressBar.getWidth() - b.right - b.left;
    int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
    int fillLength;

    if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
      fillLength = (int) ((barRectWidth * progressBar.getPercentComplete()) + 0.5);
    } else {
      fillLength = (int) ((barRectHeight * progressBar.getPercentComplete()) + 0.5);
    }

    g2d.setColor(background);
    if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
      g2d.fillRect(b.left, b.top, barRectWidth, barRectHeight);
    } else {
      g2d.fillRect(b.left, b.top, barRectWidth, barRectHeight);
    }

    g2d.setColor(progressColor);
    if (progressBar.getOrientation() == JProgressBar.HORIZONTAL) {
      g2d.fillRect(b.left, b.top, fillLength, barRectHeight);
    } else {
      g2d.fillRect(b.left, progressBar.getHeight() - b.bottom - fillLength, barRectWidth, fillLength);
    }
  }

}