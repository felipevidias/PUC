
#include "VNM.h"

VonNeumannMachine vnm;

void setup()
{
    Serial.begin(9600);
}

void loop()
{
    static int i = 0;

    if (Serial.available() >= 3)
    {
        char x = Serial.read();
        char y = Serial.read();
        char w = Serial.read();

        char str[4] = {x, y, w, '\00'};
        Serial.println(str);

        if (vnm.registerOperation(str))
        {
            Serial.println("Operação registrada");
        }
        else
        {
            Serial.println("Memória cheia");
        }

        if (++i >= 95)
        {
            vnm.operate();
            i = 0; // Reinicia o contador após operar
        }

        delay(10);
    }
}
