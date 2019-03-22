import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.lang.*;
class brightnessExample
{
public static void main(String gg[])
{
if(gg.length!=2) return;
File file=new File(gg[0]);
int factor=Integer.parseInt(gg[1]);
int diffR,diffB,diffG;
float brFactor;
BufferedImage image=null;
try
{
image=ImageIO.read(file);
int height,width;
height=image.getHeight();
width=image.getWidth();
int red,blue,green;
Color pixelColor,brightenedImage;

for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
diffR=255-red;
diffB=255-blue;
diffG=255-green;


// increasing brightness
/*if(factor>50)
{
factor=factor-50;
brFactor=(factor*255)/50;
red=Math.round(brFactor)+red;

blue=Math.round(brFactor)+blue;

green=Math.round(brFactor)+green;
}
if(factor<50)
{
brFactor=(red*factor)/50;
red=Math.round(brFactor);
brFactor=(blue*factor)/50;
blue=Math.round(brFactor);
brFactor=(green*factor)/50;
green=Math.round(brFactor);

}
*/

red=red+factor;
blue=blue+factor;
green=green+factor;

if(red>255)
{
red=255;
}
if(red<0)
{
red=0;
}
if(blue>255)
{
blue=255;
}
if(blue<0)
{
blue=0;
}
if(green>255)
{
green=255;
}
if(green<0)
{
green=0;
}
brightenedImage=new Color(red,green,blue);
image.setRGB(x,y,brightenedImage.getRGB());
}
}
File outputFile=new File("BrightenedImage.jpg");
ImageIO.write(image,"jpg",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
