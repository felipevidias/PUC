module or_xor_outputs(
    output wire s,
    input wire [7:0] a,
    input wire [7:0] b
);

wire xor1_out, xor2_out;

xor_outputs u_xor_outputs(xor1_out, xor2_out, a, b);
or u_or(s, xor1_out, xor2_out);

endmodule
