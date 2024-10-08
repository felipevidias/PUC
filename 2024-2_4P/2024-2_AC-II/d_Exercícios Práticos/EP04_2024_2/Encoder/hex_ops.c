#include <stdio.h>
#include <string.h>

const char *hex_operation(const char *W)
{
    if (strcmp(W, "umL") == 0)
        return "0";
    else if (strcmp(W, "AonB") == 0)
        return "1";
    else if (strcmp(W, "copiaA") == 0)
        return "2";
    else if (strcmp(W, "nAxnB") == 0)
        return "3";
    else if (strcmp(W, "AeBn") == 0)
        return "4";
    else if (strcmp(W, "nA") == 0)
        return "5";
    else if (strcmp(W, "AenB") == 0)
        return "6";
    else if (strcmp(W, "nAonB") == 0)
        return "7";
    else if (strcmp(W, "AxB") == 0)
        return "8";
    else if (strcmp(W, "zeroL") == 0)
        return "9";
    else if (strcmp(W, "copiaB") == 0)
        return "A";
    else if (strcmp(W, "AeB") == 0)
        return "B";
    else if (strcmp(W, "nB") == 0)
        return "C";
    else if (strcmp(W, "nAeBn") == 0)
        return "D";
    else if (strcmp(W, "AoB") == 0)
        return "E";
    else if (strcmp(W, "nAeB") == 0)
        return "F";
    else
        return "nao existe";
}

void process_file(const char *file_path)
{
    FILE *file = fopen(file_path, "r");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo.\n");
        return;
    }

    char line[256];
    char X[10] = {0};
    char Y[10] = {0};
    char W[10] = {0};

    while (fgets(line, sizeof(line), file))
    {
        line[strcspn(line, "\n")] = 0; // Remover a nova linha

        if (strncmp(line, "X=", 2) == 0)
        {
            strcpy(X, line + 2);
            X[strcspn(X, ";")] = 0; // Remover o ponto e vírgula
        }
        else if (strncmp(line, "Y=", 2) == 0)
        {
            strcpy(Y, line + 2);
            Y[strcspn(Y, ";")] = 0; // Remover o ponto e vírgula
        }
        else if (strncmp(line, "W=", 2) == 0)
        {
            strcpy(W, line + 2);
            W[strcspn(W, ";")] = 0; // Remover o ponto e vírgula

            if (X[0] != '\0' && Y[0] != '\0')
            {
                const char *resultado = hex_operation(W);
                printf("%s%s%s\n", X, Y, resultado);
            }
            else
            {
                printf("erro\n");
            }
        }
        else if (strcmp(line, "fim.") == 0)
        {
            break;
        }
    }

    fclose(file);
}

int main()
{
    const char *file_path = "instrucoes.txt";
    process_file(file_path);
    return 0;
}
