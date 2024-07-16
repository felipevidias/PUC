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

assign f_a = (~y | ~z) & (~x | y | z);
assign f_b = (x | ~y | ~z) & (~x | y | w | z);
assign f_c = (x | ~y | z) & (~x | y | w | z);
assign f_d = (~y | ~z) & (x | w);
assign f_e = (x | y | ~z) & (~y | ~z) & (~x | w);

endmodule
