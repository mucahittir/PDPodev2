package rg;


public class RastgeleKarakter 
{
    private final int c, b;
    private double s;
    private final double m;
    private final String alfabe;
    
    public RastgeleKarakter()
    {
        this.c = 1664525; 
        this.b = 1013904226;
        this.m = Math.pow(2, 32);
        this.alfabe = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz";
    }
    
    private double RastgeleSayiUret()
    {   
        
        s = System.nanoTime()%100000;
        s = (s * c + b)%m;
        return s%alfabe.length();
    }
    
    private double RastgeleSayiUret(String alfabe)
    {   
        
        s = System.nanoTime()%100000;
        s = (s * c + b)%m;
        return s%alfabe.length();
    }
    
    private char IntToChar()
    {
        char karakter;
        karakter = alfabe.charAt((int)RastgeleSayiUret());
        return karakter;
    }
    
    private char IntToChar(String alfabe)
    {
        char karakter;
        karakter = alfabe.charAt((int)RastgeleSayiUret(alfabe));
        return karakter;
    }
    
    private int KarakterIndex(char a)
    {
       return alfabe.indexOf(a);
    }
    
    private String KelimeDondur(int length , String alfabe)
    {
        String cumle = "";
        for(int i = 0 ; i < length ; i++)
        {
            cumle += IntToChar(alfabe);
        }
        return cumle;
    }
    
    private String Sirala(char [] karakterler)
    {
        char temp;
        String alfabe = "";
        for(int i = 0 ; i < karakterler.length; i++)
        {
            for(int j = i+1 ; j < karakterler.length; j++ )
            {
                if(karakterler[i] > karakterler[j])
                {
                    temp = karakterler[i];
                    karakterler[i] = karakterler[j];
                    karakterler[j] = temp;
                }
            }
        }
        for(int i = 0 ; i < karakterler.length; i++)
        {
            alfabe += karakterler[i];
        }
        
        return alfabe;
    }
    
    public char KarakterDondur()
    {
        return IntToChar();
    }
    
    public String KelimeDondur(int length)
    {
        String cumle = "";
        for(int i = 0 ; i < length ; i++)
        {
            cumle += IntToChar();
        }
        return cumle;
    }
    
    
    
    public String KarakterArasiKelime(char a , char b)
    {
        int sayi1, sayi2;
        sayi1 = KarakterIndex(a);
        sayi2 = KarakterIndex(b);
        if(sayi1 > sayi2)
        {
            int gecici;
            gecici = sayi1;
            sayi1 = sayi2;
            sayi2 = gecici;
        }
            
        String geciciAlfabe =  alfabe.substring(sayi1, sayi2);
        return KelimeDondur((int)RastgeleSayiUret()%10+1, geciciAlfabe);
    }
    
    public String RastgeleCumle()
    {
        int kelimeSayi = (int)RastgeleSayiUret()%5+1;
        String cumle = "";
        for(int i = 0 ; i < kelimeSayi; i++)
        {
            cumle += KelimeDondur((int)RastgeleSayiUret()%5+1) + " ";
        }
        
        return cumle;
    }
    
    public String KarakterlerleKelime(String karakterler)
    {
        char[]a = karakterler.toCharArray();
        String geciciAlfabe = Sirala(a);
        return KelimeDondur((int)RastgeleSayiUret()%10+1, geciciAlfabe);
    }
    
    
    
    
    
}
