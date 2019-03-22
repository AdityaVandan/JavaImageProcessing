import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
class MergerExample
{
public static void main(String gg[])
{
int offX,offY;
//if(gg.length==4) return;
offX=Integer.parseInt("250");
offY=Integer.parseInt("250");
File file1=new File(gg[0]);
File file2=new File(gg[1]);
BufferedImage image1=null;
BufferedImage image2=null;
BufferedImage image=null;
try
{
image1=ImageIO.read(file1);
image2=ImageIO.read(file2);
image=ImageMerger.merge(image1,image2,1,offX,offY);

File outputFile=new File("combinedImage.jpg");
ImageIO.write(image,"jpg",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
class ImageMerger
{
public static BufferedImage merge(BufferedImage bigImage,BufferedImage smallImage,int offsetPoint,int offsetX,int offsetY)
{
int W,H,w,h;
W=bigImage.getWidth();
H=bigImage.getHeight();
w=smallImage.getWidth();
h=smallImage.getHeight();
BufferedImage image=new BufferedImage(W,H,BufferedImage.TYPE_INT_RGB);
Color pixelValue1,pixelValue2,pixelValue;
int alpha1,alpha2;
int r1,r2,g1,g2,b1,b2,r,b,g,c1,c2;
float a2,a1,a;
float calN,calD,cal;
if(offsetPoint==1)
{


for(int x=0;x<W;x++)
{
for(int y=0;y<H;y++)
{
pixelValue=new Color(bigImage.getRGB(x,y));

image.setRGB(x,y,bigImage.getRGB(x,y));





if((x>offsetX && x<(offsetX+w)) && (y>offsetY && y<(offsetY+h)))
{
pixelValue1=new Color(bigImage.getRGB(x,y));
pixelValue2=new Color(smallImage.getRGB((x-offsetX),(y-offsetY)));
r1=pixelValue1.getRed();
g1=pixelValue1.getGreen();
b1=pixelValue1.getBlue();
a1=pixelValue1.getAlpha();
r2=pixelValue2.getRed();
g2=pixelValue2.getGreen();
b2=pixelValue2.getBlue();
a2=pixelValue2.getAlpha();
c1=r1;
c2=r2;
calN=(c1*(a1/256))+(c2*a2*(1-(a1/256)));
calD=(a1/256)+((a2/256)*(1-(a1/256)));
a=calD;
cal=calN/calD;
r=(int)cal;

c1=g1;
c2=g2;
calN=(c1*(a1/256))+(c2*a2*(1-(a1/256)));
cal=calN/calD;
g=(int)cal;

c1=b1;
c2=b2;
calN=(c1*(a1/256))+(c2*a2*(1-(a1/256)));
cal=calN/calD;
b=(int)cal;
if(a>=1) a=0.992f;
if(r>=255) r=255;
if(g>=255) g=255;
if(b>=255) b=255;
//System.out.println("Red: "+r1+" "+r2+" "+r+" Green: "+g1+" "+g2+" Blue: "+b1+" "+b2+" Alpha: "+a1+" "+a2+" "+a);
pixelValue=new Color(r,g,b);
image.setRGB(x,y,pixelValue.getRGB());
}
}
}
}
return image;
}
}
