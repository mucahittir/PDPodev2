/**
*
* @author Mucahit Tiryaki mucahit.tiryaki1@ogr.sakarya.edu.tr
* @since 12.03.2019
* <p>
* Rastgele karakter kütüphanesi
* </p>
*/


package rg;


public class RastgeleKarakter 
{
    //kullandığımız random fonksiyonunda kullandığımız değişken tanımlamaları ve alfabe tanımlaması.
    private final int c, b;
    private double s;
    private final double m;
    private final String alfabe;
    
    //tanımladığımız değişkenlerin ilk değerlerinin atıldığı yapıcı metod.
    public RastgeleKarakter()
    {
        this.c = 1664525; 
        this.b = 1013904226;
        this.m = Math.pow(2, 32);
        this.alfabe = "ABCÇDEFGĞHIİJKLMNOÖPQRSŞTUÜVWXYZabcçdefgğhıijklmnoöpqrsştuüvwxyz";
    }
    
    // kullandığımız rastgele sayı üretme algoritması. algoritma adı:lineer benzerlik alg.
    private double RastgeleSayiUret()
    {   
        
        s = System.nanoTime()%100000;
        s = (s * c + b)%m;
        return s%alfabe.length();
    }
    
    // rastgele sayı üretme metodunun kullanıcının alfabesine göre overload edilmiş hali.
    private double RastgeleSayiUret(String alfabe)
    {   
        
        s = System.nanoTime()%100000;
        s = (s * c + b)%m;
        return s%alfabe.length();
    }
    
    //rastgele sayı üretme algoritmasına göre alfabemizden karakter döndüren metod.
    private char IntToChar()
    {
        char karakter;
        karakter = alfabe.charAt((int)RastgeleSayiUret());
        return karakter;
    }
    
    //karakter döndüren metodun kullanıcının alfabesine göre overload edilmiş hali.
    private char IntToChar(String alfabe)
    {
        char karakter;
        karakter = alfabe.charAt((int)RastgeleSayiUret(alfabe));
        return karakter;
    }
    
    //istediğimiz karakterin alfabenin kaçıncı elemanı olduğunu gösteren metod.
    private int KarakterIndex(char a)
    {
       return alfabe.indexOf(a);
    }
    
    //kelime döndüren fonksiyonun kullanıcının alfabesine göre overload edilmiş hali.
    private String KelimeDondur(int length , String alfabe)
    {
        String cumle = "";
        //inttochar metodundan aldığımız karakterleri cümle değişkeninin içine ekler.
        for(int i = 0 ; i < length ; i++)
        {
            cumle += IntToChar(alfabe);
        }
        return cumle;
    }
    
    // kullanıcıdan aldığımız alfabenin harflerini sıralayan metod
    private String Sirala(char [] karakterler)
    {
        char temp;
        String alfabe = "";
        //sıralama algoritması.
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
        //sıraladığımız karakterleri alfabe değişkeninin içine ekler
        for(int i = 0 ; i < karakterler.length; i++)
        {
            alfabe += karakterler[i];
        }
        
        return alfabe;
    }
    
    // tek bir rastgele karakter döndüren metod.
    public char KarakterDondur()
    {
        return IntToChar();
    }
    //kullanıcıdan aldığı uzunlukta karakter döndüren metod.
    public String KelimeDondur(int length)
    {
        String cumle = "";
        //inttochar metodundan aldığımız karakterleri cümle değişkeninin içine ekler.
        for(int i = 0 ; i < length ; i++)
        {
            cumle += IntToChar();
        }
        return cumle;
    }
    
    
    //kullanıcdan aldığımız karakterlerin arasındaki harflerin alfabe olarak tanımlandığı ve o alfabeye göre kelime döndürülen metod.
    public String KarakterArasiKelime(char a , char b)
    {
        int sayi1, sayi2;
        sayi1 = KarakterIndex(a);
        sayi2 = KarakterIndex(b);
        //eğer 1.karakterin indexi diğerinden büyükse yerlerini değiştirdiğimiz koşul. 
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
    
    // karakterlerarasikelime methodunun kaç karakter olacağını da belli ettiğimiz overload edilmiş fonksiyon
     public String KarakterArasiKelime(char a , char b , int sayi)
    {
        int sayi1, sayi2;
        sayi1 = KarakterIndex(a);
        sayi2 = KarakterIndex(b);
        //eğer 1.karakterin indexi diğerinden büyükse yerlerini değiştirdiğimiz koşul. 
        if(sayi1 > sayi2)
        {
            int gecici;
            gecici = sayi1;
            sayi1 = sayi2;
            sayi2 = gecici;
        }
            
        String geciciAlfabe =  alfabe.substring(sayi1, sayi2);
        return KelimeDondur(sayi, geciciAlfabe);
    }
    
    // rastgele bir cümle döndüren metod.
    public String RastgeleCumle()
    {
        int kelimeSayi = (int)RastgeleSayiUret()%5+1;
        String cumle = "";
        // rastgele olarak alınan boşluk sayısı kadar kelime üreten döngü
        for(int i = 0 ; i < kelimeSayi; i++)
        {
            cumle += KelimeDondur((int)RastgeleSayiUret()%8+1) + " ";
        }
        
        return cumle;
    }
    // rastgele cümle döndüren metodun overload edilmiş hali. parametre olarak girilen sayı kadar kelime.
    public String RastgeleCumle(int sayi)
    {
        String cumle = "";
        // rastgele olarak alınan boşluk sayısı kadar kelime üreten döngü
        for(int i = 0 ; i < sayi; i++)
        {
            cumle += KelimeDondur((int)RastgeleSayiUret()%8+1) + " ";
        }
        
        return cumle;
    }
    // rastgele cümle döndüren metodun overload edilmiş hali. parametre olarak girilen sayı kadar kelime ve harf.
    public String RastgeleCumle(int sayi , int harfsayi)
    {
        String cumle = "";
        // rastgele olarak alınan boşluk sayısı kadar kelime üreten döngü
        for(int i = 0 ; i < sayi; i++)
        {
            cumle += KelimeDondur(harfsayi) + " ";
        }
        
        return cumle;
    }
    
    //kullanıcıdan aldığımız girdiler ile alfabe oluşturup o alfabe ile rastgele kelime döndürdüğümüz metod.
    public String KarakterlerleKelime(String karakterler)
    {
        char[]a = karakterler.toCharArray();
        String geciciAlfabe = Sirala(a);
        return KelimeDondur((int)RastgeleSayiUret()%10+1, geciciAlfabe);
    }
    //karakterlerlekelime metodunun overload edilmiş hali. parametre olarak girilen sayı kadar harf.
    public String KarakterlerleKelime(String karakterler , int sayi)
    {
        char[]a = karakterler.toCharArray();
        String geciciAlfabe = Sirala(a);
        return KelimeDondur(sayi, geciciAlfabe);
    }
    
    
    
    
    
}
