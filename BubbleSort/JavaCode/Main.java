import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class BubbleSort
{
    private int[] ordenedArray = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas
    private int lengthArray;

    // Construtor da Classe BubbleSort
    public BubbleSort(int[] array, int lengthArray)
    {
        ordenedArray = array;
        this.lengthArray = lengthArray;
    }

    public int[] ordenedList()
    {
        for(int i = 0; i < lengthArray; i++)
        {
            for(int j = 0; j < lengthArray - i - 1; j++)
            {
                if(ordenedArray[j] > ordenedArray[j+1])
                {
                    int aux = ordenedArray[j];
                    ordenedArray[j] = ordenedArray[j+1];
                    ordenedArray[j+1] = aux;
                }
            }
        }
        return ordenedArray;
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
        int lengthArray = scanner.nextInt();
        scanner.close();
        
        while(count != 4)
        {
            int[] array = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

            for(int i = 0; i < lengthArray; i++) // Adicionar i números aleatórios na lista
            {
                array[i] = random.nextInt(lengthArray);
            }
    
            BubbleSort bubblesort = new BubbleSort(array, lengthArray);
    
            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            long start = System.nanoTime();
            array = bubblesort.ordenedList();
            long end = System.nanoTime() - start;
    
            System.out.println(end);
    
            // Escrever no Arquivo o Tempo de Execução do Algoritmo
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);
    
            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}