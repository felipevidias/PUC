// -------------------------
// Guia_0806 - Unidade Aritmética
// Nome: [Seu Nome]
// Matrícula: [Sua Matrícula]
// -------------------------

module fullAdder (
    output s,
    output co,
    input a,
    input b,
    input ci
);
    // descrever por portas e/ou módulos
    xor XOR1 (s, a, b);
    xor XOR2 (s, s, ci);
    and AND1 (co, a, b);
    and AND2 (co, ci, XOR1);
endmodule // fullAdder

module AU (
    input [4:0] A,
    input [4:0] B,
    input chave,
    output [4:0] resultado,
    output igual,
    output diferente
);

    // Somador completo com uma entrada invertida para subtração
    wire [4:0] soma, diferenca;
    wire carryOut;
    
    assign igual = (A == B);
    assign diferente = ~igual;

    // Subcircuito para calcular o complemento de 1
    wire [4:0] complemento;
    assign complemento = chave ? B : ~B;

    // Seleção da operação (soma ou subtração)
    assign carryOut = chave;
    assign resultado = chave ? diferenca : soma;

    // Somador completo
    fullAdder FA0 (soma[0], carryOut, A[0], complemento[0], chave);
    fullAdder FA1 (soma[1], FA0.co, A[1], complemento[1], chave);
    fullAdder FA2 (soma[2], FA1.co, A[2], complemento[2], chave);
    fullAdder FA3 (soma[3], FA2.co, A[3], complemento[3], chave);
    fullAdder FA4 (soma[4], FA3.co, A[4], complemento[4], chave);

    // Subtrator é o inverso do somador
    assign diferenca = soma;

endmodule // AU

module test_AU;
    // ------------------------- definir dados
    reg [4:0] A, B;
    reg chave;
    wire [4:0] resultado;
    wire igual, diferente;

    // ------------------------- instanciar unidade aritmética
    AU UUT (.A(A), .B(B), .chave(chave), .resultado(resultado), .igual(igual), .diferente(diferente));

    // ------------------------- parte principal
    initial begin
        $display("Guia_0806 - Unidade Aritmética");
        $display("Teste da Unidade Aritmética");

        // Testes
        // Teste 1: Soma de números diferentes
        A = 5'b10101;
        B = 5'b01110;
        chave = 1'b0; // Seleciona a soma como operação
        #10; // Espera 10 unidades de tempo
        $display("Resultado para A=21, B=14, chave=0 (soma): %b", resultado);
        $display("Igual: %b, Diferente: %b", igual, diferente);

        // Teste 2: Subtração de números iguais
        A = 5'b01111;
        B = 5'b01111;
        chave = 1'b1; // Seleciona a subtração como operação
        #10; // Espera 10 unidades de tempo
        $display("Resultado para A=15, B=15, chave=1 (subtração): %b", resultado);
        $display("Igual: %b, Diferente: %b", igual, diferente);
    end
endmodule // test_AU
