module RAM_1x4 (
    input wire CLK,
    input wire R_W,
    input wire [1:0] ADDR,
    input wire [3:0] DATA_IN,
    output wire [3:0] DATA_OUT
);

reg [3:0] memory [0:1]; // Declaração da memória RAM

always @(posedge CLK) begin
    if (R_W) // Se R_W for 1, escreve na memória
        memory[ADDR] <= DATA_IN;
    else // Senão, lê da memória
        DATA_OUT <= memory[ADDR];
end

endmodule
