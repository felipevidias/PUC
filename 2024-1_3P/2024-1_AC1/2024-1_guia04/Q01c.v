// 2024-guia01 817294_Felipe_Vilhena_Dias 01/03/2024
module fxyz (output s,
input x, y, z);
assign s = ~(~x & y) & ~z;
endmodule // fxyz

