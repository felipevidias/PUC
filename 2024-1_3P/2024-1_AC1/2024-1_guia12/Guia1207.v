module RAM_8x16 (
    input wire CLK,
    input wire R_W,
    input wire [3:0] ADDR,
    input wire [15:0] DATA_IN,
    output reg [15:0] DATA_OUT
);

wire [2:0] addr_low, addr_high;
wire [15:0] data_in_low, data_in_high;
wire [15:0] data_out_low, data_out_high;

// Divide o endereço e os dados de entrada em duas partes para as memórias RAM 1x16
assign addr_low = ADDR[2:0];
assign addr_high = ADDR[2:0];
assign data_in_low = DATA_IN;
assign data_in_high = DATA_IN;

// Instancia oito memórias RAM 1x16
RAM_1x16 ram0 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_low),
    .DATA_IN(data_in_low),
    .DATA_OUT(data_out_low)
);

RAM_1x16 ram1 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b001),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram2 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b010),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram3 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b011),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram4 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b100),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram5 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b101),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram6 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b110),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

RAM_1x16 ram7 (
    .CLK(CLK),
    .R_W(R_W),
    .ADDR(addr_high + 3'b111),
    .DATA_IN(data_in_high),
    .DATA_OUT(data_out_high)
);

// Seleciona a saída correta com base no bit de endereço mais significativo
always @* begin
    case (ADDR[3])
        4'b0000: DATA_OUT = data_out_low;
        4'b0001: DATA_OUT = data_out_high;
        4'b0010: DATA_OUT = data_out_high;
        4'b0011: DATA_OUT = data_out_high;
        4'b0100: DATA_OUT = data_out_high;
        4'b0101: DATA_OUT = data_out_high;
        4'b0110: DATA_OUT = data_out_high;
        4'b0111: DATA_OUT = data_out_high;
        default: DATA_OUT = 16'b0; // Caso o endereço seja inválido
    endcase
end

endmodule
