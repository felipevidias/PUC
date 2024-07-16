module RAM_4x16 (
    input wire CLK,
    input wire R_W,
    input wire [2:0] ADDR,
    input wire [15:0] DATA_IN,
    output reg [15:0] DATA_OUT
);

wire [1:0] addr_low, addr_high;
wire [7:0] data_in_low, data_in_high;
wire [7:0] data_out_low, data_out_high;

// Divide o endereço e os dados de entrada em duas partes para a memória RAM 4x8
assign addr_low = ADDR[1:0];
assign addr_high = ADDR[1:0];
assign data_in_low = DATA_IN[7:0];
assign data_in_high = DATA_IN[15:8];

// Instancia uma memória RAM 4x8
RAM_4x8 ram (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_low),
    .DATA_IN(data_in_low),
    .DATA_OUT(data_out_low)
);

// Instancia uma memória RAM 4x8 (com offset para os endereços altos)
RAM_4x8 ram_offset (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 2'b10), // Offset dos endereços altos
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

// Concatena as saídas das duas memórias RAM 4x8 para formar a saída da memória RAM 4x16
always @* begin
    DATA_OUT = {data_out_high, data_out_low};
end

endmodule
