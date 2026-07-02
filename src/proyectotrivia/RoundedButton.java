package proyectotrivia;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class RoundedButton extends JButton {

private Color colorNormal = new Color(153, 204, 255);
private Color colorHover = new Color(102, 178, 255);
private Color colorPressed = new Color(51, 153, 255);

    private boolean hover = false;

    public RoundedButton() {

        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 18));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hover = false;
                repaint();
            }

        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Sombra
        g2.setColor(new Color(0,0,0,60));
        g2.fillRoundRect(4,4,getWidth()-4,getHeight()-4,35,35);

        // Color
        if(getModel().isPressed())
            g2.setColor(colorPressed);
        else if(hover)
            g2.setColor(colorHover);
        else
            g2.setColor(colorNormal);

        g2.fillRoundRect(0,0,getWidth()-4,getHeight()-4,35,35);

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        Shape s = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),35,35);
        return s.contains(x,y);
    }

}