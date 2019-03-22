import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
class avgGrayScale
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
int red,blue,green,avgRGB;
Color pixelColor,grayScale;

for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
avgRGB=(red+blue+green)/3;
grayScale=new Color(avgRGB,avgRGB,avgRGB);
image.setRGB(x,y,grayScale.getRGB());
}
}
File outputFile=new File("avgGrayScale.jpg");
ImageIO.write(image,"jpg",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
