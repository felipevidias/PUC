module Guia_0703(
    input wire a,
    input wire b,
    input wire select_port,
    input wire select_group,
    output wire out
);

wire and_out, nand_out, or_out, nor_out;

assign and_out = a & b;
assign nand_out = ~(a & b);
assign or_out = a | b;
assign nor_out = ~(a | b);

assign out = select_group ? (select_port ? nand_out : nor_out) : (select_port ? and_out : or_out);

endmodule
