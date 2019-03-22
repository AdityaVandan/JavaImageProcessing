import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.*;
public class ImageToByteArrayExample
{
public static void main(String args[])
{
if(args.length==0) return;
File file=new File(args[0]);
int lumino;
byte avg;
try
{
BufferedImage image=ImageIO.read(file);
ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(image,"jpg",baos);
byte[] res=baos.toByteArray();
baos.close();
for(int x=0;x<res.length;x=x+4)
{
lumino=(res[x+1]+res[x+2]+res[x+3])/3;
avg=(byte)lumino;
res[x+1]=res[x+2]=res[x+3]=(avg);
}
InputStream in=new ByteArrayInputStream(res);
BufferedImage image2=ImageIO.read(in);
ImageIO.write(image2,"jpg",new File("example.jpg"));

}catch(IOException e)
{
System.out.println("Dude there is some error here: "+e.getMessage());
}
}
}