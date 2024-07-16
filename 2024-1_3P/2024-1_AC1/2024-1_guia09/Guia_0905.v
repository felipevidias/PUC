module Guia_0905 (
    input clk,
    output reg pulse
);

reg pulse_ff; // Flip-flop para sincronização
reg [1:0] state; // Estado para controlar a duração do pulso

parameter PULSE_DURATION = 2; // Duração do pulso em unidades de tempo

always @(posedge clk) begin
    // Sincronização do flip-flop com a borda de subida do clock
    pulse_ff <= 1'b0;

    // Controla a duração do pulso
    case(state)
        2'b00: begin
            pulse <= 1'b0;
            if (pulse_ff == 1'b1)
                state <= state + 1;
        end
        2'b01: begin
            pulse <= 1'b1;
            if (pulse_ff == 1'b0)
                state <= state + 1;
        end
        default: state <= 2'b00; // Reseta o estado
    endcase
end

always @(posedge clk) begin
    // Sincronização do flip-flop com a borda de subida do clock
    pulse_ff <= ~pulse_ff;
end

endmodule
