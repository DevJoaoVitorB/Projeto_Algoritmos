import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class InsertionSort
{
    private int[] ordenedArray = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas
    private int lengthArray;

    // Construtor da Classe InsertionSort
    public InsertionSort(int[] array, int lengthArray)
    {
        ordenedArray = array;
        this.lengthArray = lengthArray;
    }

    public int[] ordenedList()
    {
        int aux, j;
        for(int i = 1; i < lengthArray; i++)
        {
            j = i;
            while (j > 0 && ordenedArray[j] < ordenedArray[j-1])
            {
                aux = ordenedArray[j];
                ordenedArray[j] = ordenedArray[j-1];
                ordenedArray[j-1] = aux;
                j--;
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

        // Informação da Quantidade de Entradas
        System.out.println("Enter quantity of input values: ");
        int lengthArray = scanner.nextInt();

        scanner.close();

        while(count < 4){
            int[] array = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

            for(int i = 0; i < lengthArray; i++)
            {
                array[i] = random.nextInt(lengthArray);
            }

            InsertionSort insertionsort = new InsertionSort(array, lengthArray);

            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            long start = System.nanoTime();
            array = insertionsort.ordenedList();
            long end = System.nanoTime() - start;

            System.out.println(end);

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);

            ffile.printf("Runtime: %fns \n", (double)end);

            file.close();
            count++;
        }
    }
}