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
    private List<Integer> ordenedList;
    private int lengthList;

    // Construtor da Classe BubbleSort
    public BubbleSort(List<Integer> ordenedList, int lengthList)
    {
        this.ordenedList = ordenedList;
        this.lengthList = lengthList;
    }

    public List<Integer> ordenedList()
    {
        for(int i = 0; i < lengthList; i++)
        {
            for(int j = 0; j < lengthList - 1; j++)
            {
                // Troca de Valores
                if(ordenedList.get(j) > ordenedList.get(j+1))
                {
                    int aux = ordenedList.get(j);
                    ordenedList.set(j, ordenedList.get(j+1));
                    ordenedList.set(j+1, aux);
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
        int cont = 0;

        // Informações da Quantidade de Entradas e Nome do Arquivo
        System.out.println("Enter quantity of input values: ");
        int lengthList = scanner.nextInt();
        scanner.close();

        while(cont != 4)
        {
            List<Integer> ordenedList = new ArrayList<>();
    
            for(int i = 0; i < lengthList; i++)
            {
                ordenedList.add(random.nextInt(lengthList)); // Adicionar n números aleatórios na lista
            }
    
            BubbleSort BubbleSort = new BubbleSort(ordenedList, lengthList);
    
            // Medir o Tempo de Processamento do Algoritmo Bubble Sort
            double start = System.currentTimeMillis() / (double)1000;
            List<Integer> sortedList = BubbleSort.ordenedList();
            double end = (System.currentTimeMillis() / (double)1000) - start;
    
            System.out.println(end);
    
            // Gravar as Informações em um Arquivo.txt
            FileWriter file = new FileWriter("runtimefile", true);
            PrintWriter ffile = new PrintWriter(file);
    
            int break_ = 0;
    
            ffile.printf("LISTA DE VALORES ORDENADOS: \n");
            for(int i = 0; i < lengthList; i++)
            {
                ffile.printf("%d ", sortedList.get(i));
                break_++;
    
                if(break_ == 20){break_ = 0; ffile.printf("\n");}
            }
            ffile.printf("\nTEMPO: %.6f\n", end);
    
            file.close();
            cont++;
        }
    }
}