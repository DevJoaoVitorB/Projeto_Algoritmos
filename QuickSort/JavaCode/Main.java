import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class QuickSort {
    public int[] ordenedList = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

    public QuickSort(int[] ordenedList) {
        this.ordenedList = ordenedList;
    }

    public void OrdenedList(int begin, int end)
    {
        int i, j, pivo, aux;
        i = begin;
        j = end-1;
        pivo = ordenedList[(begin + end) / 2];
    
        while(i <= j)
        {
            while(ordenedList[i] < pivo && i < end)
            {
                i++;
            }
            while(ordenedList[j] > pivo && j > begin)
            {
                j--;
            }
    
            if(i <= j)
            {
                aux = ordenedList[i];
                ordenedList[i] = ordenedList[j];
                ordenedList[j] = aux;
                i++;
                j--;
            }
        }
    
        if(j > begin) OrdenedList(begin, j+1);
        if(i < end) OrdenedList(i, end);
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

            QuickSort quicksort = new QuickSort(list);

            // Medir o Tempo de Processamento do Algoritmo Quick Sort
            long start = System.nanoTime();
            quicksort.OrdenedList(0, lengthList);
            long end = System.nanoTime() - start;

            System.out.println(end);
            // quicksort.PrintList(quicksort.ordenedList, lengthList); // Imprimir a Lista Ordenada

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);

            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}