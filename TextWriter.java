import java.io.*;

public class TextWriter
{

    protected String myFileName;
    protected PrintWriter myOutFile;
    protected int myErrorFlags;
    protected static final int OPENERROR = 1;
    protected static final int CLOSEERROR = 2;
    protected static final int WRITEERROR = 4;

    public TextWriter(String s)
    {
        this(s, null);
    }

    public TextWriter(String s, String s1)
    {
        myErrorFlags = 0;
        myFileName = s;
        myErrorFlags = 0;
        try
        {
            myOutFile = new PrintWriter(new FileWriter(s, "app".equals(s1)));
        }
        catch(IOException ioexception)
        {
            myErrorFlags |= 0x1;
            myFileName = null;
        }
    }

    public void close()
    {
        if(myFileName != null)
            myOutFile.close();
    }

    public boolean fail()
    {
        return myErrorFlags != 0;
    }

    public void print(char c)
    {
        myOutFile.print(c);
    }

    public void print(int i)
    {
        myOutFile.print(i);
    }

    public void print(double d)
    {
        myOutFile.print(d);
    }

    public void print(String s)
    {
        myOutFile.print(s);
    }

    public void println()
    {
        myOutFile.println();
    }

    public void println(char c)
    {
        myOutFile.println(c);
    }

    public void println(int i)
    {
        myOutFile.println(i);
    }

    public void println(double d)
    {
        myOutFile.println(d);
    }

    public void println(String s)
    {
        myOutFile.println(s);
    }
}
