package edu.unapec.controladores;

import edu.unapec.respuestas.RespuestaProcesoExel;
import edu.unapec.servicios.implementaciones.ArticuloServImpl;
import edu.unapec.servicios.interfaces.ArticuloServIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by WillieManuel on 16/7/16.
 */
@Controller
public class ExcelControladora {

    @Autowired
    ApplicationContext applicationContext;
    private String _index = "/WEB-INF/index";

    @RequestMapping(value = "inicio", method = RequestMethod.GET)
    public ModelAndView inicio(Model model){
        model.addAttribute("respuestaProcesoExcel", new RespuestaProcesoExel());
        return new ModelAndView(_index);
    }

    @RequestMapping(value = "procesarExcel", method = RequestMethod.GET)
    public ModelAndView procesarExcel(Model model){
        ArticuloServIF articuloServIF = (ArticuloServImpl) applicationContext.getBean("articuloServImpl");
        RespuestaProcesoExel respuesta = articuloServIF.procesarValoresExcel();
        model.addAttribute("respuestaProcesoExcel", respuesta);
        return new ModelAndView(_index);
    }

}
