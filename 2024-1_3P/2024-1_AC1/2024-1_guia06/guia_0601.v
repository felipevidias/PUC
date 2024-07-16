module FuncionesLogicas (
    input wire x,
    input wire y,
    input wire z,
    output wire f_a,
    output wire f_b,
    output wire f_c,
    output wire f_d,
    output wire f_e
);

assign f_a = (~x & z) | (y & ~z);
assign f_b = x | (y & ~z);
assign f_c = y | (x & ~z);
assign f_d = (~y & z) | (x & ~z);
assign f_e = ~x | y;

endmodule
