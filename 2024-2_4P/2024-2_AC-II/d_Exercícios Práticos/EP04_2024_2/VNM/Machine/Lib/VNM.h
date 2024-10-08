#ifndef VNM_H
#define VNM_H

#include <Arduino.h>

class VonNeumannMachine
{
private:
    String *memory;
    int maxMemorySize;
    int currentMemorySize;

    // Endereços reservados
    const int PC = 0;
    const int W = 1;
    const int X = 2;
    const int Y = 3;

    char andGate(char a, char b);
    char orGate(char a, char b);
    char notGate(char a);
    char xorGate(char a, char b);

    // Operações op0-opF
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

    String fromHexaToBinary(char value);
    char fromBinaryToHexa(String value);

public:
    VonNeumannMachine();
    VonNeumannMachine(int len);
    ~VonNeumannMachine(); // Destrutor para desalocar memória

    bool registerOperation(String expression);
    void operate();

    String getPC();
    void setPC(String newPC);

    String getX();
    void setX(String newX);

    String getY();
    void setY(String newY);

    String getW();
    void setW(String newW);

    void printMemory();
};

#endif
