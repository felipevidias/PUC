module Guia_0702(
    input wire a,
    input wire b,
    input wire select,
    output wire out
);

wire or_out;
wire nor_out;

assign or_out = a | b;
assign nor_out = ~(a | b);

assign out = select ? nor_out : or_out;

endmodule
