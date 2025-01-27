#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Bubble Sort
int *ordened_array;

void bubble_sort(int qtd)
{
    int i, j, aux;

    // Verificar cada valor do Array com todos os outros
    for(i = 0; i < qtd; i++)
    {
        // Colocar o valor atual na posição certa do Array
        for(j = 0; j < qtd-1; j++)
        {      
            if(ordened_array[j] > ordened_array[j+1])
            {
                aux = ordened_array[j];                 // Valor Auxiliar recebe Atual Valor
                ordened_array[j] = ordened_array[j+1];  // Valor Atual recebe Próximo Valor
                ordened_array[j+1] = aux;               // Próximo Valor recebe Valor Auxiliar
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
    // Informa a quantidade de valores de entrada!
    printf("Enter quantity of input values: ");
    scanf("%d", &qtd_input);
    ordened_array = (int *) malloc(qtd_input * sizeof(int));
    // Informa o nome do arquivo!
    printf("File Name: ");
    scanf("%s", name);

    // Criar um arquivo com o nome informado
    file = fopen(name, "w");

    // Gerar uma lista de X valores aleatorios(0 - 10.000)
    for(int i = 0; i < qtd_input; i++)
    {
        int value = rand() % 10000;
        ordened_array[i] = value;
    }

    init = ((double) clock())/CLOCKS_PER_SEC; // Inicio do temporizador do algoritmo

    bubble_sort(qtd_input); // Chamada da função Bubble Sort

    end = (((double) clock())/CLOCKS_PER_SEC) - init; // Fim do temporizador do algoritmo

    // Escrever no arquivo os valores do array e o tempo de processamento
    fprintf(file, "LISTA DE VALORES ORDENADOS: \n");
    int t = 0;
    for(int k = 0; k < qtd_input; k++)
    {
        fprintf(file, "%d ", ordened_array[k]);
        t++;

        if(t == 20){fprintf(file, "\n"); t = 0;}
    }
    fprintf(file, "\nTEMPO: %lfs", end);

    return 0;
}