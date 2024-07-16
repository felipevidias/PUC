// -------------------------
// Guia_0805 - Complemento de dois
// Nome: Felipe Vilhena Dias
// Matricula: 817294
// -------------------------
module twos_complement (
    input [4:0] input_num,
    output reg [4:0] twos_comp
);

    reg [4:0] ones_comp;

    // Complemento de um
    always @* begin
        ones_comp = ~input_num;
    end

    // Adicionar 1 ao complemento de um
    always @* begin
        if (ones_comp == 5'b11111) // Se for -1 (todos os bits 1)
            twos_comp = 5'b00000;
        else
            twos_comp = ones_comp + 1;
    end

endmodule // twos_complement

module test_twos_complement;
    // ------------------------- definir dados
    reg [4:0] num;
    wire [4:0] complement;

    // ------------------------- instanciar complemento de dois
    twos_complement TWOS_COMP (.input_num(num), .twos_comp(complement));

    // ------------------------- parte principal
    initial begin
        $display("Guia_0805 - Felipe Vilhena Dias - 817294");
        $display("Teste do complemento de dois");

        // Testes do complemento de dois
        // Teste 1: num = 5 (5 em decimal)
        num = 5'b00101;
        #10; // Espera 10 unidades de tempo
        $display("Complemento de dois para num=5: %b", complement);

        // Teste 2: num = -3 (11101 em complemento de dois)
        num = 5'b11101;
        #10; // Espera 10 unidades de tempo
        $display("Complemento de dois para num=-3: %b", complement);

        // Teste 3: num = 0 (0 em decimal)
        num = 5'b00000;
        #10; // Espera 10 unidades de tempo
        $display("Complemento de dois para num=0: %b", complement);
    end
endmodule // test_twos_complement
