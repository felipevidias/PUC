module mux_mux(output s, input a, input b, input c);
    wire w1, w2, w3;
    
    mux MUX_1(w1, b, c, a);
    mux MUX_2(w2, ~a, ~b, c);
    not NOT_1(w3, c);
    mux MUX_3(s, w1, w2, w3);
    
endmodule
