#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Merge Sort
int *ordened_array;
int *vetAux;

void merge(int begin, int middle, int end)
{
    int auxBegin = begin, auxMiddle = middle+1, aux = 0, size = end-begin+1;
    vetAux = (int*)malloc(size * sizeof(int));

    while(auxBegin <= middle && auxMiddle <= end)
    {
        if(ordened_array[auxBegin] < ordened_array[auxMiddle]) 
        {
            vetAux[aux] = ordened_array[auxBegin];
            auxBegin++;
        } else {
            vetAux[aux] = ordened_array[auxMiddle];
            auxMiddle++;
        }
        aux++;
    }

    while(auxBegin <= middle)
    {
        vetAux[aux] = ordened_array[auxBegin];
        auxBegin++;
        aux++;
    }

    while(auxMiddle <= end) 
    {
        vetAux[aux] = ordened_array[auxMiddle];
        auxMiddle++;
        aux++;
    }

    for(aux = begin; aux <= end; aux++)
    {    
        ordened_array[aux] = vetAux[aux-begin];
    }
    
    free(vetAux);
}

void merge_sort(int begin, int end)
{
    if (begin < end) {
        int middle = (end+begin)/2;

        merge_sort(begin, middle);
        merge_sort(middle+1, end);
        merge(begin, middle, end);
    }
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
    merge_sort(0, length_array); // Chamada da função Merge Sort
    end = (((double) clock())/CLOCKS_PER_SEC) - start; // Fim do temporizador do algoritmo

    printf("%lf \n", end);
    print(length_array); // Função para imprimir a lista ordenada

    // Escrever no arquivo o tempo de processamento
    fprintf(file, "Runtime: %lfs \n", end);

    return 0;
}
