package edu.unapec.utilidades;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by WillieManuel on 16/7/16.
 */
public class ExcelUtil {

    public XSSFWorkbook obtenerExcelPorRuta(String ruta){
        try {
            File excel = new File(ruta);
            FileInputStream archivo = new FileInputStream(excel);
            XSSFWorkbook workbook = new XSSFWorkbook(archivo);
            archivo.close();
            return workbook;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
