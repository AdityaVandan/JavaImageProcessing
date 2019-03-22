import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
class SingleColorChannel
{
public static void main(String gg[])
{
if(gg.length==0) return;
File file1=new File(gg[0]);
File file2=new File(gg[0]);
File file3=new File(gg[0]);
BufferedImage image1,image2,image3;
image1=image2=image3=null;
try
{
image1=ImageIO.read(file1);
image2=ImageIO.read(file2);
image3=ImageIO.read(file3);
int height,width;
height=image1.getHeight();
width=image1.getWidth();
int blue,red,green;
Color pixelColor,grayScale1,grayScale2,grayScale3;
for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image1.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
grayScale1=new Color(red,red,red);
grayScale2=new Color(blue,blue,blue);
grayScale3=new Color(green,green,green);
image1.setRGB(x,y,grayScale1.getRGB());
image2.setRGB(x,y,grayScale2.getRGB());
image3.setRGB(x,y,grayScale3.getRGB());
}
}
File outputFile1=new File("SingleColorChannelRed.jpg");
File outputFile2=new File("SingleColorChannelBlue.jpg");
File outputFile3=new File("SingleColorChannelGreen.jpg");
ImageIO.write(image1,"jpg",outputFile1);
ImageIO.write(image2,"jpg",outputFile2);
ImageIO.write(image3,"jpg",outputFile3);
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}