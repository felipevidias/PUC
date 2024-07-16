module RAM_4x8 (
    input wire CLK,
    input wire R_W,
    input wire [2:0] ADDR,
    input wire [7:0] DATA_IN,
    output reg [7:0] DATA_OUT
);

wire [1:0] addr_1, addr_2;
wire [7:0] data_in_1, data_in_2;
wire [7:0] data_out_1, data_out_2;

// Divide o endereço e os dados de entrada em duas partes para as duas memórias RAM 2x8
assign addr_1 = ADDR[1:0];
assign addr_2 = ADDR[1:0];
assign data_in_1 = DATA_IN;
assign data_in_2 = DATA_IN;

// Instancia duas memórias RAM 2x8
RAM_2x8 ram_1 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_1),
    .DATA_IN(data_in_1),
    .DATA_OUT(data_out_1)
);

RAM_2x8 ram_2 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_2),
    .DATA_IN(data_in_2),
    .DATA_OUT(data_out_2)
);

// Seleciona a saída correta com base no bit de endereço mais significativo
always @* begin
    if (ADDR[2] == 1'b0) // Se o bit de endereço mais significativo for 0, seleciona a saída da primeira memória
        DATA_OUT = data_out_1;
    else // Senão, seleciona a saída da segunda memória
        DATA_OUT = data_out_2;
end

endmodule
