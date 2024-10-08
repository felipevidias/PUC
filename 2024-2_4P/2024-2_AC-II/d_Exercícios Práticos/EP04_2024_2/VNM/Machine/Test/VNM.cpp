
#include "VNM.h"

VonNeumannMachine::VonNeumannMachine()
{
    this->memory = new char *[100];
    this->maxMemorySize = 100;
    this->currentMemorySize = 4; // Primeiras 4 posições reservadas
    for (int i = 0; i < 4; i++)
    {
        memory[i] = new char[9]; // Max 8 bits per memory entry
        strcpy(memory[i], "00000000");
    }
}

VonNeumannMachine::VonNeumannMachine(int len)
{
    this->memory = new char *[len];
    this->maxMemorySize = len;
    this->currentMemorySize = 4; // Primeiras 4 posições reservadas
    for (int i = 0; i < 4; i++)
    {
        memory[i] = new char[9]; // Max 8 bits per memory entry
        strcpy(memory[i], "00000000");
    }
}

// Destrutor para liberar memória alocada dinamicamente
VonNeumannMachine::~VonNeumannMachine()
{
    for (int i = 0; i < maxMemorySize; i++)
    {
        delete[] memory[i];
    }
    delete[] memory;
}

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

char *VonNeumannMachine::fromHexaToBinary(char value)
{
    switch (value)
    {
    case '0':
        return "0000";
    case '1':
        return "0001";
    case '2':
        return "0010";
    case '3':
        return "0011";
    case '4':
        return "0100";
    case '5':
        return "0101";
    case '6':
        return "0110";
    case '7':
        return "0111";
    case '8':
        return "1000";
    case '9':
        return "1001";
    case 'A':
        return "1010";
    case 'B':
        return "1011";
    case 'C':
        return "1100";
    case 'D':
        return "1101";
    case 'E':
        return "1110";
    case 'F':
        return "1111";
    default:
        return "0000";
    }
}

char VonNeumannMachine::fromBinaryToHexa(const char *value)
{
    if (strcmp(value, "0000") == 0)
        return '0';
    if (strcmp(value, "0001") == 0)
        return '1';
    if (strcmp(value, "0010") == 0)
        return '2';
    if (strcmp(value, "0011") == 0)
        return '3';
    if (strcmp(value, "0100") == 0)
        return '4';
    if (strcmp(value, "0101") == 0)
        return '5';
    if (strcmp(value, "0110") == 0)
        return '6';
    if (strcmp(value, "0111") == 0)
        return '7';
    if (strcmp(value, "1000") == 0)
        return '8';
    if (strcmp(value, "1001") == 0)
        return '9';
    if (strcmp(value, "1010") == 0)
        return 'A';
    if (strcmp(value, "1011") == 0)
        return 'B';
    if (strcmp(value, "1100") == 0)
        return 'C';
    if (strcmp(value, "1101") == 0)
        return 'D';
    if (strcmp(value, "1110") == 0)
        return 'E';
    if (strcmp(value, "1111") == 0)
        return 'F';
    return '0';
}

bool VonNeumannMachine::registerOperation(const char *expression)
{
    if (currentMemorySize >= maxMemorySize)
    {
        return false;
    }
    memory[currentMemorySize++] = strdup(expression);
    return true;
}

void VonNeumannMachine::operate()
{
    // Simulação das operações
    Serial.println("Executando operações...");
}

void VonNeumannMachine::printMemory()
{
    for (int i = 0; i < currentMemorySize; i++)
    {
        Serial.print(i);
        Serial.print(": ");
        Serial.println(memory[i]);
    }
    Serial.println();
}
