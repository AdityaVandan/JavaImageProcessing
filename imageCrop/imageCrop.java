import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
class ImageCrop
{
ImageCrop()
{

}
public BufferedImage getCroppedImage(BufferedImage i,int startX,int startY,int cWidth,int cHeight)
{
int height,width;
int matrix[][];
BufferedImage croppedImage1,croppedImage2,croppedImage3,croppedImage4;
try
{
height=i.getHeight();
width=i.getWidth();
croppedImage=new BufferedImage(cWidth,cHeight,BufferedImage.TYPE_INT_RGB);
if(height==cHeight && cWidth==cWidth) return i;
if((startX+cWidth)>height || (startY+cHeight)>width)
{
System.out.println("Image out of Bounds");
return croppedImage;
}
for(int x=startX;x<(startX+cWidth);x++)
{
for(int y=startY;y<(startY+cHeight);y++)
{
croppedImage.setRGB(x-startX,y-startY,i.getRGB(x,y));
//matrix[x-startX][y-startY]=i.getRGB(x,y);
}
}

}catch(Exception ioException)
{
System.out.println("Crop method Error   "+ioException.getMessage());
}
return croppedImage;
}
}
class ImageCropExample
{
public static void main(String gg[])
{
if(gg.length<5) return;
int x,y,height,width;
x=Integer.parseInt(gg[1]);
y=Integer.parseInt(gg[2]);
width=Integer.parseInt(gg[3]);
height=Integer.parseInt(gg[4]);
ImageCrop im=new ImageCrop();
BufferedImage inputImage=null;
try
{
File file=new File(gg[0]);
inputImage=ImageIO.read(file);
File outputFile=new File("CroppedImage.jpg");
BufferedImage outputImage=im.getCroppedImage(inputImage,x,y,height,width);
ImageIO.write(outputImage,"jpg",outputFile);
}catch(IOException ioException)
{
System.out.println("Main Function Error");
}
}
}
