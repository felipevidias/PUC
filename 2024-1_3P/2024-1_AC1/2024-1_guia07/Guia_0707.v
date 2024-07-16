module Guia_0707_Test;

reg [1:0] a, b;
reg select;
wire out;

Guia_0707 dut (
    .a(a),
    .b(b),
    .select(select),
    .out(out)
);

initial begin
    // Teste com a menor que b
    a = 2'b00; b = 2'b01; select = 0;
    #10;
    // Verificar se out é 1
    if (out !== 1) $display("Teste falhou para a menor que b");

    // Teste com a maior que b
    a = 2'b10; b = 2'b01; select = 1;
    #10;
    // Verificar se out é 1
    if (out !== 1) $display("Teste falhou para a maior que b");

    // Mais testes podem ser adicionados conforme necessário

    // Finalizar a simulação
    $finish;
end

endmodule
