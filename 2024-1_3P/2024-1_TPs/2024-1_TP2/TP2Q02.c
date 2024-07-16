#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ALTERNATIVE_NAMES 10
#define MAX_ALTERNATIVE_ACTORS 10
#define MAX_LINE_LENGTH 1024
#define MAX_NAME_LENGTH 50
#define MAX_TOKENS 20
#define MAX_PERSONAGENS 1000

typedef struct {
    char elementos[MAX_ALTERNATIVE_NAMES][MAX_NAME_LENGTH];
    int tamanho;
} Lista;

typedef struct {
    char id[MAX_NAME_LENGTH];
    char name[MAX_NAME_LENGTH];
    Lista alternativeNames;
    char house[MAX_NAME_LENGTH];
    char ancestry[MAX_NAME_LENGTH];
    char species[MAX_NAME_LENGTH];
    char patronus[MAX_NAME_LENGTH];
    int hogwartsStaff; // bool
    int hogwartsStudent; // bool 
    char actorName[MAX_NAME_LENGTH];
    Lista alternativeActors;
    int alive; // bool
    char dateOfBirth[11]; // Alterado para incluir espaço para a data formatada
    char yearOfBirth[50];
    char eyeColour[50];
    char gender[50];
    char hairColour[50]; 
    int wizard; // bool
} Personagem;

void inicializarLista(Lista *lista) {
    lista->tamanho = 0;
}

void adicionarElemento(Lista *lista, const char *elemento) {
    if (lista->tamanho < MAX_ALTERNATIVE_NAMES) {
        strncpy(lista->elementos[lista->tamanho], elemento, MAX_NAME_LENGTH - 1);
        lista->elementos[lista->tamanho][MAX_NAME_LENGTH - 1] = '\0'; // Garante que a string seja terminada
        lista->tamanho++;
    }
}

void liberarLista(Lista *lista) {
    lista->tamanho = 0;
}

int split(char *str, char delim, char *tokens[]) {
    int count = 0;
    char *token = str;

    while (*str != '\0') {
        if (*str == delim) {
            *str = '\0';
            tokens[count++] = token;
            token = str + 1;
        }
        str++;
    }

    tokens[count++] = token;
    return count;
}

void formatarData(char *data) {
    int dia, mes, ano;
    sscanf(data, "%d-%d-%d", &dia, &mes, &ano);
    sprintf(data, "%02d-%02d-%d", dia, mes, ano);
}

void ler(Personagem *personagem, char *line) {
    char *tokens[MAX_TOKENS];
    int num_tokens = split(line, ';', tokens);

    strcpy(personagem->id, tokens[0]);
    strcpy(personagem->name, tokens[1]);

    inicializarLista(&(personagem->alternativeNames));
    int i = 0;
    char *alternativeNames_token = strtok(tokens[2], ",");
    while (alternativeNames_token != NULL && i < MAX_ALTERNATIVE_NAMES) {
        // Remover colchetes e todas as aspas simples
        int length = strlen(alternativeNames_token);
        for (int j = 0; j < length; j++) {
            if (alternativeNames_token[j] == '[' || alternativeNames_token[j] == ']') {
                memmove(&alternativeNames_token[j], &alternativeNames_token[j + 1], length - j);
                length--;
                j--;
            } else if (alternativeNames_token[j] == '\'') {
                memmove(&alternativeNames_token[j], &alternativeNames_token[j + 1], length - j);
                length--;
                j--;
            }
        }
        adicionarElemento(&(personagem->alternativeNames), alternativeNames_token);
        alternativeNames_token = strtok(NULL, ",");
        i++;
    }

    strcpy(personagem->house, tokens[3]);
    strcpy(personagem->ancestry, tokens[4]);
    strcpy(personagem->species, tokens[5]);
    strcpy(personagem->patronus, tokens[6]);
    personagem->hogwartsStaff = strcmp(tokens[7], "Sim") == 0;
    personagem->hogwartsStudent = strcmp(tokens[8], "Sim") == 0;
    strcpy(personagem->actorName, tokens[9]);

    inicializarLista(&(personagem->alternativeActors));
    i = 0;
    char *alternativeActors_token = strtok(tokens[10], ",");
    while (alternativeActors_token != NULL && i < MAX_ALTERNATIVE_ACTORS) {
        // Remover colchetes e todas as aspas simples
        int length = strlen(alternativeActors_token);
        for (int j = 0; j < length; j++) {
            if (alternativeActors_token[j] == '[' || alternativeActors_token[j] == ']') {
                memmove(&alternativeActors_token[j], &alternativeActors_token[j + 1], length - j);
                length--;
                j--;
            } else if (alternativeActors_token[j] == '\'') {
                memmove(&alternativeActors_token[j], &alternativeActors_token[j + 1], length - j);
                length--;
                j--;
            }
        }
        adicionarElemento(&(personagem->alternativeActors), alternativeActors_token);
        alternativeActors_token = strtok(NULL, ",");
        i++;
    }
    
    personagem->alive = strcmp(tokens[11], "Sim") == 0;
    strcpy(personagem->dateOfBirth, tokens[12]);
    formatarData(personagem->dateOfBirth); // Formatar a data de nascimento
    strcpy(personagem->yearOfBirth, tokens[13]);
    strcpy(personagem->eyeColour, tokens[14]);
    strcpy(personagem->gender, tokens[15]);
    strcpy(personagem->hairColour, tokens[16]);
    personagem->wizard = strcmp(tokens[17], "Sim") == 0;
}

void imprimir(Personagem *personagem) {
    printf("[%s ## %s ## {", personagem->id, personagem->name);
    for (int i = 0; i < personagem->alternativeNames.tamanho-1; i++) {
        printf("%s,", personagem->alternativeNames.elementos[i]);
    }
    printf("%s} ## ", personagem->alternativeNames.elementos[personagem->alternativeNames.tamanho-1]);
    printf("%s ## ", personagem->house);
    printf("%s ## ", personagem->ancestry);
    printf("%s ## ", personagem->species);
    printf("%s ## ", personagem->patronus);
    printf("false ## ");
    printf("false ## ");
    printf("%s ## ", personagem->actorName);
    printf("false ## ");
    printf("%s ## ", personagem->dateOfBirth);
    printf("%s ## ", personagem->yearOfBirth);
    printf("%s ## ", personagem->eyeColour);
    printf("%s ## ", personagem->gender);
    printf("%s ## ", personagem->hairColour);
    printf("false]\n");
}

int main() {
    FILE *file = fopen("characters.csv", "r");
    if (file == NULL) {
        printf("Não foi possível abrir o arquivo.\n");
        return 1;
    }

    char line[MAX_LINE_LENGTH];
    fgets(line, sizeof(line), file); // Ignorar cabeçalho

    Personagem personagens[MAX_PERSONAGENS];
    int num_personagens = 0;

    while (fgets(line, sizeof(line), file)) {
        ler(&personagens[num_personagens], line);
        num_personagens++;
        if (num_personagens >= MAX_PERSONAGENS) {
            printf("Número máximo de personagens atingido.\n");
            break;
        }
    }

    fclose(file);

    char idBusca[MAX_NAME_LENGTH];
    while (1) {
        scanf("%s", idBusca);
        if (strcmp(idBusca, "FIM") == 0)
            break;
        int encontrado = 0;
        for (int i = 0; i < num_personagens; i++) {
            if (strcmp(personagens[i].id, idBusca) == 0) {
                imprimir(&personagens[i]);
                encontrado = 1;
                break;
            }
        }
        if (!encontrado) {
            printf("Personagem não encontrado.\n");
        }
    }

    for (int i = 0; i < num_personagens; i++) {
        liberarLista(&(personagens[i].alternativeNames));
        liberarLista(&(personagens[i].alternativeActors));
    }

    return 0;
}
