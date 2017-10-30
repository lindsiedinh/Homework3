package com.mycompany.binarysearchmaven;


/*
Lindsie Dinh
1031935
HW3
 */
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author PANDA 
 */
public class MyList {

    public static void main(String[] args) {
        // TODO code application logic here

        CommandLineParser parser = new DefaultParser();
        Options options = new Options(); 

        options.addOption("t", "type", true, "First Parameter");
        options.addOption("k", "key", true, "Second Parameter");
        options.addOption(Option.builder("l") 
            .longOpt("list") 
            .desc("List") 
            .hasArgs() 
            .required(true) 
            .build());

        try {
            CommandLine commandLine = parser.parse(options, args, true);

            String type = commandLine.getOptionValue("type");
            String key = commandLine.getOptionValue("key");
            String[] array = commandLine.getOptionValues("list");
            

            if (array.length < 1 && key.isEmpty()) {
                System.out.println("0");
                return;
            }

            if (type.equals("i")) {

                Integer[] intArray = new Integer[array.length];
                for (int i = 0; i < array.length; i++) {
                    intArray[i] = Integer.parseInt(array[i]);
                }
                int keyI = Integer.parseInt(key);
                
                int value = binSearch(intArray, keyI);
                System.out.println(value);

            } else if (type.equals("s")) {

                int value = binSearch(array, key);
                System.out.println(value);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static int binSearch(Comparable[] aList, Comparable key) {
        int left = 0, right = aList.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (aList[mid].compareTo(key) == 0) {
                return 1;
            }

            if (aList[mid].compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

}
