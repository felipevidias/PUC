module logic_expression(
    output wire f_SoP,
    output wire F_PoS,
    input wire [3:0] input_vector
);

// Expressão canônica para SoP
assign f_SoP = input_vector[0] | input_vector[1] | input_vector[2] | input_vector[3] |
               (input_vector[0] & ~input_vector[1] & input_vector[2] & ~input_vector[3]) |
               (input_vector[0] & ~input_vector[1] & ~input_vector[2] & input_vector[3]) |
               (~input_vector[0] & input_vector[1] & input_vector[2] & ~input_vector[3]) |
               (~input_vector[0] & input_vector[1] & input_vector[2] & input_vector[3]);

// Expressão canônica para PoS
assign F_PoS = (input_vector[0] | input_vector[1] | input_vector[2] | input_vector[3]) &
               (input_vector[0] | input_vector[1] | ~input_vector[2] | ~input_vector[3]) &
               (~input_vector[0] | input_vector[1] | ~input_vector[2] | input_vector[3]) &
               (~input_vector[0] | input_vector[1] | input_vector[2] | input_vector[3]);

// Simplificação de mintermos por mapa de Veitch-Karnaugh
// Expressões simplificadas para SoP
assign f_SoP_simplified = input_vector[0] | input_vector[1] | input_vector[2] | input_vector[3] |
                          (input_vector[0] & input_vector[1]) | (input_vector[0] & input_vector[2]) |
                          (input_vector[1] & input_vector[3]) | (input_vector[2] & input_vector[3]);

// Expressões simplificadas para PoS
assign F_PoS_simplified = (input_vector[0] & input_vector[1]) | (input_vector[0] & input_vector[3]) |
                          (input_vector[1] & ~input_vector[2]) | (input_vector[1] & input_vector[2] & input_vector[3]);

// Expressões equivalentes com portas NAND (dupla negação)
assign f_SoP_nand = ~(~input_vector[0] & ~input_vector[1] & ~input_vector[2] & ~input_vector[3]);
assign F_PoS_nand = ~(~input_vector[0] | ~input_vector[1] | ~input_vector[2] | ~input_vector[3]);

// Expressões equivalentes com portas NOR (dupla negação)
assign f_SoP_nor = ~(input_vector[0] | input_vector[1] | input_vector[2] | input_vector[3]);
assign F_PoS_nor = ~(input_vector[0] & input_vector[1] & input_vector[2] & input_vector[3]);

endmodule
