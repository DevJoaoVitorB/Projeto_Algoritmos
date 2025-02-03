#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Merge Sort
int *ordened_array;

void merge_sort(int length_array)
{
    
}

void print(int length_array)
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

    printf("Merge Sort Algorithm \n");
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
    merge_sort(length_array); // Chamada da função Merge Sort
    end = (((double) clock())/CLOCKS_PER_SEC) - start; // Fim do temporizador do algoritmo

    printf("%lf \n", end);
    print(length_array); // Função para imprimir a lista ordenada

    // Escrever no arquivo o tempo de processamento
    fprintf(file, "Runtime: %lfs \n", end);

    return 0;
}
