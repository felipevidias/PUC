// Mealy FSM
module mealy_1101 (
    output y,
    input x,
    input clk,
    input reset
);

// constant definitions
`define found 1
`define notfound 0

// state identifiers
parameter start = 2'b00;
parameter id1 = 2'b01;
parameter id11 = 2'b11;
parameter id110 = 2'b10;

// state variables
reg [1:0] E1; // current state
reg [1:0] E2; // next state

// next state logic
always @(x or E1)
begin
    y = `notfound;
    case (E1)
        start:
            if (x)
                E2 = id1;
            else
                E2 = start;
        id1:
            if (x)
                E2 = id11;
            else
                E2 = start;
        id11:
            if (x)
                E2 = id11;
            else
                E2 = id110;
        id110:
            if (x)
            begin
                E2 = id1;
                y = `found;
            end
            else
            begin
                E2 = start;
                y = `notfound;
            end
        default: // undefined state
            E2 = 2'bxx;
    endcase
end

// state transition
always @(posedge clk or negedge reset)
begin
    if (reset)
        E1 <= E2; // updates current state
    else
        E1 <= 2'b00; // reset
end

endmodule // mealy_1101
