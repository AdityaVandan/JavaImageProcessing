import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
import java.awt.*;
class Example
{
public static void main(String args[])
{
if(args.length==0) return;
File file=new File(args[0]);
try
{
BufferedImage image=ImageIO.read(file);
ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(image,"jpg",baos);
byte[] res=baos.toByteArray();
baos.close();
for(int x=0;x<res.length;x=x+4)
{
res[x+1]=res[x+2]=res[x+3];
}



InputStream in=new ByteArrayInputStream(res);
BufferedImage image2=ImageIO.read(in);
ImageIO.write(image2,"jpg",new File("example.jpg"));


}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
}
