// -------------------------
// Guia_0506.v - GATES
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------

module porta_NAND;

    // Sinais de entrada
    reg a, b;
    // Sinais de saída
    wire NAND_out;

    // Lógica do NAND
    assign NAND_out = ~(a & b); 


    // Inicialização do teste
    initial begin
        $display("NAND para função (a ^ b = a xor b): ");
        // Teste para a = 0, b = 0
        a = 1'b0;
        b = 1'b0;
        #10; 
        $display("a = %b & b = %b | NAND = %b", a, b, NAND_out);
        
        // Teste para a = 0, b = 1
        a = 1'b0;
        b = 1'b1;
        #10;
        $display("a = %b & b = %b | NAND = %b", a, b, NAND_out);
        
        // Teste para a = 1, b = 0
        a = 1'b1;
        b = 1'b0;
        #10;
        $display("a = %b & b = %b | NAND = %b", a, b, NAND_out);
        
        // Teste para a = 1, b = 1
        a = 1'b1;
        b = 1'b1;
        #10;
        $display("a = %b & b = %b | NAND = %b", a, b, NAND_out);
        
        // Encerra a simulação
        $finish;
    end
endmodule
