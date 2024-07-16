module Guia_1102 (
    output reg y,
    input x,
    input clk,
    input reset
);

// State identifiers
parameter INIT = 2'b00;
parameter S1 = 2'b01;
parameter S10 = 2'b10;
parameter S101 = 2'b11;

// State variables
reg [1:0] state;

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
                    state <= INIT;
                    y <= 0;
                end
            end
            S1: begin
                if (x) begin
                    state <= S10;
                    y <= 0;
                end
                else begin
                    state <= INIT;
                    y <= 0;
                end
            end
            S10: begin
                if (x) begin
                    state <= S101;
                    y <= 0;
                end
                else begin
                    state <= INIT;
                    y <= 0;
                end
            end
            S101: begin
                if (x) begin
                    state <= INIT;
                    y <= 1;
                end
                else begin
                    state <= INIT;
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
