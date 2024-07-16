// Moore FSM
module moore_1101 (
    output reg y,
    input x,
    input clk,
    input reset
);

// constant definitions
`define found 1
`define notfound 0

// state identifiers
parameter start = 3'b000;
parameter id1 = 3'b001;
parameter id11 = 3'b011;
parameter id110 = 3'b010;
parameter id1101 = 3'b110; // signal found

// state variables
reg [2:0] E1; // current state
reg [2:0] E2; // next state

// next state logic
always @(x or E1)
begin
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
                E2 = id1101;
            else
                E2 = start;
        id1101:
            if (x)
                E2 = id11;
            else
                E2 = start;
        default: // undefined state
            E2 = 3'bxxx;
    endcase
end

// state transition
always @(posedge clk or negedge reset)
begin
    if (reset)
        E1 <= E2; // updates current state
    else
        E1 <= 3'b000; // reset
end

// output logic
always @(E1)
begin
    y <= (E1 == id1101) ? `found : `notfound; // first bit of state value (MOORE indicator)
end

endmodule // moore_1101
