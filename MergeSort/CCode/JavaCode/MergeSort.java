import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class MergeSort {
    private int[] ordenedList;
    private int auxList;

   
    public MergeSort(int[] ordenedList, int l, int m, int r) {
        this.ordenedList = ordenedList;
        this.lengthList = ordenedList.length;
    }

    public int[] ordenedList() {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;

        int[n1] L; //array da parte esquerda
        int[n2] R; //array da parte direita

        for (i = 0; i < n1; i++){
            L[i] = ordenedList[l+i];
        }
        for (j = 0; j < n2; j++){
            R[j] = ordenedList[m+1+j];
        }

        i = 0;
        j = 0;
        k = l;

        return ordenedList;
    }
}


public class Main {
    public static void main(String arg[]) throws IOException
    {   
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int value = 0;

        // Informações da Quantidade de Entradas e Nome do Arquivo
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();

        scanner.close();

        while(value < 4){
            int[] ordenedList = new int[lengthList];

            for(int i = 0; i < lengthList; i++)
            {
                // ordenedList.add(random.nextInt(lengthList)); // Adicionar n números aleatórios na lista
                ordenedList[i] = random.nextInt(lengthList);
            }

            MergeSort mergesort = new MergeSort(ordenedList);

            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            double start = System.currentTimeMillis()/ (double)1000 ;
            int[] sortedList = mergesort.ordenedList();
            double end = (System.currentTimeMillis()/ (double)1000) - start;

            System.out.println(end);

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("MergeSort100", true);
            PrintWriter ffile = new PrintWriter(file);

            int break_ = 0;

            ffile.printf("LISTA DE VALORES ORDENADOS: \n");
            for(int i = 0; i < lengthList; i++)
            {
                ffile.printf("%d ", sortedList[i]);
                break_++;

                if(break_ == 20){break_ = 0; ffile.printf("\n");}
            }
            ffile.printf("\nTEMPO: %.6f\n", end);

            file.close();
            value++;
        }
    }
}