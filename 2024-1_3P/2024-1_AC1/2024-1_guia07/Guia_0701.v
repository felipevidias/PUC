module Guia_0701_Test;

reg a, b, select;
wire out1, out2;

Guia_0701 dut (
    .a(a),
    .b(b),
    .select(select),
    .out1(out1),
    .out2(out2)
);

initial begin
    // Teste com operação AND
    a = 1; b = 0; select = 0;
    #10;
    // Verificar se out1 é 0 e out2 é 0
    if (out1 !== 0 || out2 !== 0) $display("Teste falhou para operação AND");

    // Teste com operação NAND
    a = 1; b = 0; select = 1;
    #10;
    // Verificar se out1 é 1 e out2 é 1
    if (out1 !== 1 || out2 !== 1) $display("Teste falhou para operação NAND");

    // Teste com operação AND novamente
    a = 0; b = 1; select = 0;
    #10;
    // Verificar se out1 é 0 e out2 é 0
    if (out1 !== 0 || out2 !== 0) $display("Teste falhou para operação AND");

    // Teste com operação NAND novamente
    a = 0; b = 1; select = 1;
    #10;
    // Verificar se out1 é 1 e out2 é 1
    if (out1 !== 1 || out2 !== 1) $display("Teste falhou para operação NAND");

    // Teste com operação AND e seleção para NAND
    a = 1; b = 1; select = 1;
    #10;
    // Verificar se out1 é 0 e out2 é 0
    if (out1 !== 0 || out2 !== 0) $display("Teste falhou para operação AND com seleção para NAND");

    // Teste com operação NAND e seleção para AND
    a = 1; b = 1; select = 0;
    #10;
    // Verificar se out1 é 1 e out2 é 1
    if (out1 !== 1 || out2 !== 1) $display("Teste falhou para operação NAND com seleção para AND");

    // Mais testes podem ser adicionados conforme necessário

    // Finalizar a simulação
    $finish;
end

endmodule
