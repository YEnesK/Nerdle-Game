
package nyp_proje;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class DosyaIslemleri {
    
    public static void kaydet(Kayit rec){
        try {
         FileOutputStream fileOut = new FileOutputStream("kayit.dat");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(rec);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved.");
      } catch (IOException e) {
         e.printStackTrace();
         System.out.printf("Data could not serialized!");
      }
    }
    
    public static Kayit kayitOku(){
        try {
         FileInputStream fileIn = new FileInputStream("kayit.dat");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         
         Kayit rec = (Kayit) in.readObject();
    
         in.close();
         fileIn.close();
         return rec;
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("Record class not found");
         c.printStackTrace();
         return null;
      }
    }

    public static void istatistikKaydet(Istatistik stat){
        try {
         FileOutputStream fileOut = new FileOutputStream("statics.dat");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(stat);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved.");
      } catch (IOException e) {
         e.printStackTrace();
         System.out.printf("Data could not serialized!");
      }
    }
    
    public static Istatistik istatistikOku(){
        try {
         FileInputStream fileIn = new FileInputStream("statics.dat");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         
         Istatistik readenstatics = (Istatistik) in.readObject();
    
         in.close();
         fileIn.close();
         return readenstatics;
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         System.out.println("Statics class not found");
         c.printStackTrace();
         return null;
      }
    }
}