import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
class newGrayScale
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
int red,blue,green,avgRGB,newRGB;
Color pixelColor,grayScale;

for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
System.out.println(red+" "+green+" "+blue);
newRGB=(int)(0.299*red)+(int)(0.587*blue)+(int)(0.114*green);
avgRGB=(red+blue+green)/3;
grayScale=new Color(newRGB,newRGB,newRGB);
image.setRGB(x,y,grayScale.getRGB());
}
}
File outputFile=new File("newGrayScale.jpg");
ImageIO.write(image,"jpg",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
