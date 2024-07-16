module nand_nand(output s, input a, input b, input c, input d);
    wire w1, w2;
    
    nand NAND_1(w1, a, c);
    nand NAND_2(w2, b, d);
    nand NAND_3(s, w1, w2);
    
endmodule
