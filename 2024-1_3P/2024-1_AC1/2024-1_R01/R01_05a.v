module xor_outputs(
    output wire s1,
    output wire s2,
    input wire [7:0] a,
    input wire [7:0] b
);

xor u_xor1(s1, a[0] ^ b[0]);
xor u_xor2(s2, (~a[0]) ^ (~b[0]));

endmodule
