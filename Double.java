public class Double {
    public double nr;
    public Double(String nr)
    {
        char[] a=nr.toCharArray();
        boolean negative=false;
        int i=0;
        double aux1=0,aux2=0;
        double putere=1;
        if(a[i]=='-')
        {
            negative=true;
            i++;
        }
        while((i<a.length)&&(a[i]!='.'))
        {
            aux1=(double)(a[i]-'0')+aux1*10;
            i++;
        }
        for(int j=i+1;j<=a.length-1;j++)
        {
            aux2=(double)(a[j]-'0')+aux2*10;
            putere=putere*10;
        }
        if(putere>0)
            aux2=aux2/putere;
        if(negative)
            this.nr=(aux1+aux2)*-1;
        else
            this.nr=aux1+aux2;
    }
    public boolean equals(Double d)
    {
        if(this.nr==d.nr)
            return true;
        return false;
    }
}
