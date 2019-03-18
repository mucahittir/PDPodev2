/**
*
* @author Mucahit Tiryaki mucahit.tiryaki1@ogr.sakarya.edu.tr
* @since 12.03.2019
* <p>
* Rastgele karakter kütüphanesi test projesi
* </p>
*/

package test;
import rg.RastgeleKarakter;

public class Test {

    public static void main(String[] args) 
    {
       RastgeleKarakter rastgele = new RastgeleKarakter();
       
        for(int i = 0 ; i < 30; i++)
            System.out.println("Tek bir rastgele karakter: " + rastgele.KarakterDondur());
        for(int i = 0 ; i < 30; i++)
            System.out.println("Rastgele 3 karakter: " + rastgele.KelimeDondur(3));
        for(int i = 0 ; i < 30; i++)
            System.out.println("Verilen iki karakter arası rastgele kelime: " + rastgele.KarakterArasiKelime('J', 'k'));
        for(int i = 0 ; i < 30; i++)
            System.out.println("Verilen iki karakter arası rastgele kelime(4 harfli): " + rastgele.KarakterArasiKelime('J', 'k' , 4));
        for(int i = 0 ; i < 30; i++)
            System.out.println("Belirtilen Karakterler:(a,s,d,f,g,t,y,u,ı,o,x,c,v,b): " + rastgele.KarakterlerleKelime("asdfgtyuıoxcvb"));
        for(int i = 0 ; i < 30; i++)
            System.out.println("Belirtilen Karakterler:(a,s,d,f,g,t,y,u,ı,o,x,c,v,b)(3 harfli): " + rastgele.KarakterlerleKelime("asdfgtyuıoxcvb" , 2));
        for(int i = 0 ; i < 30; i++)
            System.out.println("Rastgele Cümle: " + rastgele.RastgeleCumle());
        for(int i = 0 ; i < 30; i++)
            System.out.println("Rastgele Cümle(5 kelimelik): " + rastgele.RastgeleCumle(5));    
        for(int i = 0 ; i < 30; i++)
            System.out.println("Rastgele Cümle(5 kelime , 5 harf): " + rastgele.RastgeleCumle(5,5));
        
       
       
       
    }

}
        