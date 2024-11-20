/*
 * Written by Tamia Simpkins
 */
import java.awt.*;
import javax.swing.*;

public class SierpinskisTriangle extends Canvas {
    public static final int width = 800;
    public static final int height = 800;
    private static final int limit = 4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski's Triangle");
        frame.setSize(800, 800);
        SierpinskisTriangle st = new SierpinskisTriangle();
        frame.add(st);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        int[] xPoints = {width / 2, 150, width - 100};
        int[] yPoints = {100, height - 100, height - 100};
        drawTriangle(xPoints, yPoints, limit, g);
    }

    public void drawTriangle(int[] xPoints, int[] yPoints, int sub, Graphics g) {
        // draw the main triangle
        g.setColor(Color.pink);
        g.fillPolygon(xPoints, yPoints, 3);

        // calculate midpoints
        int[] midx = {
            (xPoints[0] + xPoints[1]) / 2,
            (xPoints[1] + xPoints[2]) / 2,
            (xPoints[0] + xPoints[2]) / 2
        };

        int[] midy = {
            (yPoints[0] + yPoints[1]) / 2,
            (yPoints[1] + yPoints[2]) / 2,
            (yPoints[0] + yPoints[2]) / 2
        };

        //draw the upside down triangle
        g.setColor(Color.CYAN);
        g.fillPolygon(midx, midy, 3);

        // recursive call
        if (sub > 0) {
            drawTriangle(new int[]{xPoints[0], midx[0], midx[2]}, new int[]{yPoints[0], midy[0], midy[2]}, sub - 1, g);
            
            drawTriangle(new int[]{midx[0], xPoints[1], midx[1]}, new int[]{midy[0], yPoints[1], midy[1]}, sub - 1, g);
            
            drawTriangle(new int[]{midx[2], midx[1], xPoints[2]}, new int[]{midy[2], midy[1], yPoints[2]}, sub - 1, g);

            // draw additional upside down triangles in the gaps
            drawTriangle(new int[]{midx[0], midx[1], (midx[0] + midx[1]) / 2}, 
                        	new int[]{midy[0], midy[1], (midy[0] + midy[1]) / 2}, sub - 1, g);
            
            drawTriangle(new int[]{midx[1], midx[2], (midx[1] + midx[2]) / 2}, 
                         	new int[]{midy[1], midy[2], (midy[1] + midy[2]) / 2}, sub - 1, g);
            
            drawTriangle(new int[]{midx[2], midx[0], (midx[0] + midx[2]) / 2}, 
                         	new int[]{midy[2], midy[0], (midy[0] + midy[2]) / 2}, sub - 1, g);
        }
    }
}
