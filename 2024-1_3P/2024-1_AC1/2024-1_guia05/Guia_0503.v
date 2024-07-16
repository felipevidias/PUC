// -------------------------
// Guia_0503.v - NOR
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------

module porta_NOR;

    // Sinais de entrada
    reg a, b;
    // Sinal de saída
    wire NOR_out;

    // Lógica do NOR
    assign NOR_out = ~(a || b); // Implementando a função (~a || b) usando NOR

    // Inicialização do teste
    initial begin
        $display("NOR para função (~a || b): ");
        // Teste para a = 0, b = 0
        a = ~1'b0;
        b = 1'b0;
        #10; 
        $display("a = %b e b = %b | NOR = %b", a, b, NOR_out);
        
        // Teste para a = 0, b = 1
        a = ~1'b0;
        b = 1'b1;
        #10;
        $display("a = %b e b = %b | NOR = %b", a, b, NOR_out);
        
        // Teste para a = 1, b = 0
        a = ~1'b1;
        b = 1'b0;
        #10;
        $display("a = %b e b = %b | NOR = %b", a, b, NOR_out);
        
        // Teste para a = 1, b = 1
        a = ~1'b1;
        b = 1'b1;
        #10;
        $display("a = %b e b = %b | NOR = %b", a, b, NOR_out);
        
        // Encerra a simulação
        $finish;
    end
endmodule
