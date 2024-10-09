#ifndef VNM_H
#define VNM_H

#include <Arduino.h>

class VonNeumannMachine
{
private:
    String *memory; // Memória da máquina
    int maxMemorySize;
    int currentMemorySize;

    // Endereços reservados para os registradores
    const int PC = 0; // Program Counter
    const int W = 1;  // Registrador de resultado
    const int X = 2;  // Registrador X
    const int Y = 3;  // Registrador Y

    // Portas lógicas básicas
    char andGate(char a, char b);
    char orGate(char a, char b);
    char notGate(char a);
    char xorGate(char a, char b);

    // Operações ULA (op0-opF)
    char op0(char a, char b);
    char op1(char a, char b);
    char op2(char a, char b);
    char op3(char a, char b);
    char op4(char a, char b);
    char op5(char a, char b);
    char op6(char a, char b);
    char op7(char a, char b);
    char op8(char a, char b);
    char op9(char a, char b);
    char opA(char a, char b);
    char opB(char a, char b);
    char opC(char a, char b);
    char opD(char a, char b);
    char opE(char a, char b);
    char opF(char a, char b);

    // Conversão entre binário e hexadecimal
    String fromHexaToBinary(char value);
    char fromBinaryToHexa(String value);

public:
    // Construtor e destrutor
    VonNeumannMachine();
    VonNeumannMachine(int len);
    ~VonNeumannMachine(); // Destrutor para desalocar memória

    // Função para registrar uma operação na memória
    bool registerOperation(String expression);

    // Função para operar sobre a memória
    void operate();

    // Funções para acessar e modificar os registradores PC, X, Y e W
    String getPC();
    void setPC(String newPC);

    String getX();
    void setX(String newX);

    String getY();
    void setY(String newY);

    String getW();
    void setW(String newW);

    // Função para imprimir o estado da memória (Dump da memória)
    void printMemory();
};

#endif
