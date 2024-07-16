module Guia_1105 (
    output reg y,
    input x,
    input clk,
    input reset
);

// State identifiers
parameter INIT = 3'b000;
parameter S0 = 3'b001;
parameter S01 = 3'b011;
parameter S010 = 3'b101;
parameter S1 = 3'b100;
parameter S10 = 3'b110;
parameter S101 = 3'b010;

// State variables
reg [2:0] state;

// Next state logic and output logic
always @(posedge clk or negedge reset) begin
    if (reset) begin
        state <= INIT;
        y <= 0;
    end
    else begin
        case(state)
            INIT: begin
                if (x) begin
                    state <= S1;
                    y <= 0;
                end
                else begin
                    state <= S0;
                    y <= 0;
                end
            end
            S0: begin
                if (x) begin
                    state <= S01;
                    y <= 0;
                end
                else begin
                    state <= S0;
                    y <= 0;
                end
            end
            S01: begin
                if (x) begin
                    state <= S010;
                    y <= 1;
                end
                else begin
                    state <= S0;
                    y <= 0;
                end
            end
            S010: begin
                if (x) begin
                    state <= S1;
                    y <= 0;
                end
                else begin
                    state <= S0;
                    y <= 0;
                end
            end
            S1: begin
                if (x) begin
                    state <= S10;
                    y <= 0;
                end
                else begin
                    state <= S1;
                    y <= 0;
                end
            end
            S10: begin
                if (x) begin
                    state <= S101;
                    y <= 1;
                end
                else begin
                    state <= S1;
                    y <= 0;
                end
            end
            S101: begin
                if (x) begin
                    state <= S1;
                    y <= 0;
                end
                else begin
                    state <= S0;
                    y <= 0;
                end
            end
            default: begin
                state <= INIT;
                y <= 0;
            end
        endcase
    end
end

endmodule
