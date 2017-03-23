import java.io.*;

import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Visualisierung
{
	public static void main( String[ ] args ) throws Exception
	{

		DBManager.connect();

		XYSeriesCollection dataset = new XYSeriesCollection( );


		for(int i = 0; i < DBManager.durchnittspreisProTagX().size(); i++){

			XYSeries a = new XYSeries( "Tanke"+i );
			dataset.addSeries(a);

			for(int j = 0; j < DBManager.durchnittspreisProTagX().get(i).size(); j++){

				a.add((Double)DBManager.durchnittspreisProTagX().get(i).get(j), 
						(Double)DBManager.durchnittspreisProTagY().get(i).get(j));

			}
		}

		JFreeChart xylineChart = ChartFactory.createXYLineChart(
				"Durchnittsspritpreis pro Tag aller Tanken des letzten Jahres", 
				"UTS",
				"Spritpreis pro Liter", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, true, false);
		
		XYPlot plot = xylineChart.getXYPlot();
		plot.getRangeAxis().setLowerBound(1.155);
		

		int width = 1920; /* Width of the image */
		int height = 1080; /* Height of the image */ 
		File XYChart = new File( "Durchschnittspreis.jpeg" ); 
		ChartUtilities.saveChartAsJPEG( XYChart, xylineChart, width, height);

		XYSeriesCollection dataset2 = new XYSeriesCollection( );
		XYSeries b = new XYSeries( "günstigste Tanke" );

		for(int i = 0; i < DBManager.günstigteTankstelle().size(); i++){

			b.add(i,DBManager.günstigteTankstelle().get(i));

		}

		dataset2.addSeries(b);

		JFreeChart xylineChart2 = ChartFactory.createXYLineChart(
				"günstigste Tankstelle", 
				"Stunde",
				"Spritpreis pro Liter", 
				dataset2,
				PlotOrientation.VERTICAL, 
				true, true, false);
		
		XYPlot plot2 = xylineChart2.getXYPlot();
		plot2.getRangeAxis().setLowerBound(1.155);

		int width2 = 1920; /* Width of the image */
		int height2 = 1080; /* Height of the image */ 
		File XYChart2 = new File( "günstigste Tankstelle.jpeg" ); 
		ChartUtilities.saveChartAsJPEG( XYChart2, xylineChart2, width2, height2);

		System.out.println(DBManager.setTankstellenanzahl());
		System.out.println(DBManager.durchnittspreisProTagY().get(0));
		System.out.println(DBManager.durchnittspreisProTagX().get(2));
		System.out.println(DBManager.günstigteTankstelle());
	}
}