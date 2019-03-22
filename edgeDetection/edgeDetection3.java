import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.lang.*;
class edgeDetectionExample3
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
Color pixelColor,edge;
int [][]imageArray=new int[width][height];
int [][]matrix=new int[3][3];
EdgeDetection ed=new EdgeDetection();
Color edPixel;
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

edPixel=ed.getEDPixel(matrix);
image.setRGB(x,y,edPixel.getRGB());
}

}
}





File outputFile=new File("edgeDetectedImage3.jpg");
ImageIO.write(image,"jpg",outputFile);

}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
class EdgeDetection
{
public static int [][]kernel;
EdgeDetection()
{
kernel=new int[3][3];
for(int x=0;x<3;x++)
{
for(int y=0;y<3;y++)
{
if((x%2==1 && y%2==0) || (x%2==0 && y%2==1)) kernel[x][y]=0;
if(x%2==1 && y%2==1) kernel[x][y]=0;
}
}
kernel[0][0]=1;
kernel[2][2]=1;
kernel[0][2]=-1;
kernel[2][0]=-1;
System.out.println(kernel[0][0]);
System.out.println(kernel[0][1]);
System.out.println(kernel[0][2]);
System.out.println(kernel[1][0]);
System.out.println(kernel[1][1]);
System.out.println(kernel[1][2]);
System.out.println(kernel[2][0]);
System.out.println(kernel[2][1]);
System.out.println(kernel[2][2]);

}
public Color getEDPixel(int matrix[][])
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
//System.out.println(a+" "+c+" "+b);
int []colorArray=new int[3];
colorArray[0]=(int)a;
colorArray[1]=(int)c;
colorArray[2]=(int)b;
for(int x=0;x<colorArray.length;x++)
{
if(colorArray[x]<0) colorArray[x]=0;
if(colorArray[x]>255) colorArray[x]=255;
}
return new Color(colorArray[0],colorArray[1],colorArray[2]);
}

}

