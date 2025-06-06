#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Insertion Sort
int *ordened_array;

void insertion_sort(int length_array)
{
    int i, temp, aux;

    for(i = 1; i < length_array; i++)
    {
        temp = i;
        while(ordened_array[temp] < ordened_array[temp - 1]) 
        {
            aux = ordened_array[temp];
            ordened_array[temp] = ordened_array[temp - 1];
            ordened_array[temp - 1] = aux;
            temp--;

            if(temp == 0) break;
        }
    }
}

void print_array(int length_array)
{
    int i, break_;
    for(i = 0; i < length_array; i++)
    {
        printf("%d ", ordened_array[i]);
        break_++;
        if(break_ == 20) {break_ = 0; printf("\n");}
    }
}

int main()
{
    int length_array = 0;
    char file_name[50];
    double start = 0, end = 0;

    FILE* file;

    printf("Insertion Sort Algorithm \n");
    // Informa a quantidade de valores de entrada
    printf("Enter quantity of input values: ");
    scanf("%d", &length_array);
    ordened_array = (int *) malloc(length_array * sizeof(int));
    // Informa o nome do arquivo
    printf("File Name: ");
    scanf("%s", file_name);

    // Criar um arquivo com o nome informado
    file = fopen(file_name, "w");

    // Gerar uma lista de X valores aleatorios(0 - 9,999)
    for(int i = 0; i < length_array; i++)
    {
        ordened_array[i] = rand() % 10000;
    }

    start = ((double) clock())/CLOCKS_PER_SEC; // Inicio do temporizador do algoritmo
    insertion_sort(length_array); // Chamada da função Insertion Sort
    end = (((double) clock())/CLOCKS_PER_SEC) - start; // Fim do temporizador do algoritmo

    printf("%lf \n", end);
    // print_array(length_array); // Função para imprimir a lista ordenada

    // Escrever no arquivo o tempo de processamento
    fprintf(file, "Runtime: %lfs \n", end);

    return 0;
}
