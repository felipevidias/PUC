module Guia_0907 (
    input clk,
    input pulse_source,
    output reg pulse
);

reg pulse_ff; // Flip-flop para sincronização

always @(posedge clk) begin
    pulse_ff <= pulse_source; // Sincronização do flip-flop com o sinal do gerador

    // Geração do pulso
    if (pulse_ff == 1'b1)
        pulse <= 1'b1;
    else
        pulse <= 1'b0;
end

endmodule
