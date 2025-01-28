package JavaCode;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class BubbleSort
{
    private int[] ordenedList = new int[100];
    private int lengthList;

    public BubbleSort(int[] ordenedList, int lengthList)
    {
        this.ordenedList = ordenedList;
        this.lengthList = lengthList;
    }

    public int[] ordenedList()
    {
        for(int i = 0; i < lengthList; i++)
        {
            for(int j = 0; j < lengthList - 1; j++)
            {
                if(ordenedList[j] > ordenedList[j+1])
                {
                    int aux = ordenedList[j];
                    ordenedList[j] = ordenedList[j+1];
                    ordenedList[j+1] = aux;
                }
            }
        }
        return ordenedList;
    }
}

public class Main {
    public static void main(String arg[]) throws IOException
    {   
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] ordenedList = new int[100];
        int[] sortedList = new int[100];

        // Informações da Quantidade de Entradas
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();
        scanner.close();

        for(int i = 0; i < lengthList; i++)
        {
            ordenedList[i] = random.nextInt(lengthList); // Adicionar i números aleatórios na lista
        }

        BubbleSort BubbleSort = new BubbleSort(ordenedList, lengthList);

        // Medir o Tempo de Processamento do Algoritmo Bubble Sort
        double start = System.currentTimeMillis() / (double)1000;
        sortedList = BubbleSort.ordenedList();
        double end = (System.currentTimeMillis() / (double)1000) - start;

        System.out.println(end);

        // Gravar as Informações em um Arquivo.txt
        FileWriter file = new FileWriter("runtimefile", true);
        PrintWriter ffile = new PrintWriter(file);

        ffile.printf("Runtime: %.6f\n", end);
        file.close();
    }
}
