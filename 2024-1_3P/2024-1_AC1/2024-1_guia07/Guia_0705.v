module Guia_0705(
    input wire a,
    input wire b,
    input wire neg_b,
    input wire [2:0] select,
    output wire out
);

wire and_out, nand_out, or_out, nor_out, xor_out, xnor_out, not_b;

assign and_out = a & b;
assign nand_out = ~(a & b);
assign or_out = a | b;
assign nor_out = ~(a | b);
assign xor_out = a ^ b;
assign xnor_out = ~(a ^ b);
assign not_b = neg_b ? ~b : b;

assign out = (select == 3'b000) ? and_out :
            (select == 3'b001) ? nand_out :
            (select == 3'b010) ? or_out :
            (select == 3'b011) ? nor_out :
            (select == 3'b100) ? xor_out :
            (select == 3'b101) ? xnor_out :
            (select == 3'b110) ? not_b :
            1'bx; // Caso de seleção inválido

endmodule
