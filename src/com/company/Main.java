package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
            throws IOException
    {
        List<Output> outputList = new ArrayList<Output>();
        int number = 4;
        int i = 1;
        Process process = Runtime.getRuntime().exec("ping -n " + number + " google.com");
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {

            if (i > 2)
            {
                System.out.println(s);
                String[] splitOutput = s.split(" ");
                int bytes = Integer.parseInt(splitOutput[3].split("=")[1]);
                int time = Integer.parseInt(splitOutput[4].split("=")[1].replace("m", "").replace("s", ""));
                int ttl = Integer.parseInt(splitOutput[5].split("=")[1]);
                outputList.add(new Output(bytes, time, ttl));
            }
            if (i == number + 2)
                break;
            i++;
        }
        var series = new XYSeries("key");
        var datasetSeries = new XYSeriesCollection();
        outputList.forEach((output ->
        {
            for (int j = 0; j < number; j++) {
                series.add(output.getTime(), j);
            }

        }));
        XYDataset dataset = datasetSeries.addSeries(series);
        outputList.forEach((output -> System.out.println(output.toString())));
        JFreeChart lineChart = ChartFactory.createXYLineChart("Latency", "x", "y", dataset);
        ChartUtils.saveChartAsPNG(new File("char.png"), lineChart, 450, 400);
    }

}
