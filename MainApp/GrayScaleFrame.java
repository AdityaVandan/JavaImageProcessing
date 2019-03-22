import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
public class GrayScaleFrame extends JFrame
{
private JLabel g;
private Image image;
private GrayScaleCreator creator;
private JPanel buttonPanel;
private JLabel imageLabel;
private ImagePanel imagePanel;
private JButton averageGs;
private JButton decomposedGs;
private JButton desaturatedGs;
private JButton singleColorChannelRedGs;
private JButton singleColorChannelBlueGs;
private JButton singleColorChannelGreenGs;
private JButton luminosityGs1;
private JButton luminosityGs2;
private JButton hsl;
private Container c;
private String name;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Constructor
GrayScaleFrame(String fileName)
{
super("GrayScale");

name=fileName;
initComponents();
initActionListener();
setAppearance();

}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ setImage()
public void setInitialImage()
{
image=creator.getImage(0);
imageLabel.setIcon(new ImageIcon(image));

}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ initComponents()
public void initComponents()
{
g=new JLabel();
imageLabel=new JLabel();
creator=new GrayScaleCreator(name);
GrayScaleCreator creator;
imagePanel=new ImagePanel();
buttonPanel=new JPanel();
averageGs=new JButton("Avg");
decomposedGs=new JButton("Dec");
desaturatedGs=new JButton("Desat");
singleColorChannelRedGs=new JButton("SCC Red");
singleColorChannelBlueGs=new JButton("SCC Blue");
singleColorChannelGreenGs=new JButton("SCC Green");
luminosityGs1=new JButton("Lumino");
luminosityGs2=new JButton("Lumino");
hsl=new JButton("Original");
buttonPanel.setLayout(new GridLayout(10,1));
buttonPanel.add(averageGs);
buttonPanel.add(decomposedGs);
buttonPanel.add(desaturatedGs);
buttonPanel.add(singleColorChannelRedGs);
buttonPanel.add(singleColorChannelGreenGs);
buttonPanel.add(singleColorChannelBlueGs);
buttonPanel.add(luminosityGs1);
buttonPanel.add(luminosityGs2);
buttonPanel.add(hsl);
imagePanel.setLayout(new BorderLayout());
imagePanel.add(imageLabel,BorderLayout.CENTER);
imagePanel.add(g,BorderLayout.CENTER);

imageLabel.setVisible(true);
g.setVisible(false);
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ setAppearance()
public void setAppearance()
{
c=getContentPane();
c.setLayout(null);
buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
imagePanel.setBorder(BorderFactory.createLineBorder(Color.black));
buttonPanel.setBounds(5,5,300,940);
imagePanel.setBounds(5+310,5,1150,940);
c.add(imagePanel);
c.add(buttonPanel);
setDefaultCloseOperation(EXIT_ON_CLOSE);
int height,width;
height=1000;
width=1500;
setSize(width,height);
Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
setLocation(d.width/2-(width)/2,d.height/2-(height)/2);
setVisible(true);
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ initActionListener()
public void initActionListener()
{
averageGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==averageGs)
{
image=creator.getImage(1);

g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));
}
}
});



decomposedGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==decomposedGs)
{
image=creator.getImage(2);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));
}
}
});




desaturatedGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==desaturatedGs)
{
image=creator.getImage(3);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));
}
}
});

singleColorChannelRedGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==singleColorChannelRedGs)
{
image=creator.getImage(4);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});


singleColorChannelGreenGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==singleColorChannelGreenGs)
{
image=creator.getImage(5);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});


singleColorChannelBlueGs.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==singleColorChannelBlueGs)
{
image=creator.getImage(6);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});


luminosityGs1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==luminosityGs1)
{
image=creator.getImage(7);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});


luminosityGs2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==luminosityGs2)
{
image=creator.getImage(8);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});


hsl.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==hsl)
{
image=creator.getImage(9);
g.setVisible(true);
imageLabel.setVisible(false);
g.setIcon(new ImageIcon(image));

}
}
});



}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Main
public static void main(String gg[])
{
if(gg.length==0) return;
JFrame frame=new GrayScaleFrame(gg[0]);
}
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ GrayScaleCreator Class
class GrayScaleCreator
{
private String name;
private BufferedImage averageGs;
private BufferedImage decomposedGs;
private BufferedImage desaturatedGs;
private BufferedImage singleColorChannelRedGs;
private BufferedImage singleColorChannelBlueGs;
private BufferedImage singleColorChannelGreenGs;
private BufferedImage luminosityGs1;
private BufferedImage luminosityGs2;
private BufferedImage hsl;
private BufferedImage originalImage;
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Constructor 
GrayScaleCreator(String fileName)
{
name=fileName;
grayScaleMethod();
}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ GrayScaleMethod
public void grayScaleMethod()
{
File file=new File(name);

try
{
originalImage=ImageIO.read(file);
decomposedGs=ImageIO.read(file);
averageGs=ImageIO.read(file);
desaturatedGs=ImageIO.read(file);
singleColorChannelRedGs=ImageIO.read(file);
singleColorChannelBlueGs=ImageIO.read(file);
singleColorChannelGreenGs=ImageIO.read(file);
luminosityGs1=ImageIO.read(file);
luminosityGs2=ImageIO.read(file);
hsl=ImageIO.read(file);
int height,width,average;
height=averageGs.getHeight();
width=averageGs.getWidth();
int red,blue,green,avgRGB,newRed,newGreen,newBlue;
Color pixelColor,grayScale;

for(int y=0;y<height;y++)
{
for(int x=0;x<width;x++)
{
pixelColor=new Color(averageGs.getRGB(x,y));
red=pixelColor.getRed();
blue=pixelColor.getBlue();
green=pixelColor.getGreen();
avgRGB=(red+blue+green)/3;
grayScale=new Color(avgRGB,avgRGB,avgRGB);
averageGs.setRGB(x,y,grayScale.getRGB());

grayScale=new Color(red,red,red);
decomposedGs.setRGB(x,y,grayScale.getRGB());

average=avg(red,blue,green);
grayScale=new Color(average,average,average);
desaturatedGs.setRGB(x,y,grayScale.getRGB());

grayScale=new Color(red,red,red);
singleColorChannelRedGs.setRGB(x,y,grayScale.getRGB());

grayScale=new Color(green,green,green);
singleColorChannelGreenGs.setRGB(x,y,grayScale.getRGB());

grayScale=new Color(blue,blue,blue);
singleColorChannelBlueGs.setRGB(x,y,grayScale.getRGB());

newRed=(int)(0.299*red);
newGreen=(int)(0.587*green);
newBlue=(int)(0.114*blue);
grayScale=new Color(newRed+newGreen+newBlue,newRed+newGreen+newBlue,newRed+newGreen+newBlue);
luminosityGs1.setRGB(x,y,grayScale.getRGB());

newRed=(int)(red*0.2126);
newGreen=(int)(blue*0.7152);
newBlue=(int)(green*0.0722);
grayScale=new Color(newRed+newGreen+newBlue,newRed+newGreen+newBlue,newRed+newGreen+newBlue);
luminosityGs2.setRGB(x,y,grayScale.getRGB());

}
}
File outputFile=new File("avgGrayScale.jpg");
ImageIO.write(averageGs,"jpg",outputFile);
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
public Image getImage(int i)
{
if(i==0) return originalImage.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==1) return averageGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==2) return decomposedGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==3) return desaturatedGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==4) return singleColorChannelRedGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==5) return singleColorChannelGreenGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==6) return singleColorChannelBlueGs.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==7) return luminosityGs1.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==8) return luminosityGs2.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
if(i==9) return hsl.getScaledInstance(1150,940,Image.SCALE_SMOOTH);
System.out.println("Image Khali Hai");
return null;
}
}
class ImagePanel extends JPanel
{
private BufferedImage image;
public void setImage(BufferedImage i)
{
image=i;
}
protected void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawImage(image,0,0,this);
}

}