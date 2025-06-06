import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class MergeSort {
    public int[] ordenedList = new int[100]; // Mudar o tamanho do array com base na quantidade de entradas

    public MergeSort(int[] ordenedList) {
        this.ordenedList = ordenedList;
    }

    public void OrdenedList(int begin, int end)
    {
        if (begin < end) {
            int middle = (end+begin)/2;
    
            OrdenedList(begin, middle);
            OrdenedList(middle+1, end);
            Merge(begin, middle, end);
        }
    }

    public void Merge(int begin, int middle, int end)
    {
        int auxBegin = begin, auxMiddle = middle+1, aux = 0, size = end-begin+1;
        int[] vetAux = new int[size];

        while(auxBegin <= middle && auxMiddle <= end)
        {
            if(ordenedList[auxBegin] < ordenedList[auxMiddle]) 
            {
                vetAux[aux] = ordenedList[auxBegin];
                auxBegin++;
            } else {
                vetAux[aux] = ordenedList[auxMiddle];
                auxMiddle++;
            }
            aux++;
        }

        while(auxBegin <= middle)
        {
            vetAux[aux] = ordenedList[auxBegin];
            auxBegin++;
            aux++;
        }

        while(auxMiddle <= end) 
        {
            vetAux[aux] = ordenedList[auxMiddle];
            auxMiddle++;
            aux++;
        }

        for(aux = begin; aux <= end; aux++)
        {    
            ordenedList[aux] = vetAux[aux-begin];
        }
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

            MergeSort mergesort = new MergeSort(list);

            // Medir o Tempo de Processamento do Algoritmo Merge Sort
            long start = System.nanoTime();
            mergesort.OrdenedList(0, lengthList - 1);
            long end = System.nanoTime() - start;

            System.out.println(end);
            // mergesort.PrintList(mergesort.ordenedList, lengthList); // Imprimir a Lista Ordenada

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);

            ffile.printf("Runtime: %.0fns \n", (double)end);
            file.close();
            count++;
        }
    }
}