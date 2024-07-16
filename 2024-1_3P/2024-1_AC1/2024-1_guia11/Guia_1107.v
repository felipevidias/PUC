module Guia_1104 (
    output reg y,
    input x,
    input clk,
    input reset
);

// State identifiers
parameter INIT = 3'b000;
parameter S1 = 3'b001;
parameter S11 = 3'b011;
parameter S111 = 3'b111;
parameter S1111 = 3'b101;

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
                    state <= INIT;
                    y <= 0;
                end
            end
            S1: begin
                if (x) begin
                    state <= S11;
                    y <= 0;
                end
                else begin
                    state <= INIT;
                    y <= 0;
                end
            end
            S11: begin
                if (x) begin
                    state <= S111;
                    y <= 0;
                end
                else begin
                    state <= INIT;
                    y <= 0;
                end
            end
            S111: begin
                if (x) begin
                    state <= S1111;
                    y <= 0;
                end
                else begin
                    state <= INIT;
                    y <= 0;
                end
            end
            S1111: begin
                if (x) begin
                    state <= S1;
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
