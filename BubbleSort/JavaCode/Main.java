import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class BubbleSort
{
    private int[] ordenedList = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas
    private int lengthList;

    public BubbleSort(int[] ordenedList, int lengthList)
    {
        this.ordenedList = ordenedList;
        this.lengthList = lengthList;
    }

    public int[] OrdenedList()
    {
        int i, j, aux;

        for(i = 0; i < lengthList; i++)
        {
            for(j = 0; j < lengthList - i - 1; j++)
            {
                if(ordenedList[j] > ordenedList[j+1])
                {
                    aux = ordenedList[j];
                    ordenedList[j] = ordenedList[j+1];
                    ordenedList[j+1] = aux;
                }
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
        
        // Informações da Quantidade de Entradas
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();
        scanner.close();
        
        while(count != 4)
        {
            int[] list = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

            for(int i = 0; i < lengthList; i++) // Adicionar i números aleatórios na lista
            {
                list[i] = random.nextInt(lengthList);
            }
    
            BubbleSort bubblesort = new BubbleSort(list, lengthList);
    
            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            long start = System.nanoTime();
            list = bubblesort.OrdenedList();
            long end = System.nanoTime() - start;
    
            System.out.println(end);
            // bubblesort.PrintList(list, lengthList); // Imprimir a Lista Ordenada
    
            // Escrever no Arquivo o Tempo de Execução do Algoritmo
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);
    
            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}