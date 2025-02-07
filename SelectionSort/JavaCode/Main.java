import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class SelectionSort {
    private int[] ordenedList = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas
    private int lengthList;
   
    public SelectionSort(int[] ordenedList, int lengthList)
    {
        this.ordenedList = ordenedList;
        this.lengthList = lengthList;
    }

    public int[] OrdenedList()
    {
        int i, j, min, aux;

        for(i = 0; i < (lengthList-1); i++)
        {
            min = i;
            for(j = (i+1); j < lengthList; j++)
            {
                if(ordenedList[j] < ordenedList[min]) min = j;
            }
            if (i != min)
            { 
                aux = ordenedList[i];
                ordenedList[i] = ordenedList[min];
                ordenedList[min] = aux;
            }
        }
        return ordenedList;
    }

    public void PrintList(int[] sortedList, int lengthList)
    {
        for(int i = 0; i < lengthList; i++)
        {
            System.out.printf("%d ", sortedList[i]);
        }
        System.out.print("\n");
    }
}

public class Main {
    public static void main(String arg[]) throws IOException
    {   
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 0;

        // Informações da Quantidade de Entradas e Nome do Arquivo
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();

        scanner.close();

        while(count < 4){
            int[] list = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

            for(int i = 0; i < lengthList; i++)
            {
                list[i] = random.nextInt(lengthList);
            }

            SelectionSort selectionsort = new SelectionSort(list, lengthList);

            // Medir o Tempo de Processamento do Algoritmo Selection Sort
            long start = System.nanoTime();
            list = selectionsort.OrdenedList();
            long end = System.nanoTime() - start;

            System.out.println(end);
            // selectionsort.PrintList(list, lengthList); // Imprimir a Lista Ordenada

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);

            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}