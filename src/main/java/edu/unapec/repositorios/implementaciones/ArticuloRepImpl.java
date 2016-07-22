package edu.unapec.repositorios.implementaciones;

import edu.unapec.entidades.Articulo;
import edu.unapec.repositorios.interfaces.ArticuloRepIF;
import edu.unapec.respuestas.RespuestaProcesoExel;
import edu.unapec.utilidades.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WillieManuel on 16/7/16.
 */
@Repository("articuloRepImpl")
public class ArticuloRepImpl implements ArticuloRepIF {

    @Autowired
    private Environment environment;

    private ExcelUtil excelUtil;

    public ArticuloRepImpl(){
        excelUtil = new ExcelUtil();
    }

    @Override
    public List<Articulo> obtenerArticulos() {

        List<Articulo> articulos = new ArrayList<Articulo>();
        Articulo articulo;
        int columna = 0;

        //Cargando Excel de Articulos
        XSSFWorkbook workbook = excelUtil.obtenerExcelPorRuta(environment.getProperty("ExcelArticulos"));
        XSSFSheet sheet = workbook.getSheetAt(Integer.parseInt(environment.getProperty("HojaDatos")));
        sheet.removeRow(sheet.getRow(0)); //Eliminando Fila de Headers

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            articulo = new Articulo();
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 0) //Id
                    articulo.setId(((Double)cell.getNumericCellValue()).intValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_STRING && columna == 1) //Nombre
                    articulo.setNombre(cell.getStringCellValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 2) //Cantidad
                    articulo.setCantidad(((Double)cell.getNumericCellValue()).intValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 3) //Precio
                    articulo.setPrecio(cell.getNumericCellValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 4) //SubTotal
                    articulo.setSubTotal(cell.getNumericCellValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 5) //Impuestos
                    articulo.setImpuesto(cell.getNumericCellValue());
                else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC && columna == 6) //Total
                    articulo.setTotal(cell.getNumericCellValue());

                columna++;
            }
            articulos.add(articulo);
            columna = 0;
        }
        return articulos;
    }

    @Override
    public void escribirProcesoArticulos(RespuestaProcesoExel respuesta) {

        try {
            XSSFWorkbook workbook = excelUtil.obtenerExcelPorRuta(environment.getProperty("ExcelArticulos"));
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hhmmss a");
            XSSFSheet sheet = workbook.createSheet(sdf.format(new Date()));

            //Headers
            Row rowHeaders = sheet.createRow(0);

            Cell cellCantidadArticulos = rowHeaders.createCell(0);
            cellCantidadArticulos.setCellValue("Cantidad Articulos");

            Cell cellcantidadArticulosGeneral = rowHeaders.createCell(1);
            cellcantidadArticulosGeneral.setCellValue("Cantidad Articulos General");

            Cell cellingresosNetos = rowHeaders.createCell(2);
            cellingresosNetos.setCellValue("Ingresos Netos");

            Cell cellimpuestos= rowHeaders.createCell(3);
            cellimpuestos.setCellValue("Impuestos");

            Cell cellingresosBrutos = rowHeaders.createCell(4);
            cellingresosBrutos.setCellValue("Ingresos Brutos");

            //Resultado Proceso
            Row rowResultadoProceso = sheet.createRow(1);

            Cell cell1 = rowResultadoProceso.createCell(0);
            cell1.setCellValue(respuesta.getCantidadArticulos());

            Cell cell2 = rowResultadoProceso.createCell(1);
            cell2.setCellValue(respuesta.getCantidadArticulosGeneral());

            Cell cell3 = rowResultadoProceso.createCell(2);
            cell3.setCellValue(respuesta.getIngresosNetos());

            Cell cell4= rowResultadoProceso.createCell(3);
            cell4.setCellValue(respuesta.getImpuestos());

            Cell cell5 = rowResultadoProceso.createCell(4);
            cell5.setCellValue(respuesta.getIngresosBrutos());

            FileOutputStream out = new FileOutputStream(new File(environment.getProperty("ExcelArticulos")));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
