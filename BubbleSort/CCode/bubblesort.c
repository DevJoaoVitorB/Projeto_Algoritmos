#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Bubble Sort
int *ordened_array;

void bubble_sort(int qtd)
{
    int i, j, aux;
    
    for(i = 0; i < qtd; i++)
    {
        for(j = 0; j < qtd-i-1; j++)
        {      
            if(ordened_array[j] > ordened_array[j+1]) 
            {
                aux = ordened_array[j];
                ordened_array[j] = ordened_array[j+1];
                ordened_array[j+1] = aux;
            }
        }
    }
}

int main()
{
    int qtd_input = 0;
    char name[50];
    double init = 0, end = 0;

    FILE* file;

    printf("Bubble Sort Algorithm \n");
    // Informa a quantidade de valores de entrada
    printf("Enter quantity of input values: ");
    scanf("%d", &qtd_input);
    ordened_array = (int *) malloc(qtd_input * sizeof(int));
    // Informa o nome do arquivo
    printf("File Name: ");
    scanf("%s", name);

    // Criar um arquivo com o nome informado
    file = fopen(name, "w");

    // Gerar uma lista de X valores aleatorios(0 - 9,999)
    for(int i = 0; i < qtd_input; i++)
    {
        int value = rand() % 10000;
        ordened_array[i] = value;
    }

    init = ((double) clock())/CLOCKS_PER_SEC; // Inicio do temporizador do algoritmo

    bubble_sort(qtd_input); // Chamada da função Bubble Sort

    end = (((double) clock())/CLOCKS_PER_SEC) - init; // Fim do temporizador do algoritmo

    printf("%lf", end);
    
    // Escrever no arquivo o tempo de execução do algortimo 
    fprintf(file, "Runtime: %lfs", end);

    return 0;
}
