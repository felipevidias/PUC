// -------------------------
// Guia_0807 - Unidade Lógica
// -------------------------

module LU (
    input [4:0] A,
    input [4:0] B,
    input chave,
    output igualdade,
    output desigualdade
);

    // Comparador para verificar igualdade
    assign igualdade = (A == B);

    // Lógica para calcular desigualdade
    assign desigualdade = chave ? ~igualdade : igualdade;

endmodule // LU

module test_LU;
    // ------------------------- definir dados
    reg [4:0] A, B;
    reg chave;
    wire igualdade, desigualdade;

    // ------------------------- instanciar unidade lógica
    LU UUT (.A(A), .B(B), .chave(chave), .igualdade(igualdade), .desigualdade(desigualdade));

    // ------------------------- parte principal
    initial begin
        $display("Guia_0807 - Unidade Lógica");
        $display("Teste da Unidade Lógica");

        // Testes
        // Teste 1: A igual a B
        A = 5'b10101;
        B = 5'b10101;
        chave = 1'b0; // Seleciona a igualdade como operação
        #10; // Espera 10 unidades de tempo
        $display("A igual a B (igualdade): %b, Desigualdade: %b", igualdade, desigualdade);

        // Teste 2: A diferente de B
        A = 5'b10101;
        B = 5'b01010;
        chave = 1'b1; // Seleciona a desigualdade como operação
        #10; // Espera 10 unidades de tempo
        $display("A diferente de B (desigualdade): %b, Igualdade: %b", desigualdade, igualdade);
    end
endmodule // test_LU
