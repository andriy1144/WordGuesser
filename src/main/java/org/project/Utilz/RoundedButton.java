package org.project.Utilz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton{
    private Color textColor;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setMotionListener();
        this.textColor = Color.WHITE;
    }

    public RoundedButton(String text, Color textColor) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setMotionListener();
        this.textColor = textColor;
    }

    private void setMotionListener(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Color.ORANGE);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        Shape round = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 20, 20);

        g2.setColor(getBackground());
        g2.fill(round);

        g2.setColor(getForeground());
        g2.draw(round);

        FontMetrics fm = g2.getFontMetrics();
        Rectangle r = fm.getStringBounds(getText(), g2).getBounds();
        int textX = (width - r.width) / 2;
        int textY = (height - r.height) / 2 + fm.getAscent();

        g2.setColor(textColor);
        g2.drawString(getText(), textX, textY);
        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Overridden to prevent default border painting
    }
}