/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantillapdfmain;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class PlantillaPdfMain {
    
    public static void main(String[] args){
        
      creaplantilla();
      
    }
    
    public static void creaplantilla(){
      Date date = new Date();
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy -- HH:MM:SS"); //Formato de conversión
      String rutaRelativaImg = "C:\\Users\\Alejandro\\Desktop\\tarea java\\entrega\\recargado\\CRUD_recargado\\IMG\\duoc.png";
     
      String fechaConvertida = format.format(date); //Se parsea la fecha
      //Plantilla miPlantilla = new Plantilla("Ale", "Fuentes", fechaConvertida, rutaRelativaImg);
      Plantilla miPlantilla = new Plantilla("DUOC-UC", fechaConvertida, rutaRelativaImg);
      miPlantilla.crearPlantilla();
}
    
    public static void abrirPDF(){
        try{
            String rutaPDF = "C:\\Users\\Alejandro\\Desktop\\2222\\CRUD_ArraylistRecargado\\duoc-uc.png";
            
            //utiliza navegador web clase Desktop de java
            if(Desktop.isDesktopSupported()){
                
                //inicializa y crea la instancia con la ruta del archivo
                Desktop desktop = Desktop.getDesktop();
                
                File archivoPDF = new File(rutaPDF);
                if (archivoPDF.exists()){   //comprueba que el archivo exista
                    
                    desktop.open(archivoPDF);
                }else{
                    System.out.println("El archivo PDF no existe en la ruta especificada");
                    JOptionPane.showMessageDialog(null, "El archivo PDF no existe en la ruta especificada");
                            
                }
            }else{
                System.out.println("La funcionalidad Desktop no esta soportada en este S.O. ");
                JOptionPane.showMessageDialog(null, "La funcionalidad Desktop no esta soportada en este S.O.");
            }
        }  catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
