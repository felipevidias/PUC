// -------------------------
// Guia_0802 - Subtrator 5bits
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------
// -------------------------
// half subtractor
// -------------------------
module halfSubtractor (
    output d,
    output bo,
    input a,
    input b
);
    // descrever por portas
    xor XOR1 (d, a, b);
    and AND1 (bo, a, ~b);
endmodule // halfSubtractor

// -------------------------
// full subtractor
// -------------------------
module fullSubtractor (
    output d,
    output bo,
    input a,
    input b,
    input bi
);
    // descrever por portas e/ou módulos
    wire d1, b1, b2;
    halfSubtractor HS1(d, b1, a, b);
    halfSubtractor HS2(d1, b2, d, bi);
    or OR1(bo, b1, b2);
endmodule // fullSubtractor

module test_fullSubtractor;
    // ------------------------- definir dados
    reg [4:0] x;
    reg [4:0] y;
    wire [4:0] borrow; // “emprestado"
    wire [5:0] diff;
    // Five full subtractors
    fullSubtractor FS0 (diff[0], borrow[0], x[0], y[0], 1'b0);
    fullSubtractor FS1 (diff[1], borrow[1], x[1], y[1], borrow[0]);
    fullSubtractor FS2 (diff[2], borrow[2], x[2], y[2], borrow[1]);
    fullSubtractor FS3 (diff[3], borrow[3], x[3], y[3], borrow[2]);
    fullSubtractor FS4 (diff[4], borrow[4], x[4], y[4], borrow[3]);
    // ------------------------- parte principal
    initial begin
        $display("Guia_0802 - Felipe Vilhena Dias - 817294");
        $display("Test ALU’s full subtractor");
        // Testes do subtrator completo

        // Teste 1: x = 11 (3 em decimal), y = 7 (7 em decimal)
        x = 5'b0011;
        y = 5'b0111;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=3 e y=7: %b", diff);

        // Teste 2: x = 10 (2 em decimal), y = 5 (5 em decimal)
        x = 5'b0010;
        y = 5'b0101;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=2 e y=5: %b", diff);

        // Teste 3: x = 15 (15 em decimal), y = 9 (9 em decimal)
        x = 5'b1111;
        y = 5'b1001;
        #10; // Espera 10 unidades de tempo
        $display("Diferença para x=15 e y=9: %b", diff);
    end
endmodule // test_fullSubtractor
