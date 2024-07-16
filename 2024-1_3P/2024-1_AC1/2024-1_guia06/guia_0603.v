module FuncoesLogicas (
    input wire x,
    input wire y,
    input wire w,
    input wire z,
    output wire f_a,
    output wire f_b,
    output wire f_c,
    output wire f_d,
    output wire f_e
);

assign f_a = (~x & ~w & z) | (~x & y & ~z) | (x & y & w) | (~y & ~w & z) | (x & ~y & ~z) | (~x & ~y & z);
assign f_b = (~w & z) | (~x & ~w) | (~y & ~w & z) | (~y & ~z) | (~x & y & ~z) | (~x & ~y & z) | (x & y & z) | (x & y & ~z);
assign f_c = (~w) | (~x & ~w & z) | (x & y) | (~y & ~w & z) | (~y & ~z) | (~x & ~z) | (x & y & z) | (x & ~y & ~z);
assign f_d = (~x & w & ~z) | (~x & ~z) | (~x & y & ~z) | (~y & ~w & z) | (~y & ~z) | (x & y & z) | (x & ~y & ~z);
assign f_e = (~w & z) | (~x & ~w) | (~y & ~w & z) | (~x & ~z) | (~x & y & ~z) | (~y & ~z) | (x & y & z) | (x & ~y & ~z);

endmodule
