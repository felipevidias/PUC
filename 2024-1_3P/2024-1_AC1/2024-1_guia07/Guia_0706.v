module Guia_0706(
    input wire [1:0] a,
    input wire [1:0] b,
    input wire select,
    output wire out
);

wire xor0, xor1, xnor0, xnor1;

assign xor0 = a[0] ^ b[0];
assign xor1 = a[1] ^ b[1];
assign xnor0 = ~(a[0] ^ b[0]);
assign xnor1 = ~(a[1] ^ b[1]);

assign out = select ? (xnor0 & xnor1) : (xor0 & xor1);

endmodule
