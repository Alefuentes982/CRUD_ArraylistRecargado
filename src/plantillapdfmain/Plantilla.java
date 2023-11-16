/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantillapdfmain;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPCell;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import crudalumnos.Alumno;
import static crudalumnos.AlumnoDao.obtenerDatos;
import javax.swing.JOptionPane;


/**
 *
 * @author Alejandro
 */
public class Plantilla {
    String nombre;
    //String apellido;
    String fecha;
    String rutaImagen;
    
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    //public Plantilla(String nombre, String apellido, String fecha, String rutaImagen) {
    public Plantilla(String nombre, String fecha, String rutaImagen) {    
        this.nombre = nombre;
       // this.apellido = apellido;
        this.fecha = fecha;
        this.rutaImagen = rutaImagen;
        
        documento = new Document();
        titulo = new Paragraph("INFORME DE ALUMNOS DUOC-UC");
    }
     
     
    public void crearPlantilla(){
         System.out.println(fecha);
         
        try{
            archivo = new FileOutputStream(nombre + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1); //alinea centrado en el doc
            
            Image image = null;
            try{
                image = Image.getInstance(rutaImagen);//carga imagen
                image.scaleAbsolute(150, 100);//cambia tamaño
                image.setAbsolutePosition(416, 750); //coloca imagen en posicion xy
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            
            documento.add(image); //agrega imagen al doc
            
            documento.add(titulo);
            //FUTURA MODIFICACION PARA AGREGAR EL NOMBRE DE QUIEN EMITE INFORME
            //agregego parrafos por default se alinean a la izq
            //documento.add(new Paragraph("Nombre: "+ nombre));
            //documento.add(new Paragraph("Apellido: "+ apellido));
            
            documento.add(Chunk.NEWLINE);//crea nueva linea en blanco
            //parrafo principal
            Paragraph texto = new Paragraph("En el siguiente informe se presenta una lista con los alumnos matriculados a la carrera de ingenieria en informatica DUOC-UC");
            texto.setAlignment(Element.ALIGN_JUSTIFIED); // justifico el texto principal
            documento.add(texto);
            
            documento.add(Chunk.NEWLINE);
            
            //crea tabla en pdf
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            
            PdfPCell rut = new PdfPCell(new Phrase("Rut"));
            rut.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell nom = new PdfPCell(new Phrase("Nombre"));
            nom.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell edad = new PdfPCell(new Phrase("Edad"));
            edad.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            
            tabla.addCell(rut);
            tabla.addCell(nom);
            tabla.addCell(edad);
            
            for (Alumno alumno : obtenerDatos()){
                tabla.addCell(alumno.getRut());
                tabla.addCell(alumno.getNombre());
                tabla.addCell(String.valueOf(alumno.getEdad()));
            }
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph("Fecha: " + fecha));
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Archivo PDF creado exitosamente");
            System.out.println("PDF creado exitosamente"); 
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }catch(DocumentException e){
            System.err.println(e.getMessage());
        }
    }
    
}
