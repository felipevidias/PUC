/*
Guia_030E.v
817294 - Felipe Vilhena Dias
*/

module Guia_0306 (
    input [7:0] value,
    output reg [7:0] ones_complement
);

initial begin
    ones_complement = ~value; // Complemento de 1
end

endmodule

module Guia_0307 (
    input [7:0] value,
    output reg [7:0] twos_complement
);

reg [7:0] ones_complement;

Guia_0306 ones_complement_calculator (
    .value(value),
    .ones_complement(ones_complement)
);

always @(*) begin
    twos_complement = ones_complement + 1; // Complemento de 2
end

endmodule

module Guia_0306_Test;

reg [7:0] value;
wire [7:0] ones_complement;

Guia_0306 uut (
    .value(value),
    .ones_complement(ones_complement)
);

initial begin
    value = 8'b10101010; // Valor de teste
    #10; // Aguarda alguns ciclos
    $display("Value: %b, Ones' complement: %b", value, ones_complement);
    $finish; // Encerra a simulação
end

endmodule

module Guia_0307_Test;

reg [7:0] value;
wire [7:0] twos_complement;

Guia_0307 uut (
    .value(value),
    .twos_complement(twos_complement)
);

initial begin
    value = 8'b10101010; // Valor de teste
    #10; // Aguarda alguns ciclos
    $display("Value: %b, Twos' complement: %b", value, twos_complement);
    $finish; // Encerra a simulação
end

endmodule
