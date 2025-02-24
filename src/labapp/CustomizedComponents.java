/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labapp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author masihullahomar
 */
public class CustomizedComponents {
    
}
class RoundedPanel extends JPanel {

    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    // Constructor with layout manager and four corner radii
    public RoundedPanel(LayoutManager layout, int topLeft, int topRight, int bottomLeft, int bottomRight) {
        super(layout);
        this.topLeftRadius = topLeft;
        this.topRightRadius = topRight;
        this.bottomLeftRadius = bottomLeft;
        this.bottomRightRadius = bottomRight;
        setOpaque(false); // Ensure transparency to see rounded corners
    }

    // Constructor with just four corner radii
    public RoundedPanel(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        this(null, topLeft, topRight, bottomLeft, bottomRight);
    }

    // Paint component with rounded corners
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the background color
        graphics.setColor(getBackground());

        // Create a path with rounded corners
        Shape roundedShape = createRoundedShape(width, height);
        graphics.fill(roundedShape); // Fill background

        // Optionally draw a border
        graphics.setColor(getForeground());
        // graphics.draw(roundedShape); // Uncomment to add a border
    }

    private Shape createRoundedShape(int width, int height) {
        int arcTopLeft = topLeftRadius * 2;
        int arcTopRight = topRightRadius * 2;
        int arcBottomLeft = bottomLeftRadius * 2;
        int arcBottomRight = bottomRightRadius * 2;

        // Use Path2D for custom rounded corners
        Path2D path = new Path2D.Double();
        path.moveTo(topLeftRadius, 0);
        path.lineTo(width - topRightRadius, 0);
        path.quadTo(width, 0, width, topRightRadius);
        path.lineTo(width, height - bottomRightRadius);
        path.quadTo(width, height, width - bottomRightRadius, height);
        path.lineTo(bottomLeftRadius, height);
        path.quadTo(0, height, 0, height - bottomLeftRadius);
        path.lineTo(0, topLeftRadius);
        path.quadTo(0, 0, topLeftRadius, 0);
        path.closePath();

        return path;
    }
}



class RoundedButton extends JButton {

    private int cornerRadius;

    // Constructor with corner radius
    public RoundedButton(int cornerRadius) {
        super(); // Call the parent constructor
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Ensure transparency to apply custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable antialiasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle for the button background
        Shape roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Set the background color
        g2.setColor(getBackground());
        g2.fill(roundedRect);

        // Optionally draw a border
        g2.setColor(getForeground());
        g2.draw(roundedRect);

        // Paint the button's text and other default content
        g2.setClip(roundedRect); // Ensure text stays within the rounded shape
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Do not paint the default border
    }
}

class RoundedTextField extends JTextField {

    private int cornerRadius;

    // Constructor with corner radius
    public RoundedTextField(int cornerRadius) {
        super(); // Call the parent constructor
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Ensure transparency to apply custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable antialiasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle for the text field background
        Shape roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Set the background color
        g2.setColor(getBackground());
        g2.fill(roundedRect);

        // Paint the text field content
        g2.setClip(roundedRect); // Ensure text stays within the rounded shape
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable antialiasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(Color.WHITE);
        
        // Create a rounded rectangle for the border
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius));
        g2.dispose();
    }
}


class RoundedPasswordField extends JPasswordField {
    private int cornerRadius;

    public RoundedPasswordField(int radius) {
        super();
        this.cornerRadius = radius;
        setOpaque(false); // Makes the background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        g2.dispose();
        super.paintComponent(g); // Let the superclass paint the text
    }
    
        @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable antialiasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(Color.WHITE);
        
        // Create a rounded rectangle for the border
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius));
        g2.dispose();
    }

}

//class RoundedPanel extends JPanel {
//
////        private Color backgroundColor;
//        private int cornerRadius;
//
//        // Constructor with layout manager and corner radius
//        public RoundedPanel(LayoutManager layout, int radius) {
//            super(layout);
//            cornerRadius = radius;
//            setOpaque(false); // Make sure the panel is transparent to see the rounded corners
//        }
//
//        // Constructor with layout manager, corner radius, and background color
////        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
////            super(layout);
////            cornerRadius = radius;
//////            backgroundColor = bgColor;
////            setOpaque(false); // Make sure the panel is transparent to see the rounded corners
////        }
//
//        // Constructor with just corner radius
//        public RoundedPanel(int radius) {
//            super();
//            cornerRadius = radius;
//            setOpaque(false); // Make sure the panel is transparent to see the rounded corners
//        }
//
//        // Constructor with corner radius and background color
////        public RoundedPanel(int radius, Color bgColor) {
////            super();
////            cornerRadius = radius;
////            backgroundColor = bgColor;
////            setOpaque(false); // Make sure the panel is transparent to see the rounded corners
////        }
//
//        // Paint component with rounded corners
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
//            int width = getWidth();
//            int height = getHeight();
//            Graphics2D graphics = (Graphics2D) g;
//            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//            // Draw the background with rounded corners
////            if (backgroundColor != null) {
////                graphics.setColor(backgroundColor);
////            } else {
////                graphics.setColor(getBackground());
////            }
//
//            graphics.setColor(getBackground());
//
//            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
//
//            // Optionally draw a border if desired
//            graphics.setColor(getForeground());
//            //graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // uncomment to add border
//     }
// }


