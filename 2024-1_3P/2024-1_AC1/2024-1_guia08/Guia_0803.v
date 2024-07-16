// -------------------------
// Guia_0803 - Comparador de termos
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------
module comparator (
    input [4:0] a,
    input [4:0] b,
    output equal
);
    // Comparação bit a bit
    assign equal = (a == b);
endmodule // comparator

module test_comparator;
    // ------------------------- definir dados
    reg [4:0] x;
    reg [4:0] y;
    wire equal_terms;

    // ------------------------- instanciar comparador
    comparator COMPARE (x, y, equal_terms);

    // ------------------------- parte principal
    initial begin
        $display("Guia_0801 - Felipe Vilhena Dias - 817294");
        $display("Teste do comparador de termos");

        // Testes do comparador
        // Teste 1: x = y = 5 (5 em decimal)
        x = 5'b01010;
        y = 5'b01010;
        #10; // Espera 10 unidades de tempo
        $display("Igualdade para x=5 e y=5: %b", equal_terms);

        // Teste 2: x = 10 (2 em decimal), y = 5 (5 em decimal)
        x = 5'b01010;
        y = 5'b00101;
        #10; // Espera 10 unidades de tempo
        $display("Igualdade para x=5 e y=10: %b", equal_terms);

        // Teste 3: x = 15 (15 em decimal), y = 9 (9 em decimal)
        x = 5'b01111;
        y = 5'b01001;
        #10; // Espera 10 unidades de tempo
        $display("Igualdade para x=15 e y=9: %b", equal_terms);
    end
endmodule // test_comparator
