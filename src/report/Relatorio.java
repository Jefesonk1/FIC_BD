package report;

import java.io.InputStream;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jefeson
 */
public class Relatorio {
       public void gerarRelatorio(List<?> lista,String jrxmlPath) throws JRException {
       // jrxmlPath = "/report/relatorio.jrxml";
        InputStream src = Relatorio.class.getResourceAsStream(jrxmlPath);
        JasperReport report = JasperCompileManager.compileReport(src);
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
        JasperViewer.viewReport(print, false);
    } 
 
}
