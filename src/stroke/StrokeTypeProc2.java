package stroke;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import util.Vector2;
import canvas.Drawable;
import canvas.Pixel;
import canvas.command.DrawCommand;
import canvas.command.DrawCommandPixel;

public class StrokeTypeProc2 implements StrokeType {

    @Override
    public DrawCommand[] paintLine(Drawable canvas, Color color, int strokeWidth, int x1, int y1, int x2, int y2, Vector2 velocity) {
        List<DrawCommand> result = new LinkedList<DrawCommand>();
        double rand = Math.random() * 2*Math.PI;
        double length = 1 + Math.random() * 2.5;
        for (int j = 0; j < strokeWidth * length; j++) {
            Pixel pixel = new Pixel((int)(x1 + Math.sin(rand)*j), (int)(y1 + Math.cos(rand)*j), new Color(color.getRed(),color.getGreen(), color.getBlue(), (int)(j/(float)(strokeWidth * length)*255)));

            if (!canvas.getPixelColor(pixel).equals(pixel.color())) {
                result.add(new DrawCommandPixel(pixel));
            }
        }
        
        return result.toArray(new DrawCommand[result.size()]);
    }
    
    @Override
    public String toString() {
        return "Hair";
    }

}
