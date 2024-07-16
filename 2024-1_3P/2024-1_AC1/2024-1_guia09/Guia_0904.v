module Guia_0904 (
    input clk,
    output reg pulse
);

reg [25:0] counter; // Contador de 26 bits para a divisão do clock
parameter DIVIDER = 3; // Divide o período do clock por 3

always @(posedge clk) begin
    counter <= counter + 1;
    if (counter == ((clk / DIVIDER) - 1)) begin
        pulse <= ~pulse;
        counter <= 0;
    end
end

endmodule
