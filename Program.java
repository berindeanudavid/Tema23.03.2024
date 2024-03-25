import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.HashSet;
public class Program {
    public static void main(String[] args)
    {
        try{
            BufferedReader reader1=new BufferedReader(new FileReader("numere.dat"));
            BufferedReader reader2=new BufferedReader(new FileReader("intervale.dat"));
            Interval.writer=new FileWriter("statistica.dat");
            String line1=reader1.readLine();
            HashSet<Double> set=new HashSet<>();
            while(line1!=null)
            {
                Double d=new Double(line1);
                if(!set.contains(d))
                set.add(d);
                else System.out.println("Numarul "+d.nr+" a fost deja introdus!");
                line1=reader1.readLine();
            }
            String line2=reader2.readLine();
            while(line2!=null)
            {
                String[] intervalParameters=line2.split(",");                    
                Interval interval=new Interval(intervalParameters[0].substring(1,intervalParameters[0].length()),intervalParameters[1].substring(0,intervalParameters[1].length()-1));
                for(Double d:set)
                {
                    interval.testare(d);             
                }
                interval.rezultat();
                line2=reader2.readLine();
            }
            reader1.close();
            reader2.close();
            Interval.writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Nu exista acest fisier sau nu-l pot accesa");
        }
    }
}
