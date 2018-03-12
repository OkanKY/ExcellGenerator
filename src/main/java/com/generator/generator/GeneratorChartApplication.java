package com.generator.generator;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.generator.generator.service.ExcellService;
import com.generator.generator.service.impl.ExcellServiceImpl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
/**
 * @author imssbora
 */
public class GeneratorChartApplication extends JFrame {
	private static final long serialVersionUID = 6294689542092367723L;

	private ExcellService excellService;

	public GeneratorChartApplication(String title) {
		super(title);

		excellService=new ExcellServiceImpl();

		// Create dataset
		PieDataset dataset = createDataset();

		// Create chart
		JFreeChart chart = ChartFactory.createPieChart(
				"Pie Chart Example",
				dataset,
				true,
				true,
				false);

		//Format Label
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
				"Marks {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

		// Create Panel
		ChartPanel panel = new ChartPanel(chart);
		setContentPane(panel);
	}


	private PieDataset createDataset(){
		DefaultPieDataset dataset=new DefaultPieDataset();
		HashMap<String, Integer> map = generateMap();
		List<Double> list= excellService.generateList(60000);
		list.stream().forEach(c->{
			if(0.0<=c && c<1.0){
				map.put("0.0-1.0",map.get("0.0-1.0")+1);
			}else if(1.0<=c && c<2.0){
				map.put("1.0-2.0",map.get("1.0-2.0")+1);
			}else if(2.0<=c && c<3.0){
				map.put("2.0-3.0",map.get("2.0-3.0")+1);
			}else if(3.0<=c && c<4.0){
				map.put("3.0-4.0",map.get("3.0-4.0")+1);
			}else if(4.0<=c && c<5.0){
				map.put("4.0-5.0",map.get("4.0-5.0")+1);
			}else if(5.0<=c && c<6.0){
				map.put("5.0-6.0",map.get("5.0-6.0")+1);
			}else if(6.0<=c && c<7.0){
				map.put("6.0-7.0",map.get("6.0-7.0")+1);
			}else if(7.0<=c && c<8.0){
				map.put("7.0-8.0",map.get("7.0-8.0")+1);
			}else if(8.0<=c && c<9.0){
				map.put("8.0-9.0",map.get("8.0-9.0")+1);
			}else if(9.0<=c && c<10.0){
				map.put("9.0-10.0",map.get("9.0-10.0")+1);
			}else if(10.0<=c && c<11.0){
				map.put("10.0-11.0",map.get("10.0-11.0")+1);
			}else if(11.0<=c && c<12.0){
				map.put("11.0-12.0",map.get("11.0-12.0")+1);
			}else if(12.0<=c && c<13.0){
				map.put("12.0-13.0",map.get("12.0-13.0")+1);
			}else if(13.0<=c && c<14.0){
				map.put("13.0-14.0",map.get("13.0-14.0")+1);
			}else if(14.0<=c && c<15.0){
				map.put("14.0-15.0",map.get("14.0-15.0")+1);
			}
		});
		dataset.setValue("0.0-1.0",map.get("0.0-1.0"));
		dataset.setValue("1.0-2.0",map.get("1.0-2.0"));
		dataset.setValue("2.0-3.0",map.get("2.0-3.0"));
		dataset.setValue("3.0-4.0",map.get("3.0-4.0"));
		dataset.setValue("4.0-5.0",map.get("4.0-5.0"));
		dataset.setValue("5.0-6.0",map.get("5.0-6.0"));
		dataset.setValue("6.0-7.0",map.get("6.0-7.0"));
		dataset.setValue("7.0-8.0",map.get("7.0-8.0"));
		dataset.setValue("8.0-9.0",map.get("8.0-9.0"));
		dataset.setValue("9.0-10.0",map.get("9.0-10.0"));
		dataset.setValue("10.0-11.0",map.get("10.0-11.0"));
		dataset.setValue("11.0-12.0",map.get("11.0-12.0"));
		dataset.setValue("12.0-13.0",map.get("12.0-13.0"));
		dataset.setValue("13.0-14.0",map.get("13.0-14.0"));
		dataset.setValue("14.0-15.0",map.get("14.0-15.0"));

		return dataset;

	}

	private HashMap<String, Integer> generateMap(){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("0.0-1.0",0);
			map.put("1.0-2.0",0);
			map.put("2.0-3.0",0);
			map.put("3.0-4.0",0);
			map.put("4.0-5.0",0);
			map.put("5.0-6.0",0);
			map.put("6.0-7.0",0);
			map.put("7.0-8.0",0);
			map.put("8.0-9.0",0);
			map.put("9.0-10.0",0);
			map.put("10.0-11.0",0);
			map.put("11.0-12.0",0);
			map.put("12.0-13.0",0);
			map.put("13.0-14.0",0);
			map.put("14.0-15.0",0);
			return map;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GeneratorChartApplication example = new GeneratorChartApplication("Pie Chart");
			example.setSize(800, 400);
			example.setLocationRelativeTo(null);
			example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			example.setVisible(true);
		});
	}
}