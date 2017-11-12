
import org.apache.commons.cli.*;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.OffsetDateTime;
import java.util.Scanner;


public class Sort
{
    private static String filename;
    private static String compareType;
    private static String sortType;

    private static Comparable[] polygonArray;

    public static void main(String[] args)
    {
        Options options = new Options();

        options.addOption("f", true, "Filename");
        options.addOption("F", true, "Filename");

        options.addOption("t", true, "Compare Type");
        options.addOption("T", true, "Compare Type");

        options.addOption("s", true, "Sort Type");
        options.addOption("S", true, "Sort Type");

        CommandLineParser parser = new DefaultParser();
        try
        {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("f"))
            {
                filename = cmd.getOptionValue("f");

            }

            if (cmd.hasOption("F"))
            {
                filename = cmd.getOptionValue("F");
            }

            if (cmd.hasOption("t"))
            {
                compareType = cmd.getOptionValue("t");
            }

            if (cmd.hasOption("T"))
            {
                compareType = cmd.getOptionValue("T");
            }

            if (cmd.hasOption("s"))
            {
                sortType = cmd.getOptionValue("s");
            }

            if (cmd.hasOption("S"))
            {
                sortType = cmd.getOptionValue("S");
            }

        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        System.out.println("filename: " + filename + " compare type: " + compareType + " sort type: " + sortType);

        File file = new File("res/" + filename);

        try
        {
            Scanner readFile = new Scanner(file);

            String numOfObjects = readFile.next();
            int count = Integer.parseInt(numOfObjects);

            polygonArray = new Polygon[count];

            for (int i = 0; i < count; i++)
            {
                String ObjectType = readFile.next();
                String height = readFile.next();
                String value = readFile.next();

                System.out.println("Adding To Array! " + "Number Of Objects: " + count  + " " + ObjectType + " height: " + height + " value: " + value);

                Class<?> cls = Class.forName(ObjectType);
                Class<?> paramType[] = new Class[3];

                paramType[0] = Double.TYPE;
                paramType[1] = Character.TYPE;
                paramType[2] = Double.TYPE;

                Constructor<?> constructor = cls.getConstructor(paramType);

                Object argList[] = new Object[3];
                argList[0] = new Double(Double.parseDouble(height));
                argList[1] = new Character(compareType.charAt(0));
                argList[2] = new Double(Double.parseDouble(value));

                Object o = constructor.newInstance(argList);

                polygonArray[i] = (Polygon) o;

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

        if (compareType.charAt(0) == 'h' || compareType.charAt(0) == 'H')
        {
            if (sortType.charAt(0) == 'b' || sortType.charAt(0) == 'B')
            {
                long startTime = System.currentTimeMillis();
                bubbleSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }
                System.out.println("Array Of Polygons Has Been Bubble Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");


            }
            if (sortType.charAt(0) == 'i' || sortType.charAt(0) == 'I')
            {
                long startTime = System.currentTimeMillis();
                insertionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }
                System.out.println("Array Of Polygons Has Been Insertion Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");

            }
            if (sortType.charAt(0) == 's' || sortType.charAt(0) == 'S')
            {
                long startTime = System.currentTimeMillis();
                selectionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }
                System.out.println("Array Of Polygons Has Been Selection Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");

            }
            if (sortType.charAt(0) == 'm' || sortType.charAt(0) == 'M')
            {
                long startTime = System.currentTimeMillis();
                mergeSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }
                System.out.println("Array Of Polygons Has Been Merge Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'q' || sortType.charAt(0) == 'Q')
            {
                long startTime = System.currentTimeMillis();
                quickSort(polygonArray, 0, (polygonArray.length - 1));
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }
                System.out.println("Array Of Polygons Has Been Quick Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'z' || sortType.charAt(0) == 'Z')
            {
                long startTime = System.currentTimeMillis();
                heapSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double height = polygon.getHeight();

                    System.out.println("height: " + height);
                }

                System.out.println("Array Of Polygons Has Been Heap Sorted By Height LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
        }

        if (compareType.charAt(0) == 'v' || compareType.charAt(0) == 'V')
        {
            if (sortType.charAt(0) == 'b' || sortType.charAt(0) == 'B')
            {
                long startTime = System.currentTimeMillis();
                bubbleSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Bubble Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");


            }
            if (sortType.charAt(0) == 'i' || sortType.charAt(0) == 'I')
            {
                long startTime = System.currentTimeMillis();
                insertionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Insertion Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");

            }
            if (sortType.charAt(0) == 's' || sortType.charAt(0) == 'S')
            {
                long startTime = System.currentTimeMillis();
                selectionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Selection Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'm' || sortType.charAt(0) == 'M')
            {
                long startTime = System.currentTimeMillis();
                mergeSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Merge Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'q' || sortType.charAt(0) == 'Q')
            {
                long startTime = System.currentTimeMillis();
                quickSort(polygonArray, 0, (polygonArray.length - 1));
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;


                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Quick Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'z' || sortType.charAt(0) == 'Z')
            {
                long startTime = System.currentTimeMillis();
                heapSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double volume = polygon.calcVolume();

                    System.out.println("Volume: " + volume);
                }
                System.out.println("Array Of Polygons Has Been Heap Sorted By Volume LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }

        }

        if (compareType.charAt(0) == 'a' || compareType.charAt(0) == 'A')
        {
            if (sortType.charAt(0) == 'b' || sortType.charAt(0) == 'B')
            {
                long startTime = System.currentTimeMillis();
                bubbleSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Bubble Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");


            }
            if (sortType.charAt(0) == 'i' || sortType.charAt(0) == 'I')
            {
                long startTime = System.currentTimeMillis();
                insertionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Insertion Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");

            }
            if (sortType.charAt(0) == 's' || sortType.charAt(0) == 'S')
            {
                long startTime = System.currentTimeMillis();
                selectionSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Selection Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'm' || sortType.charAt(0) == 'M')
            {
                long startTime = System.currentTimeMillis();
                mergeSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Merge Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'q' || sortType.charAt(0) == 'Q')
            {
                long startTime = System.currentTimeMillis();
                quickSort(polygonArray, 0, (polygonArray.length - 1));
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Quick Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
            if (sortType.charAt(0) == 'z' || sortType.charAt(0) == 'Z')
            {
                long startTime = System.currentTimeMillis();
                heapSort(polygonArray);
                long stopTime = System.currentTimeMillis();

                long totalTime = stopTime - startTime;

                for (int i = 0; i < polygonArray.length; i++)
                {
                    Polygon polygon = (Polygon) polygonArray[i];
                    double area = polygon.calcBaseArea();

                    System.out.println("Area: " + area);
                }
                System.out.println("Array Of Polygons Has Been Heap Sorted By Area LARGEST TO SMALLEST!!");
                System.out.println("Time Took To Sort Algorithm: " + totalTime + "ms");
            }
        }

    }

    public static void bubbleSort(Comparable[] polygonArray)
    {
        //bubble sorting

        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING BUBBLE SORTED.......");
        for (int i = 0; i < polygonArray.length; i++)
        {
            for (int k = 1; k < (polygonArray.length - i); k++)
            {

                Polygon polygonKMinus1 = (Polygon) polygonArray[k - 1];
                Polygon polygonK = (Polygon) polygonArray[k];

                if (polygonKMinus1.compareTo(polygonK) == -1)
                {
                    Polygon temp = (Polygon) polygonArray[k - 1];
                    polygonArray[k - 1] = polygonArray[k];
                    polygonArray[k] = temp;
                }

            }

        }
    }

    public static void insertionSort(Comparable[] polygonArray)
    {
        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING INSERTION SORTED.......");

        for (int i = 1; i < polygonArray.length; i++)
        {
            for (int k = i; k > 0; k--)
            {

                Polygon polygonKMinus1 = (Polygon) polygonArray[k - 1];
                Polygon polygonK = (Polygon) polygonArray[k];

                if (polygonK.compareTo(polygonKMinus1) == 1)
                {
                    Polygon temp = (Polygon) polygonArray[k - 1];

                    polygonArray[k - 1] = polygonArray[k];
                    polygonArray[k] = temp;

                }
            }
        }
    }

    public static void selectionSort(Comparable[] polygonArray)
    {
        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING SELECTION SORTED.......");

        for (int i = 0; i < polygonArray.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < polygonArray.length; j++)
            {
                Polygon polygonJ = (Polygon) polygonArray[j];
                Polygon polygonIndex = (Polygon) polygonArray[index];

                if (polygonJ.compareTo(polygonIndex) == 1)
                {
                    index = j;//searching for highest index  
                }
            }
            Polygon bigger = (Polygon) polygonArray[index];
            polygonArray[index] = polygonArray[i];
            polygonArray[i] = bigger;
        }
    }

    public static Comparable[] mergeSort(Comparable[] polygonArray)
    {
        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING MERGE SORTED.......");

        if (polygonArray.length <= 1)
        {
            return polygonArray;
        }

        Comparable[] first = new Comparable[polygonArray.length / 2];
        Comparable[] second = new Comparable[polygonArray.length - first.length];
        System.arraycopy(polygonArray, 0, first, 0, first.length);
        System.arraycopy(polygonArray, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, polygonArray);
        return polygonArray;
    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result)
    {
        int indexFirst = 0;

        int indexSecond = 0;

        int indexMerged = 0;

        while (indexFirst < first.length && indexSecond < second.length)
        {
            if (first[indexFirst].compareTo(second[indexSecond]) > 0)
            {
                result[indexMerged] = first[indexFirst];
                indexFirst++;
            } else
            {
                result[indexMerged] = second[indexSecond];
                indexSecond++;
            }
            indexMerged++;
        }

        System.arraycopy(first, indexFirst, result, indexMerged, first.length - indexFirst);
        System.arraycopy(second, indexSecond, result, indexMerged, second.length - indexSecond);
    }


    public static int partition(Comparable[] polygonArray, int low, int high)
    {
        Polygon pivot = (Polygon) polygonArray[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            Polygon polygonJ = (Polygon) polygonArray[j];

            if (polygonJ.compareTo(pivot) == 1 || polygonJ.compareTo(pivot) == 0)
            {
                i++;

                Polygon temp = (Polygon) polygonArray[i];
                polygonArray[i] = polygonArray[j];
                polygonArray[j] = temp;
            }
        }

        Polygon temp = (Polygon) polygonArray[i + 1];
        polygonArray[i + 1] = polygonArray[high];
        polygonArray[high] = temp;

        return i + 1;
    }


    public static void quickSort(Comparable[] polygonArray, int low, int high)
    {
        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING QUICK SORTED.......");

        if (low < high)
        {
            int pi = partition(polygonArray, low, high);

            quickSort(polygonArray, low, pi - 1);
            quickSort(polygonArray, pi + 1, high);
        }
    }


    public static void heapSort(Comparable[] polygonArray)
    {

        System.out.println("PLEASE WAIT WHILE ARRAY IS BEING HEAP SORTED.......");
        int size = polygonArray.length;
        for (int k = size / 2; k >= 1; k--)
            sink(polygonArray, k, size);
        while (size > 1)
        {
            exch(polygonArray, 1, size--);
            sink(polygonArray, 1, size);
        }
    }

    private static void sink(Comparable[] polygonArray, int k, int size)
    {
        while (2 * k <= size)
        {
            int j = 2 * k;
            if (j < size && greater(polygonArray, j, j + 1)) j++;
            if (!greater(polygonArray, k, j)) break;
            exch(polygonArray, k, j);
            k = j;
        }
    }

    private static boolean greater(Comparable[] polygonArray, int i, int j)
    {
        return polygonArray[i - 1].compareTo(polygonArray[j - 1]) > 0;
    }

    private static void exch(Comparable[] polygonArray, int i, int j)
    {
        Polygon swap = (Polygon) polygonArray[i - 1];
        polygonArray[i - 1] = polygonArray[j - 1];
        polygonArray[j - 1] = swap;
    }


}
