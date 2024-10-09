#include "VNM.h"

// Construtor da máquina Von Neumann
VonNeumannMachine::VonNeumannMachine()
{
    this->memory = new char *[100]; // Inicializa a memória com 100 posições
    this->maxMemorySize = 100;
    this->currentMemorySize = 4; // Primeiras 4 posições reservadas para registradores
    for (int i = 0; i < 4; i++)
    {
        memory[i] = new char[9]; // Max 8 bits por posição de memória
        strcpy(memory[i], "00000000"); // Inicializa cada posição com 0
    }
}

// Construtor personalizado para um tamanho específico de memória
VonNeumannMachine::VonNeumannMachine(int len)
{
    this->memory = new char *[len];
    this->maxMemorySize = len;
    this->currentMemorySize = 4; // Primeiras 4 posições reservadas para registradores
    for (int i = 0; i < 4; i++)
    {
        memory[i] = new char[9];
        strcpy(memory[i], "00000000");
    }
}

// Destrutor para liberar a memória alocada dinamicamente
VonNeumannMachine::~VonNeumannMachine()
{
    for (int i = 0; i < maxMemorySize; i++)
    {
        delete[] memory[i];
    }
    delete[] memory;
}

// Portas lógicas usadas pelas operações
char VonNeumannMachine::andGate(char a, char b)
{
    return (a == '1' && b == '1') ? '1' : '0';
}

char VonNeumannMachine::orGate(char a, char b)
{
    return (a == '1' || b == '1') ? '1' : '0';
}

char VonNeumannMachine::notGate(char a)
{
    return (a == '1') ? '0' : '1';
}

char VonNeumannMachine::xorGate(char a, char b)
{
    return (a != b) ? '1' : '0';
}

// Implementação das operações op0 - opF
char VonNeumannMachine::op0(char a, char b) { return orGate(a, notGate(a)); }
char VonNeumannMachine::op1(char a, char b) { return orGate(a, notGate(b)); }
char VonNeumannMachine::op2(char a, char b) { return andGate(a, a); }
char VonNeumannMachine::op3(char a, char b) { return xorGate(notGate(a), notGate(b)); }
char VonNeumannMachine::op4(char a, char b) { return notGate(andGate(a, b)); }
char VonNeumannMachine::op5(char a, char b) { return notGate(a); }
char VonNeumannMachine::op6(char a, char b) { return andGate(a, notGate(b)); }
char VonNeumannMachine::op7(char a, char b) { return orGate(notGate(a), notGate(b)); }
char VonNeumannMachine::op8(char a, char b) { return xorGate(a, b); }
char VonNeumannMachine::op9(char a, char b) { return andGate(a, notGate(a)); }
char VonNeumannMachine::opA(char a, char b) { return andGate(b, b); }
char VonNeumannMachine::opB(char a, char b) { return orGate(a, a); }
char VonNeumannMachine::opC(char a, char b) { return xorGate(a, notGate(b)); }
char VonNeumannMachine::opD(char a, char b) { return notGate(a); }
char VonNeumannMachine::opE(char a, char b) { return xorGate(notGate(a), b); }
char VonNeumannMachine::opF(char a, char b) { return orGate(a, notGate(a)); }

// Converte de hexadecimal para binário
char *VonNeumannMachine::fromHexaToBinary(char value)
{
    switch (value)
    {
    case '0': return "0000";
    case '1': return "0001";
    case '2': return "0010";
    case '3': return "0011";
    case '4': return "0100";
    case '5': return "0101";
    case '6': return "0110";
    case '7': return "0111";
    case '8': return "1000";
    case '9': return "1001";
    case 'A': return "1010";
    case 'B': return "1011";
    case 'C': return "1100";
    case 'D': return "1101";
    case 'E': return "1110";
    case 'F': return "1111";
    default: return "0000";
    }
}

// Converte de binário para hexadecimal
char VonNeumannMachine::fromBinaryToHexa(const char *value)
{
    if (strcmp(value, "0000") == 0) return '0';
    if (strcmp(value, "0001") == 0) return '1';
    if (strcmp(value, "0010") == 0) return '2';
    if (strcmp(value, "0011") == 0) return '3';
    if (strcmp(value, "0100") == 0) return '4';
    if (strcmp(value, "0101") == 0) return '5';
    if (strcmp(value, "0110") == 0) return '6';
    if (strcmp(value, "0111") == 0) return '7';
    if (strcmp(value, "1000") == 0) return '8';
    if (strcmp(value, "1001") == 0) return '9';
    if (strcmp(value, "1010") == 0) return 'A';
    if (strcmp(value, "1011") == 0) return 'B';
    if (strcmp(value, "1100") == 0) return 'C';
    if (strcmp(value, "1101") == 0) return 'D';
    if (strcmp(value, "1110") == 0) return 'E';
    if (strcmp(value, "1111") == 0) return 'F';
    return '0';
}

// Registra uma operação na memória
bool VonNeumannMachine::registerOperation(const char *expression)
{
    if (currentMemorySize >= maxMemorySize)
    {
        return false;  // Memória cheia
    }
    memory[currentMemorySize++] = strdup(expression); // Copia a expressão para a memória
    return true;
}

// Executa as operações registradas na memória
void VonNeumannMachine::operate()
{
    Serial.println("Executando operações...");

    for (int i = 4; i < currentMemorySize; i++) // Percorre as operações, a partir do índice 4
    {
        char *operation = memory[i];
        char X_val = getX()[0];  // Valor de X
        char Y_val = getY()[0];  // Valor de Y

        char result;

        // Identifica a operação com base no terceiro caractere da string (operação)
        switch (operation[2])
        {
        case '0':
            result = op0(X_val, Y_val);
            break;
        case '1':
            result = op1(X_val, Y_val);
            break;
        case '2':
            result = op2(X_val, Y_val);
            break;
        // Repita para op3 - opF...
        default:
            result = '0';  // Operação inválida
        }

        // Armazena o resultado no registrador W
        setW(String(result));

        // Exibe o estado da memória após a operação
        printMemory();
    }
}

// Exibe o conteúdo da memória (Dump da memória)
void VonNeumannMachine::printMemory()
{
    for (int i = 0; i < currentMemorySize; i++)
    {
        if (i == 0) Serial.print("PC: ");
        else if (i == 1) Serial.print("W: ");
        else if (i == 2) Serial.print("X: ");
        else if (i == 3) Serial.print("Y: ");
        else Serial.print("Mem["); Serial.print(i); Serial.print("]: ");

        Serial.println(memory[i]);
    }
    Serial.println();
}
