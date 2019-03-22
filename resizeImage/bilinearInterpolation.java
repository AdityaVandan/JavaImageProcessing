import java.lang.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
class ImageResizerBilinear
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
System.out.println(iW+" "+iH+" "+fW+" "+fH+" "+r);
resizedImage=new BufferedImage(fW+2000,fH+2000,BufferedImage.TYPE_INT_RGB);
int c,a,b,x,y,z;
int rgb1,rgb2;
float r1,r2,g1,g2,b1,b2;
float R,G,B;
float slope;
Color color1,color2,color;
for(x=0,a=0;x<iW;a+=r,x++)
{
for(c=0;c<r;c++)
{
for(y=0,b=0;y<iH;b+=r,y++)
{
for(z=0;z<r;z++)
{
if(y<iH-2)
{
rgb1=inputImage.getRGB(x,y);
rgb2=inputImage.getRGB(x,y+1);
color1=new Color(rgb1);
color2=new Color(rgb2);
r1=color1.getRed();
g1=color1.getGreen();
b1=color1.getBlue();

r2=color2.getRed();
g2=color2.getGreen();
b2=color2.getBlue();

slope=(z+1)/r;
R=(r2*slope)+((1-slope)*r1);
G=(g2*slope)+((1-slope)*g1);
B=(b2*slope)+((1-slope)*b1);
color=new Color(Math.round(R),Math.round(G),Math.round(B));

resizedImage.setRGB(a+c,b+z,color.getRGB());
}
}
}
}
}
return resizedImage;
}
}
}
class ImageResizeExample2
{
public static void main(String gg[])
{
if(gg.length<2) return;
File inputFile=new File(gg[0]);
int width=Integer.parseInt(gg[1]);
BufferedImage i=null;
ImageResizerBilinear im=new ImageResizerBilinear();
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