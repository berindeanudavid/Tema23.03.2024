import java.io.IOException;
import java.util.ArrayList;
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
            //
            ArrayList<Double> doubleArray=new ArrayList<>();
            HashSet<String> set= new HashSet<>();
            String line1=reader1.readLine();
            boolean invalid=false;
            while(line1!=null)
            {
                doubleArray.add(new Double(line1));
                line1=reader1.readLine();
                if(set.contains(line1))
                {
                    invalid=true;
                }
                else
                {
                    set.add(line1);
                }
            }
            if(invalid)
            {
                System.out.println("Numerele trebuie sa fie introduse doar o data.");
            }
            else
            {
                String line2=reader2.readLine();
                while(line2!=null)
                {
                    String[] intervalParameters=line2.split(",");
                    Interval interval=new Interval(intervalParameters[0].substring(1,intervalParameters[0].length()),intervalParameters[1].substring(0,intervalParameters[1].length()-1));
                    for(Double d:doubleArray)
                    {
                        interval.testare(d);
                    }
                    interval.rezultat();
                    line2=reader2.readLine();
                }
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
