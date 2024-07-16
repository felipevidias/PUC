// ---------------------------
// -- test clock generator (2)
// ---------------------------
module clock (output reg clk);
    initial clk = 1'b0;
    always begin
        #12 clk = ~clk;
    end
endmodule

module pulse (input clock, output reg signal);
    always @ (posedge clock)
    begin
        signal <= 1'b1;
        #3 signal <= 1'b0;
        #3 signal <= 1'b1;
        #3 signal <= 1'b0;
    end
endmodule // pulse

module trigger (input on, input clock, output reg signal);
    always @ (posedge clock)
    begin
        if (on)
        begin
            #60 signal <= 1'b1;
            #60 signal <= 1'b0;
        end
    end
endmodule // trigger

module Guia_0901;

    wire clock;
    reg p;
    wire p1, t1;

    clock clk_inst (clock);
    pulse pulse_inst (clock, p1);
    trigger trigger_inst (p, clock, t1);

    initial begin
        p = 1'b0;
    end

    initial begin
        $dumpfile("Guia_0901.vcd");
        $dumpvars(1, clock, p1, p, t1);

        #060 p = 1'b1;
        #120 p = 1'b0;
        #180 p = 1'b1;
        #240 p = 1'b0;
        #300 p = 1'b1;
        #360 p = 1'b0;
        #376 $finish;
    end
endmodule // Guia_0901
