module clock(output reg clk);
    initial clk = 1'b0;
    always begin
        #12 clk = ~clk;
    end
endmodule

module pulse1 (input clock, output reg signal);
    always @ (posedge clock)
    begin
        signal <= 1'b1;
        #4 signal <= 1'b0;
        #4 signal <= 1'b1;
        #4 signal <= 1'b0;
        #4 signal <= 1'b1;
        #4 signal <= 1'b0;
    end
endmodule

module pulse2 (input clock, output reg signal);
    always @ (posedge clock)
    begin
        signal <= 1'b1;
        #5 signal <= 1'b0;
    end
endmodule

module pulse3 (input clock, output reg signal);
    always @ (negedge clock)
    begin
        signal <= 1'b1;
        #15 signal <= 1'b0;
        #15 signal <= 1'b1;
    end
endmodule

module pulse4 (input clock, output reg signal);
    always @ (negedge clock)
    begin
        signal <= 1'b1;
        #20 signal <= 1'b0;
        #20 signal <= 1'b1;
        #20 signal <= 1'b0;
    end
endmodule

module Guia_0902;
    reg clock;
    reg p1, p2, p3, p4;
    wire pls1, pls2, pls3, pls4;

    clock clk_inst (.clk(clock));
    pulse1 pulse1_inst (.clock(clock), .signal(pls1));
    pulse2 pulse2_inst (.clock(clock), .signal(pls2));
    pulse3 pulse3_inst (.clock(clock), .signal(pls3));
    pulse4 pulse4_inst (.clock(clock), .signal(pls4));

    initial begin
        $dumpfile("Guia_0902.vcd");
        $dumpvars(1, clock, p1, p2, p3, p4, pls1, pls2, pls3, pls4);
        #480 $finish;
    end
endmodule
