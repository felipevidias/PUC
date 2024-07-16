// -------------------------
// Guia_0804 - Comparador de termos diferentes
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------
module comparator_different (
    input [4:0] a,
    input [4:0] b,
    output different
);
    // Comparação bit a bit
    assign different = (a != b);
endmodule // comparator_different

module test_comparator_different;
    // ------------------------- definir dados
    reg [4:0] x;
    reg [4:0] y;
    wire different_terms;

    // ------------------------- instanciar comparador de termos diferentes
    comparator_different COMPARE_DIFFERENT (x, y, different_terms);

    // ------------------------- parte principal
    initial begin
        $display("Guia_0801 - Felipe Vilhena Dias - 817294");
        $display("Teste do comparador de termos diferentes");

        // Testes do comparador de termos diferentes
        // Teste 1: x = y = 5 (5 em decimal)
        x = 5'b01010;
        y = 5'b01010;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=5 e y=5: %b", different_terms);

        // Teste 2: x = 10 (2 em decimal), y = 5 (5 em decimal)
        x = 5'b01010;
        y = 5'b00101;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=5 e y=10: %b", different_terms);

        // Teste 3: x = 15 (15 em decimal), y = 9 (9 em decimal)
        x = 5'b01111;
        y = 5'b01001;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=15 e y=9: %b", different_terms);
    end
endmodule // test_comparator_different
