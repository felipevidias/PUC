#include "VNM.h"

VonNeumannMachine vnm;

void setup()
{
    Serial.begin(9600); // Inicia a comunicação serial a 9600 bps
}

void loop()
{
    int i = 0; // Contador de operações
    char c;

    while (true)
    {
        if (Serial.available() >= 3)
        {        // Verifica se há pelo menos 3 bytes disponíveis
            i++; // Incrementa o contador de operações

            // Lê os três caracteres e os armazena em strings
            String x((char)Serial.read());
            String y((char)Serial.read());
            String w((char)Serial.read());
            String str = x + y + w; // Combina X, Y e W em uma única string
            Serial.println(str);    // Imprime a operação recebida

            // Tenta registrar a operação
            if (!vnm.registerOperation(str.c_str()))
            {
                Serial.println("Erro ao registrar a operação. Memória cheia."); // Mensagem de erro
            }

            // Se já registrou 95 operações, execute-as
            if (i >= 95)
            {
                vnm.operate(); // Executa as operações registradas
                i = 0;         // Reinicia o contador após operar
            }
            delay(10);         // Espera um pequeno intervalo
            c = Serial.read(); // Lê o caractere extra entre expressões
        }
    }
}
