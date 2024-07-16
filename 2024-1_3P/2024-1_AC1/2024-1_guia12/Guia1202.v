module RAM_1x8 (
    input wire CLK,
    input wire R_W,
    input wire [0:0] ADDR,
    input wire [7:0] DATA_IN,
    output wire [7:0] DATA_OUT
);

wire [3:0] addr_1, addr_2;
wire [3:0] data_in_1, data_in_2;
wire [3:0] data_out_1, data_out_2;

// Divide o endereço e os dados de entrada em duas partes para as duas memórias RAM 1x4
assign addr_1 = ADDR[3:0];
assign addr_2 = ADDR[3:0];
assign data_in_1 = DATA_IN[3:0];
assign data_in_2 = DATA_IN[7:4];

// Instancia duas memórias RAM 1x4
RAM_1x4 ram_1 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_1),
    .DATA_IN(data_in_1),
    .DATA_OUT(data_out_1)
);

RAM_1x4 ram_2 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_2),
    .DATA_IN(data_in_2),
    .DATA_OUT(data_out_2)
);

// Combina as saídas das duas memórias RAM 1x4 para formar a saída da memória RAM 1x8
assign DATA_OUT = {data_out_2, data_out_1};

endmodule
