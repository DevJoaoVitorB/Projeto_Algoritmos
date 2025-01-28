#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Array que será ordenado pelo algoritmo Insertion Sort
int *ordened_array;

void insertion_sort(int qtd)
{
    int i, temp, aux;

    // Começa a verificação pela posição 1 do array(vetor) até a última 
    for(i = 1; i < qtd; i++)
    {
        temp = i; // A variavel auxiliar recebe a posição atual que está sendo verificada

        while(ordened_array[temp] < ordened_array[temp - 1]) // Verificar a o valor da posição atual da direita para a esquerda até o valor atual ser maior que o valor à sua esquerda 
        {
            aux = ordened_array[temp];                      // Valor Auxiliar recebe Atual Valor
            ordened_array[temp] = ordened_array[temp - 1];  // Valor Atual recebe Próximo Valor
            ordened_array[temp - 1] = aux;                  // Próximo Valor recebe Valor Auxiliar
            temp--;

            if(temp == 0) break;
        }
    }
}

int main()
{
    int qtd_input = 0;
    char name[50];
    double init = 0, end = 0;

    FILE* file;

    printf("Insertion Sort Algorithm \n");
    // Informa a quantidade de valores de entrada!
    printf("Enter quantity of input values: ");
    scanf("%d", &qtd_input);
    ordened_array = (int *) malloc(qtd_input * sizeof(int));
    // Informa o nome do arquivo!
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

    insertion_sort(qtd_input); // Chamada da função Insertion Sort

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