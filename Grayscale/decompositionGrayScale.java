import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
class decompostionGrayScale
{
public static void main(String gg[])
{
if(gg.length==0) return;
File file=new File(gg[0]);
BufferedImage image=null;
try
{
image=ImageIO.read(file);
int height,width;
height=image.getHeight();
width=image.getWidth();
int blue,red,green;
Color pixelColor,grayScale;
for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
grayScale=new Color(red,red,red);
image.setRGB(x,y,grayScale.getRGB());

}
}
File outputFile=new File("decomposedGrayScale.jpg");
ImageIO.write(image,"jpg",outputFile);
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}