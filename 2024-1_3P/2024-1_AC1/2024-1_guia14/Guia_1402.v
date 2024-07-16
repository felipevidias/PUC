module shift_register (
    input wire clk,
    input wire ld,
    input wire [4:0] data,
    output reg [4:0] q
);

    always @(posedge clk) begin
        if (ld) begin
            q <= data;
        end else begin
            q[4] <= q[3];
            q[3] <= q[2];
            q[2] <= q[1];
            q[1] <= q[0];
            q[0] <= 0; // Assuming the leftmost bit is shifted out as 0
        end
    end

endmodule
