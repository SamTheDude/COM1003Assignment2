package com.company;

import com.company.sheffield.EasyGraphics;
import com.company.sheffield.EasyReader;

public class Fish {
    //===== Constant Definitions =====
    //Window dimensions.
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 500;

    //Relative image file location.
    private static final String FILE_LOCATION = "src/resources/fish.txt";

    //Image dimensions.
    private static final int IMAGE_WIDTH = 134;
    private static final int IMAGE_HEIGHT = 45;


    //===== Main Function =====
    public static void main(String[] args) {
        //Create the window for all of the graphics.
        EasyGraphics window = new EasyGraphics(WINDOW_WIDTH, WINDOW_HEIGHT);

        int[][] fileContents = readFile();
        boolean[][] fishMap = decodeArray(fileContents);

        int[] homeCords = new int[]{0, 0};

        outputBitmap(window, fishMap, homeCords, 1);
    }

    //===== Image Output =====
    private static void outputBitmap(
            EasyGraphics window, boolean[][] map, int[] coords, int scaleFactor){
        //work out the dimensions of the map.
        int xDepth = map.length;
        int yDepth = map[0].length;

        //Iterates through the area and plots each point if the
        //corresponding value in the map is true.
        for (int x = 0; x < xDepth; x++) {
            for (int y = 0; y < yDepth; y++) {
                int ycord = (xDepth*scaleFactor) - (coords[0] + x*scaleFactor);
                int xcord = (coords[1] + y*scaleFactor);
                if(map[x][y]){
                    window.fillRectangle(xcord, ycord, scaleFactor, scaleFactor);
                }
            }

        }
    }


    //===== File Interpretation =====
    //Read in the file and store it as an array of integer arrays
    //corresponding to the character's Unicode values in the
    //format of the pixel arrangement of the image.
    private static int[][] readFile(){
        //Define the 2D array with the dimensions of the fish.
        int[][] returnValue = new int[IMAGE_HEIGHT][IMAGE_WIDTH];

        //Read contents of file and index each character into a
        //string.
        EasyReader file = new EasyReader(FILE_LOCATION);
        String fileContents = file.readString();

        //Iterate through the char array and place all the unicode
        //values into the correct spaces in the returned array.
        int counter = 0;
        for (int y = 0; y < IMAGE_HEIGHT; y++) {
            for (int x = 0; x < IMAGE_WIDTH; x++) {
                returnValue[y][x] = (int)fileContents.charAt(counter);
                counter++;
            }
        }

        return returnValue;
    }

    //Convert all the integer elements into a boolean array where
    //true is for the even numbers and false is for the odd numbers.
    private static boolean[][] decodeArray(int[][] input){
        //Make a boolean 2D array to match the size of the input
        //integer 2D array.
        int xDepth = input.length;
        int yDepth = input[0].length;
        boolean[][] decodedArray = new boolean[xDepth][yDepth];

        //Sets the corresponding value in the decodedArray variable
        //to true or false based off the value in the input array.
        for (int x = 0; x < xDepth; x++) {
            for (int y = 0; y < yDepth; y++) {
                decodedArray[x][y] = ((input[x][y] % 2) == 0);
            }
        }

        return decodedArray;
    }
}
