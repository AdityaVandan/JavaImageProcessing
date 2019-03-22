import java.awt.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
class desaturationGrayScale
{
public static void main(String args[])
{
if(args.length==0) return;
File file=new File(args[0]);
BufferedImage image=null;
try
{
image=ImageIO.read(file);
int height,width,red,blue,green;
height=image.getHeight();
width=image.getWidth();
Color pixelColor,grayScale;
int average;
for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
average=avg(red,blue,green);
grayScale=new Color(average,average,average);
image.setRGB(x,y,grayScale.getRGB());
}
}
File outputFile=new File("DesaturatedGrayScale.jpg");
ImageIO.write(image,"jpg",outputFile);
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
} 
}
private static int avg(int red,int blue,int green)
{
int max,min;
max=max(red,blue,green);
min=min(red,blue,green);
return (max+min)/2;
}
private static int max(int red,int blue,int green)
{
if(red>blue)
{
if(red>green) return red;
else return green;
}
else
{
if(blue>green) return blue;
else return green;
}
}
private static int min(int red,int blue,int green)
{
if(red<blue)
{
if(red<green) return red;
else return green;
}
else
{
if(blue<green) return blue;
else return green;
}
}
}