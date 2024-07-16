module f(output s, input x, input y);
    wire w1, w2, w3, w4;
    
    not NOT_1(w1, y);
    and AND_1(w2, x, w1);
    not NOT_2(w3, w2);
    or OR_1(w4, y, x);
    or OR_2(s, w3, w4);
    
endmodule
