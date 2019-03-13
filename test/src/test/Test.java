package test;
import rg.RastgeleKarakter;

public class Test {

    public static void main(String[] args) 
    {
       RastgeleKarakter rastgele = new RastgeleKarakter();
       System.out.println("Tek bir rastgele karakter: " + rastgele.KarakterDondur());
       System.out.println("Rastgele 3 karakter: " + rastgele.KelimeDondur(3));
       System.out.println("Verilen iki karakter arası rastgele kelime: " + rastgele.KarakterArasiKelime('J', 'k'));
       System.out.println("Belirtilen Karakterler: " + rastgele.KarakterlerleKelime("asdfgtyuıoxcvb"));
       System.out.println("Rastgele Cümle: " + rastgele.RastgeleCumle());
       
    }

}
        