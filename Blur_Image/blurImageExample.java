import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.lang.*;
class blurImageExample
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
int red,blue,green;
Color pixelColor,blur;
int [][]imageArray=new int[width][height];
int [][]matrix=new int[3][3];
BlurPixel bp=new BlurPixel();
Color blurPixel;
for(int x=0;x<3;x++)
{
for(int y=0;y<3;y++)
{
matrix[x][y]=0;
}
}
int [][]kernel;
int []color=new int[3];
for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(image.getRGB(x,y));
imageArray[x][y]=image.getRGB(x,y);
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
}
}

for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
if(x>0 && y>0 && x<width-1 && y<height-1)
{
for(int p=0;p<3;p++)
{
for(int q=0;q<3;q++)
{
matrix[p][q]=imageArray[x+p-1][y+q-1];
}
}

blurPixel=bp.getBlurPixel(matrix);
image.setRGB(x,y,blurPixel.getRGB());
}

}
}





File outputFile=new File("BlurredImage.png");
ImageIO.write(image,"png",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
class BlurPixel
{
public static int [][]kernel;
BlurPixel()
{
kernel=new int[3][3];
for(int x=0;x<3;x++)
{
for(int y=0;y<3;y++)
{
if(x%2==0 && y%2==0) kernel[x][y]=1;
if((x%2==1 && y%2==0) || (x%2==0 && y%2==1)) kernel[x][y]=2;
if(x%2==1 && y%2==1) kernel[x][y]=4;
}
}
/*
System.out.println(kernel[0][0]);
System.out.println(kernel[0][1]);
System.out.println(kernel[0][2]);
System.out.println(kernel[1][0]);
System.out.println(kernel[1][1]);
System.out.println(kernel[1][2]);
System.out.println(kernel[2][0]);
System.out.println(kernel[2][1]);
System.out.println(kernel[2][2]);
*/
}
public Color getBlurPixel(int matrix[][])
{
float a,b,c;
a=b=c=0;
int red,blue,green;
Color newColor;
for(int x=0;x<3;x++)
{
for(int y=0;y<3;y++)
{
newColor=new Color(matrix[x][y]);
red=newColor.getRed();
blue=newColor.getBlue();
green=newColor.getGreen();
a=a+(red*kernel[x][y]);
b=b+(blue*kernel[x][y]);
c=c+(green*kernel[x][y]);
}
}
int []colorArray=new int[3];
colorArray[0]=(int)a/16;
colorArray[1]=(int)c/16;
colorArray[2]=(int)b/16;

return new Color(colorArray[0],colorArray[1],colorArray[2]);
}

}

