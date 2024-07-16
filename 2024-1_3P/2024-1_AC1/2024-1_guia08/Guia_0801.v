// -------------------------
// Guia_0801 - Somador 5bits
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------
// -------------------------
// half adder
// -------------------------
module halfAdder (
    output s,
    output co,
    input a,
    input b
);
    // descrever por portas
    xor XOR1 (s, a, b);
    and AND1 (co, a, b);
endmodule // halfAdder

// -------------------------
// full adder
// -------------------------
module fullAdder (
    output s,
    output co,
    input a,
    input b,
    input ci
);
    // descrever por portas e/ou modulos
    wire s1, c1, c2;
    halfAdder HA1(s, c1, a, b);
    halfAdder HA2(s1, c2, s, ci);
    or OR1(co, c1, c2);
endmodule // fullAdder

module test_fullAdder;
    // ------------------------- definir dados
    reg [4:0] x;
    reg [4:0] y;
    wire [4:0] carry; // “vai-um”
    wire [5:0] soma;
    // Five full adders
    fullAdder FA0 (soma[0], carry[0], x[0], y[0], 1'b0);
    fullAdder FA1 (soma[1], carry[1], x[1], y[1], carry[0]);
    fullAdder FA2 (soma[2], carry[2], x[2], y[2], carry[1]);
    fullAdder FA3 (soma[3], carry[3], x[3], y[3], carry[2]);
    fullAdder FA4 (soma[4], carry[4], x[4], y[4], carry[3]);
    // ------------------------- parte principal
    initial begin
        $display("Guia_0801 - Felipe Vilhena Dias - 817294");
        $display("Test ALU’s full adder");
        // Testes do somador completo

        // Teste 1: x = 11 (3 em decimal), y = 7 (7 em decimal)
        x = 5'b10101;
        y = 5'b01110;
        #10; // Espera 10 unidades de tempo
        $display("Soma para x=21 e y=14: %b", soma);

        // Teste 2: x = 10 (2 em decimal), y = 5 (5 em decimal)
        x = 5'b11111;
        y = 5'b00001;
        #10; // Espera 10 unidades de tempo
        $display("Soma para x=31 e y=1: %b", soma);

        // Teste 3: x = 15 (15 em decimal), y = 9 (9 em decimal)
        x = 5'b00000;
        y = 5'b11111;
        #10; // Espera 10 unidades de tempo
        $display("Soma para x=0 e y=31: %b", soma);
    end
endmodule // test_fullAdder
