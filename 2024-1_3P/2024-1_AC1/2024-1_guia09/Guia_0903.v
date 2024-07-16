module Guia_0904 (
    input clk,
    output reg pulse
);

reg [1:0] counter;
parameter CLK_DIV = 3; // Divide o período do clock por 3

always @(posedge clk) begin
    counter <= counter + 1;
    if (counter == (CLK_DIV - 1)) begin
        pulse <= ~pulse;
        counter <= 0;
    end
end

endmodule
