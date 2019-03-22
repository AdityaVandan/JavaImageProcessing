import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
class alphaValue
{
public static void main(String gg[])
{
if(gg.length!=1) return;
File file=new File(gg[0]);
BufferedImage image=null;
try
{
image=ImageIO.read(file);

int height=image.getHeight();
int width=image.getWidth();
Color pixel;
for(int x=0;x<width;x++)
{
for(int y=0;y<height;y++)
{
pixel=new Color(image.getRGB(x,y));
System.out.println(pixel.getRed()+" "+pixel.getGreen()+" "+pixel.getBlue()+" "+pixel.getAlpha()); 
}
}
}catch(IOException ioException)
{
System.out.println(ioException.toString());
}
}
}