module Guia_1101 (
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
reg [1:0] state, next_state;

// FSM logic
always @(posedge clk or negedge reset) begin
    if (reset) begin
        state <= INIT;
        y <= 0;
    end
    else begin
        state <= next_state;
    end
end

always @(state or x) begin
    case(state)
        INIT: begin
            if (x) begin
                next_state = S1;
                y <= 0;
            end
            else begin
                next_state = INIT;
            end
        end
        S1: begin
            if (x) begin
                next_state = S1;
                y <= 0;
            end
            else begin
                next_state = S10;
            end
        end
        S10: begin
            if (x) begin
                next_state = S101;
                y <= 0;
            end
            else begin
                next_state = S1;
            end
        end
        S101: begin
            if (x) begin
                next_state = S1;
                y <= 1;
            end
            else begin
                next_state = S1;
            end
        end
        default: begin
            next_state = INIT;
        end
    endcase
end

endmodule
