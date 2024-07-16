module Guia_0704(
    input wire a,
    input wire b,
    input wire [1:0] select,
    output wire out
);

wire xor_out, xnor_out, or_out, nor_out;

assign xor_out = a ^ b;
assign xnor_out = ~(a ^ b);
assign or_out = a | b;
assign nor_out = ~(a | b);

assign out = (select == 2'b00) ? or_out :
            (select == 2'b01) ? nor_out :
            (select == 2'b10) ? xor_out :
            (select == 2'b11) ? xnor_out :
            1'bx; // Caso de seleção inválido

endmodule
