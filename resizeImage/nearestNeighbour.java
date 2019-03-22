import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
class ImageResizer
{
public BufferedImage resize(int finalWidth,BufferedImage inputImage)
{
float initialWidth,initialHeight,finalHeight;
initialWidth=inputImage.getWidth();
initialHeight=inputImage.getHeight();
float resizingRatio;
if(finalWidth<initialWidth)
{
resizingRatio=initialWidth/finalWidth;
finalHeight=initialHeight/resizingRatio;
BufferedImage resizedImage;
System.out.println(finalHeight);
int iW,iH,fH,fW,r;
iW=Math.round(initialWidth);
iH=Math.round(initialHeight);
fW=Math.round(finalWidth);
fH=Math.round(finalHeight);
r=Math.round(resizingRatio);
resizedImage=new BufferedImage(fW+20,fH+20,BufferedImage.TYPE_INT_RGB);
int a,b,x,y;
int argb;
for(a=0,x=0;x<iW;x+=r,a++)
{
for(b=0,y=0;y<iH;y+=r,b++)
{
argb=inputImage.getRGB(x,y);
//System.out.println(x+" "+y+" "+argb+" "+a+" "+b);
resizedImage.setRGB(a,b,inputImage.getRGB(x,y));
}
}
return resizedImage;
}else
{
resizingRatio=finalWidth/initialWidth;
finalHeight=initialHeight*resizingRatio;
BufferedImage resizedImage;
int iW,iH,fH,fW,r;
iW=Math.round(initialWidth);
iH=Math.round(initialHeight);
fW=Math.round(finalWidth);
fH=Math.round(finalHeight);
r=Math.round(resizingRatio);
resizedImage=new BufferedImage(fW+2000,fH+2000,BufferedImage.TYPE_INT_RGB);
int c,a,b,x,y;
for(a=0,x=0;x<iW;x++,a+=r)
{
for(c=0;c<r;c++)
{
for(b=0,y=0;y<iH;y++,b+=r)
{
for(int z=0;z<r;z++)
{
//System.out.println(x+" "+y+" "+" "+a+" "+b);
resizedImage.setRGB(a+c,b+z,inputImage.getRGB(x,y));
}
}
}
}
return resizedImage;
}
}
}
class ImageResizeExample
{
public static void main(String gg[])
{
if(gg.length<2) return;
File inputFile=new File(gg[0]);
int width=Integer.parseInt(gg[1]);
BufferedImage i=null;
ImageResizer im=new ImageResizer();
try
{
i=ImageIO.read(inputFile);
BufferedImage outputImage=im.resize(width,i);
if(outputImage==null)
{
System.out.println("Output image null");
return;
}
ImageIO.write(outputImage,"jpg",new File("resizedImage.jpg"));
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}