module twisted_ring_shift_register (
    input wire clk,
    input wire ld,
    input wire [5:0] data,
    output reg [5:0] q
);

    always @(posedge clk) begin
        if (ld) begin
            q <= data;
        end else begin
            q[5] <= q[0];
            q[4] <= q[5];
            q[3] <= q[4];
            q[2] <= q[3];
            q[1] <= q[2];
            q[0] <= q[1];
        end
    end

endmodule
