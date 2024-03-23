import java.io.FileWriter;
import java.io.IOException;

public class Interval {
    private Double min;
    private Double max;
    private double countNr;
    private double countNrForInterval;
    public static FileWriter writer;
    public Interval(String min, String max)
    {
        this.min=new Double(min);
        this.max=new Double(max);
    }
    public void testare(Double d)
    {
        countNr++;
        if(d.nr<=this.max.nr&&d.nr>=this.min.nr)
        {
            countNrForInterval++;
        }
    }
    public void rezultat()
    {
        try{
            if(countNr>0)
                writer.append("Intre "+min.nr+" si "+max.nr+" sunt "+(countNrForInterval/countNr)*100+"% dintre testari.\n");
            else    
                writer.append("Nu a fost testat niciun numar.");
        }
        catch(IOException e)
        {
            System.out.println("Nu exista acest fisier sau nu-l pot accesa");
        }
    }
}
