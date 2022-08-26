package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args)
            throws IOException
    {
        int number = 4;
        Process process = Runtime.getRuntime().exec("ping -n " + number + " google.com");
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            for (int i = 0; i < 3; i++) {
                System.out.println(s);
            }
            //String[] split = s.split("=");
            //System.out.println(Arrays.toString(split));
        }

    }
}
