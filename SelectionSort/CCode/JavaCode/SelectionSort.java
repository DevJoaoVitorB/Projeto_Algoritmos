import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class SelectionSort {
    private int[] ordenedList;
    private int lengthList;

   
    public SelectionSort(int[] ordenedList) {
        this.ordenedList = ordenedList;
        this.lengthList = ordenedList.length;
    }

    public int[] ordenedList() {
        for(int i = 0; i < (lengthList -1); i++){
            int min = i;
            for(int j = (i+1); j < lengthList; j++){
                if(ordenedList[j]<ordenedList[min]){ //caso o valor do índice j seja menor que o valor do indice i,  min recebe o valor de j e adiciona a min
                    min = j;
                }  
                if (i != min){ // se o i 
                    int aux = ordenedList[i];
                    ordenedList[i] = ordenedList[min];
                    ordenedList[min] = aux;
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

            SelectionSort selectionsort = new SelectionSort(ordenedList);

            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            double start = System.currentTimeMillis()/ (double)1000 ;
            int[] sortedList = selectionsort.ordenedList();
            double end = (System.currentTimeMillis()/ (double)1000) - start;

            System.out.println(end);

            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("SelectionSort100", true);
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